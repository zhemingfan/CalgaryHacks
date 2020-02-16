package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class SearchPane extends Pane {
	private int height;
	private int width;
	
	public SearchPane(int h, int w) {
		super();
		this.height = h;
		this.width = w;
		Button btn = new Button("Test");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Scene sc = Main.getScene();
				sc.setRoot(new ResultsPane(SearchPane.this.height, SearchPane.this.width));
			}
		});
		this.getChildren().add(btn);
		this.setStyle("-fx-background-color: #e30300");
	}
}
