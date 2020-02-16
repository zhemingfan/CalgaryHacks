package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class SearchPane extends Pane {
	private int height;
	private int width;
	private ArrayList<String> keys;
	
	public SearchPane(int w, int h) {
		super();
		this.height = h;
		this.width = w;
		this.keys = new ArrayList<String>();
		
		Button btn = new Button("Search");
		btn.setPrefWidth(100);
		btn.setPrefHeight(50);
		btn.setLayoutX((this.width/2)-50);
		btn.setLayoutY(550);	
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Scene sc = Main.getScene();
				sc.setRoot(new ResultsPane(SearchPane.this.width, SearchPane.this.height));
			}
		});
		
		ComboBox<String> selDept = new ComboBox<>();
		selDept.getItems().addAll("Computer Science", "Other");
		selDept.setPromptText("Select a Department");
		selDept.setPrefWidth(500);
		selDept.setPrefHeight(50);
		selDept.setLayoutX(this.width/2-250);
		selDept.setLayoutY(100);
		
		TextField selKey = new TextField("Enter Keywords");
		selKey.setPrefWidth(500);
		selKey.setPrefHeight(50);
		selKey.setLayoutX(this.width/2-250);
		selKey.setLayoutY(160);
		
		
		FlowPane curKeys = new FlowPane();
		curKeys.setPrefWidth(500);
		curKeys.setPrefHeight(300);
		curKeys.setLayoutX(this.width/2-250);
		curKeys.setLayoutY(220);
		curKeys.setStyle("-fx-background-color: #00ffff");
		
		
		this.getChildren().addAll(btn, selDept, selKey, curKeys);
		this.setStyle("-fx-background-color: #e30300");
	}
}
