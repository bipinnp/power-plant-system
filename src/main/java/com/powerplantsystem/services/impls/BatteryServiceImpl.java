package com.powerplantsystem.services.impls;

import com.powerplantsystem.dtos.BatteryDto;
import com.powerplantsystem.dtos.BatteryStatisticsDto;
import com.powerplantsystem.entities.Battery;
import com.powerplantsystem.repositories.BatteryRepository;
import com.powerplantsystem.services.BatteryService;
import com.powerplantsystem.utils.BatteryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        final List<Battery> savedBatteryList = batteryRepository.saveAll(batteries);
        return savedBatteryList.stream().map(BatteryDto::convertToDto).collect(Collectors.toList());
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
        final List<Battery> allBattery = batteryRepository.findAll();
        final BatteryUtil batteryUtil = BatteryUtil.builder()
                .batteries(allBattery)
                .from(from)
                .to(to)
                .build();
        final List<Battery> batteryList = batteryUtil.selectedBattery(allBattery);
        return BatteryStatisticsDto.getStatistics(batteryList);
    }
}
