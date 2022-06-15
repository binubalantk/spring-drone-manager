package com.dronemanager.services;

import com.dronemanager.dao.AdministratorDao;
import com.dronemanager.models.Administrator;
import org.springframework.stereotype.Service;

@Service("adminUserService")
public class AdminUserService extends BaseServiceImpl<Administrator, String> {
    public AdminUserService(AdministratorDao dao) {
        super(dao);
    }
}
