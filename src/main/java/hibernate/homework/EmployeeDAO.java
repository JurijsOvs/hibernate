package hibernate.homework;

import org.hibernate.Session;

import javax.persistence.EntityTransaction;
import java.util.List;

public class EmployeeDAO {

    private Session session;

    public EmployeeDAO(Session session) {
        this.session = session;
    }

    public List<Employee> findAllEmployees(){
        return session.createQuery("from employee", Employee.class)
                .getResultList();
    }

    public Long getTotalEmployees (){
        return session.createQuery("select count (em) from hibernate.homework.Employee em", Long.class)
                .getSingleResult();
    }

    public Employee findById (long id){
        return session.find(Employee.class,id);


               /* session.createQuery("from hibernate.homework.Employee where hibernate.homework.Employee.id=:id", hibernate.homework.Employee.class)
                .setParameter("id",id)
                .getSingleResult();*/
    }

    public Employee addEmployee (Employee employee){

        EntityTransaction transaction = null;
        try{
            transaction = session.getTransaction();
            if(!transaction.isActive()){
                transaction.begin();
            }

            session.persist(employee);
            transaction.commit();
            return employee;

        }catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            return null;
        }
    }

    public List<Employee> findName(String name){
        return session.createQuery("select e from hibernate.homework.Employee e where e.name = :name", Employee.class)
                .setParameter("name", name)
                .getResultList();

                //session.find(hibernate.homework.Employee.class, name);
    }

    public boolean removeEmployee(long id){
        EntityTransaction transaction = null;
        try{
            transaction = session.getTransaction();
            if(!transaction.isActive()){
                transaction.begin();
            }
            Employee employee = session.load(Employee.class, id);
            session.remove(employee);
            transaction.commit();
            return true;

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            return false;
        }
    }
}
