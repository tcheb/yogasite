package com.croissantyoga.app.db;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    @NotNull(message="{NotNull.User.username}")
    private String username;

    @Column(name = "firstname")
    @NotNull(message="{NotNull.User.firstName}")
    private String firstName;

    @Column(name = "lastname")
    @NotNull(message="{NotNull.User.lastName}")
    private String lastName;

    @Email
    @Column(name = "email")
    @NotNull(message="{NotNull.User.email}")
    private String email;

    @Column(name = "password")
    @NotNull(message="{NotNull.User.password}")
    private String password;

    @ManyToOne()
    @JoinColumn(name = "group_id")
    private Group group;

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(group, user.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, group);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", group=" + group +
                '}';
    }
}