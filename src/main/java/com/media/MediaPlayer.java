package com.media;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;


public class MediaPlayer extends Application{

    FileChooser mediaFileChooser;
    Player mediaPlayer;
    MenuBar menu;
    Menu fileMenu;
    MenuItem openItem;



    public void start(Stage primaryStage){
        try{
            BorderPane root = new BorderPane();
            Scene scene1 = new Scene(root,400,400);

            mediaFileChooser = new FileChooser();

            menu = new MenuBar();
            fileMenu = new Menu("File");
            openItem = new MenuItem("Open");

            fileMenu.getItems().add(openItem);
            menu.getMenus().add(fileMenu);

            openItem.setOnAction((e) -> {

                try {
                    File mediaFile = mediaFileChooser.showOpenDialog(primaryStage);
                    System.out.println(mediaFile.getAbsolutePath() + ": " + mediaFile.toURI().toURL().toExternalForm());
                    mediaPlayer = new Player(mediaFile.toURI().toURL().toExternalForm());
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
                root.setCenter(mediaPlayer);
            });

            root.setTop(menu);

            primaryStage.setScene(scene1);
            primaryStage.show();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}

