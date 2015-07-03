package com.setplex.middleware.controller;

import com.setplex.middleware.service.TVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ruslan Yatsevich
 */
@RestController
public class PackageCtrl {

    @Autowired
    TVService service;
}
