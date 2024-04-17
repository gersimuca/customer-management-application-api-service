package com.gersimuca.customer_management_application.model;

import com.gersimuca.customer_management_application.enumaration.Role;
import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;

@Entity
@Table(name = "client")

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {
    @Id
    @SequenceGenerator(name = "primary_key_seq", sequenceName = "primary_key_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_key_seq")
    @Column(insertable=false, updatable=false)
    private UUID client_id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name" , nullable = false)
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name= "role", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "client_id") // name of the foreign key column in the requests table referencing client
    private RequestsEntity request;

}
