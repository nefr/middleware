package com.setplex.middleware.persistence;

import com.setplex.middleware.AbstractTestConfig;
import com.setplex.middleware.model.ChannelTV;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ruslan Yatsevich
 */
public class ChannelTest extends AbstractTestConfig {

    @Autowired
    protected ChannelMapper mapper;

    @Test
    public void channelCRUD() {
        Assert.assertTrue(4 == mapper.selectAll().size());
        ChannelTV s = mapper.getChannel(2001);
        Assert.assertEquals("ESPN", s.getName());
    }
}
