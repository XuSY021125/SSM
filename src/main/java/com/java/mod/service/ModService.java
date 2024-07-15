package com.java.mod.service;

import com.java.mod.mapper.ModMapper;
import com.java.mod.pojo.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModService {
    @Autowired
    private  ModMapper modMapper;

    public Mod create(Mod mod) {
        modMapper.insert(mod);
        return mod;
    }


    public void delete(String modid) {
        modMapper.delete(modid);
    }


    public Mod update(Mod mod) {
        modMapper.update(mod);
        return mod;
    }


    public Mod getModById(String modid) {
        return modMapper.getModById(modid);
    }


    public List<Mod> getModAll() {
        return modMapper.getModAll();
    }
}
