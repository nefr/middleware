package com.setplex.middleware.persistence;

import com.setplex.middleware.model.ChannelTV;
import com.setplex.middleware.model.PackageTV;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ruslan Yatsevich
 */
@Repository
public interface ChannelMapper {
    @Select("SELECT * FROM channel WHERE channelId = #{channelId}")
    public ChannelTV getChannel(int channelId);

    @Select("SELECT * FROM channel")
    public List<ChannelTV> findAll();

    @Insert("INSERT INTO channel(channelId, name, language, packageId) VALUES(#{channelId}, #{name}, #{language}, #{packageId})")
    public void insertChannel(ChannelTV channel);

    @Update("UPDATE CHANNEL SET name = #{name}, language = #{language} WHERE channelId = #{channelId}")
    public void updateChannel(ChannelTV channel);

    @Delete("DELETE FROM channel WHERE channelId = #{channelId}")
    public void deleteChannel(int channelId);
}
