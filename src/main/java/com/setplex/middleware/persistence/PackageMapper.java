package com.setplex.middleware.persistence;

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
public interface PackageMapper {

    @Select("SELECT * FROM package WHERE packageId = #{packageId}")
    public PackageTV getPackage(int packageId);

    @Select("SELECT * FROM package")
    public List<PackageTV> findAll();

    @Insert("INSERT INTO package(packageId, name) VALUES(#{packageId}, #{name})")
    public void insertPackage(PackageTV packageTV);

    @Update("UPDATE PACKAGE SET name = #{name} WHERE packageId = #{packageId}")
    public void updatePackage(PackageTV packageTV);

    @Delete("DELETE FROM package WHERE packageId = #{packageId}")
    public void deletePackage(int packageId);
}
