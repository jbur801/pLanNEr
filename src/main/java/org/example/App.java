package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.Logic.Task;

import java.io.IOException;

/**
 * JavaFX App
 * App is the main class that the program starts in (because it extends application)
 * by extends we mean that all the code that is in the javafx.Application class is loaded here
 * (so this class contains all the methods and fields of that one without us having to type it out (see inheritance)
 * it also means that other code (that we dont see in this case) can treat App objects as if they were javafx.Application objects
 * Application.Start() is the first thing called in a javafx program (in normal java it would be a method called Main(String[] Args)
 */
public class App extends Application {


    //this is a javafx class that represents the state of a window (everything in a window)
    private static Scene scene;
    private static Stage _stage;
    /**
     *
     * @param stage Stage is a javafx class that represents a window, a scene goes in a stage and the scene dictates the content
     *              if you want to add a window to a javafx app you add a stage, if you want to drastically change the screen
     *              you change the scene.
     * @throws IOException
     */
    //super basic java rundown
    //the override is related to inheritance, it shows that there is a method that has the same name and other parameter types as this one
    //in javafx.Application, but that we want to use this version of the method instead
    //public means basically that other classes can see the method and call it (as opposed to private where only this class would be able to
    // void is the return type, it means return nothing the return type will always go after the access modifier
    //start is obviously the name
    //the capitalised Stage is the parameter type, the lower case one is the parameter alias which the method will to refer to the parameter by
    //if there were multiple parameters they would be comma delimited
    //the throws part is a little weird, it basically signals to the program that this method can cause an issue
    //in this case the issue is if the loadfxml method cant find a valid fxml file because its in the wrong place or has the wrong name
    //which would cause an IOException and a crash, there are ways to handle exceptions but dnt worry about that for now
    // (see try/catch if you really care)
    @Override
    public void start(Stage stage) throws IOException {
        //scene can be generated a few ways but in this case we are loading it from an fxml file
        //scene = new Scene(loadFXML("primary"), 640, 480);
        initCreateTask(new Task());
        //the stage is what is shown so the scene needs to be added to the stage
        stage.setScene(scene);
        //this makes the stage window visible once its set up
        stage.show();
        _stage = stage;
    }

    public static void switchScene(Scene newScene){
        _stage.setScene(newScene);
    }

    private void initCreateTask(Task task) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CreateTask" + ".fxml"));
        Parent root = fxmlLoader.load();
        CreateTaskController controller = fxmlLoader.getController();
        scene = new Scene(root, 640, 480);
        controller.setSelf(scene);
        controller.initTask(task);
    }

    //this method has the static keyword, google this its kinda important
    static void setRoot(String fxml) throws IOException {
        //this is a method for switching scenes basically you pass in the name of the scene and it will switch to that scene
        scene.setRoot(loadFXML(fxml));
    }

    //this method is called in App.Start() and is responsible for actually turning the fxml into a screen layout
    //you might notice that the return type is Parent. In javaFX a lot of things
    //extend parent and therefore what we are actually passing it could be a lot of things, but they can all be treated like a parent
    //this is another example of inheritance
    private static Parent loadFXML(String fxml) throws IOException {
        //FXMLLoader is doing the heavy lifting here, doesnt really matter how it works,
        //just see that its being passed the full path of the fxml file and generating the layout
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        //when this load method is called on top of turning the fxml into a Parent object, the loader will also create an object of
        //the controller for the fxml (the fxml tells it what the controller class is) and binds that to the parent object
        //this step is what links the controller to the object generated from the fxml.
        //we need to ask for the controller object here if we want it using fxmlLoader.getController()
        return fxmlLoader.load();
    }


    //this method is technically unnecessary in a javafx application, but can be needed in some run environments
    //I left it in basically to show what a normal main method looks like in java
    //(this would be the traditional entry point into a java program)
    public static void main(String[] args) {
        launch();
    }

}