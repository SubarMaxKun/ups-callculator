/* (C)2023 */
package com.shevliakov.upsbatterycalculator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/** Battery entity */
@Entity
@Table(name = "batteries")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Setter
@Getter
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull private String brand;
    @NonNull private String model;
    @NonNull private String type;
    @NonNull private int voltage;
    @NonNull private int capacity;
}
