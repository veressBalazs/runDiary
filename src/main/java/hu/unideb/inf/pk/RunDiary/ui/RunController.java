package hu.unideb.inf.pk.RunDiary.ui;


import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;


import hu.unideb.inf.pk.RunDiary.database.RunDAO;
import hu.unideb.inf.pk.RunDiary.database.RunDAOFactory;
import hu.unideb.inf.pk.RunDiary.database.RunEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import hu.unideb.inf.pk.RunDiary.Statiscticss;

public class RunController implements Initializable {
	
	
	private RunDAOFactory daofactory; 
	
	@FXML
	TableView<RunEntity> runTable;
	
	@FXML
	TableColumn<RunEntity, LocalDate> colDate;
	
	@FXML
	TableColumn<RunEntity, Integer> colDistance;
	
	@FXML
	TableColumn<RunEntity, Duration> colTime;
	
	@FXML
	TableColumn<RunEntity, Double> colSpeed;
	
	@FXML
	TableColumn<RunEntity, Double> colCalories;

	@FXML
    Button addBt;
	
    @FXML
    Button updateBt;
    
    @FXML
    Button deleteBt;
    
    @FXML
    Label warnL;
    
    @FXML
    Label monthKm;
    
    @FXML
    Label yearKm;
    
    @FXML
    Label allKm;




	public void initialize(URL location, ResourceBundle resources) {
		daofactory = RunDAOFactory.getInstance();
		
		
		refreshData();
		
	}


	 @FXML
	    private void onAddBt() throws IOException {
		 Stage stage = new Stage();
	        VBox mainPane = (VBox) FXMLLoader.load(getClass().getResource("/fxml/addNew.fxml"));

	        Scene scene = new Scene(mainPane);
	        stage.setTitle("Add Entry");
	        stage.setScene(scene);
	        disablemenu(true);
	        stage.showAndWait();
	        disablemenu(false);
	        refreshData(); 
		 
		 
		 
	 }
	 
	 @FXML
	 private void onUpdateBtn() throws IOException{
		 RunEntity runEntity = runTable.getSelectionModel().getSelectedItem();
		 
		 if(runEntity != null){
			 Stage stage = new Stage();
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(getClass().getResource("/fxml/addNew.fxml"));
	            VBox mainPane = (VBox) loader.load();

	            Scene scene = new Scene(mainPane);
	            stage.setTitle("Update Entry");
	            stage.setScene(scene);
	            //stage.initStyle(StageStyle.UNDECORATED);

	            AddNewController addNewAccController = loader.getController();
	            addNewAccController.setRunEntity(runEntity);
	            disablemenu(true);
	            stage.showAndWait();

	            disablemenu(false);
	            refreshData();
			 
			 
		 }
		 else{
			 
			 warnL.setText("Vállassz ki egy bejegyzést!");
			 
		 }
		 
		 
	 }
	 
	 
	 @FXML
	    private void onDeleteBt(ActionEvent event) {
		RunEntity re = runTable.getSelectionModel().getSelectedItem();
		if (re != null){
			RunDAO rd = daofactory.createRunDAO();
			rd.removeEntry(re);
			refreshData();
		}
		else{
			 warnL.setText("Vállassz ki egy bejegyzést!");
		}
		 
		 
		 
	 }



	private void refreshData() {
		RunDAO runDao= daofactory.createRunDAO();
		List<RunEntity> l= runDao.readAllEntry();
		ObservableList<RunEntity> lista = FXCollections.observableArrayList(l);
		
		
		runTable.getColumns().get(0).setVisible(false);
		runTable.getColumns().get(0).setVisible(true);
		colDate.setCellValueFactory(new PropertyValueFactory<RunEntity,LocalDate>("date"));
		colDistance.setCellValueFactory(new PropertyValueFactory<RunEntity,Integer>("distance"));
		colTime.setCellValueFactory(new PropertyValueFactory<RunEntity,Duration>("time"));
		colSpeed.setCellValueFactory(new PropertyValueFactory<RunEntity,Double>("averageSpeed"));
		colCalories.setCellValueFactory(new PropertyValueFactory<RunEntity,Double>("burnedCalories"));
		
		runTable.setItems(lista);
		
		warnL.setText(null);
		
		Statiscticss stats= new Statiscticss(l);
		
		monthKm.setText(stats.currentMonth()+" km");
		yearKm.setText(stats.currentYear()+" km");
		allKm.setText(stats.summ()+" km");
		
		
		
		
	}
	
	 private void disablemenu(boolean b) {
	        addBt.setDisable(b);
	        updateBt.setDisable(b);
	        deleteBt.setDisable(b);
	        runTable.setVisible(!b);
	    }
	
	

}
















/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package hu.unideb.prt.petApp.petApp.ui;

