package com.setplex.middleware.service;

import com.setplex.middleware.Util.IdUtil;
import com.setplex.middleware.model.ChannelTV;
import com.setplex.middleware.model.PackageTV;
import com.setplex.middleware.persistence.ChannelMapper;
import com.setplex.middleware.persistence.PackageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public PackageTV getPackage(int id) {
        return packageMapper.getPackage(id);
    }

    @Transactional
    public List<PackageTV> getPackages() {
        return packageMapper.selectAll();
    }

    @Transactional
    public List<ChannelTV> getChannelsByPackage(int packageId) {
        return channelMapper.getChannelsByPackage(packageId);
    }

    @Transactional
    public List<ChannelTV> getChannels() {
        return channelMapper.selectAll();
    }

    @Transactional
    public ChannelTV getChannel(int channelId) {
        return channelMapper.getChannel(channelId);
    }

    @Transactional
    public List<PackageTV> getPackagesWithChannels() {
        List<PackageTV> packages = packageMapper.selectAll();
        for (PackageTV p : packages) {
            p.setChannels(channelMapper.getChannelsByPackage(p.getPackageId()));
        }
        return packages;
    }

    @Transactional
    public void createPackage(PackageTV pk) {
        pk.setPackageId(IdUtil.nextId());
        packageMapper.insertPackage(pk);
    }
}
