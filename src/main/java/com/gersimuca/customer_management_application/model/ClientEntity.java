package com.gersimuca.customer_management_application.model;

import com.gersimuca.customer_management_application.enumaration.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;


import java.time.LocalDateTime;

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
    @Column(insertable=false, updatable=false, name = "client_id")
    private Long clientId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name" , nullable = false)
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name= "role", nullable = false)
    private Role role;

    @NotNull
    @Column(name="created_by")
    private Long createdBy;

    @NotNull
    @Column(name="updated_by")
    private Long updatedBy;

    @NotNull
    @CreatedDate
    @Column(name="created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @CreatedDate
    @Column(name="updated_at", nullable = false)
    private LocalDateTime updatedAt;


    @PrePersist
    public void beforePersist(){
        setCreatedBy(clientId);
        setCreatedAt(LocalDateTime.now());
        setUpdatedBy(clientId);
        setUpdatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void beforeUpdate(){
        setUpdatedBy(clientId);
        setUpdatedAt(LocalDateTime.now());
    }

}
