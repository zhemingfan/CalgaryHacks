package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ResultsPane extends Pane {
	
	private int height;
	private int width;
	
	public ResultsPane(int w, int h) {
		super();
		this.height = h;
		this.width = w;
		Button btn = new Button("Test");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Scene sc = Main.getScene();
				sc.setRoot(new SearchPane(ResultsPane.this.width, ResultsPane.this.height));
			}
		});
		this.getChildren().add(btn);
		this.setStyle("-fx-background-color: #0000ff");
	}
}
