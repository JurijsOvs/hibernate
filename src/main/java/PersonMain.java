import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class PersonMain {

    public static void main(String[] args) {

        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()){
            Session session = sessionFactory.openSession();

            PersonDAO personDAO = new PersonDAO(session);

            PersonDetails personDetails = new PersonDetails();

            personDetails.setAddress("Rezekne");
            personDetails.setCompanyName("Amazon");
            personDetails.setPhoneNumber("1233456");
            personDetails.setTimeInCompany("5");

            Person person = new Person();

                    person.setName("Base Man");
                    person.setPersonCode("999999-99999");
                    person.setBirthDate(LocalDate.now());
                    person.setPersonDetails(personDetails);

       //     personDAO.removePerson(5);
         personDAO.addPerson(person);



/*            List<Person> result = session.createQuery("from Person", Person.class)
                    .getResultList();*/


          //  for(Person table : result){
/*                System.out.print( "Person found: " + table.getName() + "| " + "p.code: "
                        + table.getPersonCode()
                        + "| " + "BirthDate: "
                        + table.getBirthDate() + "|");*/

  /*              System.out.println(String.format("Person name: %s| pers.code: %s| pers.birthdate: %s",
                        table.getName(),
                        table.getPersonCode(),
                        table.getBirthDate()));*/

           //     PersonDetails personDetails = table.getPersonDetails();
/*                System.out.println("Company name: " + personDetails.getCompanyName() + "| "
                        + "personal Address: " + personDetails.getAddress() + "| "
                        + "personal phone number: " + table.getPersonDetails().getPhoneNumber());*/

         /*       System.out.println(String.format("Company: %s| address: %s| phone number: %s",
                        personDetails.getCompanyName(),
                        personDetails.getAddress(),
                        personDetails.getPhoneNumber()));*/
         //   }

        }catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }
}
