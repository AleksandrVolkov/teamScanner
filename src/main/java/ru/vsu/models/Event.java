package ru.vsu.models;

import ru.vsu.models.enums.Category;
import ru.vsu.models.enums.Status;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventID;
    private String name;
    private Status status;
    private String description;
    private Category category;
    private String address;
    private Date dateTime;
    private User creator;

    @ManyToMany(mappedBy = "events")
    private List<User> participants;
    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private List<Comment> comments;

    public Event(String name, Status status, String description, Category category, String address, Date dateTime, User creator, List<User> participants, List<Comment> comments) {
        this.name = name;
        this.status = status;
        this.description = description;
        this.category = category;
        this.address = address;
        this.dateTime = dateTime;
        this.creator = creator;
        this.participants = participants;
        this.comments = comments;
    }

    public Event() {
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
