package com.example.taxserviceservlet.entity;

import java.sql.Date;
import java.time.LocalDateTime;

public class User {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Integer age;

    private String ipn;

    private Personality personality;

    private String address;

    private Date dateOfRegistration;

    private Long userId;

    private UserRole userRole;

    public static class Builder {

        private User user;

        public Builder() {
            user = new User();
        }

        public User.Builder firstName(String firstName) {
            this.user.firstName = firstName;
            return this;
        }

        public User.Builder lastName(String lastName) {
            this.user.lastName = lastName;
            return this;
        }

        public User.Builder email(String email) {
            this.user.email = email;
            return this;
        }

        public User.Builder password(String password) {
            this.user.password = password;
            return this;
        }

        public User.Builder age(Integer age) {
            this.user.age = age;
            return this;
        }

        public User.Builder ipn(String ipn) {
            this.user.ipn = ipn;
            return this;
        }

        public User.Builder personality(Personality personality) {
            this.user.personality = personality;
            return this;
        }

        public User.Builder address(String address) {
            this.user.address = address;
            return this;
        }

        public User.Builder dateOfRegistration(Date dateOfRegistration) {
            this.user.dateOfRegistration = dateOfRegistration;
            return this;
        }

        public User.Builder userRole(UserRole userRole) {
            this.user.userRole = userRole;
            return this;
        }

        public User build() {
            return this.user;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIpn() {
        return ipn;
    }

    public void setIpn(String ipn) {
        this.ipn = ipn;
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", ipn='" + ipn + '\'' +
                ", personality=" + personality +
                ", address='" + address + '\'' +
                ", dateOfRegistration=" + dateOfRegistration +
                ", userId=" + userId +
                ", userRole=" + userRole +
                '}';
    }
}

