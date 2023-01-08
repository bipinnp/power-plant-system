package com.powerplantsystem.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * Battery is an entity class which holds properties and functions of
 * battery object in power plant system.
 *
 * @author Bipin Shrestha
 * @since 06/01/2023
 */

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Battery implements Comparable<Battery>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Post code is mandatory")
    private String postCode;

    @NotBlank(message = "Watt capacity is mandatory")
    private long wattCapacity;

    @Override
    public int compareTo(Battery battery) {
        return name.compareTo(battery.getName());
    }
}
