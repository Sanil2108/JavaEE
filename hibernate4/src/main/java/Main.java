import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Map;

/**
 * Created by root on 14/1/18.
 */
public class Main {
    SessionFactory sessionFactory;

    Main(){
        Configuration configuration=new Configuration().configure()
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Movie.Genre.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory=configuration.buildSessionFactory(serviceRegistry);
    }

    public void persist(Movie movie){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(movie);
        session.getTransaction().commit();
        session.close();
    }

    public Movie findMovie(int movieId){
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Movie movie=(Movie)session.get(Movie.class, movieId);

        System.out.println("Movie fetched. \n"+movie);
        session.getTransaction().commit();
        session.close();
        return movie;
    }

    public static void main(final String[] args) throws Exception {
        Main main=new Main();

        Movie movie=new Movie();
        movie.setId(0);
        movie.setTitle("Shawshank Redemption");
        movie.setDirector("Frank Darabont");
        movie.setSynopsis("Andy Dufresne, a successful banker,");
        movie.addGenre(new Movie.Genre("Suspense"));
        movie.addGenre(new Movie.Genre("Thriller"));
        main.persist(movie);

        Movie movie1=main.findMovie(1);

    }
}
