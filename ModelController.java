package sample.Model;

import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;
import org.json.JSONObject;
import sample.Model.EnityClasses.Csapat;
import sample.Model.EnityClasses.CsapatDao;
import sample.Model.EnityClasses.Meccsek;
import sample.Model.EnityClasses.MeccsekDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Model ModelController az adatbazis olvasasahoz írásához tartozó deklaraciokkal metodusokkal
 **/
public class ModelController extends FromRestApi {
    public static List<Csapat> csapat = new ArrayList<>();
    public static List<Meccsek> meccsek = new ArrayList<>();
    /**
     * Az adatbazis írásához tartozó deklarációk
     **/
    private static Gson gson = new Gson();
    /**
     * Inicializalas
     **/
    Injector injector = Guice.createInjector(new PersistenceModule("jpa-persistence-unit-1"));
    protected MeccsekDao meccsekDao = injector.getInstance(MeccsekDao.class);
    protected CsapatDao csapatDao = injector.getInstance(CsapatDao.class);

    /**
     * Rest apiból kapott adatok feltoltésére való metódus
     **/
    public static void feltoltRestapiListabol(List<JSONObject> orszagokJson) {

        for (int i = 0; i < orszagokJson.size(); ++i) {
            Csapat x = gson.fromJson(String.valueOf(orszagokJson.get(i)), Csapat.class);
            csapat.add(x);
            System.out.println("................" + csapat.get(i).toString());
        }
    }

    /**
     * Lokalis apiból kapott adatok feltöltése
     **/
    public static void feltoltLokalisAPibol(ArrayList<org.json.simple.JSONObject> orszagokJson) {
        for (int i = 0; i < orszagokJson.size(); ++i) {
            if (String.valueOf(orszagokJson.get(i)).equals("")) {
            } else {
                Meccsek x = gson.fromJson(String.valueOf(orszagokJson.get(i)), Meccsek.class);
                meccsek.add(x);
                System.out.println("................" + meccsek.get(i).toString());
            }

        }
    }

    public void adatbazisInicializalas() throws IOException {


        ModelController.readApi();
        ModelController.makeJsonArray();
        ModelController.feltoltRestapiListabol(ModelController.makeJsonObjects(ModelController.arrs));

        ModelController.readJson();
        ModelController.feltoltLokalisAPibol(ModelController.makeJsonObjectFromFile(ModelController.jsonArray));
    }

    public void feltoltCsapatokAdatbazis() {
        for (int i = 0; i < ModelController.csapat.size(); i++) {
            csapatDao.persist(ModelController.csapat.get(i));
        }
    }

    public void feltoltMeccsekAdatbazis() {
        for (int i = 0; i < ModelController.meccsek.size(); i++) {
            meccsekDao.persist(ModelController.meccsek.get(i));
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


