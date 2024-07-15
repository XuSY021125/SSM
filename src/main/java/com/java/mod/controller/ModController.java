package com.java.mod.controller;

import com.java.mod.pojo.Mod;
import com.java.mod.service.ModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * ModController类用于处理与模组相关的HTTP请求
 */
@RestController
@RequestMapping("/mods")
public class ModController {
    /**
     * Mod服务接口的实例，用于执行业务逻辑
     */
    @Autowired
    private  ModService modService;

    /**
     * 创建新模组的POST请求处理器
     *
     * @param mod 要创建的模组对象
     * @return 新创建的模组对象
     */
    @PostMapping
    public Mod create(@RequestBody Mod mod) {
        return modService.create(mod);
    }

    /**
     * 删除指定id模组的DELETE请求处理器。
     *
     * @param modid 要删除的模组id
     */
    @DeleteMapping("/{modid}")
    public void delete(@PathVariable String modid) {
        modService.delete(modid);
    }

    /**
     * 更新指定ID模组的PUT请求处理器。
     *
     * @param modid 要更新的模组id
     * @param mod 包含更新信息的模组对象
     * @return 更新后的模组对象
     */
    @PutMapping("/{modid}")
    public Mod update(@PathVariable String modid, @RequestBody Mod mod) {
        mod.setModid(modid);
        return modService.update(mod);
    }

    /**
     * 根据id获取模组的GET请求处理器
     *
     * @param modid 模组id
     * @return 请求的模组对象
     */
    @GetMapping("/{modid}")
    public Mod getMod(@PathVariable String modid) {
        return modService.getModById(modid);
    }

    /**
     * 获取所有模组的GET请求处理器
     *
     * @return 包含所有模组的列表
     */
    @GetMapping("/modlist")
    public List<Mod> getAll(){
       return modService.getModAll();
    }
}
