package filters;

import services.ServiceUser;
import utils.FreeMarker;

import javax.servlet.*;
import java.io.IOException;

public class FilterLogin implements Filter {
    private ServiceUser serviceUser;
    private final FreeMarker freeMarker = new FreeMarker();

    public FilterLogin(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
