package com.example.demo.service.impl;

import com.example.demo.model.Manager;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ManagerService;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(Jdbi jdbi) {
        this.managerRepository = jdbi.onDemand(ManagerRepository.class);
    }

    @Override
    public Manager getManager(Integer id) {
        return managerRepository.getManager(id);
    }
}
