package task1;

import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class Contact {
    private String name;
    private String lastname;
    private String nick;

    private Map<String, String> phoneNumbers;
    private String email;

    private String birthday;

    public Contact(String name, String lastname, String nick, Map<String, String> phoneNumbers, String email, String birthday) {
        this.name = name;
        this.lastname = lastname;
        this.nick = nick;
        this.email = email;
        this.birthday = birthday;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Map<String, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<String, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Contact contact = (Contact) object;
        return Objects.equals(name, contact.name) && Objects.equals(lastname, contact.lastname) && Objects.equals(nick, contact.nick) && Objects.equals(birthday, contact.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, nick, birthday);
    }

    public String printPhoneNumbers() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (Map.Entry<String, String> entry : phoneNumbers.entrySet()) {
            joiner.add(String.valueOf(entry.getKey() + " : " + entry.getValue()));
        }
        return joiner.toString();
    }

    @Override
    public String toString() {
        return name + ", " + lastname + ", " + nick + ", " + printPhoneNumbers() +
                ", " + email + ", " + birthday;
    }
}
