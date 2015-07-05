package com.setplex.middleware.persistence;

import com.setplex.middleware.model.PackageTV;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ruslan Yatsevich
 */
@Repository
public interface PackageMapper {

    @Select("SELECT * FROM package WHERE packageId = #{packageId}")
    public PackageTV getPackage(int packageId);

    @Select("SELECT * FROM package p WHERE  p.packageId = #{packageId}")
    @Results({
        @Result(property="packageId", column="packageId"),
        @Result(property="name", column="name"),
        @Result(property="channels", column="packageId", javaType=List.class, many=@Many(select="com.setplex.middleware.persistence.ChannelMapper.getChannelsByPackage")) })
    public PackageTV getFullPackage(int packageId);

    @Select("SELECT * FROM package")
    public List<PackageTV> selectAll();

    @Insert("INSERT INTO package(packageId, name) VALUES(#{packageId}, #{name})")
    public void insertPackage(PackageTV packageTV);

    @Update("UPDATE PACKAGE SET name = #{name} WHERE packageId = #{packageId}")
    public void updatePackage(PackageTV packageTV);

    @Delete("DELETE FROM package WHERE packageId = #{packageId}")
    public void deletePackage(int packageId);
}
