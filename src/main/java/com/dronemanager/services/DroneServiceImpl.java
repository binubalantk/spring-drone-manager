package com.dronemanager.services;

import com.dronemanager.models.Drone;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DroneServiceImpl implements DronService{
    private static final List<Drone> drones = new LinkedList<>();

    @Override
    public List<Drone> getAll() {
        return drones;
    }

    @Override
    public void create(Drone drone) {
        drones.add(drone);
    }

    @Override
    public Optional<Drone> getById(String id) {
        return drones.stream()
                .filter(drone -> drone.getId().equals(id))
                .findFirst();
    }

    @Override
    public void removeById(String id) {
        drones.removeIf(drone -> drone.getId().equals(id));
    }
}
