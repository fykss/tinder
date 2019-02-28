package servlets;

import dto.User;
import services.ServiceCookie;
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

public class ServletUsers extends HttpServlet {
    private final FreeMarker freeMarker = new FreeMarker();
    private Connection connection;

    public ServletUsers(Connection connection) {
        this.connection = connection;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HashMap<String, Object> data = new HashMap<>();

        ServiceCookie serviceCookie = new ServiceCookie(req, resp);
        int idUser = Integer.parseInt(serviceCookie.getCookie().getValue());

        freeMarker.render("users.ftl", data, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        System.out.println(req.getParameterMap());



        resp.sendRedirect("/users");
    }
}
