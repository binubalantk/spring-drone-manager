package com.dronemanager.dao;

import java.util.List;

public interface BaseDao<OBJECT, ID> {
    OBJECT create(OBJECT object);

    OBJECT update(ID id, OBJECT object);

    List<OBJECT> getAll(Class<OBJECT> objectClass);

    OBJECT getById( Class<OBJECT> objectClass, ID id);

    void removeById(ID id, Class<OBJECT> objectClass);
}
