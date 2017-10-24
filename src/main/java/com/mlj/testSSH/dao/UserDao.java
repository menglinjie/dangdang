package com.mlj.testSSH.dao;

import com.mlj.testSSH.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
     * 根据用户名密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    public User select(@Param("username") String username, @Param("password") String password);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public int insert(User user);

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<User> selectAll();

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    public int delete(int id);
}
