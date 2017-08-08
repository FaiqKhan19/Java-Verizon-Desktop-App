package application;
// created by Faiq Khan.
import java.io.FileNotFoundException;
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.collections.*;

public class GUI extends Application { 

	VerizonData data = new VerizonData();
	Stage stage;
	int FullTimeEmployee, PartTimeEmployee, MonthlyCustomer, PayAsYouGoCustomer;
	
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	public void start(Stage primaryStage)
	{
		stage = primaryStage;
		
		Image image = new Image("images.jpeg");
		ImageView iv = new ImageView(image);
		iv.fitWidthProperty().bind(stage.widthProperty());
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(createTabs());
		borderPane.setTop(iv);
	
		Scene scene = new Scene(borderPane, 600, 550);
		//scene.getStylesheets().add("GUIApp.css");
		stage.setScene(scene);
		stage.setTitle("My GUI");
		stage.show();
		
		try {
			data.loadArrays(data);
			
		} catch (FileNotFoundException | ClassNotFoundException ex) {
			
		}
	}
	
	//**Creates 4 different tabs consists of Full Time Employee,**// 
	//**Part time Employee, Monthly Customer, and Pay As You Go Customer**//
	
	TabPane createTabs()
	{
		Tab tab1 = new Tab("Full Time Employee");
		tab1.setClosable(false);
	    tab1.setContent(ftempPane());
		
		Tab tab2 = new Tab("Part Time Employee");
		tab2.setClosable(false);
		tab2.setContent(ptempPane());
		
		Tab tab3 = new Tab("Monthly customer");
		tab3.setClosable(false);
		tab3.setContent(monthlycsPane());
		
		Tab tab4 = new Tab("Pay As You Go Customer");
		tab4.setClosable(false);
		tab4.setContent(payasgoPane());
		
		TabPane tabPane = new TabPane();
		tabPane.getTabs().addAll(
				tab1,
				tab2, 
				tab3, 
				tab4);
		return tabPane;
		
	}
	
