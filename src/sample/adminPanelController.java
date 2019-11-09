package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;


public class adminPanelController {

    @FXML
    Button btn_doctor,btn_admin,btn_recep,btn_lab,btn_pharmacy,btn_accountSettings,doctorbtn_clr,doctorbtn_reg,doctorbtn_search,doctorbtn_filltoedit
            ,doctorbtn_save,doctorbtn_updateclr,doctorbtn_changepass;
    @FXML
    AnchorPane anc_doctor,anc_admin,anc_recep,anc_lab,anc_pharmacy,anc_accountSettings;
    @FXML
    TextField txt_doctorID,doctortxt_nic,doctortxt_name,doctortxt_mobile,doctortxt_regstate,doctortxt_search,update_doctorID,change_doctorID,
            doctortxt_nicchange,doctortxt_namechange,doctortxt_mobilechange,doctortxt_emailchange,doctortxt_email;
    @FXML
    PasswordField doctortxt_pass,doctortxt_cpass,doctortxt_newpass,doctortxt_newcpass;
    @FXML
    DatePicker doctordate_dob,doctordate_changedob;
    @FXML
    TextArea doctortxt_address,doctortxt_exp,doctortxt_sp,doctortxt_addresschange;



    public void anchorPaneSelect(ActionEvent actionEvent) {
        if(actionEvent.getSource()==btn_doctor){
            anc_doctor.toFront();
        }
        else if(actionEvent.getSource()==btn_admin){
            anc_admin.toFront();
        }
        else if(actionEvent.getSource()==btn_recep){
            anc_recep.toFront();
        }
        else if(actionEvent.getSource()==btn_lab){
            anc_lab.toFront();
        }
        else if(actionEvent.getSource()==btn_pharmacy){
            anc_pharmacy.toFront();
        }
        else if(actionEvent.getSource()==btn_accountSettings){
            anc_accountSettings.toFront();
        }
    }

    private boolean checkNullblah() {
        //try {
        if (doctortxt_nic.getText().trim() != "") {
            return true;
        } else {
            return true;
        }
        //}
        /*catch (NullPointerException e){
            return false;
        }*/
    }


    public void registerDoctor(ActionEvent actionEvent) throws Exception {
        DbConn dbConn = new DbConn();

        if (doctortxt_nic.getText().trim() == null || doctortxt_name.getText().trim() != "" || doctordate_dob.getValue().toString()!="" ||
                doctortxt_address.getText().trim() != "" || doctortxt_mobile.getText().trim() != "" || doctortxt_email.getText().trim() != "" || txt_doctorID.getText().trim() != "" ||
                doctortxt_regstate.getText().trim() != "" || doctortxt_exp.getText().trim() != "" || doctortxt_sp.getText().trim() != "" || doctortxt_pass.getText().trim() != ""|| doctortxt_cpass.getText().trim()!="") {

            if (dbConn.userExistregNo(txt_doctorID.getText().trim(), "doctor")) {
                if (dbConn.registration("doctor", doctortxt_nic.getText().trim(), doctortxt_name.getText().trim(), doctordate_dob.getValue().toString(),
                        doctortxt_address.getText().trim(), doctortxt_mobile.getText().trim(), doctortxt_email.getText().trim(), txt_doctorID.getText().trim(),
                        doctortxt_regstate.getText().trim(), doctortxt_exp.getText().trim(), doctortxt_sp.getText().trim(), doctortxt_pass.getText().trim())) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText("Success !");
                    alert.setContentText("New Doctor Added");
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Unsuccess");
                    alert.setHeaderText("Unsuccess !");
                    alert.setContentText("New Doctor Not Added");
                    alert.show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Doctor ID Exist");
                alert.setContentText("Doctor Exist from same DoctorID");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Fields Empty");
            alert.setHeaderText("Fields Emplty");
            alert.setContentText("One or more fields are empty");
            alert.show();
        }

    }


    public void newDoctorClr(ActionEvent actionEvent) {
    }

    public void searchDoctor(ActionEvent actionEvent) {
    }

    public void changeDoctorPass(ActionEvent actionEvent) {
    }

    public void doctorFillToEdit(ActionEvent actionEvent) {
    }

    public void doctorSave(ActionEvent actionEvent) {
    }

    public void updateDoctorClr(ActionEvent actionEvent) {
    }
}
