package filters;

import dto.User;
import exceptions.LoginFailureException;
import exceptions.NoParametersException;
import org.eclipse.jetty.http.HttpMethod;
import services.ServiceUser;
import utils.FreeMarker;
import utils.ParameterFromRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class FilterLogin implements Filter {
    private ServiceUser serviceUser;
    private final FreeMarker freeMarker = new FreeMarker();

    public FilterLogin(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req;
        if (request instanceof HttpServletRequest) {
            req = (HttpServletRequest) request;
        } else {
            throw new IllegalArgumentException("ServletRequest should be instance of HttpServletRequest");
        }
        HashMap<String, Object> data = new HashMap<>();


        if (HttpMethod.POST.name().equalsIgnoreCase(req.getMethod())) {
            try {
                ParameterFromRequest pfr = new ParameterFromRequest(req);

                String email = pfr.getStr("email");
                String password = pfr.getStr("password");
                User user = new User(email, password);

                if (!serviceUser.userCheck(user) || !serviceUser.checkPassword(user)) {

                    throw new LoginFailureException("Incorrect login or password");
                }

                chain.doFilter(request, response);
            } catch (NoParametersException | LoginFailureException e) {
                data.put("message", e.getMessage());
                data.put("rout", "/login");

                freeMarker.render("login-error.ftl", data, (HttpServletResponse) response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
