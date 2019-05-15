package sample.Model;

import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;
import jpa.GenericJpaDao;
import org.json.JSONObject;
import sample.Model.*;
import sample.Model.EnityClasses.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 Model Controller az adatbazis olvasasahoz írásához tartozó deklaraciokkal metodusokkal
 **/
public  class Controller extends FromRestApi  {
    /**
     Az adatbazis írásához tartozó deklarációk
     **/
    private static Gson gson=new Gson();
    public static List<Csapat> csapat=new ArrayList<>();
    public static List<Meccsek> meccsek=new ArrayList<>();

    /**
     Rest apiból kapott adatok feltoltésére való metódus
     **/
    public static void feltoltRestapiListabol(List<JSONObject> orszagokJson) {

        for (int i = 0; i < orszagokJson.size(); ++i) {
            Csapat x =gson.fromJson(String.valueOf(orszagokJson.get(i)), Csapat.class);
            csapat.add(x);
            System.out.println("................"+ csapat.get(i).toString());
        }
    }
    /**
     Lokalis apiból kapott adatok feltöltése
     **/
    public static void feltoltLokalisAPibol(ArrayList<org.json.simple.JSONObject> orszagokJson) {
        for (int i = 0; i < orszagokJson.size(); ++i) {
            if(String.valueOf(orszagokJson.get(i)).equals("")){}else {
                Meccsek x = gson.fromJson(String.valueOf(orszagokJson.get(i)), Meccsek.class);
                meccsek.add(x);
                System.out.println("................"+ meccsek.get(i).toString());
            }

        }
    }

    /**Inicializalas**/
    Injector injector = Guice.createInjector(new PersistenceModule("jpa-persistence-unit-1"));
    protected MeccsekDao meccsekDao=injector.getInstance(MeccsekDao.class);
    protected CsapatDao csapatDao =injector.getInstance(CsapatDao.class);
    public void adatbazisInicializalas() throws IOException {


        Controller.readApi();
        Controller.makeJsonArray();
        Controller.feltoltRestapiListabol(Controller.makeJsonObjects(Controller.arrs));

        Controller.readJson();
        Controller.feltoltLokalisAPibol(Controller.makeJsonObjectFromFile(Controller.jsonArray));
    }
    public  void feltoltCsapatokAdatbazis(){
        for (int i=0; i<Controller.csapat.size();i++){
            csapatDao.persist(Controller.csapat.get(i));
        }
    }
    public  void feltoltMeccsekAdatbazis(){
        for (int i=0; i<Controller.meccsek.size();i++){
            meccsekDao.persist(Controller.meccsek.get(i));
        }
    }


}













//    List<Orszag> orszag=new ArrayList<>();
//    List<Liga> liga=new ArrayList<>();
    /*
     OrszagDao orszagDao =injector.getInstance(OrszagDao.class);
     LigaDao ligaDao =injector.getInstance(LigaDao.class);

    public void feltoltListabol(List<JSONObject> orszagokJson, GenericJpaDao T) {
        for (int i = 0; i < orszagokJson.size(); ++i) {
            Orszag x =gson.fromJson(String.valueOf(orszagokJson.get(i)), Orszag.class);
            orszag.add(x);
            System.out.println("................"+orszag.get(i));
            T.persist(x);
        }
    }
    public void feltoltListabol2(List<JSONObject> orszagokJson, GenericJpaDao T) {
        for (int i = 0; i < orszagokJson.size(); ++i) {
            Liga x =gson.fromJson(String.valueOf(orszagokJson.get(i)), Liga.class);
            liga.add(x);
            System.out.println("................"+ liga.get(i).toString());
            T.persist(x);
        }
    }

    */


