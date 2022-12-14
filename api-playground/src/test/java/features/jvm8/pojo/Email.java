package features.jvm8.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {
    String emailAddress;
    boolean isPreferred;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isPreferred() {
        return isPreferred;
    }

    public void setPreferred(boolean preferred) {
        isPreferred = preferred;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailAddress='" + emailAddress + '\'' +
                ", isPreferred=" + isPreferred +
                '}';
    }
}
