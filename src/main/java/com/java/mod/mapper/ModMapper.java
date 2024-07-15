package com.java.mod.mapper;

import com.java.mod.pojo.Mod;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ModMapper {
    @Insert("INSERT INTO table_mods (modid, modversion, modavailable, modinfo) VALUES (#{modid}, #{modversion}, #{modavailable}, #{modinfo})")
    int insert(Mod mod);

    @Update("UPDATE table_mods SET modversion=#{modversion}, modavailable=#{modavailable}, modinfo=#{modinfo} WHERE modid=#{modid}")
    int update(Mod mod);

    @Delete("DELETE FROM table_mods WHERE modid=#{modid}")
    int delete(String modid);

    @Select("SELECT * FROM table_mods WHERE modid=#{modid}")
    Mod getModById(String modid);

    @Select("SELECT * FROM table_mods")
    List<Mod> getModAll();
}