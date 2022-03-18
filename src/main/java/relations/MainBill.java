package relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MainBill {

    public static void main(String[] args) {


        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()){

                Session session = sessionFactory.openSession();



                Persona person = new Persona().setName("Janis").setLastName("Berzins").setIdCode("11111");

            Bill bill = new Bill().setAmount(BigDecimal.valueOf(25.00)).setAddress("Kautkada iela").setBillNumber("1").setDate(LocalDate.now()).setPersona(person);

                session.save(person);
                session.save(bill);




            }

        }
    }

