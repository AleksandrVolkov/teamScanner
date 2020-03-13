package ru.vsu.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentID;
    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User creator;

    @ManyToOne
    @JoinColumn(name = "eventID", nullable = false)
    private Event event;

    private Date timeCreated;
    private String commentText;

    public Comment(User creator, Event event, Date timeCreated, String commentText) {
        this.creator = creator;
        this.event = event;
        this.timeCreated = timeCreated;
        this.commentText = commentText;
    }

    public Comment() {
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
