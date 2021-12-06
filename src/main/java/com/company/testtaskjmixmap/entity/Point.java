package com.company.testtaskjmixmap.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.JmixProperty;
import io.jmix.core.metamodel.annotation.PropertyDatatype;
import io.jmix.maps.Geometry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

@JmixEntity
@Table(name = "POINT")
@Entity
public class Point {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Geometry
    @PropertyDatatype("geoPoint")
    @Column(name = "LOCATION")
    @JmixProperty
    private org.locationtech.jts.geom.Point location;

    @InstanceName
    @Digits(integer = 8, fraction = 0)
    @NotNull
    @Column(name = "CODE", unique = true)
    private Integer code;

    @Column(name = "ADDRESS")
    private String address;

    @Digits(integer = 2, fraction = 9)
    @NotNull
    @Column(name = "LATITUDE")
    private Double latitude;

    @Digits(integer = 2, fraction = 9)
    @NotNull
    @Column(name = "LONGITUDE")
    private Double longitude;

    @PositiveOrZero
    @Column(name = "ICON")
    private Integer icon;

    public org.locationtech.jts.geom.Point getLocation() {
        return location;
    }

    public void setLocation(Double longitude, Double latitude) {

    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}