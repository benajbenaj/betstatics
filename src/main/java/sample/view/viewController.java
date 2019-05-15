package sample.view;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import sample.Controller.MainController;
import sample.Model.Controller;
import sample.Model.EnityClasses.CsapatDao;
import sample.Model.EnityClasses.MeccsekDao;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class viewController extends MainController implements Initializable {
    @FXML
    public Label tag1;
    @FXML
    public Button write;
    MainController y= new MainController();
    @FXML
    public Button write1;
    @FXML
    public Label tag11;
    @FXML
    private Label gol;
    @FXML
    private RadioButton cs1;
    @FXML
    private RadioButton cs2;
    @FXML
    private RadioButton cs3;
    @FXML
    private RadioButton cs4;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tag1.setVisible(false);
        write.setVisible(false);
        cs1.setVisible(false);
        cs2.setVisible(false);
        cs3.setVisible(false);
        cs4.setVisible(false);


    }
    @FXML

    public void akcio(ActionEvent actionEvent) throws IOException {
        ir(y);

    }
    public void ir(MainController x) {
        if (cs1.isSelected()) {

            gol.setText("A " + x.nevAmireKattintott(cs1.getText()) + " gólátlaga az utóbbi a tavaszi "
                    + x.hanyMeccsetJatszottTavasszal(cs1.getText())+" meccsén:"+x.tavaszimeccseinekatlaga(cs1.getText()));

        } else if (cs2.isSelected()) {
            gol.setText("A " + x.nevAmireKattintott(cs2.getText())
                    + " gólátlaga az utóbbi a tavaszi " + x.hanyMeccsetJatszottTavasszal(cs2.getText())+ " meccsén:"+x.tavaszimeccseinekatlaga(cs2.getText()));
        } else if (cs3.isSelected()) {
            gol.setText("A " + x.nevAmireKattintott(cs3.getText())
                    + " gólátlaga az utóbbi a tavaszi "+x.hanyMeccsetJatszottTavasszal(cs3.getText())+" meccsén:"+x.tavaszimeccseinekatlaga(cs3.getText()));

        } else if (cs4.isSelected()) {
            gol.setText("A " + x.nevAmireKattintott(cs4.getText())
                    + " gólátlaga az utóbbi a tavaszi "+x.hanyMeccsetJatszottTavasszal(cs4.getText())+" meccsén:"+x.tavaszimeccseinekatlaga(cs4.getText()));
        }
    }

    public void leker(ActionEvent actionEvent) throws IOException {
        write1.setVisible(false);
        tag11.setVisible(false);
        y.adatbazisInicializalas();
        y.feltoltCsapatokAdatbazis();
        y.feltoltMeccsekAdatbazis();
        tag1.setVisible(true);
        write.setVisible(true);
        cs1.setVisible(true);
        cs2.setVisible(true);
        cs3.setVisible(true);
        cs4.setVisible(true);
    }
}

