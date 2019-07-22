package com.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 拿 Connection 单独使用可以用这个(可以不走框架)
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       this.applicationContext = applicationContext;
    }

    private DataSource getDataSource(){
        if(applicationContext != null){
            Object obj = applicationContext.getBean(DataSource.class); // 调类型，不调名字，因为springboot已经封装了
            if(obj != null){
                return (DataSource)obj;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public Connection getConnection(){
        Connection con = null;
        try {
            DataSource ds = getDataSource();
            if(ds != null){
                con = ds.getConnection();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
