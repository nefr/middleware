package com.setplex.middleware.controller;

import com.setplex.middleware.model.ChannelTV;
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
@RequestMapping("/packages")
public class ChannelCtrl {

    @Autowired
    TVService service;

    @RequestMapping(value = "/channels", method = RequestMethod.GET)
    public List<ChannelTV> getChannels() {
        return service.getChannels();
    }

    @RequestMapping(value = "/{pId}/channels", method = RequestMethod.GET)
    public List<ChannelTV> getChannelsByPackage(@PathVariable int pId) {
        return service.getChannelsByPackage(pId);
    }

    @RequestMapping(value = "/{pId}/channels/{cId}", method = RequestMethod.GET)
    public ChannelTV getChannel(@PathVariable int pId, @PathVariable int cId) {
        return service.getChannel(cId);
    }
}
