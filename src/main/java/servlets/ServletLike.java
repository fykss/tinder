package servlets;

import services.ServiceUser;
import utils.FreeMarker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServletLike extends HttpServlet {
    private final FreeMarker freeMarker = new FreeMarker();
    private Connection connection;

    public ServletLike(Connection connection) {
        this.connection = connection;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> data = new HashMap<>();

        freeMarker.render("like-page.ftl", data, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String like = req.getParameter("like");
        String dislike = req.getParameter("dislike");
        System.out.println(req.getParameterMap());

        resp.sendRedirect("/users");
    }
}
