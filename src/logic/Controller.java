package logic;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.Main;
public class Controller  {

	Main ui = new Main();
		String medarbejderNavn;
	 	String username;
	 	String password;
	 	
	    @FXML
	    private TextField passLoginField;
	    @FXML
	    private TextField userLoginField;
	    @FXML
	    private TextField opretNavnField;
	    @FXML
	    private TextField opretBrugerField;
	    @FXML
	    private TextField opretPassField;
	    
	    @FXML
	    public void loginCheck(ActionEvent event) {
	    	if(userLoginField.getText().equals(username) && passLoginField.getText().equals(password)) {
	    		System.out.println("Successful login!");
	    	} else {
	    		System.out.println("Incorrect username or password");

	    }
	   }
		
	    @FXML
		  public void opretLogin(ActionEvent event) throws IOException {
		    
		    	try {
		    	Parent root = FXMLLoader.load(getClass().getResource("/presentation/opretLoginUI.fxml"));
		      
		    	Scene scene = new Scene(root);
		    	Stage primaryStage = new Stage();
		    	primaryStage.setScene(scene);
		    	primaryStage.setTitle("Ferrari login");
		    	primaryStage.show();
		            
		    } catch(Exception e) {
		    	e.printStackTrace(); }
	    }
	    }







