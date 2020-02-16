package application;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class Main extends Application {
	final int S_WIDTH = 1280;
	final int S_HEIGHT = 720;
	
	private static Scene sc;
	
	@Override
	public void start(Stage ps) {
		try {
			Main.sc = new Scene(new SearchPane(S_WIDTH, S_HEIGHT), S_WIDTH, S_HEIGHT);
			ps.setScene(sc);

			ps.setFullScreen(true);
			ps.setFullScreenExitHint("");
			//ps.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
			ps.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Scene getScene() {
		return Main.sc;
	}
}
