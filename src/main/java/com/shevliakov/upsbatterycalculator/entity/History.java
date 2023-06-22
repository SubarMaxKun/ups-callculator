/* (C)2023 */
package com.shevliakov.upsbatterycalculator.entity;

import jakarta.persistence.Column;
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

/** History entity */
@Entity
@Table(name = "history")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Setter
@Getter
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "user_id")
    private int userId;

    @NonNull private int capacity;
    @NonNull private int voltage;

    @NonNull
    @Column(name = "consumed_power")
    private String consumedPower;

    @NonNull
    @Column(name = "usage_time")
    private int hours;

    @NonNull
    @Column(name = "inverter_efficiency")
    private float inverterEfficiency;
}
