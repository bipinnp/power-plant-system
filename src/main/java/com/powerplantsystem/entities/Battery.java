package com.powerplantsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

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
    @Setter(AccessLevel.NONE)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Post code is mandatory")
    private String postcode;

    @NotBlank(message = "Watt capacity is mandatory")
    private long capacity;

    @Override
    public int compareTo(Battery battery) {
        return name.compareTo(battery.getName());
    }
}
