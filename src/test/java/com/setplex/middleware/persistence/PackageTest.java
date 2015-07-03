package com.setplex.middleware.persistence;

import com.setplex.middleware.AbstractTestConfig;
import com.setplex.middleware.AbstractTestDS;
import com.setplex.middleware.Util.IdUtil;
import com.setplex.middleware.model.PackageTV;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ruslan Yatsevich
 */

public class PackageTest  extends AbstractTestConfig {

    @Autowired
    protected PackageMapper mapper;

    @Test
    public void testCRUD() {
        int newPackageId = IdUtil.nextId();
        String newPackageName = "sport2";

        PackageTV pk = new PackageTV(newPackageId, newPackageName);
        mapper.insertPackage(pk);
        pk = mapper.getPackage(newPackageId);
        Assert.assertEquals(newPackageName, pk.getName());

        pk = mapper.findAll().get(0);
        pk.setName(newPackageName);
        mapper.updatePackage(pk);
        Assert.assertEquals(newPackageName, mapper.getPackage(pk.getPackageId()).getName());

        mapper.deletePackage(pk.getPackageId());
        Assert.assertNull(mapper.getPackage(pk.getPackageId()));
    }
}
