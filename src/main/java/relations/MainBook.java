package relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityTransaction;
import java.util.Arrays;

public class MainBook {

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .buildSessionFactory()){
            Session session = sessionFactory.openSession();


            Book book1 = new Book()
                    .setTitle("Book1")
                    .setYearOfPublishing(1999);


            Book book2 = new Book()
                    .setTitle("Book2")
                    .setYearOfPublishing(1987);


            Book book3 = new Book()
                    .setTitle("Book3")
                    .setYearOfPublishing(2002);


            Author author1 = new Author()
                    .setName("Name")
                    .setLastName("Lastname")
                    .setYearOfBirts(1984)
                    .setBooks(Arrays.asList(book1,book2,book3));

            EntityTransaction transaction = session.getTransaction();
            transaction.begin();

            session.persist(author1);
            session.persist(book1);
            session.persist(book2);
            session.persist(book3);

            transaction.commit();

        }
    }
}
