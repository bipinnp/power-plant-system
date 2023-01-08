package com.powerplantsystem.dtos;

import com.fasterxml.jackson.databind.DeserializationFeature;
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
    private String postcode;
    private long capacity;

    public static BatteryDto convertToDto(Battery battery){
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .convertValue(battery,BatteryDto.class);
    }
}
