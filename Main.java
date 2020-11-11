package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class Main extends Application {

    public int CurrentI = 0;
    //the index we are going to use for the array

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Hello World");


        ImageView iv[] = new ImageView[4];

        for (int i = 0; i < 4; i++) {
            iv[i] = new ImageView("file:C:\\Users\\abdlr\\IdeaProjects\\Lab17_201\\src\\sample\\cat" + i + ".jpeg");


            iv[i].setFitHeight(600);
            iv[i].setFitWidth(600);
            iv[i].setPreserveRatio(true);
        }
        //For loop to assign the images for the array of objects imageView


        StackPane stack = new StackPane();
        stack.getChildren().add(iv[0]);
        //Using stackpane so I can update the pictures


        BorderPane borderPane = new BorderPane();


        borderPane.setCenter(stack);
        //The ImageViewer which is assigned to stackPane are in the center


        Scene scene = new Scene(borderPane, 460, 700);
        //the dimensions of the app


        primaryStage.setScene(scene);
        //assigning the scene to primary stage so it's ready to be shown


        EventHandler<ActionEvent> eventHandler = e -> {
            stack.getChildren().clear();
            stack.getChildren().add(iv[add()]);
        };
        //handler that will change the images

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(2000), eventHandler));
        //making each image stay for 2000ms which is 2 seconds

        animation.setCycleCount(Timeline.INDEFINITE);
        //making the animation run without stopping
        animation.play();
        //playing the animation


        stack.setOnMouseClicked(e -> {
            if (animation.getStatus() == Animation.Status.PAUSED) {
                animation.play();
            } else {
                animation.pause();
            }
        });
        //handler that pause the animation if clicked and play if clicked again


        primaryStage.show();
        //it shows the scene we assigned to the primaryStage
    }

    public int add() {
        //if statement that going to check the index is not going out of bound if we add 1
        // in our case 4 out of bound
        if (this.CurrentI + 1 > 3) {
            CurrentI = 0;
            //if it is going out of bound it'll assign the index to 0
            return 0;
        } else return ++CurrentI;
        //if the index is not going out of bound it will return index+1
    }


    public static void main(String[] args) {
        launch(args);
    }
}
