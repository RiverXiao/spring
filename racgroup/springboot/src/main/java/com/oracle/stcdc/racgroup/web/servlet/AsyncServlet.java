package com.oracle.stcdc.racgroup.web.servlet;


import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/my/asyncservlet", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AsyncContext context = req.startAsync();

        context.start(()->{
            try {
                resp.getWriter().println("Hello Asnyc servlet");
                // 触发完成
                context.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
//        // 触发完成
//        context.complete();

    }
}
