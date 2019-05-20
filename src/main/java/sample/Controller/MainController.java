package sample.Controller;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;
import sample.Model.Controller;
import sample.Model.EnityClasses.CsapatDao;
import sample.Model.EnityClasses.Meccsek;
import sample.Model.EnityClasses.MeccsekDao;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public   class MainController extends Controller implements EredmenyStreams {
    Injector injector = Guice.createInjector(new PersistenceModule("jpa-persistence-unit-1"));
    protected MeccsekDao meccsekDao=injector.getInstance(MeccsekDao.class);
    CsapatDao csapatDao =injector.getInstance(CsapatDao.class);
    public void adatbazisInicializalas() throws IOException {


        Controller.readApi();
        Controller.makeJsonArray();
        Controller.feltoltRestapiListabol(Controller.makeJsonObjects(Controller.arrs));

        Controller.readJson();
        Controller.feltoltLokalisAPibol(Controller.makeJsonObjectFromFile(Controller.jsonArray));

    }
    public  void feltoltCsapatokAdatbazis(){
         int x=csapatDao.findAll().size();
        if(x!= Controller.csapat.size()) {
            for (int i = x; i < Controller.csapat.size(); i++) {

                csapatDao.persist(Controller.csapat.get(i));

            }
        }
    }
    public  void feltoltMeccsekAdatbazis(){
        int x=meccsekDao.findAll().size();
        if(x!= Controller.meccsek.size()) {
            for (int i = x; i < Controller.meccsek.size(); i++) {
                meccsekDao.persist(Controller.meccsek.get(i));
            }
        }
    }






    @Override
    public String nevAmireKattintott(String radio) {
        return csapatDao.find(radio).get().getTeam_name();
    }

    @Override
    public long hanyMeccsetJatszottTavasszal(String s) {
        return meccsekDao.findAll().stream().filter(c->c.getMatch_hometeam_name().contains(s) ||c.getMatch_awayteam_name().contains(s)).count();   }

    @Override
    public Double tavaszimeccseinekatlaga(String s) {
        Double x=meccsekDao.findAll().stream().filter(c->c.getMatch_hometeam_name().contains(s)).mapToLong(Meccsek::getMatch_hometeam_score).average().getAsDouble();
        Double y=meccsekDao.findAll().stream().filter(c->c.getMatch_awayteam_name().contains(s)).mapToLong(Meccsek::getMatch_awayteam_score).average().getAsDouble();

        return (x+y)/2;}



}
