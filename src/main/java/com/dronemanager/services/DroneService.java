package com.dronemanager.services;

import com.dronemanager.dao.BaseDao;
import com.dronemanager.models.Drone;
import org.springframework.stereotype.Service;

@Service("droneService")
public class DroneService extends BaseServiceImpl<Drone, String> {
    public DroneService(BaseDao<Drone, String> dao) {
        super(dao);
    }
}
