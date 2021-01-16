package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.example.Logic.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateTaskController {

    @FXML
    private ListView _subTaskList;
    @FXML
    private DatePicker _deadline;
    @FXML
    private TextField _description;


    private Scene _parent;
    private Scene _self;
    private ObservableList<Task> _subTasks;
    private Task _task;

    public void setParent(Scene scene){
        _parent = scene;
    }

    public void setSelf(Scene scene){
        _self = scene;
    }
    @FXML
    public void initialize() {
        _subTasks = FXCollections.observableArrayList();
        _subTasks.add(new Task());
       _subTaskList.setItems(_subTasks);
    }

    public void initTask(Task task){
        _task = task;
    }


    public void AddSubTask(Task task){
        _subTasks.add(task);
    }

    @FXML
    public void newSubTask(){
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CreateTask" + ".fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CreateTaskController controller = fxmlLoader.getController();
        Scene scene = new Scene(root, 640, 480);
        controller.setSelf(scene);
        Task task = new Task();
        controller.initTask(task);
        controller.setParent(_self);
        App.switchScene(scene);
        _subTasks.add(task);
    }

    @FXML
    public void done(){
        _task.setDeadline(_deadline.getValue());
        _task.setDescription(_description.getText());
        App.switchScene(_parent);
    }
}
