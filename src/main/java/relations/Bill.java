package relations;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   @Column(name = "name")
  private String billNumber;
    @Column(name = "address")
  private String address;
    @Column(name = "amount")
  private BigDecimal amount;
  @Column(name = "date")
  private LocalDate date;

  @ManyToOne
  private Persona persona;

    public Bill() {
    }

    public Bill(String billNumber, String address, BigDecimal amount, LocalDate date, Persona persona) {
        this.billNumber = billNumber;
        this.address = address;
        this.amount = amount;
        this.date = date;
        this.persona = persona;
    }

    public long getId() {
        return id;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public Bill setBillNumber(String billNumber) {
        this.billNumber = billNumber;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Bill setAddress(String address) {
        this.address = address;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Bill setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Bill setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Persona getPersona() {
        return persona;
    }

    public Bill setPersona(Persona persona) {
        this.persona = persona;
        return this;
    }
}
