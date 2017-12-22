import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by root on 21/12/17.
 */
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter writer=response.getWriter();
        writer.write("Filter1 is invoked\n");
        chain.doFilter(request, response);
        writer.write("\nFilter1 is invoked");
    }

    @Override
    public void destroy() {

    }
}
