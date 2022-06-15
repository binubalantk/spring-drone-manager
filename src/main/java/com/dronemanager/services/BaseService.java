package com.dronemanager.services;

import java.util.List;
import java.util.Optional;

public interface BaseService<OBJECT, ID> {

    List<OBJECT> getAll(Class<OBJECT> objectClass);

    OBJECT create(OBJECT object);

    Optional<OBJECT> getById(ID id, Class<OBJECT> objectClass);

    void removeById(ID id, Class<OBJECT> objectClass);
}
