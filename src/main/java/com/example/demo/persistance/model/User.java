package com.example.demo.persistance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "Users")
@Table()
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Email
    @NotNull
    private String email;

    @Column(nullable = false)
    @Length(min = 8, message = "at least 8 characters")
    @JsonIgnore
    private String password;

    @Column(nullable = false, unique = true)
    @NotNull
    private String username;

    @Column
    @NotNull
    private String name;

    @OneToMany(fetch = LAZY)
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    private Set<Movie> movies;

    public User(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @OneToMany(mappedBy = "user")
    private Collection<Comment> comment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(username, user.username) &&
                Objects.equals(name, user.name) &&
                Objects.equals(comments, user.comments) &&
                Objects.equals(movies, user.movies) &&
                Objects.equals(comment, user.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, username, name, comments, movies, comment);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", comments=" + comments +
                ", movies=" + movies +
                ", comment=" + comment +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Collection<Comment> getComment() {
        return comment;
    }

    public void setComment(Collection<Comment> comment) {
        this.comment = comment;
    }

}
