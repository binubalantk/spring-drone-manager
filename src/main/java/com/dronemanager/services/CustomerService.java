package com.dronemanager.services;

import com.dronemanager.dao.CustomerDao;
import com.dronemanager.models.Customer;
import org.springframework.stereotype.Service;

@Service("CustomerService")
public class CustomerService extends BaseServiceImpl<Customer, String> {
    public CustomerService(CustomerDao dao) {
        super(dao);
    }
}
