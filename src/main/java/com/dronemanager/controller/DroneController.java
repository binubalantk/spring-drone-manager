package com.dronemanager.controller;

import com.dronemanager.exceptions.DroneNotFoundException;
import com.dronemanager.models.Drone;
import com.dronemanager.services.DroneServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/drone")
@SuppressWarnings("unused")
public class DroneController {
    private final DroneServiceImpl droneServiceImpl;

    private final MessageSource messageSource;

    public DroneController(DroneServiceImpl droneServiceImpl, MessageSource messageSource) {
        this.droneServiceImpl = droneServiceImpl;
        this.messageSource = messageSource;
    }

    @Autowired


    @GetMapping("/getAll")
    @ResponseBody
    public List<Drone> getAll() {
        return this.droneServiceImpl.getAll();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public Drone getById(@PathVariable("id") String id) {
        Optional<Drone> optionalDrone = this.droneServiceImpl.getById(id);
        if (optionalDrone.isEmpty()) {
            throw new DroneNotFoundException();
        }
        return optionalDrone.get();
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Object> create(@RequestBody Drone drone, Locale locale) {
        this.droneServiceImpl.create(drone);
        return new ResponseEntity<>(messageSource.getMessage("drone.created", null, locale), HttpStatus.OK);
    }

    @PostMapping("/remove")
    @ResponseBody
    public ResponseEntity<Object> remove(@RequestBody String id, Locale locale) {
        this.droneServiceImpl.removeById(id);
        return new ResponseEntity<>(messageSource.getMessage("drone.removed", null, locale), HttpStatus.OK);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ResponseEntity<Object> upload(@RequestPart("drone") String str, @RequestPart("imageFile") MultipartFile file) throws IOException {
        Drone drone = new Gson().fromJson(str, Drone.class);
        File f = new File(String.format("drone_image_%s.jpg", drone.getId()));
        f.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(f);
        outputStream.write(file.getBytes());
        outputStream.close();
        this.droneServiceImpl.create(drone);
        return new ResponseEntity<>("File uploaded", HttpStatus.OK);
    }
}
