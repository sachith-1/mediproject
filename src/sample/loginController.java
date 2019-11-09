package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.jetbrains.annotations.NotNull;

public class loginController {

    @FXML
    TextField emailfld;

    @FXML
    PasswordField passfld;

    @FXML
    RadioButton rbtn_admin,rbtn_doctor,rbtn_recep;

    @FXML
    Label warninglbl;

    public void login(ActionEvent actionEvent) throws Exception {
       loginController loginController=new loginController();
        DbConn dbConn=new DbConn();
        warninglbl.setText("");
        if(rbtn_admin.isSelected()){
            if(dbConn.login(emailfld.getText().trim(),passfld.getText().trim(),"admin")){
                loginController.loginAll(actionEvent,"Easy Medi |Admin Panel","adminPanel.fxml",
                        "main.css");
            }
            else{
                warninglbl.setStyle("-fx-text-fill:#cf380b;");
                warninglbl.setText("Email or Password is Incorrect.");
            }

        }
        else if(rbtn_doctor.isSelected()){
            if(dbConn.login(emailfld.getText().trim(),passfld.getText().trim(),"doctor")){
                loginController.loginAll(actionEvent,"Easy Medi |Doctor Panel","doctorPanel.fxml",
                        "main.css");
            }
            else{
                warninglbl.setStyle("-fx-text-fill:#cf380b;");
                warninglbl.setText("Email or Password is Incorrect.");
            }
        }else if(rbtn_recep.isSelected()){
            if(dbConn.login(emailfld.getText().trim(),passfld.getText().trim(),"receptionist")){
                loginController.loginAll(actionEvent,"Easy Medi |Receptionist Panel","recepPanel.fxml",
                        "main.css");
            }
            else{
                warninglbl.setStyle("-fx-text-fill:#cf380b;");
                warninglbl.setText("Email or Password is Incorrect.");
            }
        }
        else {

            warninglbl.setStyle("-fx-text-fill:#cf380b;");
            warninglbl.setText("Select The Employee Type");

        }

    }
    private void loginAll(@NotNull ActionEvent actionEvent, String title, String fxml, String css) throws Exception {

            Stage s=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Scene mainScene=new Scene(root);
            mainScene.getStylesheets().add(getClass().getResource(css).toExternalForm());
            s.setScene(mainScene);
            s.setTitle(title);
            s.initStyle(StageStyle.TRANSPARENT);
            s.show();

    }
}
