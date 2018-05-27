package com.zccoder.mybatis1.ch2.hello;

import org.apache.ibatis.session.SqlSession;

/**
 * <br>
 * 标题：SqlSession 演示<br>
 * 描述：标准 SqlSession 使用方法<br>
 *
 * @author zc
 * @date 2018/03/14
 **/
public class SqlSessionDemo {

    public void demo(){

        // 定义 SqlSession
        SqlSession sqlSession = null;
        try {
            // 打开 SqlSession 会话
            sqlSession = MyBatisUtil.getSqlSessionFactoryByXml().openSession();
            // some code ...
            sqlSession.commit();
        }catch (Exception e){
            System.err.println(e.getMessage());
            sqlSession.rollback();
        }finally {
            // 在 finally 语句中确保资源被顺利关闭
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
