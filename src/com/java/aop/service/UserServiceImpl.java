package com.java.aop.service;

import com.java.aop.bean.UserBean;
import com.java.aop.bean.UserExample;
import com.java.aop.dao.UserMapper;
import com.java.aop.util.JDBCFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: YSFY
 * @Date: 2018/7/21 23:11
 * @Pacage_name: com.java.aop.jdk
 * @Project_Name: javaTest
 * @Description:    用户接口实现类
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser() {
        Connection connection = JDBCFactory.getConnection();

        Integer result = 0;
        String sql = "insert into user (id,user_name,password,sex,age,address) values(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setInt(1,5);
            preparedStatement.setString(2,"悦诗风吟");
            preparedStatement.setString(3,"123456");
            preparedStatement.setString(4, "男");
            preparedStatement.setInt(5, 27);
            preparedStatement.setString(6,"浙江省杭州市滨江区滨安路优迈科技A幢");

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result>0?true:false;
    }

}
