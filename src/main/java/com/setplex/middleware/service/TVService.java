package com.setplex.middleware.service;

import com.setplex.middleware.model.PackageTV;
import com.setplex.middleware.persistence.ChannelMapper;
import com.setplex.middleware.persistence.PackageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author Ruslan Yatsevich
 */
@Service
public class TVService {

    @Autowired
    ChannelMapper channelMapper;
    @Autowired
    PackageMapper packageMapper;

    public List<PackageTV> getPackagesWithChannels() {
        return Collections.emptyList();
    }
}
