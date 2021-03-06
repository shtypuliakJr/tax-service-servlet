package com.example.taxserviceservlet.web.dto;

import java.sql.Date;

public class UserDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String age;

    private String ipn;

    private String personality;

    private String address;

    private Date dateOfRegistration;

    private Long userId;

    private String userRole;

    public static Builder builder() {
        return new UserDTO.Builder();
    }


    public static class Builder {

        private final UserDTO userDTO;

        public Builder() {
            userDTO = new UserDTO();
        }

        public Builder firstName(String firstName) {
            this.userDTO.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.userDTO.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.userDTO.email = email;
            return this;
        }

        public Builder password(String password) {
            this.userDTO.password = password;
            return this;
        }

        public Builder age(String age) {
            this.userDTO.age = age;
            return this;
        }

        public Builder ipn(String ipn) {
            this.userDTO.ipn = ipn;
            return this;
        }

        public Builder dateOfRegistration(Date dateOfRegistration) {
            this.userDTO.dateOfRegistration = dateOfRegistration;
            return this;
        }

        public Builder personality(String personality) {
            this.userDTO.personality = personality;
            return this;
        }

        public Builder address(String address) {
            this.userDTO.address = address;
            return this;
        }

        public Builder userId(Long userId) {
            this.userDTO.userId = userId;
            return this;
        }

        public Builder userRole(String userRole) {
            this.userDTO.userRole = userRole;
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
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
                ", userRole='" + userRole + '\'' +
                '}';
    }
}

