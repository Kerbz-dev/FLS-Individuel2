package presentation;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
public class Controller {


	    @FXML
	    private TextField passText;

	    @FXML
	    private TextField userText;

	    @FXML
	    public void loginCheck(ActionEvent event) {
	    	if(userText.getText().equals("user") && passText.getText().equals("pass")) {
	    		System.out.println("success");
	    	} else {
	    		System.out.println("failed");
	    //	Stage loginStage = new Stage();
	    }
	    }
}

