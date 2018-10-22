package cn.jiayuli.mybatis;

import cn.jiayuli.mybatis.dao.RechargeMapper;
import cn.jiayuli.mybatis.entity.Recharge;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {
    @org.junit.Test
    public void mybaris() {
        //mybatis的配置文件
        String resource = "mybatis-config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        //通过 SqlSession 实例来直接执行已映射的 SQL 语句
        /*String statement = "cn.jiayuli.mybatis.dao.RechargeMapper.selectByPrimaryKey";
        try {
            Recharge recharge = session.selectOne(statement, 1);
            System.out.println(recharge);
        }
        finally {
            session.close();
        }*/
        //使用对于给定语句能够合理描述参数和返回值的接口
        try {
            RechargeMapper mapper = session.getMapper(RechargeMapper.class);
            Recharge recharge = mapper.selectByPrimaryKey(1);
            System.out.println(recharge);
        } finally {
            session.close();
        }
    }

    @org.junit.Test
    public void error() {
        int divider = 10;
        int result = 100;
        try{
            while (divider > -1) {
                divider = divider - 1;
                result = result + 100 / divider;
            }
            System.out.println("完美执行!!");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常抛出了!!");
            System.out.println(result);
        }
    }
}
