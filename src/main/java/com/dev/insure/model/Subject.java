package com.dev.insure.model;

import com.dev.insure.utils.INSURANCE_OBJECT_TYPE;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "year", nullable = false)
    private int constructionYear;

    @NotNull
    private String square;

    @Enumerated(EnumType.STRING)
    private INSURANCE_OBJECT_TYPE objType;

    @NotNull
    private String state;

    private String postcode;

    @NotNull
    private String region;

    private String district;

    @NotNull
    private String city;

    @NotNull
    private String street;

    private int buildnum;

    private String part;

    private String bldg;

    @NotNull
    private int flatnum;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Agreement> subjects = new HashSet<>();

    public Subject() {};

    public int getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public INSURANCE_OBJECT_TYPE getObjType() {
        return objType;
    }

    public void setObjType(INSURANCE_OBJECT_TYPE objType) {
        this.objType = objType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuildnum() {
        return buildnum;
    }

    public void setBuildnum(int buildnum) {
        this.buildnum = buildnum;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getBldg() {
        return bldg;
    }

    public void setBldg(String bldg) {
        this.bldg = bldg;
    }

    public int getFlatnum() {
        return flatnum;
    }

    public void setFlatnum(int flatnum) {
        this.flatnum = flatnum;
    }
}
