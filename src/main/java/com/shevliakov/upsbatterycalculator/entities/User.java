package com.shevliakov.upsbatterycalculator.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @NonNull
  private String username;
  @NonNull
  private String password;
}
