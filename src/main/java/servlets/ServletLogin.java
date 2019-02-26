package servlets;

import dao.DAOUserSQL;
import dto.User;
import utils.DbConnection;
import utils.FreeMarker;

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

    private final FreeMarker freeMarker = new FreeMarker();

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

        Connection connection = new DbConnection().connection();
        DAOUserSQL daoUserSQL = new DAOUserSQL(connection);
        User user = new User(email, password);
        HashMap<String, Object> data = new HashMap<>();

        if (daoUserSQL.check(user)) {
            Cookie cookie = new Cookie("users", Integer.toString(daoUserSQL.getId(user)));
            resp.addCookie(cookie);
            resp.sendRedirect("/users");
        } else {
            System.out.println("Enter correct data");
            freeMarker.render("login-error.ftl", data, resp);
        }
    }
}