	// Full Time Employee
	private Node ftempPane()
	{
		///**Create GridPane which has all the data fields etc for Full Time Employee**///
		GridPane root = new GridPane();
		root.setHgap(12);
		root.setVgap(6);
		root.setPadding(new Insets(5));
		
		///All the labels here.///
		Label name = new Label("Name:");
        Label address = new Label("Address:");
        Label city = new Label("City:");
        Label state = new Label("State:");
        Label zip = new Label("Zip:");
        Label id = new Label("ID Number:");
        Label phoneNum = new Label("Phone Number:");
        Label job = new Label("Job:");
        Label salary = new Label("Salary:");
        
        ///All the fields here.///
        final TextField nameField = new TextField();
        final TextField addressField = new TextField();
        final TextField cityField = new TextField();
        final TextField stateField = new TextField();
        final TextField zipCodeField = new TextField();
        final TextField idNoField = new TextField();
        final TextField phoneNumField = new TextField();
        final TextField jobField = new TextField();
        final TextField salaryField = new TextField();
        
        ///All Buttons here.///
        Button searchID = new Button("Search ID");
        final TextField searchField = new TextField();
        Button saveButton = new Button("Save");
        Button updateButton = new Button("Update");
        final Button clearButton = new Button("Clear");
        Button deleteButton = new Button("Delete");
        
        ///Add the Labels, Text fields, and Buttons here.///
        root.add(name, 0, 1);
        root.add(nameField, 1, 1, 1, 1);
        root.add(address, 0, 2);
        root.add(addressField, 1, 2, 1, 1);
        root.add(city, 0, 3);
        root.add(cityField, 1, 3, 1, 1);
        root.add(state, 0, 4);
        root.add(stateField, 1, 4, 1, 1);
        root.add(zip, 0, 5);
        root.add(zipCodeField, 1, 5, 1, 1);
        root.add(id, 2, 1);
        root.add(idNoField, 3, 1, 1, 1);
        root.add(phoneNum, 2, 2);
        root.add(phoneNumField, 3, 2, 1, 1);
        root.add(job, 2, 3);
        root.add(jobField, 3, 3, 1, 1);
        root.add(salary, 2, 4);
        root.add(salaryField, 3, 4, 1, 1);
        
        root.add(saveButton, 0, 6);
        root.add(searchID, 0, 0);
        root.add(searchField, 1, 0);
        root.add(updateButton, 1, 6);
        root.add(clearButton, 2, 6);
        root.add(deleteButton, 3, 6);
     
        root.setAlignment(Pos.TOP_CENTER);
		
      //**This Save Button will create a new Full Time Employee object so, it can be added to database(VerizonData)**//
		saveButton.setOnAction(new EventHandler<ActionEvent> (){
			public void handle(ActionEvent event)
			{

				FullTimeEmployee employee;
				try {
					employee = new 
							FullTimeEmployee(nameField.getText(), phoneNumField.getText(), 
									addressField.getText(), cityField.getText(), 
									zipCodeField.getText(), stateField.getText(),
									Integer.parseInt(idNoField.getText()),
									jobField.getText(), 
									Double.valueOf(salaryField.getText()));
					
					data.getEmployeeList().add(employee);
					
				} catch (NumberFormatException e) {
					
					e.printStackTrace();
				} catch (IllegalInput e) {
					
					e.printStackTrace();
				}
				data.saveArrays(data);
				FullTimeEmployee = Integer.parseInt(idNoField.getText());
			}
		});
		
		//**This button will update the database(VerizonData)**//
		updateButton.setOnAction(new EventHandler<ActionEvent> (){

			@Override
			public void handle(ActionEvent event) {
				
				data.removeEmployee(FullTimeEmployee, data);
				saveButton.fire();
			}
			
		});
		
		//**This clear button will clear all the text fields**//
		clearButton.setOnAction(new EventHandler<ActionEvent> (){

			public void handle(ActionEvent arg0) {
				nameField.clear();
				phoneNumField.clear();
				addressField.clear();
				cityField.clear();
				stateField.clear();
				zipCodeField.clear();
				idNoField.clear();
				jobField.clear();
				salaryField.clear();
				FullTimeEmployee = 0;
				
			}
			
		});
		
		//**This button will search a full time employee using Id no**//
				searchID.setOnAction(new EventHandler<ActionEvent> (){

					@Override
					public void handle(ActionEvent event) {
						int idNo;
						try{
							idNo = Integer.valueOf(searchField.getText());
						} catch(Exception e) {
							return;
						}
						FullTimeEmployee ello = (FullTimeEmployee)VerizonData.searchArrays(idNo, data);
						if(ello == null) {
							Alert idAlert = new Alert(AlertType.WARNING, "ID no cannot be found", ButtonType.OK);
							idAlert.showAndWait();
							nameField.clear();
							phoneNumField.clear();
							addressField.clear();
							cityField.clear();
							stateField.clear();
							zipCodeField.clear();
							idNoField.clear();
							jobField.clear();
							salaryField.clear();
						}
						else if(ello != null)
						{
							nameField.setText(ello.getName());
							phoneNumField.setText(ello.getPhoneNum());
							addressField.setText(ello.getAddress());
							cityField.setText(ello.getCity());
							stateField.setText(ello.getState());
							zipCodeField.setText(ello.getZipCode());
							idNoField.setText(String.valueOf(ello.getIdNo()));
							jobField.setText(ello.getJobFunction());
							salaryField.setText(String.valueOf(ello.getSalary()));
							FullTimeEmployee = ello.getIdNo();
						}
						searchField.clear();
					}
					
				});
		
		//**This button will delete the object(VerizonData)**//
				deleteButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						Alert alert = new Alert(AlertType.WARNING, "Warning: It'll delete permanently "
								+ "Are you sure you want to delete this selected entry?", ButtonType.YES, ButtonType.NO);
						Optional<ButtonType> result = alert.showAndWait();
						if(result.get() ==ButtonType.YES) {
							data.removeEmployee(FullTimeEmployee, data);
							FullTimeEmployee = 0;
							// invoked when the user event occured.
							clearButton.fire();
							Alert rC = new Alert(AlertType.CONFIRMATION, "Full Time Employee successfuly deleted.",
							ButtonType.OK);
							rC.showAndWait();
						}
						
					}
					
				});
				
		
		return root;
	}
	
	// Full Time Employee
		private Node ptempPane()
		{
			///**Create GridPane which has all the data fields etc for Part Time Employee**///
			GridPane root = new GridPane();
			root.setHgap(12);
			root.setVgap(6);
			root.setPadding(new Insets(8));
			
			///All the labels here.///
			Label name = new Label("Name:");
	        Label address = new Label("Address:");
	        Label city = new Label("City:");
	        Label state = new Label("State:");
	        Label zip = new Label("Zip:");
	        Label id = new Label("ID Number:");
	        Label phoneNum = new Label("Phone Number:");
	        Label job = new Label("Job:");
	        Label hourlyRate = new Label("HourlyRate:");
	        Label hoursWorked = new Label("HoursWorked:");
	        
	        ///All the Text fields here.///
	        final TextField nameField = new TextField();
	        final TextField addressField = new TextField();
	        final TextField cityField = new TextField();
	        final TextField stateField = new TextField();
	        final TextField zipCodeField = new TextField();
	        final TextField idNoField = new TextField();
	        final TextField phoneNumField = new TextField();
	        final TextField jobField = new TextField();
	        final TextField hourlyRateField = new TextField();
	        final TextField hoursWField = new TextField();
	        
	        ///All the buttons here.///
	        Button searchID = new Button("Search ID");
	        final TextField searchField = new TextField();
	        final Button saveButton = new Button("Save");
	        Button updateButton = new Button("Update");
	        final Button clearButton = new Button("Clear");
	        Button deleteButton = new Button("Delete");
	        
	        ///All the Labels, text fields, and buttons here.///
	        root.add(name, 0, 1);
	        root.add(nameField, 1, 1, 1, 1);
	        root.add(address, 0, 2);
	        root.add(addressField, 1, 2, 1, 1);
	        root.add(city, 0, 3);
	        root.add(cityField, 1, 3, 1, 1);
	        root.add(state, 0, 4);
	        root.add(stateField, 1, 4, 1, 1);
	        root.add(zip, 0, 5);
	        root.add(zipCodeField, 1, 5, 1, 1);
	        root.add(id, 2, 1);
	        root.add(idNoField, 3, 1, 1, 1);
	        root.add(phoneNum, 2, 2);
	        root.add(phoneNumField, 3, 2, 1, 1);
	        root.add(job, 2, 3);
	        root.add(jobField, 3, 3, 1, 1);
	        root.add(hourlyRate, 2, 4);
	        root.add(hourlyRateField, 3, 4, 1, 1);
	        root.add(hoursWorked, 2, 5);
	        root.add(hoursWField, 3, 5, 1, 1);
	        
	        root.add(saveButton, 0, 7);
	        root.add(searchID, 0, 0);
	        root.add(searchField, 1, 0);
	        root.add(updateButton, 1, 7);
	        root.add(clearButton, 2, 7);
	        root.add(deleteButton, 3, 7);
			root.setAlignment(Pos.TOP_CENTER);
			
			//**This Save Button will create a new Part Time Employee object so, it can be added to database(VerizonData)**//
			saveButton.setOnAction(new EventHandler<ActionEvent> (){
				public void handle(ActionEvent event)
				{

					PartTimeEmployee employee;
					try {
						employee = new 
								PartTimeEmployee(nameField.getText(), phoneNumField.getText(), 
										addressField.getText(), cityField.getText(), 
										zipCodeField.getText(), stateField.getText(),
										Integer.valueOf(idNoField.getText()),
										jobField.getText(), 
										Double.valueOf(hourlyRateField.getText()),
										Double.valueOf(hoursWField.getText()));
						data.getEmployeeList().add(employee);
						data.saveArrays(data);
						PartTimeEmployee = Integer.valueOf(idNoField.getText());
					} catch (NumberFormatException e) {
						
						e.printStackTrace();
					} catch (IllegalInput e) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Unable to save at this time");
						alert.setHeaderText(null);
						alert.setContentText("Cannot save data"
								+ ". \n Please contact administator.");
						alert.showAndWait();
						
						//e.printStackTrace();
					}
				}
			});
			
			//**This button will update the database(VerizonData)**//
			updateButton.setOnAction(new EventHandler<ActionEvent> (){

				@Override
				public void handle(ActionEvent event) {
					
					data.removeEmployee(PartTimeEmployee, data);
					saveButton.fire();
					
					}
				
			});
			
			//**This clear button will clear all the text fields**//
			clearButton.setOnAction(new EventHandler<ActionEvent> (){

				public void handle(ActionEvent arg0) {
					nameField.clear();
					phoneNumField.clear();
					addressField.clear();
					cityField.clear();
					stateField.clear();
					zipCodeField.clear();
					idNoField.clear();
					jobField.clear();
					hourlyRateField.clear();
					hoursWField.clear();
					
				}
				
			});
			
			//**This button will search a part time employee using Id no**//
			searchID.setOnAction(new EventHandler<ActionEvent> (){

				@Override
				public void handle(ActionEvent event) {
					
					int idNo = Integer.parseInt(searchField.getText());
					PartTimeEmployee ello = (PartTimeEmployee)VerizonData.searchArrays(idNo, data);
					if(ello == null) {
						Alert idAlert = new Alert(AlertType.WARNING, "ID no cannot be found", ButtonType.OK);
						idAlert.showAndWait();
						nameField.clear();
						phoneNumField.clear();
						addressField.clear();
						cityField.clear();
						stateField.clear();
						zipCodeField.clear();
						idNoField.clear();
						jobField.clear();
						hourlyRateField.clear();
						hoursWField.clear();
						PartTimeEmployee = 0;
					}
					else if(ello != null)
					{
						nameField.setText(ello.getName());
						phoneNumField.setText(ello.getPhoneNum());
						addressField.setText(ello.getAddress());
						cityField.setText(ello.getCity());
						stateField.setText(ello.getState());
						zipCodeField.setText(ello.getZipCode());
						idNoField.setText(ello.getIdNo() + "");
						jobField.setText(ello.getJobFunction());
						hourlyRateField.setText(ello.getHourlyRate() + "");
						hoursWField.setText(ello.getHoursWork() + "");
						PartTimeEmployee = idNo;
					}
					searchField.clear();
				}
				
			});
	
	//**This button will delete the object(VerizonData)**//
			
			deleteButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					Alert alert = new Alert(AlertType.WARNING, "Warning: It'll delete permanently "
							+ "Are you sure you want to delete this selected entry?", ButtonType.YES, ButtonType.NO);
					Optional<ButtonType> result = alert.showAndWait();
					if(result.get() ==ButtonType.YES) {
						data.removeEmployee(PartTimeEmployee, data);
						FullTimeEmployee = 0;
						// invoked when the user event occured.
						clearButton.fire();
						Alert rC = new Alert(AlertType.CONFIRMATION, "Part Time Employee successfuly deleted.",
						ButtonType.OK);
						rC.showAndWait();
					}
					
				}
				
			});
			
			return root;
		}
	
	// Pay As you Go Customer
	private Node payasgoPane()
	{
		
		///**Create GridPane which has all the data fields etc for Pay As you Customer**///
		GridPane root = new GridPane();
		root.setHgap(12);
		root.setVgap(6);
		root.setPadding(new Insets(10, 10, 10, 10));
		
		///All the labels here.///
		Label name = new Label("Name:");
        Label address = new Label("Address:");
        Label city = new Label("City:");
        Label state = new Label("State:");
        Label zip = new Label("Zip:");
        Label id = new Label("ID Number:");
        Label phoneNum = new Label("Phone Number:");
        Label plan = new Label("Plan:");
        Label branch = new Label("Branch:");
        Label rate = new Label("Rate:");
        
        ///All the text fields here.///
        final TextField nameField = new TextField();
        final TextField addressField = new TextField();
        final TextField cityField = new TextField();
        final TextField stateField = new TextField();
        final TextField zipCodeField = new TextField();
        final TextField idNoField = new TextField();
        final TextField phoneNumField = new TextField();
        final TextField planField = new TextField();
        final TextField branchField = new TextField();
        final TextField rateField = new TextField();
        
        ///All buttons here.///
        Button searchID = new Button("Search ID");
        final TextField searchField = new TextField();
        final Button saveButton = new Button("Save");
        Button updateButton = new Button("Update");
        final Button clearButton = new Button("Clear");
        Button deleteButton = new Button("Delete");
        
        ///Add the labels, text fields, and buttons here.///
        root.add(name, 0, 1);
        root.add(nameField, 1, 1, 1, 1);
        root.add(address, 0, 2);
        root.add(addressField, 1, 2, 1, 1);
        root.add(city, 0, 3);
        root.add(cityField, 1, 3, 1, 1);
        root.add(state, 0, 4);
        root.add(stateField, 1, 4, 1, 1);
        root.add(zip, 0, 5);
        root.add(zipCodeField, 1, 5, 1, 1);
        root.add(id, 2, 1);
        root.add(idNoField, 3, 1, 1, 1);
        root.add(phoneNum, 2, 2);
        root.add(phoneNumField, 3, 2, 1, 1);
        root.add(plan, 2, 3);
        root.add(planField, 3, 3, 1, 1);
        root.add(branch, 2, 4);
        root.add(branchField, 3, 4, 1, 1);
        root.add(rate, 2, 5);
        root.add(rateField, 3, 5, 1, 1);
        
        root.add(saveButton, 0, 7);
        root.add(searchID, 0, 0);
        root.add(searchField, 1, 0);
        root.add(updateButton, 1, 7);
        root.add(clearButton, 2, 7);
        root.add(deleteButton, 3, 7);
		root.setAlignment(Pos.TOP_CENTER);
		
		
		//**This Save Button will create a new Pay As You Go customer object so, it can be added to database(VerizonData)**//
		saveButton.setOnAction(new EventHandler<ActionEvent> (){
			public void handle(ActionEvent event)
			{

				PayAsYouGoCustomer customer;
				try {
					customer = new 
							PayAsYouGoCustomer(nameField.getText(), phoneNumField.getText(), 
									addressField.getText(), cityField.getText(), 
									zipCodeField.getText(), stateField.getText(),
									Integer.valueOf(idNoField.getText()),
									planField.getText(), 
									branchField.getText(),
									Integer.valueOf(rateField.getText()));
					data.getCustomerList().add(customer);
					data.saveArrays(data);
					PayAsYouGoCustomer = Integer.valueOf(idNoField.getText());
				} catch (NumberFormatException e) {
					
					e.printStackTrace();
				} catch (IllegalInput e) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Unable to save data at this time");
					alert.setHeaderText(null);
					alert.setContentText("Unable to save data"
							+ ". \n Please contact administator.");
					alert.showAndWait();
				}
			}
		});
		
		//**This button will update the database(VerizonData)**//
		updateButton.setOnAction(new EventHandler<ActionEvent> (){

			@Override
			public void handle(ActionEvent event) {
				data.removeCustomer(PayAsYouGoCustomer, data);
				saveButton.fire();
				
			}
			
		});
		
		//**This clear button will clear all the text fields**//
		clearButton.setOnAction(new EventHandler<ActionEvent> (){

			public void handle(ActionEvent arg0) {
				nameField.clear();
				addressField.clear();
				cityField.clear();
				stateField.clear();
				zipCodeField.clear();
				idNoField.clear();
				phoneNumField.clear();
				planField.clear();
				branchField.clear();
				rateField.clear();
				PayAsYouGoCustomer = 0;
			}
		});
		
		//**This button will search a Pay As you Go Customer using Id no**//
		searchID.setOnAction(new EventHandler<ActionEvent> (){

			@Override
			public void handle(ActionEvent event) {
				int idNo;
				try {
				 idNo = Integer.parseInt(searchField.getText());
				} catch (Exception e) {
					return;
				}
				PayAsYouGoCustomer ello = 
						(PayAsYouGoCustomer) VerizonData.searchArrays(idNo, data);
				if(ello == null) {
					Alert idAlert = new Alert(AlertType.WARNING, "ID no cannot be found", ButtonType.OK);
					idAlert.showAndWait();
					nameField.clear();
					phoneNumField.clear();
					addressField.clear();
					cityField.clear();
					stateField.clear();
					zipCodeField.clear();
					idNoField.clear();
					planField.clear();
					branchField.clear();
					rateField.clear();
					PayAsYouGoCustomer = 0;
				}
				else if(ello != null)
				{
					nameField.clear();
					phoneNumField.clear();
					addressField.clear();
					cityField.clear();
					stateField.clear();
					zipCodeField.clear();
					idNoField.clear();
					planField.clear();
					branchField.clear();
					rateField.clear();
					PayAsYouGoCustomer = idNo;
				}
				searchField.clear();
			}
			
		});

