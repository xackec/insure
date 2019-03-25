package com.dev.insure.model;

import com.dev.insure.utils.INSURANCE_OBJECT_TYPE;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;
import java.sql.Date;

@Entity
@Table(name = "agreements")
public class Agreement {

    @Id
    @Digits(integer=6, fraction=6)
    private Integer id;

    @NotNull
    private Integer amount;

    @NotNull
    private Date validFrom;

    @NotNull
    private  Date validTo;

    private String comment;

    @NotNull
    private String fee;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Subject subject;

    public Agreement() {}

    public Agreement(int id, int amount, Date from, Date to, String fee) {
        this.id = id;
        this.amount = amount;
        this.validFrom = from;
        this.validTo = to;
        this.fee = fee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
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
}
