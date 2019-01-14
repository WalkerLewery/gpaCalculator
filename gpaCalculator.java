/**
@auther Walker Lewery 3617181
*/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import java.text.*;
import javafx.geometry.Pos;

public class gpaCalculator extends Application{
	private Button buttonAdd,buttonClear;
	private Label message,text1,text2;
	private TextField field1,field2;
	private double gpa=0,point=0,top=0,bottom=0;
	public void start (Stage stage){
			stage.setTitle("My GPA calculator");
			//buttons
			buttonAdd = new Button("Add to GPA");
			buttonAdd.setOnAction(this::eventHandler);
			buttonClear = new Button("Clear GPA");
			buttonClear.setOnAction(this::eventHandler);
			
			//Label
			message = new Label("Welcome to my GPA calculator! \nEnter your 1st grade & credit hrs.");
			text1 = new Label("Course letter grade: ");
			text2 = new Label("Course credit hours: ");
			
			//text field
			field1 = new TextField();
			field1.setPrefWidth(40);
			field2 = new TextField();
			field2.setPrefWidth(40);
			
			FlowPane myPane = new FlowPane(text1,field1,text2,field2,buttonAdd,buttonClear,message);
			myPane.setHgap(10);
			myPane.setVgap(10);
			myPane.setAlignment(Pos.CENTER);
			
			Scene myScene = new Scene(myPane,230,200);
			
			stage.setScene(myScene);
			stage.show();	
	}
	public void eventHandler(ActionEvent event){
		NumberFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		switch (field1.getText()){
			case "A+":
			point = 4.3;
			break;
	
			case "A":
			point = 4.0;
			break;

			case "A-":
			point = 3.7;
			break;

			case "B+":
			point = 3.3;
			break;

			case "B":
			point = 3.0;
			break;

			case "B-":
			point = 2.7;
			break;

			case "C+":
			point = 2.3;
			break;

			case "C":
			point = 2.0;
			break;

			case "D":
			point = 1;
			break;
			
			case "F":
			point = 0;
			break;
			
			case "WF":
			point = 0;
			break;

			default:
			point=-1;
			
		}
		if((event.getSource()==buttonAdd) && point!=-1){
			top+=point*Double.parseDouble(field2.getText());
			bottom+=Double.parseDouble(field2.getText());
			gpa=top/bottom;
			message.setText("Points for this course: "+point+"\nYour cumulative GPA is: "+df.format(gpa));
		}
		else if((event.getSource()==buttonClear)){
			gpa=0;	
			point=0;
			message.setText("\tTotals Have been reset"+"\nEnter your 1st grade & credit hrs.");
		}

		else if(point ==-1){
			message.setText("Invalid grade - GPA not changed."+"\nYour cumulative GPA is: "+df.format(gpa));
		}

		
		
	}
}
