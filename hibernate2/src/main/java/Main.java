import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by root on 11/1/18.
 */
public class Main {
    public static void main(String[] args){
        Alien mai=new Alien();
        mai.setAlienId(1);
        Alien.AlienName name=new Alien.AlienName();
        name.setfName("Fname");
        name.setmName("Mname");
        name.setlName("Lname");
        mai.setaName(name);
        mai.setColour("green");

        Configuration configuration=new Configuration().configure().addAnnotatedClass(Alien.class);

        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();

        Transaction tx=session.beginTransaction();

        session.save(mai);

        tx.commit();

//        Alien koiAur;
//        Configuration configuration=new Configuration().configure().addAnnotatedClass(Alien.class);
//
//        SessionFactory sessionFactory=configuration.buildSessionFactory();
//        Session session=sessionFactory.openSession();
//
//        Transaction tx=session.beginTransaction();
//
//        koiAur=(Alien)session.get(Alien.class, 1);
//        System.out.println(koiAur);
    }
}
