package com.action;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

import com.service.*;
import com.entity.*;
import com.service.impl.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Value("${spring.datasource.url}") //这个注解表示到配置文件中找配置的数据
    private String url;

    @Autowired(required = false)
    private IEmpService es;

    @Autowired(required = false)
    private IDeptService ds;

    @Autowired
    private SpringUtils springUtils;

    @RequestMapping(value="/index")
    public String index(){
        System.out.println("------index----------url = "+url);
        List<Dept> list = ds.selectAll();
        System.out.println("lsit:="+list);

        return "index";
    }

    @RequestMapping(value = "/testAction")
    public String testAction(HttpServletRequest request){
        String content = request.getParameter("editorValue");
        System.out.println("editorValue: \n "+content);

        request.setAttribute("content", content);
        return "success";
    }

    /*@RequestMapping(value = "/testDate")
    public String testDate() {
        String tabs = "emp";
        String msg = "";
        try {
            Connection con = springUtils.getConnection();
            String sql = "{call com.showtable(?,?,?)}";

            CallableStatement stmt = con.prepareCall(sql);
            stmt.setString(1, tabs);
            // 注册游标类型
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            // 注册varchar类型
            stmt.registerOutParameter(3, OracleTypes.VARCHAR);
            // 执行
            stmt.execute();
            // 取结果
            msg = stmt.getString(3);
            System.out.println(" msg= " + msg);
            //取游标
            ResultSet rs = (ResultSet) stmt.getObject(2);
            while (rs.next()) {
                System.out.println(" ename = " + rs.getString("ename"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        springUtils.getConnection();

    }*/

}

