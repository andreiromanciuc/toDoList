package org.fasttrackit.persistance;

import org.fasttrackit.transfer.CreateTaskRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class TaskRepository {

    public void createTask(CreateTaskRequest request) throws IOException, SQLException {

        // PREVENTING SQL INJECTION by avoiding concatenation and using PreparedStatement
        String sql = "INSERT INTO task (description, deadline) VALUES (?,?)";

        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, request.getDescription());
            preparedStatement.setDate(2, Date.valueOf(request.getDeadline()));
            preparedStatement.executeUpdate();
        }
    }
}
