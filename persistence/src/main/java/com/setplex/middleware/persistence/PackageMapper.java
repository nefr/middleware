package com.setplex.middleware.persistence;

import com.setplex.middleware.model.PackageDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ruslan Yatsevich
 */
@Repository
public interface PackageMapper {

    @Select("SELECT * FROM package WHERE packageId = #{packageId}")
    public PackageDTO getPackage(int packageId);

    @Select("SELECT * FROM package p WHERE  p.packageId = #{packageId}")
    @Results({
        @Result(property="packageId", column="packageId"),
        @Result(property="name", column="name"),
        @Result(property="channels", column="packageId", javaType=List.class, many=@Many(select="com.setplex.middleware.persistence.ChannelMapper.getChannelsByPackage")) })
    public PackageDTO getFullPackage(int packageId);

    @Select("SELECT * FROM package")
    public List<PackageDTO> selectAll();

    @Insert("INSERT INTO package(packageId, name) VALUES(#{packageId}, #{name})")
    public void insertPackage(PackageDTO packageTV);

    @Update("UPDATE PACKAGE SET name = #{name} WHERE packageId = #{packageId}")
    public void updatePackage(PackageDTO packageTV);

    @Delete("DELETE FROM package WHERE packageId = #{packageId}")
    public void deletePackage(int packageId);
}
