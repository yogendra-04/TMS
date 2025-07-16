package com.taskMange.tms.service;

import com.taskMange.tms.model.Task;
import com.taskMange.tms.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task AddTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> sortByDate(){
        return  taskRepository.findAll().stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .collect(Collectors.toList());
    }


}
