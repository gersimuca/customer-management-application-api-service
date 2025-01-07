package com.gersimuca.cma.feature.user;

import com.gersimuca.cma.enumaration.Role;
import com.gersimuca.cma.feature.request.RequestEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class UserEntity implements UserDetails {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "user_id", columnDefinition = "uuid", updatable = false, nullable = false)
  private UUID userId;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false)
  private Role role;

  @NotNull
  @Column(name = "created_by")
  private UUID createdBy;

  @NotNull
  @Column(name = "updated_by")
  private UUID updatedBy;

  @NotNull
  @CreatedDate
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @CreatedDate
  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  @OneToMany(
      mappedBy = "user",
      fetch = FetchType.LAZY,
      orphanRemoval = true,
      cascade = CascadeType.ALL)
  private List<RequestEntity> requestEntities;

  @PrePersist
  public void beforePersist() {
    setCreatedBy(userId);
    setCreatedAt(LocalDateTime.now());
    setUpdatedBy(userId);
    setUpdatedAt(LocalDateTime.now());
  }

  @PreUpdate
  public void beforeUpdate() {
    setUpdatedBy(userId);
    setUpdatedAt(LocalDateTime.now());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
