import javax.persistence.Embeddable;

@Embeddable
public class PersonDetails {

    private String address;

    private String phoneNumber;

    private String companyName;

    private String timeInCompany;

    public PersonDetails() {
    }

    public PersonDetails(String address, String phoneNumber, String companyName, String timeInCompany) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.timeInCompany = timeInCompany;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTimeInCompany() {
        return timeInCompany;
    }

    public void setTimeInCompany(String timeInCompany) {
        this.timeInCompany = timeInCompany;
    }
}
