package sample.Controller;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;
import sample.Model.EnityClasses.CsapatDao;
import sample.Model.EnityClasses.Meccsek;
import sample.Model.EnityClasses.MeccsekDao;
import sample.Model.ModelController;

import java.io.IOException;


public class Controller extends ModelController implements EredmenyStreams {
    Injector injector = Guice.createInjector(new PersistenceModule("jpa-persistence-unit-1"));
    protected MeccsekDao meccsekDao = injector.getInstance(MeccsekDao.class);
    protected CsapatDao csapatDao = injector.getInstance(CsapatDao.class);

    public void adatbazisInicializalas() throws IOException {

        ModelController.readApi();
        ModelController.makeJsonArray();
        ModelController.feltoltRestapiListabol(ModelController.makeJsonObjects(ModelController.arrs));

        ModelController.readJson();
        ModelController.feltoltLokalisAPibol(ModelController.makeJsonObjectFromFile(ModelController.jsonArray));

    }

    public void feltoltCsapatokAdatbazis() {
        int x = csapatDao.findAll().size();
        if (x != ModelController.csapat.size()) {
            for (int i = x; i < ModelController.csapat.size(); i++) {

                csapatDao.persist(ModelController.csapat.get(i));

            }
        }
    }

    public void feltoltMeccsekAdatbazis() {
        int x = meccsekDao.findAll().size();
        if (x != ModelController.meccsek.size()) {
            for (int i = x; i < ModelController.meccsek.size(); i++) {
                meccsekDao.persist(ModelController.meccsek.get(i));
            }
        }
    }


    @Override
    public String nevAmireKattintott(String radio) {
        return csapatDao.find(radio).get().getTeam_name();
    }

    @Override
    public long hanyMeccsetJatszottTavasszal(String s) {
        return meccsekDao.findAll().stream().filter(c -> c.getMatch_hometeam_name().contains(s) || c.getMatch_awayteam_name().contains(s)).count();
    }

    @Override
    public Double tavaszimeccseinekatlaga(String s) {
        Double x = meccsekDao.findAll().stream().filter(c -> c.getMatch_hometeam_name().contains(s)).mapToLong(Meccsek::getMatch_hometeam_score).average().getAsDouble();
        Double y = meccsekDao.findAll().stream().filter(c -> c.getMatch_awayteam_name().contains(s)).mapToLong(Meccsek::getMatch_awayteam_score).average().getAsDouble();

        return (x + y) / 2;
    }


}
