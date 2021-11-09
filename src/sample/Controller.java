package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import sample.util.Alerts;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private MenuItem menuItemSeller;
    @FXML
    private MenuItem menuItemDepartment;
    @FXML
    private MenuItem menuItemAbout;
    @FXML
    public void onMenuItemSellerAction(){
        System.out.println("onMenuItemSellerAction");
    }
    @FXML
    public void onMenuItemDepartmentAction(){
        loadView("departmentList.fxml");
    }
    @FXML
    public void onMenuItemAboutAction(){
        loadView("about.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private synchronized void loadView(String absoluteName){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVbox = loader.load();

            Scene scene = Main.getScene();
            VBox mainVbox =  (VBox) ((ScrollPane) scene.getRoot()).getContent();//PEGA O PRIMEIRO ELEMENTO DA VIEW da Sample(ScroolPane)

            Node mainMenu = mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(mainMenu);
            mainVbox.getChildren().addAll(newVbox.getChildren());
        } catch (IOException e) {
            Alerts.showAlerts("IO Exception","Error Loader View",e.getMessage(), Alert.AlertType.ERROR);
        }

    }
}
