package com.example.adrianomelquiades_comp228lab04;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class StudentInformationController implements Initializable {
    @FXML private TextArea StudentInformationLabel;
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
    @FXML private CheckBox studentConcil;
    @FXML private CheckBox volunteerWork;


    String program = "The program is: ";


    public void displayInformationButtonClicked() {
        System.out.println("Button clicked");


        //Get checkBox value
        String checkBoxValue = "";
        if (studentConcil.isSelected()) {
            checkBoxValue = "Student Concil";
        } else if (volunteerWork.isSelected()) {
            checkBoxValue = "Volunteer Work";
        }


        //Printing the student information:
        this.StudentInformationLabel.setText(tfName.getText() + ", " + tfAddress.getText() + ", " + tfProvince.getText() + ", " +
                tfCity.getText() + ", " + tfPostalCode.getText() + ", " + tfPhoneNumber.getText() + ", " + tfEmail.getText() +
                "\n" + program + "\nCourses: " + taCourses.getText().toString() + checkBoxValue);




        System.out.println(program);
    }

    public void clearButtonClicked() {
        StudentInformationLabel.clear();
        tfName.clear();
        tfAddress.clear();
        taCourses.clear();
        computerScienceRadioButton.setSelected(false);
        businessRadioButton.setSelected(false);
        cbCourses.getItems().clear();
        studentConcil.setSelected(false);
        volunteerWork.setSelected(false);
    }

    public void loadComboBox() {
        //ComboBox
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
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialize method");
        cbCourses.getItems().addAll("Java", "Python", "C#", "JavaScript");

    }
}



