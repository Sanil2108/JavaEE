import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by root on 11/1/18.
 */
public class App {
    public static void main(String[] args){
        Alien mai=new Alien();
        mai.setAlienId(0);
        mai.setaName("Sanil");
        mai.setColour("green");

        Configuration configuration=new Configuration();
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();


    }
}
