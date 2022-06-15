package com.dronemanager.controller;

import com.dronemanager.exceptions.DroneNotFoundException;
import com.dronemanager.models.Customer;
import com.dronemanager.services.CustomerService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/customer-user")
@SuppressWarnings("unused")
public class CustomerUserController {
    private final CustomerService customerService;

    private final MessageSource messageSource;

    public CustomerUserController(CustomerService adminUserService, MessageSource messageSource) {
        this.customerService = adminUserService;
        this.messageSource = messageSource;
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Customer> getAll() {
        return this.customerService.getAll(Customer.class);
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public Customer getById(@PathVariable("id") String id) {
        Optional<Customer> optional = this.customerService.getById(id, Customer.class);
        if (optional.isEmpty()) {
            throw new DroneNotFoundException();
        }
        return optional.get();
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Object> create(@RequestBody Customer customer, Locale locale) {
        this.customerService.create(customer);
        return new ResponseEntity<>(messageSource.getMessage("drone.created", null, locale), HttpStatus.OK);
    }

    @PostMapping("/remove")
    @ResponseBody
    public ResponseEntity<Object> remove(@RequestBody String id, Locale locale) {
        this.customerService.removeById(id, Customer.class);
        return new ResponseEntity<>(messageSource.getMessage("drone.removed", null, locale), HttpStatus.OK);
    }
}
