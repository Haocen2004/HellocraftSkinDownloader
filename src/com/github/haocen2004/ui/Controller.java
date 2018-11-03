package com.github.haocen2004.ui;

import java.net.URL;
import java.util.ResourceBundle;

import com.github.haocen2004.core.NameToUUID;
import com.github.haocen2004.core.ProfileToUrl;
import com.github.haocen2004.core.UUIDtoProfile;
import com.github.haocen2004.net.Download;

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
	private Button guid;
	@FXML
	private Button gurl;
	@FXML
	private Button dl;

	@FXML
	private TextField UserNamein;
	@FXML
	private TextField UUIDin;
	@FXML
	private TextField URLin;

	@FXML
	private Label feedback;

	public void toGetSKinB(ActionEvent event) {
		try {
			if (!(UserNamein.getText().trim().equals(""))) {
				String UserName = UserNamein.getText();
				feedback.setText("System : Getting " + UserName + "'s Skin.");
				System.out.println("UserName: " + UserName);
				UUIDin.setText(NameToUUID.Ntu(UserName));
				String UUID = UUIDin.getText();
				URLin.setText(ProfileToUrl.DtS(UUIDtoProfile.UtD(UUID)));
				String URL = URLin.getText();
				String save = ".\\skins\\" + UserName + ".png";
				Download.single(URL, save);
				feedback.setText("System : " + UserName + "'s Skin Download Finish.");

			} else {

				System.out.println("With out UserName");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getUUID(ActionEvent event) {

		String UserName = UserNamein.getText();
		if (!(UserName.trim().equals(""))) {
			UUIDin.setText(NameToUUID.Ntu(UserName));
		}

	}

	public void getURL(ActionEvent event) {
		String UUID = UUIDin.getText();
		if (!(UUID.trim().equals(""))) {
			URLin.setText(ProfileToUrl.DtS(UUIDtoProfile.UtD(UUID)));

		}

	}

	public void download(ActionEvent event) {
		String URL = URLin.getText();
		String UserName = UserNamein.getText();
		if (!(UserName.trim().equals(""))) {

			if (!(URL.trim().equals(""))) {

				String save = ".\\skins\\" + UserName + ".png";
				Download.single(URL, save);

			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("Java FX " + arg0 + " loaded!");

	}
}