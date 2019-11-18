import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 喻浩
 * @create 2019-11-18-20:40
 */
@WebFilter(filterName = "RequestFilter", urlPatterns = "/RequestFilter")
public class RequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) srequest;
        HttpServletResponse response = (HttpServletResponse) sresponse;
        HttpSession session = request.getSession();
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
