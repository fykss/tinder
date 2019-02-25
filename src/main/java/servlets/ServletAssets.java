package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ServletAssets extends HttpServlet {
    private final String ASSETS_ROOT = "src/main/resources/templates/css";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Files.copy(Paths.get(ASSETS_ROOT, req.getPathInfo()), resp.getOutputStream());
    }
}
