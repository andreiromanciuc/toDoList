package org.fasttrackit;

import org.fasttrackit.persistance.TaskRepository;
import org.fasttrackit.transfer.CreateTaskRequest;
import org.fasttrackit.transfer.UpdateTaskRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class App 
{
    public static void main( String[] args ) throws IOException, SQLException {



        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setDescription("Learn JDBS");
        createTaskRequest.setDeadline(LocalDate.now().plusWeeks(1));

        TaskRepository taskRepository = new TaskRepository();
        taskRepository.createTask(createTaskRequest);

//        UpdateTaskRequest updateTaskRequest = new UpdateTaskRequest();
//        updateTaskRequest.setDone(true);


//
//        taskRepository.deleteTask(1);
    }
}
