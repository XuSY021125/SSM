package com.java.mod.controller;

import com.java.mod.pojo.User;
import com.java.mod.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController类用于处理与用户相关的HTTP请求
 */
@RestController
public class LoginController {
    /**
     * 用户服务接口的实例，用于执行业务逻辑。
     */
    @Autowired
    private  UserService userService;

    /**
     * 处理用户登录的GET请求
     *
     * @param username 用户名
     * @param password 密码
     * @return 如果用户名和密码匹配，则返回用户信息；否则返回401 Unauthorized状态
     */
    @GetMapping("/user")
    public ResponseEntity<?> userLogin(@RequestParam("username") String username,
                                     @RequestParam("password") String password) {
        User user = userService.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body("Unauthorized");
        }
    }

    /**
     * 处理管理员登录的GET请求
     *
     * @param username 用户名
     * @param password 密码
     * @return 如果用户名、密码正确并且用户角色为"admin"，则返回欢迎信息；否则返回403 Forbidden状态
     */
    @GetMapping("/admin")
    public ResponseEntity<?> adminLogin(@RequestParam("username") String username,
                                       @RequestParam("password") String password) {
        User user = userService.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password) && "admin".equals(user.getRole())) {
            return ResponseEntity.ok("Welcome Admin!");
        } else {
            return ResponseEntity.status(403).body("Forbidden");
        }
    }
}