package com.dev.insure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @Column(name = "s/n", unique = true, nullable = false)
    private long passportSN;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "birthdate")
    private Date birthDate;

    public Client() {}

    public long getPassportSN() {
        return passportSN;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}
