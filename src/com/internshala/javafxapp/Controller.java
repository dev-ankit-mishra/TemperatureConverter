
package com.internshala.javafxapp;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

	@FXML
	public Label welcomeLabel;

	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public TextField userInput;

	@FXML
	public Button converterBtn;

	private static final String c_to_f= "Celsius to Fahrenheit";

	private static final String f_to_c= "Fahrenheit to Celsius";

	private boolean isC_TO_F=true;



	@Override
	public void initialize(URL location, ResourceBundle resources) {

		converterBtn.setOnAction(event -> {
			convert();
		});

		choiceBox.getItems().add(c_to_f);

		choiceBox.getItems().add(f_to_c);

		choiceBox.setValue(c_to_f);


		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.equals(c_to_f)){
				isC_TO_F=true;
			}else{
				isC_TO_F=false;
			}
		});

	}

	private void convert() {
		String input=userInput.getText();
		float enteredTemp=0.0f;
		try{
			enteredTemp=Float.parseFloat(input);
		}catch(Exception exception ){
			warnUser();
			return;
		}
		float newTemp=0.0f;
		if(isC_TO_F){
			newTemp=(enteredTemp * 9 / 5) + 32;
		}else{
			newTemp=(enteredTemp - 32) * 5 / 9;
		}
		display(newTemp);
	}

	private void warnUser() {
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText("Error Occured");
		alert.setTitle("Invalid Temperature");
		alert.setContentText("Enter a valid temperature");
		alert.show();
	}

	private void display(float newTemp) {
		String unit=isC_TO_F ? " F":" C";
		System.out.println("The new temp is :"+ newTemp + unit);
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new temp is : "+ newTemp + unit);
		alert.show();
	}
}
