package com.setplex.middleware.service;

import com.setplex.middleware.util.IdUtil;
import com.setplex.middleware.model.ChannelDTO;
import com.setplex.middleware.model.PackageDTO;
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
    public PackageDTO getPackage(int id) {
        return packageMapper.getPackage(id);
    }

    @Transactional
    public List<PackageDTO> getPackages() {
        return packageMapper.selectAll();
    }

    @Transactional
    public List<ChannelDTO> getChannelsByPackage(int packageId) {
        return channelMapper.getChannelsByPackage(packageId);
    }

    @Transactional
    public List<ChannelDTO> getChannels() {
        return channelMapper.selectAll();
    }

    @Transactional
    public ChannelDTO getChannel(int channelId) {
        return channelMapper.getChannel(channelId);
    }

    @Transactional
    public List<PackageDTO> getPackagesWithChannels() {
        List<PackageDTO> packages = packageMapper.selectAll();
        for (PackageDTO p : packages) {
            p.setChannels(channelMapper.getChannelsByPackage(p.getPackageId()));
        }
        return packages;
    }

    @Transactional
    public void createPackage(PackageDTO pk) {
        pk.setPackageId(IdUtil.nextId());
        packageMapper.insertPackage(pk);
    }
}
