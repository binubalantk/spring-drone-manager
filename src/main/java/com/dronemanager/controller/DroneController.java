package com.dronemanager.controller;

import com.dronemanager.exceptions.DroneNotFoundException;
import com.dronemanager.models.Drone;
import com.dronemanager.models.User;
import com.dronemanager.services.DroneService;
import com.google.gson.Gson;
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
    private final DroneService droneService;

    private final MessageSource messageSource;

    public DroneController(DroneService droneService, MessageSource messageSource) {
        this.droneService = droneService;
        this.messageSource = messageSource;
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Drone> getAll() {
        return this.droneService.getAll(Drone.class);
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public Drone getById(@PathVariable("id") String id) {
        Optional<Drone> optionalDrone = this.droneService.getById(id, Drone.class);
        if (optionalDrone.isEmpty()) {
            throw new DroneNotFoundException();
        }
        return optionalDrone.get();
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Object> create(@RequestBody Drone drone, Locale locale) {
        this.droneService.create(drone);
        return new ResponseEntity<>(messageSource.getMessage("drone.created", null, locale), HttpStatus.OK);
    }

    @PostMapping("/remove")
    @ResponseBody
    public ResponseEntity<Object> remove(@RequestBody String id, Locale locale) {
        this.droneService.removeById(id, Drone.class);
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
        this.droneService.create(drone);



        String jsonUser = "{\"id\":\"asdasd\", \"firstName\":\"Remisha\", \"lastName\":\"Binu\", \"dob\":\"14/11/1993\"}";

        Gson gson = new Gson();
        User userParsed = gson.fromJson(jsonUser, User.class);

        User user = new User("asd23", "Binu", "Balan", "04/10/1990");
        Gson gson1 = new Gson();
        String stringifiedUser = gson1.toJson(user, User.class);





        return new ResponseEntity<>("File uploaded", HttpStatus.OK);
    }
}
