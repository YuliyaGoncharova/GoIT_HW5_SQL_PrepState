package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
import java.util.List;

public class DatabasePopulateService {

    public DatabasePopulateService() {
    }
    private static final String CLIENTS_DB = "./sql/populate_client.sql";
    private static final String PROJECTS_DB = "./sql/populate_projects.sql";
    private static final String PROJECT_WORKERS_DB = "./sql/populate_project_worker.sql";
    private static final String WORKERS_DB = "./sql/populate_worker.sql";

    public static void populateClients(Connection connection) throws SQLException {
        String query = "INSERT INTO client (name) VALUES (?)";
        File file = new File(CLIENTS_DB);
        List<String> clients;
        try {
            clients = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            System.out.println("Error reading " + CLIENTS_DB + ": " + e.getMessage());
            return;
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (String client : clients) {
                preparedStatement.setString(1, client);
                preparedStatement.executeUpdate();
            }
        }
    }
    public static void populateProjects(Connection connection) throws SQLException {
        String query = "INSERT INTO project (client_id, start_date, finish_date) VALUES (?, ?, ?)";
        File file = new File(PROJECTS_DB);
        List<String> projectsTable;
        try {
            projectsTable = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            System.out.println("Error reading " + PROJECTS_DB + ": " + e.getMessage());
            return;
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (String project : projectsTable) {
                String[] projectValues = project.split(",");
                int clientId = Integer.parseInt(projectValues[0].trim());
                Date startDate = Date.valueOf(projectValues[1].trim().replace("'", ""));
                Date finishDate = Date.valueOf(projectValues[2].trim().replace("'", ""));

                preparedStatement.setInt(1, clientId);
                preparedStatement.setDate(2, startDate);
                preparedStatement.setDate(3, finishDate);
                preparedStatement.executeUpdate();
            }
        }
    }

    public static void populateProjectWorkers(Connection connection) throws SQLException {
        String query = "INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?)";
        File file = new File(PROJECT_WORKERS_DB);

        List<String> ProjectWorkersTable;
        try {
            ProjectWorkersTable = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            System.out.println("Error reading " + PROJECT_WORKERS_DB + ": " + e.getMessage());
            return;
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (String projectWorkers : ProjectWorkersTable) {
                String[] projectWorkerValues = projectWorkers.split(",");
                int projectId = Integer.parseInt(projectWorkerValues[0].trim());
                int workerId = Integer.parseInt(projectWorkerValues[1].trim().replace("'", ""));

                preparedStatement.setInt(1, projectId);
                preparedStatement.setInt(2, workerId);
                preparedStatement.executeUpdate();
            }
        }
    }

    public static void populateWorkers(Connection connection) throws SQLException {
        String query = "INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)";
        File file = new File(WORKERS_DB);

        List<String> workersTable;
        try {
            workersTable = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            System.out.println("Error reading " + WORKERS_DB + ": " + e.getMessage());
            return;
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (String worker : workersTable) {
                String[] workerInfo = worker.split(",");
                String name = (workerInfo[0].trim());
                Date birthday = Date.valueOf(workerInfo[1].trim().replace("'", ""));
                String level = (workerInfo[2].trim().replace("'", ""));
                int salary = Integer.parseInt(workerInfo[3].trim().replace("'", ""));

                preparedStatement.setString(1, name);
                preparedStatement.setDate(2, birthday);
                preparedStatement.setString(3, level);
                preparedStatement.setInt(4, salary);
                preparedStatement.executeUpdate();
            }
        }
    }
}