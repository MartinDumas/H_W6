package org.example;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();

        try {
            long clientId = clientService.create("New Client");
            System.out.println("Client created with ID: " + clientId);

            String clientName = clientService.getById(clientId);
            System.out.println("Client with ID " + clientId + ": " + clientName);

            clientService.setName(clientId, "Updated Client");
            System.out.println("Client name updated");

            List<Client> clients = clientService.listAll();
            System.out.println("All clients:");
            for (Client client : clients) {
                System.out.println(client);
            }

            clientService.deleteById(clientId);
            System.out.println("Client with ID " + clientId + " deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}
