package com.oracle.stcdc.racgroup.web.servlet;
/**
 * 实现servlet,
 * 可以加载到spring boot中
 * 在com.oracle.stcdc.racgroup.web.servlet中添加注释
 * @ServletComponentScan(basePackages = "com.oracle.stcdc.racgroup.web.servlet")
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/my/servlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().println("Hello Junhe Servlet");
    }


}
