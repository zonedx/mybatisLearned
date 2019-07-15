package com.zone.mybatis.mapper;

import com.zone.mybatis.entity.User;
import com.zone.mybatis.entity.UserVo;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Author ZONE
 * @Date 2019/7/15 9:44
 * @Version 1.0
 **/
public interface UserMapper {
    //根据id查询用户
    public User findUserById(int id) throws Exception;
    //插入用户，返回值不建议void，因为要得到“结果”
    public int insertUser(User user)throws Exception;
    //删除用户，返回值不建议void
    public int deleteUser(int id)throws Exception;
    //更新用户
    public int updateUser(User user)throws Exception;
    //多表查询，查询用户列表
    public List<UserVo> findUserVo(int id)throws Exception;
}
