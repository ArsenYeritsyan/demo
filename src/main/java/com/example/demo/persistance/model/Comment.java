package com.example.demo.persistance.model;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @CreatedDate
    private LocalDateTime createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(columnDefinition="Date")
    private Date date;

    @ManyToOne
    @JoinColumn
    private User user;

    @Lob
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Movie movie;


    public Comment(User user, String body,Movie movie) {
        this.user = user;
        this.body = body;
        this.movie=movie;
    }

    public Comment() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) &&
                Objects.equals(createdDate, comment.createdDate) &&
                Objects.equals(date, comment.date) &&
                Objects.equals(user, comment.user) &&
                Objects.equals(body, comment.body) &&
                Objects.equals(movie, comment.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, date, user, body, movie);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", date=" + date +
                ", user=" + user +
                ", body='" + body + '\'' +
                ", movie=" + movie +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
