package com.dev.insure.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Agreement> agreements = new HashSet<>();

    @Transient
    private String surname;

    @Transient
    private String name;

    @Transient
    private String name2;

    @Transient
    private String seriaN;

    @Transient
    private String numberN;


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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getSeriaN() {
        return seriaN;
    }

    public void setSeriaN(String seriaN) {
        this.seriaN = seriaN;
    }

    public String getNumberN() {
        return numberN;
    }

    public void setNumberN(String numberN) {
        this.numberN = numberN;
    }
}
