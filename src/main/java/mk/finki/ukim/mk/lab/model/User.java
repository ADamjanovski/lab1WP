package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User  {
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
    @Enumerated(value = EnumType.STRING)
    private Role role;


    public User(String username, String password, String firstName, String lastName,String ipAddress,Role role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.ipAddress=ipAddress;
        this.role = role;


    }

    public String getFullName(){
        return firstName+" "+lastName;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }


    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
