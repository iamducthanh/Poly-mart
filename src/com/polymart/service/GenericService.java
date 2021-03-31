package com.polymart.service;

import java.util.List;

public interface GenericService<T> {

    List<T> findAll();

    T findById(String id);

}
