package com.setplex.middleware.controller;

import com.setplex.middleware.model.PackageDTO;
import com.setplex.middleware.service.TVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<PackageDTO> getPackages() {
        return service.getPackagesWithChannels();
    }

    @RequestMapping(value = "/packages/{id}", method = RequestMethod.GET)
    public PackageDTO getPackage(@PathVariable int id) {
        return service.getPackage(id);
    }

    @RequestMapping(value = "/packages", method = RequestMethod.POST)
    public ResponseEntity<Void> createPackage(PackageDTO pk) {
        service.createPackage(pk);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
