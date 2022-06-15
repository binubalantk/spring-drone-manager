package com.dronemanager.controller;

import com.dronemanager.exceptions.DroneNotFoundException;
import com.dronemanager.models.Administrator;
import com.dronemanager.services.AdminUserService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/admin-user")
@SuppressWarnings("unused")
public class AdministratorUserController {
    private final AdminUserService adminUserService;

    private final MessageSource messageSource;

    public AdministratorUserController(AdminUserService adminUserService, MessageSource messageSource) {
        this.adminUserService = adminUserService;
        this.messageSource = messageSource;
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Administrator> getAll() {
        return this.adminUserService.getAll(Administrator.class);
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public Administrator getById(@PathVariable("id") String id) {
        Optional<Administrator> optional = this.adminUserService.getById(id, Administrator.class);
        if (optional.isEmpty()) {
            throw new DroneNotFoundException();
        }
        return optional.get();
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Object> create(@RequestBody Administrator administrator, Locale locale) {
        this.adminUserService.create(administrator);
        return new ResponseEntity<>(messageSource.getMessage("drone.created", null, locale), HttpStatus.OK);
    }

    @PostMapping("/remove")
    @ResponseBody
    public ResponseEntity<Object> remove(@RequestBody String id, Locale locale) {
        this.adminUserService.removeById(id, Administrator.class);
        return new ResponseEntity<>(messageSource.getMessage("drone.removed", null, locale), HttpStatus.OK);
    }
}
