package com.github.haocen2004.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Launcher extends Application {

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(getClass().getResource("/resources/assets/fxml/UImain.fxml"));
		try {

			BorderPane root = new BorderPane(
					FXMLLoader.load(getClass().getResource("/resources/assets/fxml/UImain.fxml")));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("/resources/assets/img/icon.png"));
			primaryStage.setTitle("Hellocraft Skins Downloader");
			primaryStage.show();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
