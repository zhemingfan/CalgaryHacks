package application;
import ProofOfConcept.*;

import java.util.ArrayList;
import java.util.Arrays;

import Entities.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class SearchPane extends Pane {
	private int height;
	private int width;
	public static ArrayList<String> keys;
	private ComboBox<String> selDept;
	private FlowPane keypane;
	private VBox vbox = new VBox();
	private class InterestEvent implements EventHandler<ActionEvent> {
		private Button temp;
		
		public InterestEvent(Button temp) {
			this.temp = temp;
		}
		@Override
		public void handle(ActionEvent event) {
	
				if (keys.contains(temp.getText())) {
					// remove button text from keys list
					keys.remove(temp.getText());
					// set button style to default
					temp.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff");
				} else {
					System.out.println("Selected\n");
					keys.add(temp.getText());
					temp.setStyle("-fx-background-color: #ef310d; -fx-text-fill: #000000");
				}
			
		}
		
	}
	
	public SearchPane(int w, int h) {
		super();
		this.height = h;
		this.width = w;
		this.keys = new ArrayList<String>();
		
		ImageView logo = new ImageView( new Image("/application/logo.png", true));
		logo.setLayoutX((this.width/(2)-50));
		logo.setLayoutY(100);
		
		Button btn = new Button("Search");
		btn.setPrefWidth(100);
		btn.setPrefHeight(50);
		btn.setLayoutX((this.width/2)+100);
		btn.setLayoutY(550);	
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Scene sc = Main.getScene();
				sc.setRoot(new ResultsPane(SearchPane.this.selDept.getValue(), SearchPane.this.keys, SearchPane.this.width, SearchPane.this.height));
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
				SearchPane.this.keypane.getChildren().forEach((i) -> {
					i.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff");
				});
//				SearchPane.this.keypane.getChildren().clear();
			}
		});
		
		this.selDept = new ComboBox<>();
		this.selDept.getItems().addAll("Computer Science", "Other");
		this.selDept.setPromptText("Select a Department");
		this.selDept.setPrefWidth(500);
		this.selDept.setPrefHeight(50);
		this.selDept.setLayoutX(this.width/2-250);
		this.selDept.setLayoutY(235);
		this.selDept.setEditable(true);
		
//		TextField selKey = new TextField("");
//		selKey.setPromptText("Enter keywords");
//		selKey.setPrefWidth(500);
//		selKey.setPrefHeight(50);
//		selKey.setLayoutX(this.width/2-250);
//		selKey.setLayoutY(160);
//		selKey.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent e) {
//				SearchPane.this.keys.add(selKey.getText());
//				Text text = new Text(selKey.getText());
//				Rectangle rec = new Rectangle(text.getLayoutBounds().getWidth()+8, text.getLayoutBounds().getHeight()+8);
//				rec.setFill(Color.web("#89cff0"));
//				StackPane textbox = new StackPane();
//				textbox.getChildren().addAll(rec, text);
//				SearchPane.this.keypane.getChildren().add(textbox);
//			}
//		});
		
		ArrayList<String> strlist = new ArrayList<String>();
		
		Button descriptor = new Button();
		descriptor.setBackground(null);
		descriptor.setText("Which of the following topics interest you?");
		
		vbox.setLayoutX(this.width/2-250);
		vbox.setLayoutY(350);
		vbox.getChildren().add(descriptor);
		
		this.keypane = new FlowPane();
		this.keypane.setPrefWidth(500);
		this.keypane.setPrefHeight(300);
		this.keypane.setLayoutX(this.width/2-250);
		this.keypane.setLayoutY(390);
		this.keypane.setHgap(4);
		this.keypane.setVgap(4);
		
		Button btnkey = new Button();
		
//		ArrayList<String> interestList = new ArrayList<>(Arrays.asList("Coding", "Hackathons", "Cisco", "White Whale AI", "A&W", "Eating", "KBBQ", "Algorithms", "Linux", "Windows"));
		ProofOfConcept poc = new ProofOfConcept();
		ArrayList<String> interestList = ProofOfConcept.getUniqueInterests();
		for (int i = 0; i < 10; i++ ) {
			btnkey= new Button();
			btnkey.setBackground(null);
			btnkey.setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff");
			btnkey.setOnAction( new InterestEvent(btnkey));
//			btnkey.setPrefSize(width*0.3, height * 0.05);
			btnkey.setText(interestList.get(i));

			SearchPane.this.keypane.getChildren().add(btnkey);
		};
		
//		this.getChildren().addAll(logo,btn, this.selDept, selKey, this.keypane, clr);
		
		this.getChildren().addAll(logo, this.selDept, vbox, this.keypane, clr, btn);
		this.setStyle("-fx-background-color: white");
	}
}
