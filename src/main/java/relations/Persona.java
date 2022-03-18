package relations;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "id_Code")
    private String idCode;

    @OneToMany
    @JoinColumn(name = "persona_id")
    private List<Bill> bills;

    public Persona() {
    }

    public Persona(String name, String lastName, String idCode, List<Bill> bills) {
        this.name = name;
        this.lastName = lastName;
        this.idCode = idCode;
        this.bills = bills;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Persona setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Persona setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getIdCode() {
        return idCode;
    }

    public Persona setIdCode(String idCode) {
        this.idCode = idCode;
        return this;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public Persona setBills(List<Bill> bills) {
        this.bills = bills;
        return this;
    }
}
