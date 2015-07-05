package com.setplex.middleware.controller;

import com.setplex.middleware.model.PackageTV;
import com.setplex.middleware.service.TVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ruslan Yatsevich
 */
@RestController
public class PackageCtrl {

    @Autowired
    TVService service;

    @RequestMapping(value = "/packages", method = RequestMethod.GET)
    public List<PackageTV> getPackages() {
        return service.getPackages();
    }

    @RequestMapping(value = "/packages/{id}", method = RequestMethod.GET)
    public PackageTV getPackage(@PathVariable int id) {
        return service.getPackage(id);
    }
}
