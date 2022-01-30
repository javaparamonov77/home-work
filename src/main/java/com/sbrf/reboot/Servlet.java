package com.sbrf.reboot;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SomeApp/ask")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int counter = 0;
        String username;

        HttpSession session = req.getSession();
        if(!session.isNew()) {
            counter = (Integer) session.getAttribute("counter");
        }
        counter++;
        session.setAttribute("counter", counter);
        username = req.getParameter("name");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        if (username == null) {
            printWriter.write("Привет, Anonymous" + "<br>");
        } else {
            printWriter.write("Привет, " + username + "<br>");
        }
        printWriter.write("counter = " + counter);
        printWriter.close();
    }
}