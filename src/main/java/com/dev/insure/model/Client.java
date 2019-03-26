package com.dev.insure.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Pattern(regexp="^(0|[1-9][0-9]*)$")
    @Column(name = "passports", nullable = false)
    private String passportS;

    @Pattern(regexp="^(0|[1-9][0-9]*)$")
    @Column(name = "passportn", nullable = false)
    private String passportN;

    @Pattern(regexp = "^[а-яА-Яa-zA-Z0-9.\\-\\/+=@_ ]*$")
    @NotEmpty
    @Column(name = "fullname")
    private String fullName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate")
    private Date birthDate;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Agreement> agreements = new HashSet<>();

    public Client() {}

    public Client(String passportS, String passportN, String fullName, Date birthDate) {
        this.passportS = passportS;
        this.passportN = passportN;
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassportS() {
        return passportS;
    }

    public void setPassportS(String passportS) {
        this.passportS = passportS;
    }

    public String getPassportN() {
        return passportN;
    }

    public void setPassportN(String passportN) {
        this.passportN = passportN;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Agreement> getAgreements() {
        return agreements;
    }

    public void setAgreements(Set<Agreement> agreements) {
        this.agreements = agreements;
    }

    public boolean isNew() {
        return (this.id == null);
    }


    @Override
    public String toString() {
        return "Client{" +
                "passportS='" + passportS + '\'' +
                ", passportN='" + passportN + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
