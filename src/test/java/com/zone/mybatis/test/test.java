package com.zone.mybatis.test;

import com.zone.mybatis.entity.User;
import com.zone.mybatis.entity.UserVo;
import com.zone.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName test
 * @Author ZONE
 * @Date 2019/7/15 11:09
 * @Version 1.0
 **/
public class test {

    private SqlSessionFactory sqlSessionFactory;
    //此方法在执行test方法之前执行
    @Before
    public void setUp() throws Exception{
        //创建sqlSessionFactory
        //mybatis配置文件
        String resource="SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //创建会话工厂
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testFindUserById() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void testInsertUser() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("Jam");
        user.setSex("女");
        user.setBirthday(new Date());
        //int i=userMapper.insertUser(user);//若插入成功i=1，表示受影响的行数，若插入失败，返回exception，所以这里进行如下处理
        int i=0;
        try {
            i=userMapper.insertUser(user);
        }catch (Exception e){
            i=-1;//插入失败返回-1
        }
        sqlSession.commit();//除了查询操作，其他都要commit(),提交
        System.out.println("======="+i);
        System.out.println(user.getId()+"*******"+user.getIss());//获取刚才insert进去的数据返回的主键值
        //这里之所以getId()=0，是因为userMapper.xml中将keyProperty设置="iss"了，所以getIss()=12;
        sqlSession.close();
    }
    @Test
    public void testDeleteUser() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.deleteUser(11);//删除成功返回1，删除失败返回0，而不是抛异常
        sqlSession.commit();
        System.out.println("--------"+i);
        sqlSession.close();
    }
    @Test
    public void testUpdateUser() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setId(10);
        user.setSex("男");
        String time="1999-01-01";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=simpleDateFormat.parse(time);//字符串转日期
        user.setBirthday(date);
        int i=userMapper.updateUser(user);//更新成功返回1，更新失败返回0
        sqlSession.commit();
        System.out.println("---------"+i);
        sqlSession.close();
    }
    @Test
    public void testFindUserVoById() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserVo> list=userMapper.findUserVo(1);
        System.out.println(list.get(0).getFamilyMemberName());
        sqlSession.close();
    }

}
