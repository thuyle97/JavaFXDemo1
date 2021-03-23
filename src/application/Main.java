package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {
	int counter = 0;
	@Override
	public void start(Stage primaryStage) //abstract method -> must implement
	{
		try {
			Label lbl = new Label("Counter = ?");
			lbl.setFont(new Font("Arial", 30));
			Button incBtn = new Button("Increase");
			Button decBtn = new Button ("Decrease");
			
			//Using lambda expression
			incBtn.setOnAction(event -> {
				lbl.setText("Counter = " + (++counter));
			});
			
//			incBtn.setOnAction(new EventHandler<ActionEvent>() {
//				@Override
//				public void handle(ActionEvent arg0) {
//					counter += 1;
//					lbl.setText("Counter = " + counter);	
//				}
//			});
			
			decBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					counter -= 1;
					lbl.setText("Counter = " + counter);	
				}
			});
			
			
			VBox root = new VBox(); //Layout manager	
			
			HBox buttons = new HBox();
			buttons.getChildren().add(incBtn);
			buttons.getChildren().add(decBtn);
			
			root.getChildren().add(lbl); //add label
			root.getChildren().add(buttons); //add button
			//root.getChildren().add(decBtn);
			
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
