package com.gersimuca.cma.feature.token;

import com.gersimuca.cma.feature.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "token")
public class TokenEntity {
  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "token")
  private String token;

  @Enumerated(EnumType.STRING)
  @Column(name = "token_type")
  private TokenType tokenType;

  @Column(name = "expired")
  private boolean expired;

  @Column(name = "revoked")
  private boolean revoked;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;
}
