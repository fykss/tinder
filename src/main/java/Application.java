import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.ServletAssets;
import servlets.ServletLikePage;
import servlets.ServletLogin;
import utils.DbConnection;

import java.sql.Connection;

public class Application {
    public static void main(String[] args) throws Exception {
        Connection connection = new DbConnection().connection();

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(ServletAssets.class, "/src/main/resources/templates/css/*");
        handler.addServlet(new ServletHolder(new ServletLogin()), "/login");
        handler.addServlet(new ServletHolder(new ServletLikePage()), "/users");

        Server server = new Server(85);

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
