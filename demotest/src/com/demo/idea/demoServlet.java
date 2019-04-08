package com.demo.idea;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @program: demo
 * @description: test
 * @author: wang gang
 * @create: 2019-03-26 11:34
 */
@WebServlet("/demo")
public class demoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("WEB-INF/hello.jsp").forward(req, resp);
    }

    private void dd()
    {
        //ArrayList
    }

}