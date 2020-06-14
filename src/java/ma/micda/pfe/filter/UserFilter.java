package ma.micda.pfe.filter;


import java.io.IOException;
import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ma.micda.pfe.bean.User;

/**
 *
 * @author
 */
@WebFilter("/faces/*")
public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        boolean resourceRequest = req.getRequestURI().startsWith(req.getContextPath() + "/faces" + ResourceHandler.RESOURCE_IDENTIFIER);
        boolean imageResources = req.getRequestURI().endsWith("png") || req.getRequestURI().endsWith("jpg");
        User user = (User) session.getAttribute("connectedUser");
        try {
            if ((user != null && user.getEmail()!= null) || req.getRequestURI().endsWith("index.xhtml") || req.getRequestURI().endsWith("/") || resourceRequest || imageResources) {
                chain.doFilter(request, response);
            } else {
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect(req.getContextPath()+"/faces/index.xhtml");
                return;
            }
        } catch (IOException | ServletException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {
    }
}