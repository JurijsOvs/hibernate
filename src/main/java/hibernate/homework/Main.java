package hibernate.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()){

            Session session = sessionFactory.openSession();

            EmployeeDAO employeeDAO = new EmployeeDAO(session);

            Employee JohnBrown =  new Employee("John","Brown","Junior"
            ,1500);

            Employee AaronSmith = new Employee("Aaron","Smith","Junior"
            ,1550);

            Employee BobSap = new Employee("Bob", "Sap","Junior"
            ,1400);

            Employee SuzannaAbela = new Employee("Suzanna","Abela","Mid developer"
                    ,2500);
            Employee RobertPiterson = new Employee("Robert", "Piterson","Senior Developer"
            ,4000);




/*            employeeDAO.addEmployee(JohnBrown);
            employeeDAO.addEmployee(AaronSmith);
            employeeDAO.addEmployee(BobSap);
            employeeDAO.addEmployee(SuzannaAbela);
            employeeDAO.addEmployee(RobertPiterson);*/

            Long total = employeeDAO.getTotalEmployees();
            System.out.println(total);

            List<Employee> employeeList = session.createQuery("from hibernate.homework.Employee", Employee.class)
                    .getResultList();

            for (Employee p : employeeList) {

                System.out.println(String.format("hibernate.homework.Employee: %s  %s/ Position: %s/ Salary: %.2f "
                        ,p.getName(),p.getLastname(),p.getPosition(),p.getSalary()));
            }


            Employee foundID = employeeDAO.findById(3);
            System.out.println(foundID.getName() +" "+ foundID.getLastname() +" "
            +foundID.getPosition() + " "+foundID.getSalary());

        //    System.out.println(employeeDAO.removeEmployee(1));



            List<Employee> foundName = employeeDAO.findName("John");

            for(Employee n : employeeList){
                System.out.println(n.getName() +" "+ n.getLastname());
            }


         //   session.close();


        }catch (Throwable e){
            throw new ExceptionInInitializerError(e);
        }

    }
}
