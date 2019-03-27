package com.dev.insure.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "agreements")
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Pattern(regexp = "^\\d{1,6}$")
    @Column(name = "num", unique = true, nullable = false)
    private String num;

    @Pattern(regexp = "^[1-9]\\d*$")
    @NotNull
    private String amount;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date validFrom;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @NotNull
    private  Date validTo;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private  Date calculationDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date submitDate;

    private String comment;

    @NotNull
    private String fee;

    @ManyToOne
    private Client client;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Subject subject;

    public Agreement() {
        this.validFrom = new Date();
        this.submitDate = new Date();
    }

    public Agreement(String num, String amount, Date from, Date to, String fee) {
        this.num = num;
        this.amount = amount;
        this.validFrom = from;
        this.validTo = to;
        this.fee = fee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isNew() {
        return (this.id == null);
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getCalculationDate() {
        return calculationDate;
    }

    public void setCalculationDate(Date calculationDate) {
        this.calculationDate = calculationDate;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "num='" + num + '\'' +
                ", amount='" + amount + '\'' +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", calculationDate=" + calculationDate +
                ", submitDate=" + submitDate +
                ", comment='" + comment + '\'' +
                ", fee='" + fee + '\'' +
                ", client=" + client +
                ", subject=" + subject +
                '}';
    }
}
