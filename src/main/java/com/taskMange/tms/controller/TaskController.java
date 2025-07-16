package com.taskMange.tms.controller;

import com.taskMange.tms.model.Task;
import com.taskMange.tms.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @PostMapping("/addTask")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.AddTask(task), HttpStatus.CREATED);
    }

    @GetMapping("/sortedByDate")
    public ResponseEntity<List<Task>> getSortedTasks(){
        return new ResponseEntity<>(taskService.sortByDate(), HttpStatus.OK);
    }

}
