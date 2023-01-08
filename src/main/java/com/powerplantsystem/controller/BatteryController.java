package com.powerplantsystem.controller;

import com.powerplantsystem.dtos.ApiResponse;
import com.powerplantsystem.dtos.BatteryDto;
import com.powerplantsystem.dtos.BatteryStatisticsDto;
import com.powerplantsystem.entities.Battery;
import com.powerplantsystem.services.BatteryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ApiResponse<List<BatteryDto>> saveBatteries(@ParameterObject @RequestBody List<Battery> batteries){
        return null;
    }

    @Operation(summary = "Get batteries statistics based on range of postcodes")
    @GetMapping("/statistics/postcodes")
    public ApiResponse<BatteryStatisticsDto> getBatteryStatisticsByPostCodes(@ParameterObject @RequestParam("from") int from, @ParameterObject @RequestParam("to") int to){
       return null;
    }

}
