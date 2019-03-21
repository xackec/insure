package com.dev.insure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "clients")
public class Client{

    @Id
    @Column(name = "passportsn", unique = true, nullable = false)
    private String passportSN;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "birthdate")
    private Date birthDate;

    public Client() {}

    public Client(String passportSN, String fullName, Date birthDate) {
        this.passportSN = passportSN;
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    public void setPassportSN(String passportSN) {
        this.passportSN = passportSN;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassportSN() {
        return passportSN;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}
