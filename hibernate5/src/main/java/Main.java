import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 17/1/18.
 */
public class Main {
    public static void main(String [] args){
        Configuration configuration=new Configuration().configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(User.PhoneNumber.class);
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();

        User user=new User("sanil3", new User.PhoneNumber("91", "1234567890"));
        session.save(user);

        ArrayList<String> names=new ArrayList<String>();
        names.add("sanil");
        names.add("sanil3");

        Query query=session.createQuery("FROM User WHERE name IN (:uname)");
        query.setParameterList("uname", names);
        List<User> allUsers=query.list();
        for(User u:allUsers){
            System.out.println(u);
        }

        tx.commit();
        session.close();
    }
}
