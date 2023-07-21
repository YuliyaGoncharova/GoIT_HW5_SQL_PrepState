package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        String initDbQuearies = "./sql/init_db.sql";

        String sql;
        try {
            sql = Files.readString(Path.of(initDbQuearies));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            Statement statement = Database.getInstance().getConnection().createStatement();
            statement.executeUpdate(sql);
            System.out.println("Database initialization is SUCCEED.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database initialization is FAILED.");
        } finally {
            Database.getInstance().close();
        }
    }
}