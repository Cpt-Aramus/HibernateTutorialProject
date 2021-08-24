import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class App {

    public static void main(String[] args) {
        Alien telusko = new Alien();
        AlienName an = new AlienName();
        an.setFirstName("NavinKumarReddy");
        an.setLastName("Thatipalli");
       telusko.setAid(101);
       telusko.setColor("Green");
       telusko.setAname(an);

        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx =  session.beginTransaction();

        session.save(telusko);

        //Transforming data row into an Object
        telusko = session.get(Alien.class, 101);

        tx.commit();




    }

}
