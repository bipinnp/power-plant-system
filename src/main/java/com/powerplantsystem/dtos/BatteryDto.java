package com.powerplantsystem.dtos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.powerplantsystem.entities.Battery;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BatteryDto is a class which contains battery details'
 * variables and methods which can be used for response generation
 *
 * @author Bipin Shrestha
 * @since 06/01/2023
 */
@Data
@NoArgsConstructor
public class BatteryDto {

    private String name;
    private String postCode;
    private long wattCapacity;

    public static BatteryDto convertToDto(Battery battery){
        return new ObjectMapper().convertValue(battery,BatteryDto.class);
    }
}