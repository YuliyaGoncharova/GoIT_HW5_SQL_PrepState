package org.example;

import org.example.queryResultClasses.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public static void main(String[] args) {
        DatabaseQueryService queryService = new DatabaseQueryService();

        List<MaxProjectsClient> findMaxProjectsClient = new DatabaseQueryService().findMaxProjectsClient();
        List<MaxSalaryWorker> findMaxSalaryWorker = new DatabaseQueryService().findMaxSalaryWorker();
        List<LongestProject> findLongestProjects = new DatabaseQueryService().findLongestProject();
        List<YoungestEldestWorkers>  findYoungestEldestWorkers = new DatabaseQueryService().findYoungestEldestWorkers();
        List<TotalProjectPrices> printProjectPrices = new DatabaseQueryService().printProjectPrices();

        Database.getInstance().close();
    }

    public List<MaxProjectsClient> findMaxProjectsClient() {
        String sqlFilename = "./sql/find_max_projects_client.sql";
        List<MaxProjectsClient> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of(sqlFilename));
            Statement statement = Database.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("Query 1: Highest number of projects for each client:");

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int maxProjects = resultSet.getInt("MAX_PROJECTS");

                MaxProjectsClient client = new MaxProjectsClient(name, maxProjects);
                result.add(client);
                System.out.println("Client Name: " + name + ", Count of projects: " + maxProjects);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        String sqlFilename = "./sql/find_max_salary_worker.sql";
        List<MaxSalaryWorker> result = new ArrayList<>();

        System.out.println("\n" + "Query 2: Worker who has the MAX salary:");

        try {
            String sql = Files.readString(Path.of(sqlFilename));
            Statement statement = Database.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int salary = resultSet.getInt("SALARY");

                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker(name, salary);
                result.add(maxSalaryWorker);
                System.out.println("Worker name: " + name + ", salary: " + salary);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<LongestProject> findLongestProject() {
        String sqlFilename = "./sql/find_longest_project.sql";
        List<LongestProject> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of(sqlFilename));
            Statement statement = Database.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("\n" + "Query 3: Project with longest duration:");

            while (resultSet.next()) {
                int name = resultSet.getInt("NAME");
                int month_count = resultSet.getInt("MONTH_COUNT");

                LongestProject longestProject = new LongestProject(name, month_count);
                result.add(longestProject);
                System.out.println("Project id (instead of name): " + name + ", duration: " + month_count);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        String sqlFilename = "./sql/find_youngest_eldest_workers.sql";
        List<YoungestEldestWorkers> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of(sqlFilename));
            Statement statement = Database.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("\n" + "Query 4:  The oldest and youngest workers:");

            while (resultSet.next()) {
                String type = resultSet.getString("TYPE");
                String name = resultSet.getString("NAME");
                String birthday = resultSet.getString("BIRTHDAY");

                YoungestEldestWorkers youngestEldestWorkers = new YoungestEldestWorkers(name,type, birthday);
                result.add(youngestEldestWorkers);
                System.out.println("Worker name: " + name + ", age: " + type +  ", birthday: " + birthday);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<TotalProjectPrices> printProjectPrices() {
        String sqlFilename = "./sql/print_project_prices.sql";
        List<TotalProjectPrices> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of(sqlFilename));
            Statement statement = Database.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("\n" + "Query 5: Total price for each project:");

            while (resultSet.next()) {
                int name = resultSet.getInt("NAME");
                int totalProjectPrice = resultSet.getInt("TOTAL_PROJECT_PRICE");

                TotalProjectPrices projectPrice = new TotalProjectPrices(name,totalProjectPrice);
                result.add(projectPrice);
                System.out.println("Project id: " + name + ", total cost : " + totalProjectPrice);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}