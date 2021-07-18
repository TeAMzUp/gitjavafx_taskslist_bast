package ResetThosePacks;

//import ResetThosePacks.TestMyDB;

//import ResetThosePacks.SystemInfo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
//import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
//import javafx.scene.shape.Circle;
//import javafx.scene.text.Font;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
//import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

//import java.sql.*;
import java.util.List;
import java.util.Optional;

import com.dieselpoint.norm.Database;

//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;

/**
 * JavaFX App
 */
public class App extends Application {

	private TextField text = new TextField();
	private Button btn = new Button ("<- Add Task");
	private Button btn2 = new Button ("Toggle Selected Task Done/Undone");
	private Button btn3 = new Button ("Delete task from DB");
	
	private ListView<TestMyDB> listView = new ListView(); // needing this one public?
	
    private Database db = new Database();
    
    private TestMyDB changedTask = new TestMyDB();
    //private BorderPane root7 = new BorderPane();
    
    private BorderPane root = new BorderPane();
    private Scene scene = new Scene(root, 640, 480);
	
	@Override
    public void start(Stage stage) {
    	//var javaVersion = SystemInfo.javaVersion();
        //var javafxVersion = SystemInfo.javafxVersion();

        //ListView listView = new ListView();
        //var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        
        //var lbl = new Label("What doink");
        //var font = new Font(20);
        
        //btn.setFont(20);
        //var root = new BorderPane();
        var box = new HBox();
        //Button btn4 = new Button ("Delete task from DB");
        
        box.getChildren().add(btn2);
        box.getChildren().add(text);
        box.getChildren().add(btn);
        box.getChildren().add(btn3);
        //root.setCenter(listView);
        root.setBottom(box);
        box.setPadding(new Insets(30));
        
        //btn.setShape(new Circle(30));
        //btn.setPrefSize(50,50);
        btn.setOnAction(new HandleClick());
        btn2.setOnAction(new handle2());
        btn3.setOnAction(new handle3());
        
        db.setJdbcUrl("jdbc:mysql://localhost:3306/java?useSSL=false");
        db.setUser("root");
        db.setPassword("");
        
        List<TestMyDB> msgs = db.results(TestMyDB.class);
//        for (TestMyDB a : msgs) {
//        	System.out.println(a);
//        }
        
        listView.setItems(FXCollections.observableArrayList(msgs));
        
        //Not a ClickHandle(), but an addListener() on item selected
        //listView.selectionModelProperty().addListener(null);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TestMyDB>() {
			@Override
			public void changed(ObservableValue<? extends TestMyDB> observable, TestMyDB oldValue, TestMyDB newValue) {
				// TODO Auto-generated method stub
				//System.out.println(oldValue);
				System.out.println(newValue);
				changedTask = newValue;
			}
        });
        
        root.setCenter(listView);
        
        //var scene = new Scene(root, 640, 480);
        stage.setTitle("TasksList JavaFx");
        stage.setScene(scene);
        stage.show();
    }
    
	//ClickHandle() on insert button
    class HandleClick implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
        	System.out.println(event.getEventType()); // affiche le type de l'event
        	System.out.println(event.getTarget()); // affiche la source de l'event
        	//Button btn = (Button) event.getSource();
        	
        	String x1Full = text.getText();
        	System.out.println(x1Full);
        	
        	//Database db2 = new Database();
            db.setJdbcUrl("jdbc:mysql://localhost:3306/java?useSSL=false");
            db.setUser("root");
            db.setPassword("");
            
            TestMyDB tempTask = new TestMyDB();
            tempTask.NomT = x1Full;
            if (x1Full != "") {
            	db.insert(tempTask);
            }
        	
        	List<TestMyDB> msgs = db.results(TestMyDB.class);
        	listView.setItems(FXCollections.observableArrayList(msgs));
        }
    }
    
    //ClickHandle() on update button
    class handle2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
        	System.out.println(event.getEventType()); // affiche le type de l'event
        	System.out.println(event.getTarget()); // affiche la source de l'event
        	
        	//Database db2 = new Database();
            db.setJdbcUrl("jdbc:mysql://localhost:3306/java?useSSL=false");
            db.setUser("root");
            db.setPassword("");
            
            if (changedTask != null && changedTask.idT > 0) {
            	if (changedTask.DoneT == false) {
            		//changed DoneT column in DB to true
            		changedTask.DoneT=true;
            		db.update(changedTask);
            	}
            	else {
            		//changedTask.DoneT = false;
            		//changed DoneT column in DB to false
            		changedTask.DoneT=false;
            		db.update(changedTask);
            	}
            }
        	
        	List<TestMyDB> msgs = db.results(TestMyDB.class);
        	listView.setItems(FXCollections.observableArrayList(msgs));
        }
    }
    
    //ClickHandle() on delete button
    class handle3 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
        	System.out.println(event.getEventType()); // affiche le type de l'event
        	System.out.println(event.getTarget()); // affiche la source de l'event
        	
        	//Database db2 = new Database();
            db.setJdbcUrl("jdbc:mysql://localhost:3306/java?useSSL=false");
            db.setUser("root");
            db.setPassword("");
            
            if (changedTask != null && changedTask.idT > 0) {
            	Alert alert = new Alert(AlertType.CONFIRMATION);
            	alert.setTitle("Confirmation Dialog");
            	alert.setHeaderText(null);
            	alert.setContentText("Are you sure you want to delete this task?");

            	Optional<ButtonType> result = alert.showAndWait();
            	if (result.get() == ButtonType.OK){
            	    // ... user chose OK
            		db.delete(changedTask);
            	} else {
            	    // ... user chose CANCEL or closed the dialog
            	}
            }
        	
        	List<TestMyDB> msgs = db.results(TestMyDB.class);
        	listView.setItems(FXCollections.observableArrayList(msgs));
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
