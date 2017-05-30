package hu.unideb.inf.pk.RunDiary.ui;

import java.net.URL;

import java.util.ResourceBundle;

import hu.unideb.inf.pk.RunDiary.Calculator;
import hu.unideb.inf.pk.RunDiary.database.RunDAO;
import hu.unideb.inf.pk.RunDiary.database.RunDAOFactory;
import hu.unideb.inf.pk.RunDiary.database.RunEntity;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javafx.stage.Stage;

public class AddNewController implements Initializable {
	
	private Double avarageSpeed = new Double(0.0);
	private Double calories = new Double(0.0);
	private Boolean edit =Boolean.FALSE;
	
	private RunDAOFactory daoFactory;
	private static Logger	
	logger = LoggerFactory.getLogger(AddNewController.class);

	private RunEntity runEntity;

	@FXML
	private Button calcBt;
	@FXML
	private Button doneBt;
	@FXML
	private Button cancleBt;
	@FXML
	private TextField distanceIN;
	@FXML
	private TextField timeIN;
	@FXML
	private DatePicker dateIN;

	@FXML
	private Label speedIN;

	@FXML
	private Label caloriesIN;

	@FXML
	private Label warnL;

	@FXML
	private void onCancleBt() {
		Stage s = (Stage) cancleBt.getScene().getWindow();
		s.close();
	}

	@FXML
	private void onDoneBt(ActionEvent event) {
		RunDAO runDao = daoFactory.createRunDAO();

		try {
			 if(!edit){
				 runEntity = new RunEntity();
		        }
			
			runEntity.setDate(dateIN.getValue());
			runEntity.setDistance(Integer.parseInt(distanceIN.getText()));
			runEntity.setTime(Integer.parseInt(timeIN.getText()));
			
			
			
			Calculator calc = new Calculator(Double.parseDouble(timeIN.getText()),Double.parseDouble(distanceIN.getText()));
			
			avarageSpeed = calc.calculateAvrageSpeed();
			calories = calc.calculateCalories();
			
			runEntity.setAverageSpeed(avarageSpeed);
			runEntity.setBurnedCalories(calories);
			runDao.createEntry(runEntity);
			onCancleBt();
		} catch (Exception e) {
			logger.error("All Fields must be filled");
			warnL.setText("Az összes mező kitöltése kötelező!");
		}

	}

	@FXML
	private void calculate(ActionEvent event) {
		
		Calculator calc = new Calculator(Double.parseDouble(timeIN.getText()),Double.parseDouble(distanceIN.getText()));
		
		avarageSpeed = calc.calculateAvrageSpeed();
		calories = calc.calculateCalories();
		speedIN.setText(avarageSpeed.toString());
		caloriesIN.setText(calories.toString());

	}

	public void initialize(URL location, ResourceBundle resources) {
		daoFactory = RunDAOFactory.getInstance();

	}

	public void setRunEntity(RunEntity re){
		dateIN.setValue(re.getDate());
		timeIN.setText(new Integer(re.getTime()).toString());
		distanceIN.setText(new Integer(re.getDistance()).toString());
		speedIN.setText(new Double(re.getAverageSpeed()).toString());
		caloriesIN.setText(new Double(re.getBurnedCalories()).toString());
		
		edit = Boolean.TRUE;
		
		this.runEntity=re;
		
	}
	
	

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package hu.unideb.prt.petApp.petApp.ui;

import hu.unideb.prt.petApp.petApp.entity.AccountancyDAO;
import hu.unideb.prt.petApp.petApp.entity.AccountancyDAOFactory;
import hu.unideb.prt.petApp.petApp.entity.AccountancyDAOImpl;
import hu.unideb.prt.petApp.petApp.entity.AccountancyEntity;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bali
 
public class AddNewAccController implements Initializable {

    @FXML
    private Button doneBt;
    @FXML
    private Button cancleBt;
    @FXML
    private TextField type;
    @FXML
    private TextField amount;
    @FXML
    private ComboBox<String> in_out;
    @FXML
    private TextField description;
    @FXML
    private TextField summ;
    @FXML
    private DatePicker datee;
    @FXML
    Label warnL;
    @FXML
    Label azonosito;
    @FXML
    Label mennyiseg;
    @FXML
    Label kibe;
    @FXML
    Label osszeg;
    @FXML
    Label datum;
    private AccountancyDAOFactory daoFactory;
    
