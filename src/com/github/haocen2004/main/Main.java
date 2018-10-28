package com.github.haocen2004.main;

import com.github.haocen2004.cmd.SkinGet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {

		int i = 0;
		String UserName;

		while (true) {
			try {

				if (args[i] != null && args[i].length() != 0) {

					if (args[i].equalsIgnoreCase("-userid")) {

						System.out.println("User Name By String is " + args[i + 1]);
						UserName = args[i + 1];
						SkinGet.GetSKin(UserName);
						break;

					}

				} else {

					break;

				}

				i++;

			} catch (ArrayIndexOutOfBoundsException e) {

				System.out.println("Without Start Args");
				launch();
				break;

			}

		}

	}

	@Override
	public void start(Stage primaryStage) {
		try {

			System.out.println(getClass().getResource("UImain.fxml"));
			BorderPane root = new BorderPane(FXMLLoader.load(getClass().getResource("UImain.fxml")));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hellocraft SKins Downloader");
			primaryStage.show();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
