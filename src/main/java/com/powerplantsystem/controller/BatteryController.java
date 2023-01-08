package com.powerplantsystem.controller;

import com.powerplantsystem.dtos.ApiResponse;
import com.powerplantsystem.entities.Battery;
import com.powerplantsystem.services.BatteryService;
import com.powerplantsystem.utils.AppConstants;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is a controller class which includes the APIs
 * for performing battery inventory operations
 *
 * @author Bipin Shrestha
 * @since 06/01/2023
 */

@RestController
@RequestMapping("/api/v1/battery")
public class BatteryController {
    private final BatteryService batteryService;

    @Autowired
    public BatteryController(final BatteryService batteryService) {
        this.batteryService = batteryService;
    }

    @Operation(summary = "Store list of batteries")
    @PostMapping("/saveAll")
    public ApiResponse<Object> saveBatteries(@ParameterObject @RequestBody List<Battery> batteries){
        return ApiResponse.builder()
                .status(HttpStatus.OK)
                .code(String.valueOf(HttpStatus.OK.value()))
                .message(AppConstants.SAVED_ALL_BATTERIES)
                .data(batteryService.saveBatteries(batteries))
                .build();
    }

    @Operation(summary = "Get batteries statistics based on range of postcodes")
    @GetMapping("/statistics/postcodes")
    public ApiResponse<Object> getBatteryStatisticsByPostCodes(@ParameterObject @RequestParam("from") int from, @ParameterObject @RequestParam("to") int to){
       return ApiResponse.builder()
               .status(HttpStatus.OK)
               .code(String.valueOf(HttpStatus.OK.value()))
               .message(AppConstants.GET_BATTERY_STATISTICS)
               .data(batteryService.getBatteryListByPostCodeRange(from, to))
               .build();
    }
}
