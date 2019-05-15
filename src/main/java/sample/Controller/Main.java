package sample.Controller;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.Controller;
import sample.Model.EnityClasses.CsapatDao;
import sample.Model.EnityClasses.Meccsek;
import sample.Model.EnityClasses.MeccsekDao;

import java.io.IOException;
import java.util.List;

/**
 BUG VESZÉLY kimaradt időhiany miatt, annak tesztelese h leteznek e mar a rekordok akkor ne toltse fel
 Minden futtataskor törölni kell az adatbazist :(
 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 **/
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample.fxml"));
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) throws IOException {

        launch(args);

    }



}
