import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "PersonCode")
    private String PersonCode;
    @Column(name = "BirthDate")
    private LocalDate BirthDate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address",column = @Column(name = "Address")),
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "PhoneNumber")),
            @AttributeOverride(name = "companyName", column = @Column(name = "CompanyName")),
            @AttributeOverride(name = "timeInCompany", column = @Column(name = "TimeInCompany"))
    })

    private PersonDetails personDetails;

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }

    public Person() {
    }

    public Person(String name, String personCode, LocalDate birthDate) {
        this.name = name;
        PersonCode = personCode;
        BirthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonCode() {
        return PersonCode;
    }

    public void setPersonCode(String personCode) {
        PersonCode = personCode;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }
}
