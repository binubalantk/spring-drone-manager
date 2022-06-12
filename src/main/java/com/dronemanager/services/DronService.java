package com.dronemanager.services;

import com.dronemanager.models.Drone;

import java.util.List;
import java.util.Optional;

public interface DronService {
    List<Drone> getAll();
    void create(Drone drone);
    Optional<Drone> getById(String id);
    void removeById(String id);
}
