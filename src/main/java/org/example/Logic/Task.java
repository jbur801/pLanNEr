package org.example.Logic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private LocalDate _date;
    private String _description;
    private List<Task> _subTasks;

    public Task(){
        _subTasks = new ArrayList<>();
        _description = "idk fam";
    }

    public void setDeadline(LocalDate date){
        _date = date;
    }

    public void setDescription(String description){
        _description = description;
    }

    public void AddSubTask(Task task){
        _subTasks.add(task);
    }

    @Override
    public String toString(){
        return _description;
    }
}


