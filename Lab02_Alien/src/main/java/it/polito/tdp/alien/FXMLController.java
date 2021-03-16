package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private AlienDictionary ad = new AlienDictionary();;

	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTranslate;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {

    	this.txtRisultato.clear();
    	this.txtTranslate.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {

    	boolean tro = false;
    	for(int i=0;i<this.txtTranslate.getText().length();i++)
    	{
    		if(this.txtTranslate.getText().charAt(i) == '?')
    			tro = true;
    			
    			
    		if((this.txtTranslate.getText().charAt(i) != ' ')&&(this.txtTranslate.getText().charAt(i) != '?'))
    		{
    			if(!Character.isLetter(this.txtTranslate.getText().charAt(i)))
    			{
    				this.txtRisultato.setText("ERRORE: DEVONO ESSERCI SOLO LETTERE");
    				return;
    			}
    		}    	
    	}
    	
    	String array[] = this.txtTranslate.getText().split(" ");
    	if(array.length>2)
    	{
    		this.txtRisultato.setText("ERRORE: inserire 1 o 2 parole");
    	}
    	
    	if(array.length == 1)
    	{
    		if(tro == true)
    		{
    			this.txtRisultato.setText(ad.translateWord(ad.compareString(array[0])));
    			this.txtTranslate.clear();
        		return;
    		}
    		this.txtRisultato.setText(ad.translateWord(array[0]));
    		this.txtTranslate.clear();
    		return;
    	}
    	
    	if(array.length == 2)
    	{
    		ad.addWord(array[0], array[1]);
    		this.txtTranslate.clear();
    		this.txtRisultato.clear();
    		return;
    	}
    	
    	
    }

   
    @FXML
    void initialize() {
        assert txtTranslate != null : "fx:id=\"txtTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
