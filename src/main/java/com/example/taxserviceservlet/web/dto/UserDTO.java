package com.example.taxserviceservlet.web.dto;

import java.time.LocalDateTime;

public class UserDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String age;

    private String ipn;

    private String personality;

    private String address;

    private LocalDateTime dateOfRegistration;

    private Long userId;

    public static class Builder {

        private UserDTO userDTO;

        public Builder() {
            userDTO = new UserDTO();
        }

        public Builder setFirstName(String firstName) {
            this.userDTO.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.userDTO.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.userDTO.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.userDTO.password = password;
            return this;
        }

        public Builder setAge(String age) {
            this.userDTO.age = age;
            return this;
        }

        public Builder setIPN(String ipn) {
            this.userDTO.ipn = ipn;
            return this;
        }

        public Builder setPersonality(String personality) {
            this.userDTO.personality = personality;
            return this;
        }

        public Builder setAddress(String address) {
            this.userDTO.address = address;
            return this;
        }

        public UserDTO build() {
            return this.userDTO;
        }
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIpn() {
        return ipn;
    }

    public void setIpn(String ipn) {
        this.ipn = ipn;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDateTime dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", ipn='" + ipn + '\'' +
                ", personality='" + personality + '\'' +
                ", address='" + address + '\'' +
                ", dateOfRegistration=" + dateOfRegistration +
                ", userId=" + userId +
                '}';
    }
}

