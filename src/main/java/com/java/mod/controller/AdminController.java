package com.java.mod.controller;

import com.java.mod.pojo.User;
import com.java.mod.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * AdminController类用于处理与用户管理相关的HTTP请求
 */
@RestController
@RequestMapping("/admin/users")
public class AdminController {
    /**
     * 用户服务接口的实例，用于执行业务逻辑
     */
    @Autowired
    private UserService userService;

    /**
     * 创建新用户的POST请求处理器
     *
     * @param user 要创建的用户对象
     * @return 如果用户创建成功，则返回201 Created状态码和新创建的用户对象；
     *         否则返回500 Internal Server Error状态码和错误信息
     */
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User createdUser = userService.insertUser(user);
        if (createdUser != null) {
            return ResponseEntity.status(201).body(createdUser);
        }
        return ResponseEntity.status(500).body("Failed to create user");
    }

    /**
     * 删除指定userId用户的DELETE请求处理器
     *
     * @param userId 用户userId
     * @return 如果用户成功删除，则返回200 OK状态码和成功消息；
     *         否则返回404 Not Found状态码和错误信息
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId) {
        boolean deleted = userService.deleteUser(userId);
        if (deleted) {
            return ResponseEntity.ok("User deleted successfully");
        }
        return ResponseEntity.status(404).body("User not found");
    }

    /**
     * 更新指定userId用户的PUT请求处理器
     *
     * @param userId 用户userId
     * @param user 包含更新信息的用户对象
     * @return 如果用户更新成功，则返回200 OK状态码和成功消息；
     *         否则返回404 Not Found状态码和错误信息
     */
    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable("userId") String userId, @RequestBody User user) {
        user.setUserId(userId);
        boolean updated = userService.updateUser(user);
        if (updated) {
            return ResponseEntity.ok("User updated successfully");
        }
        return ResponseEntity.status(404).body("User not found");
    }

    /**
     * 获取所有用户的GET请求处理器
     *
     * @return 包含所有用户的列表
     */
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * 根据userId获取用户的GET请求处理器
     *
     * @param userId 用户userId
     * @return 如果找到用户，则返回200 OK状态码和用户对象；
     *         否则返回404 Not Found状态码和错误信息
     */
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserByUserId(@PathVariable("userId") String userId) {
        User user = userService.getUserByUserId(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(404).body("User not found");
    }
}