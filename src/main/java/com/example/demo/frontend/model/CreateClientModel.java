package com.example.demo.frontend.model;

import javax.swing.*;

import com.example.demo.backend.model.Client;
import com.example.demo.backend.repository.ClientRepository;
import com.example.demo.frontend.controller.CreateClientController;
import com.example.demo.frontend.view.CreateClientView;
import com.example.demo.frontend.view.IndexView;

public class CreateClientModel implements CreateClientController {
    private final ClientRepository clientRepository = new ClientRepository();

    @Override
    public void createClient(CreateClientView createClientView, JButton button) {
        button.addActionListener(e -> {
            Client client = new Client();
            client.setFirstName(createClientView.getFirstName().getText());
            client.setLastName(createClientView.getLastName().getText());
            client.setEmail(createClientView.getEmail().getText());
            client.setPassword(createClientView.getPassword().getText());

            clientRepository.createClient(client);
            createClientView.dispose();
            new IndexView();
        });
    }
}
