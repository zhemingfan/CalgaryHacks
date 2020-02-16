package application;
import ProofOfConcept.*;

import java.util.ArrayList;
import java.util.Arrays;

import Entities.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ResultsPane extends Pane {
	
	private int height;
	private int width;
	private class ProfileEvent implements EventHandler<ActionEvent> {
		private Professor prof;
		private HBox layout;
		
		public ProfileEvent(Button temp, Professor prof, HBox layout) {
			this.prof = prof;
			this.layout = layout;
			temp.setOnMouseEntered( e -> {
				temp.setStyle("-fx-background-color: #ef310d; -fx-text-fill: #000000");
			});
			temp.setOnMouseExited( e -> {
				temp.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000000");
			});
		}
		@Override
		public void handle(ActionEvent event) {
			if (layout.getChildren().size() >1) {
				layout.getChildren().remove(1);
			}
			StackPane profile = new StackPane();
			Text profileText = new Text();
			profile.setPrefSize(width*0.7,height);
			profile.setStyle("-fx-background-color: #FFFFFF");
			profileText.setText(prof.getProfile());
			profile.getChildren().add(profileText);
			layout.getChildren().add(profile);
		}
		
	}
	
	public ResultsPane(String department, ArrayList<String> interests, int w, int h) {
		super();
		this.height = h;
		this.width = w;
		
		HBox layout = new HBox(8);	
		ScrollPane resultBox = new ScrollPane();
		VBox resultList = new VBox(8);
		resultList.setPrefSize(width*0.3, height);
		resultList.setStyle("-fx-background-color: #ffffff");
		resultBox.setContent(resultList);
		resultBox.setStyle("-fx-background-color: #ffffff");
		layout.getChildren().add(resultBox);
		
		
		//INSERTED
		ArrayList<String> testInterest = new ArrayList<>(Arrays.asList("Coding", "White Whale AI", "Eating", "Hackathons", "KBBQ"));
	    ArrayList<String> testInterest2 = new ArrayList<>(Arrays.asList("Datamining" , "Eating", "A&W"));
	    ArrayList<String> testInterest3 = new ArrayList<>(Arrays.asList("Coding", "Datamining", "Eating", "A&W"));

	    Professor testProf3 = new Professor("Jeremy Fan", testInterest3, "www.youtube.com/Jeremy", "Computer Sceince", "jeremy.fan@ucalgary.ca");
	    Professor testProf2 = new Professor("Kelly Liu", testInterest2, "www.youtube.com/KellyLiu", "Computer Science", "Kelly.Liu2@ucalgary.ca");
	    Professor testProf = new Professor("Se Yeon Kim", testInterest, "www.youtube.com/SeYeonKim", "Computer Science", "Kim.SeYeon@ucalgary.ca");

	    ArrayList<Professor> matches = new ArrayList<>(Arrays.asList(testProf, testProf2, testProf3));
	    
	    //ArrayList<String> testUserInterest = new ArrayList<>(Arrays.asList("Datamining", "Coding", "Eating", "A&W"));
	    User testUser = new User("Jonathan Santos", SearchPane.keys, "Computer Science");
	    
	    
	/*	for (int i = 0; i < 21; i ++) {
			matches.add(new Professor("a"+i, new ArrayList<String>(),"a"+i, "a"+i, "a"+i));
		}*/
		
		Button temp = new Button();
		
		for (int i = 0; i < matches.size(); i++ ) {
			temp = new Button();
			temp.setBackground(null);
			temp.setPrefSize(width*0.3, height * 0.05);
			temp.setText(matches.get(i).getName() + "\t" + ProofOfConcept.compareStats(matches.get(i), testUser) + "% match");
			temp.setOnAction( new ProfileEvent(temp, matches.get(i),layout));
			resultList.getChildren().add(temp);
		};
		
		
		Button btn = new Button("Back");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Scene sc = Main.getScene();
				sc.setRoot(new SearchPane(ResultsPane.this.width, ResultsPane.this.height));
			}
		});
		
		this.getChildren().addAll(layout,btn);
		this.setStyle("-fx-background-color: #00000f ");
	}
}