    private AccountancyEntity ae;
    
    Boolean edit =Boolean.FALSE;
    /**
     * Initializes the controller class.
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         daoFactory = AccountancyDAOFactory.getInstance();
        ObservableList<String> items = FXCollections.observableArrayList();
        items.add("Kiadás");
        items.add("Bevétel");
        in_out.setItems(items);
        csillagoz(false);
    }    

    @FXML
    private void onDoneBt(ActionEvent event) {
        
//        AccountancyDAO ad = daoFactory.createAccountancyDAO();
//        LocalDate dat = datee.getValue();
//        if(type.getText().isEmpty() || amount.getText().isEmpty()  
//                       || in_out.getSelectionModel().getSelectedItem().isEmpty()
//                       ||summ.getText().isEmpty() || dat.toString().isEmpty() ){
//            warnL.setText("A * -al jelölt mezők kitöltése kötelező!");
//            warnL.setTextFill(Color.web("#ee0000"));
//            csillagoz(true);
//        
//        }else{
//        if(!edit){
//            ae = new AccountancyEntity();
//        }
//        ae.setType(type.getText());
//        ae.setAmount(Integer.parseInt(amount.getText()));
//        ae.setIn_out(in_out.getValue());
//        ae.setDescription(description.getText());
//        ae.setSumm(Integer.parseInt( summ.getText()));
//        LocalDate date = datee.getValue();
//        ae.setDatee(date.toString());
//        
//        ad.createEntry(ae);
//        onCancleBt();
//        }
         AccountancyDAO ad = daoFactory.createAccountancyDAO();
        LocalDate dat = datee.getValue();
       try{
        if(!edit){
            ae = new AccountancyEntity();
        }
        ae.setType(type.getText());
        ae.setAmount(Integer.parseInt(amount.getText()));
        ae.setIn_out(in_out.getValue());
        ae.setDescription(description.getText());
        ae.setSumm(Integer.parseInt( summ.getText()));
        LocalDate date = datee.getValue();
        ae.setDatee(date.toString());
        
        ad.createEntry(ae);
        onCancleBt();
        }catch(Exception e){
            warnL.setText("A * -al jelölt mezők kitöltése kötelező!");
            warnL.setTextFill(Color.web("#ee0000"));
            csillagoz(true);
            System.out.println(e);
        }
    }

    @FXML
    private void onCancleBt() {
        Stage s = (Stage)cancleBt.getScene().getWindow();
        s.close();
    }
    
     public void setAe(AccountancyEntity accountancyEntity) {
         type.setText(accountancyEntity.getType());
         amount.setText(String.valueOf(accountancyEntity.getAmount()));
         in_out.getSelectionModel().select(accountancyEntity.getIn_out());
         description.setText(accountancyEntity.getDescription());
         summ.setText(String.valueOf(accountancyEntity.getSumm()));
         LocalDate date = LocalDate.parse(accountancyEntity.getDatee());
         datee.setValue(date);
         edit = Boolean.TRUE;
         this.ae = accountancyEntity;
    }
     
    public void csillagoz(boolean b){
        if(b){
            azonosito.setText("Azonosító *");
            azonosito.setTextFill(Color.web("#ee0000"));
            mennyiseg.setText("Mennyiség *");
            mennyiseg.setTextFill(Color.web("#ee0000"));
            kibe.setText("Ki/Be *");
            kibe.setTextFill(Color.web("#ee0000"));
            osszeg.setText("Összeg *");
            osszeg.setTextFill(Color.web("#ee0000"));
            datum.setText("Dátum *");
            datum.setTextFill(Color.web("#ee0000"));
        
        }else{
            azonosito.setText("Azonosító ");
            azonosito.setTextFill(Color.web("#000000"));
            mennyiseg.setText("Mennyiség ");
            mennyiseg.setTextFill(Color.web("#000000"));
            kibe.setText("Ki/Be ");
            kibe.setTextFill(Color.web("#000000"));
            osszeg.setText("Összeg");
            osszeg.setTextFill(Color.web("#000000"));
            datum.setText("Dátum");
            datum.setTextFill(Color.web("#000000"));
        }
    
    }
    
}*/