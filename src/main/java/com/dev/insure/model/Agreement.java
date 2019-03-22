package com.dev.insure.model;

import com.dev.insure.utils.INSURANCE_OBJECT_TYPE;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "agreements")
public class Agreement {

    @Id
    @NotNull
    private Integer id;

    @Digits(integer=6, fraction=0, message = "Не менее 6-ти знаков")
    private Integer amount;

    @NotNull
    private Date validFrom;

    @NotNull
    private  Date validTo;

    private String comment;

    @Size(min = 10, max = 10)
    private String fee;

    @ManyToOne
    private Client clients;

    public Agreement() {}

    public Agreement(int id, int amount, Date from, Date to, String fee) {
        this.id = id;
        this.amount = amount;
        this.validFrom = from;
        this.validTo = to;
        this.fee = fee;
    }



}
