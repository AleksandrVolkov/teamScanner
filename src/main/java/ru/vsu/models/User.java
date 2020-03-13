package ru.vsu.models;

import ru.vsu.models.enums.Role;
import ru.vsu.models.enums.Status;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    private String login;
    private String password;
    private Role userRole;
    private Status status;
    private boolean isCreator;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "EventsComments",
            joinColumns = @JoinColumn(name = "userID"),
            inverseJoinColumns = @JoinColumn(name = "eventID")
    )
    private List<Event> events;

    @OneToMany(mappedBy = "creator", fetch = FetchType.EAGER)
    private List<Comment> comments;

    private String city;
    private int age;

    public User(String login, String password, Role userRole, Status status, boolean isCreator, List<Event> events, List<Comment> comments, String city, int age) {
        this.login = login;
        this.password = password;
        this.userRole = userRole;
        this.status = status;
        this.isCreator = isCreator;
        this.events = events;
        this.comments = comments;
        this.city = city;
        this.age = age;
    }

    public User() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isCreator() {
        return isCreator;
    }

    public void setCreator(boolean creator) {
        isCreator = creator;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
