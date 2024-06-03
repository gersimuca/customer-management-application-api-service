package com.gersimuca.customer_management_application.model;

import com.gersimuca.customer_management_application.enumaration.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "client")

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID clientId;

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
    private UUID createdBy;

    @NotNull
    @Column(name="updated_by")
    private UUID updatedBy;

    @NotNull
    @CreatedDate
    @Column(name="created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @CreatedDate
    @Column(name="updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Request> requests;


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
