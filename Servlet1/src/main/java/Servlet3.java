import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/Servlet3"})
public class Servlet3 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer=resp.getWriter();
        writer.write("Servlet3 invoked");
    }

    public class MyContextListener implements ServletContextListener{
        @Override
        public void contextInitialized(ServletContextEvent sce) {
            ServletContext context=sce.getServletContext();
            context.setInitParameter("abcd", "abcd");
        }

        @Override
        public void contextDestroyed(ServletContextEvent sce) {

        }
    }
}
