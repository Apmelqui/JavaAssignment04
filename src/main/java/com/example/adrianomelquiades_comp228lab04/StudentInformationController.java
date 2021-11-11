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


    String program = "The program is: ";
    String checkBoxValue = "";
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


        //Printing the student information:

        displayStudentInfo();


    }

    public void displayStudentInfo() {

        this.taStudentInformation.setText(tfName.getText() + ", " + tfAddress.getText() + ", " + tfProvince.getText() + ", " +
                tfCity.getText() + ", " + tfPostalCode.getText() + ", " + tfPhoneNumber.getText() + ", " + tfEmail.getText() +
                "\n" + program + "\nCourses: " + taCourses.getText().toString() + "\n" + checkBoxCouncil + "\n" + checkBoxVolunteer);
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
        computerScienceRadioButton.setSelected(false);
        businessRadioButton.setSelected(false);
        cbCourses.getItems().clear();
        studentCouncil.setSelected(false);
        volunteerWork.setSelected(false);
    }




    public void loadComboBox() {
        //ComboBox
        if (computerScienceRadioButton.isSelected()) {
            cbCourses.getItems().clear();
            cbCourses.getItems().addAll("Java", "Python", "C#", "JavaScript");
            taCourses.clear();
        } if (businessRadioButton.isSelected()) {
            cbCourses.getItems().clear();
            cbCourses.getItems().addAll("Financial Math", "Social Analysis", "Economy", "Stock analysis");
            taCourses.clear();
        }
    }




    //
    //System.out.println(selectedCourses);

//    taCourses.appendText(selectedCourses);


        /*
        System.out.println("load Combobox method");
        cbCourses.getItems().clear();

        String selectedCourses = "";

        if (computerScienceRadioButton.isSelected()){
            cbCourses.getItems().clear();
            program = "The program is: ";
            cbCourses.getItems().addAll("Java", "Python", "C#", "JavaScript");
            program += "Computer Science";
            this.taCourses.setText(cbCourses.getValue().toString());
            //selectedCourses +=
        } if (businessRadioButton.isSelected()){
            cbCourses.getItems().clear();
            program = "The program is: ";
            cbCourses.getItems().addAll("Financial Math", "Social Analysis", "Economy", "Stock analysis");
            program += "Business";
            this.taCourses.setText(cbCourses.getValue().toString());
        }


         */




    public void populateComboBox() {
        String value = cbCourses.getValue().toString();
        selectedCourses.add(value);
    }

    public void displayComboBoxValuesOnTextAreaCourses(ArrayList<String> selectedCourses) {
        for (int i = 0; i < selectedCourses.size(); i++) {
            taCourses.setText(selectedCourses.get(i));
        }
    }

    /*
    delete
    //Populate comboBox:
        cbCourses.setOnAction((event) -> {


        selectedCourses += cbCourses.getValue().toString();
        System.out.println(selectedCourses);
        this.taCourses.setText(selectedCourses);



    });
    delete
     */


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadComboBox();

    }
}



