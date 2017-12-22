import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by root on 22/12/17.
 */
@WebServlet(urlPatterns = {"/AsyncServlet"}, asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext=req.startAsync();
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {

            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {

            }

            @Override
            public void onError(AsyncEvent event) throws IOException {

            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {

            }
        });
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor=
                new ScheduledThreadPoolExecutor(10);
        scheduledThreadPoolExecutor.execute(new MyRunnable(asyncContext));

        PrintWriter writer=resp.getWriter();
        writer.write("Hello, world");

    }

    class MyRunnable implements Runnable{
        AsyncContext asyncContext;
        MyRunnable(AsyncContext asyncContext){
            this.asyncContext=asyncContext;
        }
        @Override
        public void run(){
            while(true){
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("MyRunnable.run() invoked");
            }
        }
    }
}
