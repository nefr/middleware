package com.setplex.middleware.service;

import com.setplex.middleware.domain.Package;
import com.setplex.middleware.repository.ChannelRepo;
import com.setplex.middleware.repository.PackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Transactional
@Service
public class TVService {

    @Autowired
    ChannelRepo channelRepo;
    @Autowired
    PackageRepo packageRepo;


    public Package getPackage(int id) {
        return packageRepo.findOne(id);
    }

//    @Transactional
//    public List<PackageDTO> getPackages() {
//        return packageMapper.selectAll();
//    }
//
//    @Transactional
//    public List<ChannelDTO> getChannelsByPackage(int packageId) {
//        return channelMapper.getChannelsByPackage(packageId);
//    }
//
//    @Transactional
//    public List<ChannelDTO> getChannels() {
//        return channelMapper.selectAll();
//    }
//
//    @Transactional
//    public ChannelDTO getChannel(int channelId) {
//        return channelMapper.getChannel(channelId);
//    }

    public List<Package> getPackagesWithChannels() {
       return packageRepo.findAllWithDeps();
    }

    public void createPackage(Package pk) {
        packageRepo.save(pk);
    }
}
