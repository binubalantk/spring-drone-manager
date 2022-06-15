package com.dronemanager.services;


import com.dronemanager.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<OBJECT, ID> implements BaseService<OBJECT, ID> {
    @Autowired
    private BaseDao<OBJECT, ID> dao;

    public BaseServiceImpl(BaseDao<OBJECT, ID> dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<OBJECT> getAll(Class<OBJECT> objectClass) {
        return dao.getAll(objectClass);
    }

    @Override
    @Transactional
    public OBJECT create(OBJECT object) {
        return dao.create(object);
    }

    @Override
    @Transactional
    public Optional<OBJECT> getById(ID id, Class<OBJECT> objectClass) {
        return Optional.ofNullable(dao.getById(objectClass, id));
    }

    @Override
    @Transactional
    public void removeById(ID id, Class<OBJECT> objectClass) {
        dao.removeById(id, objectClass);
    }
}
