package com.service.impl;

import java.util.*;
import com.entity.*;
import com.dao.*;
import com.service.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional // 事务
@MapperScan(basePackages="com.dao") // 扫包
@Service(value="empService") // 括号中可不写
public class EmpService implements  IEmpService{

    @Autowired(required = false)
    private IEmpDao dao;
}
