import dao.DAOUserSQL;
import filters.FilterLogin;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import services.ServiceUser;
import servlets.ServletAssets;
import servlets.ServletLikePage;
import servlets.ServletLogin;
import servlets.ServletPeopleList;
import utils.DbConnection;

import javax.servlet.DispatcherType;
import java.sql.Connection;
import java.util.EnumSet;

public class Application {
    public static void main(String[] args) throws Exception {
        Connection connection = new DbConnection().connection();
        DAOUserSQL daoUserSQL = new DAOUserSQL(connection);
        ServiceUser serviceUser = new ServiceUser(daoUserSQL);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(ServletAssets.class, "/src/main/resources/templates/css/*");
        handler.addServlet(new ServletHolder(new ServletLogin()), "/login");
        handler.addServlet(new ServletHolder(new ServletLikePage()), "/like");
        handler.addServlet(new ServletHolder(new ServletPeopleList()), "/users");

        handler.addFilter(new FilterHolder(new FilterLogin(serviceUser)), "/login/*", EnumSet.of(DispatcherType.INCLUDE,DispatcherType.REQUEST));

        Server server = new Server(85);

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
