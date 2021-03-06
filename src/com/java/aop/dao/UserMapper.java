package com.java.aop.dao;

import com.java.aop.bean.UserBean;
import com.java.aop.bean.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Sat Jul 21 23:43:54 CST 2018
     */
    int countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Sat Jul 21 23:43:54 CST 2018
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Sat Jul 21 23:43:54 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Sat Jul 21 23:43:54 CST 2018
     */
    int insert(UserBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Sat Jul 21 23:43:54 CST 2018
     */
    int insertSelective(UserBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Sat Jul 21 23:43:54 CST 2018
     */
    List<UserBean> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Sat Jul 21 23:43:54 CST 2018
     */
    UserBean selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Sat Jul 21 23:43:54 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserBean record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Sat Jul 21 23:43:54 CST 2018
     */
    int updateByExample(@Param("record") UserBean record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Sat Jul 21 23:43:54 CST 2018
     */
    int updateByPrimaryKeySelective(UserBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Sat Jul 21 23:43:54 CST 2018
     */
    int updateByPrimaryKey(UserBean record);
}