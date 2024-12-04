package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    private String username;
    @Getter
    private String firstName;
    @Getter
    private String lastName;
    @Getter
    private String password;
    @OneToMany(mappedBy = "attendee")
    @ToString.Exclude
    private List<EventBooking> bookings;
    private String ipAddress;
    public User(String username, String password, String firstName, String lastName,String ipAddress) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.ipAddress=ipAddress;
    }

    public String getFullName(){
        return firstName+" "+lastName;
    }
}
