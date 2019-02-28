package servlets;

import dao.DAOUserSQL;
import dto.User;
import services.ServiceCookie;
import services.ServiceUser;
import utils.DbConnection;
import utils.FreeMarker;
import utils.ParameterFromRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServletLogin extends HttpServlet {
    private ServiceUser serviceUser;
    private final FreeMarker freeMarker = new FreeMarker();
    private Connection connection;

    public ServletLogin(Connection connection) {
        this.connection = connection;
        this.serviceUser = new ServiceUser(new DAOUserSQL(connection));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> data = new HashMap<>();
        List<String> fields = new ArrayList<>();

        fields.add("login");
        fields.add("password");

        data.put("fields", fields);
        data.put("rout", "/login");

        freeMarker.render("login.ftl", data, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        int id = serviceUser.getId(email, password);

        if (id > 0) {
            Cookie cookie = new Cookie("user", Integer.toString(id));
            resp.addCookie(cookie);
            resp.sendRedirect("/like");
        } else {
            resp.sendRedirect("/login");

        }
    }
}
