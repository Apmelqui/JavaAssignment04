package com.example.adrianomelquiades_comp228lab04;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class StudentInformationController implements Initializable {
    @FXML private TextArea taStudentInformation;
    @FXML private RadioButton computerScienceRadioButton;
    @FXML private RadioButton businessRadioButton;
    @FXML private TextField tfName;
    @FXML private TextField tfAddress;
    @FXML private TextField tfProvince;
    @FXML private TextField tfCity;
    @FXML private TextField tfPostalCode;
    @FXML private TextField tfPhoneNumber;
    @FXML private TextField tfEmail;
    @FXML private ComboBox cbCourses;
    @FXML private TextArea taCourses;
    @FXML private CheckBox studentCouncil;
    @FXML private CheckBox volunteerWork;


    String program = "";
    String checkBoxCouncil = "";
    String checkBoxVolunteer = "";
    ArrayList<String> selectedCourses = new ArrayList<String>();

    public void displayInformationButtonClicked() {

        //Get checkBox value
        if (studentCouncil.isSelected()) {
            checkBoxCouncil = studentCouncil.getText();
        } if (volunteerWork.isSelected()) {
            checkBoxVolunteer = volunteerWork.getText();
        }

        //Get Program information from radio button
        if (businessRadioButton.isSelected()) {
            program = "";
            program += businessRadioButton.getText();
            System.out.println(program);
        } if (computerScienceRadioButton.isSelected()) {
            program = "";
            program += computerScienceRadioButton.getText();
        }

        //Printing the student information:
        displayStudentInfo();
    }

    //Methods:
    public void displayStudentInfo() {

        this.taStudentInformation.setText(tfName.getText() + ", " + tfAddress.getText() + ", " + tfProvince.getText() + ", " +
                tfCity.getText() + ", " + tfPostalCode.getText() + ", " + tfPhoneNumber.getText() + ", " + tfEmail.getText() +
                "\n\n" +"Program:\n" + program +"\n" + "\nCourses:\n" + taCourses.getText().toString() + "\nExtra Activities:\n" + checkBoxCouncil + "\n" + checkBoxVolunteer);
    }

    public void clearButtonClicked() {
        taStudentInformation.clear();
        tfName.clear();
        tfAddress.clear();
        tfProvince.clear();
        tfCity.clear();
        tfPostalCode.clear();
        tfPhoneNumber.clear();
        tfEmail.clear();
        taCourses.clear();
        //computerScienceRadioButton.setSelected(false);
        //businessRadioButton.setSelected(false);
        cbCourses.getItems().clear();
        studentCouncil.setSelected(false);
        volunteerWork.setSelected(false);
        loadComboBox();
    }

    public void loadComboBox() {
        //ComboBox
        if (computerScienceRadioButton.isSelected()) {
            cbCourses.getItems().clear();
            cbCourses.getItems().addAll("Java", "Python", "C#", "JavaScript");
            taCourses.clear();
        } if (businessRadioButton.isSelected()) {
            cbCourses.getItems().clear();
            cbCourses.getItems().addAll("Finance", "Marketing", "Macroeconomics", "Supply Chain");
            taCourses.clear();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadComboBox();

        //Adding courses into the Text Area:
        cbCourses.setOnAction((event) -> {
            if (cbCourses.getValue() != null) {
                String course = cbCourses.getValue().toString();
                if (taCourses.getText().indexOf(course) !=-1) {
                    System.out.println("This course has already been added.");
                } else {
                    taCourses.appendText(course + "\n");
                }
            }
        });
    }

}



