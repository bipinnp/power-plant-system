package com.powerplantsystem.dtos;

import com.powerplantsystem.entities.Battery;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

/**
 * BatteryStatisticsDto is a class which defines various variables and functions
 * related to computation of different statistics of battery
 *
 * @author Bipin Shrestha
 * @since 06/01/2023
 */
@Data
@Builder
@ToString
public class BatteryStatisticsDto {

    /**
     * Total number of battery
     */
    private  long totalBattery;
    /**
     * Total number of battery watt capacity
     */
    private  long totalBatteryWattCapacity;
    /**
     * Average watt capacity of battery
     */
    private double averageWattCapacity;
    /**
     * Minimum watt capacity of battery
     */
    private long minWattCapacity;
    /**
     * Maximum watt capacity of battery
     */
    private long maxWattCapacity;
    /**
     * List of battery sorted alphabetically
     */
    private List<BatteryDto> batteries;

    /**
     * Compute total battery watt capacity
     *
     * @param batteries
     * @return long
     */
    private static long getTotalWattCapacity(List<Battery> batteries) {
        return batteries.stream().mapToLong(Battery::getCapacity).sum();
    }

    /**
     * Compute average battery watt capacity
     *
     * @param batteries
     * @return double
     */
    private static double getAverageWattCapacity(List<Battery> batteries) {
        return batteries.stream().mapToLong(Battery::getCapacity).average().orElse(0.0);
    }

    /**
     *  Minimum battery watt capacity computation
     *
     * @param batteries
     * @return long
     */
    private static long getMinCapacity(List<Battery> batteries) {
        return batteries.stream().mapToLong(Battery::getCapacity).min().orElse(0L);
    }

    /**
     * Get max Capacity
     *
     * @param batteries
     * @return long
     */
    private static long getMaxCapacity(List<Battery> batteries) {
        return batteries.stream().mapToLong(Battery::getCapacity).max().orElse(0L);
    }

    /**
     * Battery statistics computation method
     *
     * @param batteries
     * @return BatteryStatisticsDto
     */
    public static BatteryStatisticsDto getStatistics(List<Battery> batteries){

        return  BatteryStatisticsDto.builder()
                .batteries(batteries.stream().sorted().map(BatteryDto::convertToDto).collect(Collectors.toList()))
                .totalBattery(batteries.size())
                .totalBatteryWattCapacity(getTotalWattCapacity(batteries))
                .minWattCapacity(getMinCapacity(batteries))
                .maxWattCapacity(getMaxCapacity(batteries))
                .averageWattCapacity(getAverageWattCapacity(batteries))
                .build();
    }
}
