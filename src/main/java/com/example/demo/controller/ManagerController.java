package com.example.demo.controller;

import com.example.demo.model.Manager;
import com.example.demo.model.Product;
import com.example.demo.service.ManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/manager")
@RequiredArgsConstructor
@Slf4j
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping("/{id}")
    public ResponseEntity<Manager> getManager(@PathVariable("id") int id) {
        log.info("Rest request to get manager");
        Manager manager = managerService.getManager(id);
        return new ResponseEntity<>(manager, HttpStatus.OK);
    }
}
