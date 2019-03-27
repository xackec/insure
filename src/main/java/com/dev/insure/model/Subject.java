package com.dev.insure.model;

import com.dev.insure.utils.INSURANCE_OBJECT_TYPE;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    private Integer constructionYear;

    @Pattern(regexp = "(^\\d{1,4}$)|(^\\d{0,4}[.]\\d{1,1}$)")
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

    private Integer buildnum;

    private String part;

    private String bldg;

    @NotNull
    private Integer flatnum;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Agreement> subjects = new HashSet<>();

    public Subject() {};


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

    public Integer getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Integer constructionYear) {
        this.constructionYear = constructionYear;
    }

    public Integer getBuildnum() {
        return buildnum;
    }

    public void setBuildnum(Integer buildnum) {
        this.buildnum = buildnum;
    }

    public Integer getFlatnum() {
        return flatnum;
    }

    public void setFlatnum(Integer flatnum) {
        this.flatnum = flatnum;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "constructionYear=" + constructionYear +
                ", square='" + square + '\'' +
                ", objType=" + objType +
                ", state='" + state + '\'' +
                ", postcode='" + postcode + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildnum=" + buildnum +
                ", part='" + part + '\'' +
                ", bldg='" + bldg + '\'' +
                ", flatnum=" + flatnum +
                '}';
    }
}
