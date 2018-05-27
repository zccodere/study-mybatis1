package com.zccoder.mybatis1.ch6.core;

import com.zccoder.mybatis1.ch6.core.proxy.HelloService;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.binding.MapperProxy;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.executor.BatchExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.InputStreamReader;

/**
 * 标题：构建SqlSessionFactory过程<br>
 * 描述：解析构建SqlSessionFactory过程<br>
 *
 * @author zc
 * @date 2018/04/28
 **/
public class Demo {

    /**
     * 解析构建SqlSessionFactory过程
     */
    public void showBuild(){
        // 通过 XMLConfigBuilder 解析 XML 文件，读出配置参数
        XMLConfigBuilder configBuilder = new XMLConfigBuilder(new InputStreamReader(this.getClass().getResourceAsStream("mybatis-config.xml")));
        // 通过 XMLConfigBuilder 对象的 parse 方法构建 Configuration，mybatis几乎所有的配置都存在该类中
        Configuration configuration = configBuilder.parse();
        // 通过 Configuration 对象创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory1 = new DefaultSqlSessionFactory(configuration);

        // 通过 Builder 模式创建 SqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory2 = sqlSessionFactoryBuilder.build(configuration);
    }

    /**
     * 映射器的内部组成
     */
    public void showMapper(){
        // 保存映射器的节点
        MappedStatement mappedStatement = null;
        // 提供 BoundSql 对象的地方，主要作用：根据参数和其它的规则组装SQL（包括第五章的动态SQL）
        SqlSource sqlSource = null;
        // 建立 SQL 和参数的地方（三个常用的属性：SQL、parameterObject、parameterMappings）
        BoundSql boundSql = null;

        // 参数本身
        boundSql.getParameterObject();
        // 参数映射信息
        boundSql.getParameterMappings();
        // 映射器里面编写的SQL
        boundSql.getSql();
    }

    /**
     * 解析SqlSession运行过程
     */
    public void showRun(){
        SqlSession sqlSession = null;
        // Mapper 映射是通过动态代理实现的
        MapperProxyFactory<HelloService> mapperProxyFactory = null;
        // 通过 newInstance 生成代理对象 MapperProxy
        HelloService helloService = mapperProxyFactory.newInstance(sqlSession);
        // 当调用 helloService.sayHello 方法时，会进入到 mapperProxy.invoke 方法
        MapperProxy mapperProxy = null;
        // 因为代理的是接口，会进入到 mapperMethod.execute 方法
        MapperMethod mapperMethod = null;
        // 从 mapperMethod 的属性 methodSignature 获得方法返回值类型去执行对应的方法
        MapperMethod.MethodSignature methodSignature = null;
        // 如果返回值类型是Many时，则执行 executeForMany 方方法
        methodSignature.returnsMany();
        // 最终调用 sqlSession 的 selectList 方法，并返回结果
    }

    /**
     * SqlSession下的四大对象
     */
    public void showHandler(){
        SqlSession sqlSession = null;

        // Mapper 执行的过程是通过 Executor、StatementHandler、ParameterHandler 和 ResultHandler 来完成数据库操作和结果返回的

        // Executor：执行器，由它来调度StatementHandler、ParameterHandler、ResultHandler 等来执行对应的SQL
        // StatementHandler：核心，承上启下的作用，使用数据库的Statement（PreparedStatement）执行操作
        // ParameterHandler：用于 SQL 对参数的处理
        // ResultHandler：进行最后数据集（ResultSet）的封装返回处理的

    }

}
