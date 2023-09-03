package com.internshala.javafxapp;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;


public class MyMain extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("Start");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();
    }
    private MenuBar createMenu(){
        //file menu
        Menu fileMenu=new Menu("File");

        MenuItem newItem=new MenuItem("New");
        newItem.setOnAction(event -> System.out.println("new menu clicked"));

        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();

        MenuItem quitItem=new MenuItem("Quit");
        quitItem.setOnAction(event-> {
            Platform.exit();
            System.exit(0);
        });

        fileMenu.getItems().addAll(newItem,separatorMenuItem,quitItem);



        //help menu
        Menu helpMenu=new Menu("Help");

        MenuItem aboutItem=new MenuItem("About");

        aboutItem.setOnAction(event -> aboutApp());

        helpMenu.getItems().addAll(aboutItem);


        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
    }

    private void aboutApp() {
        Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My first Java App");
        alertDialog.setHeaderText("JavaFx App");
        alertDialog.setContentText("I am just a begginner but soon I will start developing awesome java games");

        ButtonType yesBtn=new ButtonType("yes");
        ButtonType noBtn=new ButtonType("No");

        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
        Optional<ButtonType> clickedBtn=alertDialog.showAndWait();
        if(clickedBtn.isPresent() && clickedBtn.get()==yesBtn){
            System.out.println("Yes button clicked");
        }else{
            System.out.println("No button clicked");
        }

        alertDialog.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stop");
        super.stop();
    }
}