import hu.unideb.prt.petApp.petApp.entity.AccountancyDAOImpl;
import hu.unideb.prt.petApp.petApp.entity.AccountancyEntity;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static hu.unideb.prt.petApp.petApp.AccountancyStatistics.*;
import hu.unideb.prt.petApp.petApp.entity.AccountancyDAO;
import hu.unideb.prt.petApp.petApp.entity.AccountancyDAOFactory;
import javafx.scene.Parent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Bali
 
public class AccountanceController implements Initializable {

    @FXML
    private Label kiL;

    @FXML
    private Label beL;

    @FXML
    private Label osszL;

    @FXML
    Label warnL1;
    @FXML
    Label warnL2;

    @FXML
    TableView<AccountancyEntity> accTable;

    @FXML
    private TableColumn<AccountancyEntity, Integer> ID;
    @FXML
    TableColumn<AccountancyEntity, String> TYPE;
    @FXML
    TableColumn<AccountancyEntity, Integer> AMOUNT;
    @FXML
    TableColumn<AccountancyEntity, Boolean> IN_OUT;
    @FXML
    TableColumn<AccountancyEntity, String> DESCRIPTION;
    @FXML
    TableColumn<AccountancyEntity, Integer> SUMM;
    @FXML
    TableColumn<AccountancyEntity, String> DATE;
    @FXML
    Button addBt;
    @FXML
    Button updateBt;
    @FXML
    Button deleteBt;
    @FXML
    Button backBtn;
    private AccountancyDAOFactory daoFactory;
    @FXML
    private void handleBackBtn() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) backBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fxml/mainScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();

    }

    @FXML
    private void onAddBt() throws IOException {
        //System.out.println("You clicked me!(Add)");
        Stage stage = new Stage();
        VBox mainPane = (VBox) FXMLLoader.load(getClass().getResource("/fxml/addNewAcc.fxml"));

        Scene scene = new Scene(mainPane);
        stage.setTitle("Add Entry");
        stage.setScene(scene);
        //stage.initStyle(StageStyle.UNDECORATED);
        disablemenu(true);
        stage.showAndWait();
        disablemenu(false);
        refreshData();
    }

    @FXML
    private void onUpdateBt() throws IOException {
        AccountancyEntity accountancyEntity = accTable.getSelectionModel().getSelectedItem();
        if (accountancyEntity == null) {
            warnL1.setText("Nincs elem kiválasztva!");
            warnL1.setTextFill(Color.web("#ee0000"));
            warnL2.setText(" ");

        } else {
            warnL1.setText(" ");
            warnL2.setText(" ");
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/addNewAcc.fxml"));
            VBox mainPane = (VBox) loader.load();

            Scene scene = new Scene(mainPane);
            stage.setTitle("Update Entry");
            stage.setScene(scene);
            //stage.initStyle(StageStyle.UNDECORATED);

            AddNewAccController addNewAccController = loader.getController();
            addNewAccController.setAe(accountancyEntity);
            disablemenu(true);
            stage.showAndWait();

            disablemenu(false);
            refreshData();

        }
    }

    @FXML
    private void onDeleteBt(ActionEvent event) {
        AccountancyDAO ad = daoFactory.createAccountancyDAO();
        AccountancyEntity ae = accTable.getSelectionModel().getSelectedItem();
        if (ae == null) {
            warnL2.setText("Nincs elem kiválasztva!");
            warnL2.setTextFill(Color.web("#ee0000"));
            warnL1.setText(" ");
            return;
        }
        warnL2.setText(" ");
        warnL1.setText(" ");
        ad.removeEntry(ae);
        refreshData();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        daoFactory = AccountancyDAOFactory.getInstance();
        
        refreshData();

    }

    private void disablemenu(boolean b) {
        addBt.setDisable(b);
        updateBt.setDisable(b);
        deleteBt.setDisable(b);
        accTable.setVisible(!b);
    }

    private void refreshData() {
        AccountancyDAO ad = daoFactory.createAccountancyDAO();
        List<AccountancyEntity> lista = ad.readAllEntry();
        //System.out.println(lista);
        ObservableList<AccountancyEntity> olist = FXCollections.observableArrayList(lista);
        //System.out.println(olist);
        accTable.getColumns().get(0).setVisible(false);
        accTable.getColumns().get(0).setVisible(true);
        
        
        
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        TYPE.setCellValueFactory(new PropertyValueFactory<>("type"));
        AMOUNT.setCellValueFactory(new PropertyValueFactory<>("amount"));
        IN_OUT.setCellValueFactory(new PropertyValueFactory<>("in_out"));
        DESCRIPTION.setCellValueFactory(new PropertyValueFactory<>("description"));
        SUMM.setCellValueFactory(new PropertyValueFactory<>("summ"));
        DATE.setCellValueFactory(new PropertyValueFactory<>("datee"));
        accTable.setItems(olist);

        osszL.setText(calcProfit(lista).toString());
        beL.setText(calcIncome(lista).toString());
        kiL.setText(calcOutgo(lista).toString());
        
        warnL1.setText(" ");
        warnL2.setText(" ");

    }

}
*/