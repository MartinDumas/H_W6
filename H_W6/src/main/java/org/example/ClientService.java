package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    public long create(String name) throws SQLException {
        if (name == null || name.length() < 2 || name.length() > 255) {
            throw new IllegalArgumentException("Client name must be between 2 and 255 characters");
        }

        String sql = "INSERT INTO client (name) VALUES (?)";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, name);
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating client failed, no ID obtained.");
                }
            }
        }
    }

    public String getById(long id) throws SQLException {
        String sql = "SELECT name FROM client WHERE id = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("name");
                } else {
                    throw new SQLException("Client with id " + id + " not found.");
                }
            }
        }
    }

    public void setName(long id, String name) throws SQLException {
        if (name == null || name.length() < 2 || name.length() > 255) {
            throw new IllegalArgumentException("Client name must be between 2 and 255 characters");
        }

        String sql = "UPDATE client SET name = ? WHERE id = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setLong(2, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Client with id " + id + " not found.");
            }
        }
    }

    public void deleteById(long id) throws SQLException {
        String sql = "DELETE FROM client WHERE id = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Client with id " + id + " not found.");
            }
        }
    }

    public List<Client> listAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT id, name FROM client";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                clients.add(new Client(resultSet.getLong("id"), resultSet.getString("name")));
            }
        }
        return clients;
    }
}
