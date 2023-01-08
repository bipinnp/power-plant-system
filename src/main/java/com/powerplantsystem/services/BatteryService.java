package com.powerplantsystem.services;

import com.powerplantsystem.dtos.BatteryDto;
import com.powerplantsystem.dtos.BatteryStatisticsDto;
import com.powerplantsystem.entities.Battery;

import java.util.List;

/**
 * BatteryService is an interface which defines basic functions
 * for battery inventory related CRUD operations
 *
 * @author Bipin Shrestha
 * @since 06/01/2023
 */

public interface BatteryService {
     List<BatteryDto> saveBatteries(List<Battery> batteries);
     BatteryStatisticsDto getBatteryListByPostCodeRange(int from, int to);
}
