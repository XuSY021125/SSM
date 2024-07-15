package com.java.mod.mapper;


import com.java.mod.pojo.User;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface UserMapper {
    /**
     * 插入新用户到数据库
     *
     * @param user 要插入的用户对象，包含用户名、密码和角色
     * @return 影响的行数，>0则代表成功
     */
    @Insert("INSERT INTO users (userId, username, password, role) VALUES (#{userId}, #{username}, #{password}, #{role})")
    int insertUser(User user);

    /**
     * 根据用户userId删除用户
     *
     * @param userId 用户的唯一标识符
     * @return 影响的行数，>0则代表成功
     */
    @Delete("DELETE FROM users WHERE userId = #{userId}")
    int deleteUser(String userId);

    /**
     * 更新用户信息，包括密码和角色
     *
     * @param user 包含要更新信息的用户对象
     * @return 影响的行数，>0则代表成功
     */
    @Update("UPDATE users SET password = #{password}, role = #{role} WHERE userId = #{userId}")
    int updateUser(User user);

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return 匹配用户名的用户对象，如果未找到则返回null
     */
    @Select("SELECT userId, username, password, role FROM users WHERE username = #{username}")
    User getUserByUsername(String username);

    /**
     * 根据用户userId查找用户
     *
     * @param userId 用户的唯一标识符
     * @return 匹配userId的用户对象，如果未找到则返回null
     */
    @Select("SELECT userId, username, password, role FROM users WHERE userId = #{userId}")
    User getUserByUserId(String userId);

    /**
     * 获取所有用户列表
     *
     * @return 包含所有用户的列表
     */
    @Select("SELECT userId, username, password, role FROM users")
    List<User> getAllUsers();
}
