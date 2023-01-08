package com.powerplantsystem.repositories;

import com.powerplantsystem.entities.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class is a repository class for Battery entity.
 *
 * @author Bipin Shrestha
 * @since 06/01/2023
 */
@Repository
public interface BatteryRepository extends JpaRepository<Battery,Long> { }
