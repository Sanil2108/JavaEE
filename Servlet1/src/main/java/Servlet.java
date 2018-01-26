import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/Servlet"}, name = "Servlet", initParams = {
        @WebInitParam(name = "name", value = "sanil")
})
public class Servlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        if(name!=null){
            req.getSession().setAttribute("name", name);
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(req.getRemoteAddr());
        printWriter.write("request parameter name - "+name);
        printWriter.write("\nsession parameter name - "+req.getSession().getAttribute("name"));
        printWriter.write("\ncontext parameter name - "+getInitParameter("name"));

        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }

//        req.getRequestDispatcher("Servlet2").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}