package mouse;

import javafx.application.Platform;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class Drawing {

    @FXML
	private Label label;

    @FXML
	private CheckBox isDeep;

    @FXML
	private Pane canvas;

    private EventHandler<MouseEvent> handler;
    private MoveInfo pastmi = new MoveInfo();
    public class MoveInfo{
	double x,y;
	MoveInfo(){
	    this.x = -1;
	    this.y = -1;
	}
	MoveInfo(double x, double y){
	    this.x = x;
	    this.y = y;
	}
	public void setInfo(double x, double y){
	    this.x = x;
	    this.y = y;
	}
    };
    
    @FXML
	private Button Button_s;

    @FXML
	protected void clickButton_s(ActionEvent e){
	if(this.Button_s.getText().equals("Start")){
	    this.Button_s.setText("Stop");
	    handler = new EventHandler<MouseEvent>(){
		public void handle(MouseEvent event){
		    if(pastmi.x>=0){
			Line line = new Line(pastmi.x,pastmi.y,event.getX(),event.getY());
			line.setFill(null);
                        if(!isDeep.isSelected())
                            line.setStroke(Color.BLUE);
                        else
                            line.setStroke(Color.RED);
			canvas.getChildren().add(line);
		    }
		    pastmi.setInfo(event.getX(),event.getY());
		    try {
			if(!isDeep.isSelected())
			    Thread.sleep(100);
			else
			    Thread.sleep(0);
		    } 
		    catch (InterruptedException e) {
			e.printStackTrace();
		    }
		    pastmi.setInfo(event.getX(),event.getY());
		    event.consume();
		}
	    };
	    this.canvas.addEventHandler(MouseEvent.MOUSE_MOVED, this.handler);
	}
		else if(this.Button_s.getText().equals("Stop")){
			this.Button_s.setText("Start");
			this.canvas.removeEventHandler(MouseEvent.MOUSE_MOVED, this.handler);
		}
    }

    @FXML
	private Button Button_q;

    @FXML
	protected void clickButton_q(ActionEvent i){
		if(this.Button_q.getText().equals("Quit")){
			Platform.exit();
		}
    }
}