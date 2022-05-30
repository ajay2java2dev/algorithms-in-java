package features.jvm8.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    private String name;
    private Long phoneNumber;
    private List<Address> contactAddresses;
    private List<Email> emailAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Address> getContactAddresses() {
        return contactAddresses;
    }

    public void setContactAddresses(List<Address> contactAddresses) {
        this.contactAddresses = contactAddresses;
    }

    public List<Email> getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(List<Email> emailAddress) {
        this.emailAddress = emailAddress;
    }

    public User(String name, Long phoneNumber, List<Address> contactAddresses, List<Email> emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.contactAddresses = contactAddresses;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", contactAddresses=" + contactAddresses +
                ", emailAddress=" + emailAddress +
                '}';
    }
}
