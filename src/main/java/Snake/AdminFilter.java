package Snake;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = ((HttpServletRequest) request);
        String userName = userName(httpRequest.getSession());
        if (userName == null || !userName.equals("admin")) {
            ((HttpServletResponse) response).sendError(403);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }

    private String userName(HttpSession session) {
        if (session.getAttribute("username") == null) {
            return null;
        } else {
            return (String) session.getAttribute("username");
        }
    }
}
