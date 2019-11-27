package com.rui.service.cargo;

import com.rui.domain.cargo.FactoryExample;

import java.util.List;

public interface FactoryService {

    List findAll(FactoryExample factoryExample);
}
