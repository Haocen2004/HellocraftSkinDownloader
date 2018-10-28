package com.github.haocen2004.main;

import java.net.URL;
import java.util.ResourceBundle;
import com.github.haocen2004.cmd.SkinGet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

	@FXML
	private Button SkinGetB;

	@FXML
	private TextField UserNamein;

	@FXML
	private Label feedback;

	public void toGetSKinB(ActionEvent event) {
		try {
			if ((UserNamein.getText().trim().equals(""))) {

				System.out.println("With out UserName");

			} else {

				System.out.println("UserName: " + UserNamein.getText());
				feedback.setText("System : Getting " + UserNamein.getText() + "'s Skin.");
				SkinGet.GetSKin(UserNamein.getText());
				feedback.setText("System : " + UserNamein.getText() + "'s Skin Download Finish.");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("Java FX " + arg0 + " loaded!");

	}

}