package com.powerplantsystem.services.impls;

import com.powerplantsystem.dtos.BatteryDto;
import com.powerplantsystem.dtos.BatteryStatisticsDto;
import com.powerplantsystem.entities.Battery;
import com.powerplantsystem.repositories.BatteryRepository;
import com.powerplantsystem.services.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatteryServiceImpl implements BatteryService {

    private final BatteryRepository batteryRepository;

    @Autowired
    public BatteryServiceImpl(final BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }

    /**
     * Save multiple batteries
     *
     * @param batteries
     * @return List
     */
    @Override
    public List<BatteryDto> saveBatteries(List<Battery> batteries) {
        return null;
    }

    /**
     * Return battery list and other battery statistics by applying postcode range filter
     *
     * @param from
     * @param to
     * @return BatteryStatisticsDto
     */
    @Override
    public BatteryStatisticsDto getBatteryListByPostCodeRange(int from, int to) {
        return null;
    }
}