//**This button will delete the object(VerizonData)**//
		
		deleteButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Alert alert = new Alert(AlertType.WARNING, "Warning: It'll delete permanently "
						+ "Are you sure you want to delete this selected entry?", ButtonType.YES, ButtonType.NO);
				Optional<ButtonType> result = alert.showAndWait();
				if(result.get() ==ButtonType.YES) {
					data.removeCustomer(PayAsYouGoCustomer, data);
					PayAsYouGoCustomer = 0;
					// invoked when the user event occurs.
					clearButton.fire();
					Alert rC = new Alert(AlertType.CONFIRMATION, "Full Time Employee successfuly deleted.",
					ButtonType.OK);
					rC.showAndWait();
				}
				
			}
			
		});
		
		return root;
		
	}
	
	// Pay As you Go Customer
		private Node monthlycsPane()
		{
			
			///**Create GridPane which has all the data fields etc for Monthly Customer**///
			GridPane root = new GridPane();
			root.setHgap(12);
			root.setVgap(6);
			root.setPadding(new Insets(10, 10, 10, 10));
			
			//All the labels here.
			Label name = new Label("Name:");
	        Label address = new Label("Address:");
	        Label city = new Label("City:");
	        Label state = new Label("State:");
	        Label zip = new Label("Zip:");
	        Label id = new Label("ID Number:");
	        Label phoneNum = new Label("Phone Number:");
	        Label plan = new Label("Plan:");
	        Label branch = new Label("Branch:");
	        Label rate = new Label("Rate:");
	        
	        ///All the TextFields here.///
	        final TextField nameField = new TextField();
	        final TextField addressField = new TextField();
	        final TextField cityField = new TextField();
	        final TextField stateField = new TextField();
	        final TextField zipCodeField = new TextField();
	        final TextField idNoField = new TextField();
	        final TextField phoneNumField = new TextField();
	        final TextField planField = new TextField();
	        final TextField branchField = new TextField();
	        final TextField rateField = new TextField();
	        
	        ///All the Buttons here.///
	        Button searchID = new Button("Search ID");
	        final TextField searchField = new TextField();
	        final Button saveButton = new Button("Save");
	        Button updateButton = new Button("Update");
	        final Button clearButton = new Button("Clear");
	        Button deleteButton = new Button("Delete");
	        
	        ///Add all the labels, text fields, and buttons here.///
	        root.add(name, 0, 1);
	        root.add(nameField, 1, 1, 1, 1);
	        root.add(address, 0, 2);
	        root.add(addressField, 1, 2, 1, 1);
	        root.add(city, 0, 3);
	        root.add(cityField, 1, 3, 1, 1);
	        root.add(state, 0, 4);
	        root.add(stateField, 1, 4, 1, 1);
	        root.add(zip, 0, 5);
	        root.add(zipCodeField, 1, 5, 1, 1);
	        root.add(id, 2, 1);
	        root.add(idNoField, 3, 1, 1, 1);
	        root.add(phoneNum, 2, 2);
	        root.add(phoneNumField, 3, 2, 1, 1);
	        root.add(plan, 2, 3);
	        root.add(planField, 3, 3, 1, 1);
	        root.add(branch, 2, 4);
	        root.add(branchField, 3, 4, 1, 1);
	        root.add(rate, 2, 5);
	        root.add(rateField, 3, 5, 1, 1);
	        
	        root.add(saveButton, 0, 7);
	        root.add(clearButton, 2, 7);
	        root.add(searchID, 0, 0);
	        root.add(searchField, 1, 0);
	        root.add(updateButton, 1, 7);
	        root.add(deleteButton, 3, 7);
			root.setAlignment(Pos.TOP_CENTER);
		
	
		ObservableList <String> options = FXCollections.observableArrayList();
		
		ComboBox stateBox = new ComboBox(options);
	
	//**This Save Button will create a new Monthly customer object so, it can be added to database(VerizonData)**//
	saveButton.setOnAction(new EventHandler<ActionEvent> (){
		public void handle(ActionEvent event)
		{

			MonthlyCustomer customer;
			try {
				customer = new 
						MonthlyCustomer(nameField.getText(), phoneNumField.getText(), 
								addressField.getText(), cityField.getText(), 
								zipCodeField.getText(), stateField.getText(),
								Integer.valueOf(idNoField.getText()),
								planField.getText(), 
								branchField.getText(), Double.parseDouble(rateField.getText()));
				data.getCustomerList().add(customer);
				data.saveArrays(data);
				MonthlyCustomer = Integer.valueOf(idNoField.getText());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IllegalInput e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Unable to save data at this time");
				alert.setHeaderText(null);
				alert.setContentText("Cannot save data"
						+ ". \n Please contact administator.");
				alert.showAndWait();
			}
		}
	});
	
	//**This button will update the database(VerizonData)**//
	updateButton.setOnAction(new EventHandler<ActionEvent> (){

		@Override
		public void handle(ActionEvent event) {
			
			data.removeCustomer(MonthlyCustomer, data);
			saveButton.fire();
		}
		
	});
	
	//**This clear button will clear all the text fields**//
	clearButton.setOnAction(new EventHandler<ActionEvent> (){

		public void handle(ActionEvent arg0) {
			nameField.clear();
			addressField.clear();
			cityField.clear();
			stateField.clear();
			zipCodeField.clear();
			idNoField.clear();
			phoneNumField.clear();
			planField.clear();
			branchField.clear();
			rateField.clear();
			MonthlyCustomer = 0;
		}
		
	});
	
	//**This button will search a Monthly Customer using Id no**//
	searchID.setOnAction(new EventHandler<ActionEvent> (){

		@Override
		public void handle(ActionEvent event) {
			int idNo;
			try{
				idNo = Integer.parseInt(searchField.getText());
			} catch (Exception e) {
				return;
			}
			MonthlyCustomer ello = 
					(MonthlyCustomer) VerizonData.searchArrays(idNo, data);
			if(ello == null) {
				Alert idAlert = new Alert(AlertType.WARNING, "ID no cannot be found", ButtonType.OK);
				idAlert.showAndWait();
				nameField.clear();
				phoneNumField.clear();
				addressField.clear();
				cityField.clear();
				stateField.clear();
				zipCodeField.clear();
				idNoField.clear();
				planField.clear();
				branchField.clear();
				rateField.clear();
				MonthlyCustomer = 0;
			}
			else if(ello != null)
			{
				nameField.setText(ello.getName());
				phoneNumField.setText(ello.getPhoneNum());
				addressField.setText(ello.getAddress());
				cityField.setText(ello.getCity());
				stateField.setText(ello.getState());
				zipCodeField.setText(ello.getZipCode());
				idNoField.setText(ello.getIdNo() + "");
				planField.setText(ello.getPlan());
				branchField.setText(ello.getBranch());
				rateField.setText(ello.getRate() + "");
				MonthlyCustomer = idNo;
			}
			searchField.clear();
		}
		
	});

	deleteButton.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			Alert alert = new Alert(AlertType.WARNING, "Warning: It'll delete permanently "
					+ "Are you sure you want to delete this selected entry?", ButtonType.YES, ButtonType.NO);
			Optional<ButtonType> result = alert.showAndWait();
			if(result.get() ==ButtonType.YES) {
				data.removeCustomer(MonthlyCustomer, data);
				MonthlyCustomer = 0;
				// invoked when the user event occurs.
				clearButton.fire();
				Alert rC = new Alert(AlertType.CONFIRMATION, "Full Time Employee successfuly deleted.",
				ButtonType.OK);
				rC.showAndWait();
			}
			
		}
		
	});
	
	return root;
	}
	
}

		
