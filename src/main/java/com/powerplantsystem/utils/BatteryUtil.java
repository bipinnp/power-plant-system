package com.powerplantsystem.utils;

import com.powerplantsystem.entities.Battery;
import lombok.Builder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * BatteryUtil is a utility class which contains utility functions.
 *
 * @author Bipin Shrestha
 * @since 06/01/2023
 */

@Builder
public class BatteryUtil {

    /**
     * List Of Batteries
     */
    private List<Battery> batteries;
    /**
     * Lower bound for the postcode
     */
    private int from;

    /**
     * Upper bound for the postcode
     */
    private int to;

    /**
     * Create a Set of postcodes from battery list
     * @return
     */
    private  Set<Integer> postCodes(List<Battery> batteryList){
        return batteryList.stream()
                .map(Battery::getPostcode)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    /**
     * Create Set Of Intersection between the postcodes present on the batteries and range of elements
     *
     * @return Set
     */
    private Set<String> getRangeOfBattery(List<Battery> batteryList){
        return IntStream.rangeClosed(from,to)
                .boxed()
                .collect(Collectors.toSet())
                .stream()
                .filter(postCodes(batteryList)::contains)
                .map(String::valueOf)
                .collect(Collectors.toSet());
    }

    /**
     * BatteryList whose postcodes lies within the postcode range
     *
     * @return List
     */
    public List<Battery> selectedBattery(List<Battery> batteryList) {
        return batteryList.stream()
                .filter(battery -> getRangeOfBattery(batteryList).contains(battery.getPostcode()))
                .collect(Collectors.toList());
    }
}
