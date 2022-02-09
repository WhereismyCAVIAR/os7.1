package mouse;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    
    public static void main(String[] args){
	launch(args);
    }
    
    public void start(Stage stage) throws Exception{
	stage.setTitle("Draw with the mouse");
	Parent fxml_l = FXMLLoader.load(getClass().getResource("parts.fxml"));
	Scene scene = new Scene(fxml_l);
	stage.setScene(scene);
	stage.show();
    }
}
