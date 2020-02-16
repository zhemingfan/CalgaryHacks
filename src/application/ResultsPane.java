package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import java.util.ArrayList;

public class ResultsPane extends Pane {
	
	private int height;
	private int width;
	
	public ResultsPane(int h, int w) {
		super();
		this.height = h;
		this.width = w;
		Button btn = new Button("Back");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Scene sc = Main.getScene();
				sc.setRoot(new SearchPane(ResultsPane.this.height, ResultsPane.this.width));
			}
		});
		ScrollPane results = new ScrollPane();
		results.setPrefSize(width, height*0.90);
		results.setLayoutX(0);
		results.setLayoutY(height*0.05);
		
		this.getChildren().add(btn);
		this.getChildren().add(results);
		this.setStyle("-fx-background-color: #F7EAE2");
	}
}
