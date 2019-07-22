package com.service.impl;

import java.util.*;
import com.entity.*;
import com.dao.*;
import com.service.*;

import com.service.IDeptService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional // 事务
@MapperScan(basePackages="com.dao") // 扫包
@Service(value="deptService") // 括号中可不写
public class DeptService implements IDeptService {

    @Autowired(required = false)
    private IDeptDao dao;

    @Override
    public List<Dept> selectAll() {

        return dao.selectAll();
    }

    @Override
    public Dept selectByPrimaryKey(Integer deptno) {

        return dao.selectByPrimaryKey(deptno);
    }
}
