package com.gersimuca.customer_management_application.service;

import com.gersimuca.customer_management_application.model.Client;
import com.gersimuca.customer_management_application.enumaration.Role;

public interface ClientService {
    Client updateClient(String firstName, String lastName, String email, String password, Role role);
    void createClient(String firstName, String lastName, String email, String password, Role role);
    void deleteClient(String email);
}
