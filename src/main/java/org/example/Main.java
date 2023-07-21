package org.example;

import java.sql.Connection;


import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        DatabasePopulateService populateService = new DatabasePopulateService();
        try {
            populateService.populateClients(connection);
            populateService.populateProjects(connection);
            populateService.populateProjectWorkers(connection);
            populateService.populateWorkers(connection);

            System.out.println("Data population completed.");
        } catch (SQLException e) {
            System.out.println("Error executing SQL statements: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
}
