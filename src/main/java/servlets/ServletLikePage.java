package servlets;

import utils.FreeMarker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServletLikePage extends HttpServlet {
    private final FreeMarker freeMarker = new FreeMarker();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HashMap<String, Object> data = new HashMap<>();
        List<String> fields = new ArrayList<>();

        fields.add("like");
        fields.add("dislike");

        data.put("like", fields);
        data.put("rout", "/like");

        freeMarker.render("like-page.ftl", data, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String like = req.getParameter("like");
        String dislike = req.getParameter("dislike");

        resp.sendRedirect("/like");
    }
}
