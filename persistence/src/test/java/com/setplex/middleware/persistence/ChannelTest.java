package com.setplex.middleware.persistence;

import com.setplex.middleware.AbstractTestConfig;
import com.setplex.middleware.util.IdUtil;
import com.setplex.middleware.model.ChannelDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ruslan Yatsevich
 */
public class ChannelTest extends AbstractTestConfig {

    @Autowired
    protected ChannelMapper mapper;
    private int pkId = 1001;
    private int chId = 2001;

    @Test
    public void testRead() {
        Assert.assertTrue(4 == mapper.selectAll().size());
        ChannelDTO c = mapper.getChannel(chId);
        Assert.assertEquals("ESPN", c.getName());
        Assert.assertEquals("English", mapper.getChannelsByPackage(pkId).get(0).getLanguage());
    }
    @Test
    public void testCreate() {
        ChannelDTO c = new ChannelDTO(IdUtil.nextId(), "CBS", "English", pkId);
        mapper.insertChannel(c);
        Assert.assertTrue(3 == mapper.getChannelsByPackage(pkId).size());
        Assert.assertEquals("CBS", mapper.getChannel(c.getChannelId()).getName());
    }
    @Test
    public void testUpdate() {
        ChannelDTO c = mapper.getChannel(chId);
        c.setLanguage("Russian");
        mapper.updateChannel(c);
        Assert.assertEquals("Russian", mapper.getChannel(chId).getLanguage());
    }
    @Test
    public void testDelete() {
        mapper.deleteChannel(chId+1);
        Assert.assertNull(mapper.getChannel(chId + 1));
    }
}
