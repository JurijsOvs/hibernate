import org.hibernate.Session;

import javax.persistence.EntityTransaction;
import java.util.List;

public class PersonDAO {

    private Session session;

    public PersonDAO(Session session) {
        this.session = session;
    }

    public List<Person> findAllPerson(){
        return session.createQuery("from Person", Person.class)
                .getResultList();
    }

    public long getPersonCount(){
        return session.createQuery("select count (pers) from Person pers",Long.class)
                .getSingleResult();
    }

    public Person findById(long id){
        return session.createQuery("from Person where Person.id = :id", Person.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    public Person addPerson(Person person){
        EntityTransaction transaction = null;
        try{
            transaction = session.getTransaction();
            if(!transaction.isActive()){
                transaction.begin();
            }

            session.persist(person);
            transaction.commit();
            return person;
        }catch (Exception e){
            if(transaction != null){
             transaction.rollback();
            }
            return null;
        }
    }

    public Person findId(long id){
        return session.find(Person.class,id);
    }

    public boolean removePerson(int id){
        EntityTransaction transaction = null;
        try{
            transaction = session.getTransaction();
            if(!transaction.isActive()){
                transaction.begin();
            }
            Person person = session.load(Person.class, id);
            session.remove(person);
            transaction.commit();
            return true;

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            return false;
        }
    }

    public Person updatePerson(Person person){
        EntityTransaction transaction = null;
        try{
            transaction = session.getTransaction();
            if(!transaction.isActive()){
                transaction.begin();
            }

            session.update(person);
            transaction.commit();
            return person;

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            return null;
        }
    }

    public void getPerson(){

    }


}
