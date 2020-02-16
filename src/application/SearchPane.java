package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class SearchPane extends Pane {
	private int height;
	private int width;
	private ArrayList<String> keys;
	private ComboBox<String> selDept;
	private FlowPane keypane;
	
	public SearchPane(int w, int h) {
		super();
		this.height = h;
		this.width = w;
		this.keys = new ArrayList<String>();
		
		Button btn = new Button("Search");
		btn.setPrefWidth(100);
		btn.setPrefHeight(50);
		btn.setLayoutX((this.width/2)+100);
		btn.setLayoutY(550);
		btn.setStyle("-fx-focus-color:transparent; -fx-faint-focus-color:transparent");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Scene sc = Main.getScene();
				System.out.println(SearchPane.this.selDept.getValue());
				System.out.println(SearchPane.this.keys);
				sc.setRoot(new ResultsPane(SearchPane.this.width, SearchPane.this.height));
			}
		});
		
		Button clr = new Button("Clear");
		clr.setPrefWidth(100);
		clr.setPrefHeight(50);
		clr.setLayoutX((this.width/2)-200);
		clr.setLayoutY(550);	
		clr.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				SearchPane.this.keys.clear();
				SearchPane.this.keypane.getChildren().clear();
			}
		});
		
		this.selDept = new ComboBox<>();
		this.selDept.getItems().addAll("Computer Science", "Other");
		this.selDept.setPromptText("Select a Department");
		this.selDept.setEditable(true);
		this.selDept.setPrefWidth(500);
		this.selDept.setPrefHeight(50);
		this.selDept.setLayoutX(this.width/2-250);
		this.selDept.setLayoutY(100);
		
		TextField selKey = new TextField();
		selKey.setPromptText("Enter keyword(s)");
		selKey.setPrefWidth(500);
		selKey.setPrefHeight(50);
		selKey.setLayoutX(this.width/2-250);
		selKey.setLayoutY(160);
		selKey.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (!selKey.getText().contentEquals("")) {
					SearchPane.this.keys.add(selKey.getText());
					Text text = new Text(selKey.getText());
					text.setFill(Color.WHITE);
					text.setStyle("-fx-font: 14 arial");
					new Scene(new Group(text));
					text.applyCss();
					Rectangle rec = new Rectangle(text.getLayoutBounds().getWidth()+20, text.getLayoutBounds().getHeight()+10);
					rec.setFill(Color.web("#89cff0"));
					rec.setArcHeight(50);
					rec.setArcWidth(25);
					StackPane textbox = new StackPane();
					textbox.getChildren().addAll(rec, text);
					SearchPane.this.keypane.getChildren().add(textbox);
					selKey.clear();
				}
			}
		});
		
		this.keypane = new FlowPane();
		this.keypane.setPrefWidth(500);
		this.keypane.setPrefHeight(300);
		this.keypane.setLayoutX(this.width/2-250);
		this.keypane.setLayoutY(220);
		this.keypane.setHgap(8);
		this.keypane.setVgap(4);
		
		
		this.getChildren().addAll(btn, this.selDept, selKey, this.keypane, clr);
		this.setStyle("-fx-background-color: white");
	}
}
