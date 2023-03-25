package com.ctu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Devices")
@Table(name="Devices", schema = "PUBLIC")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deviceId")
    private Integer deviceId;

    @Column(name = "deviceName")
    private String deviceName;

    @Column(name = "deviceOS")
    private String deviceOS;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId", nullable = false)
    private User user;

    @Column(name = "fcmToken")
    private String fcmToken;

    public Device() {}

    public Device(String deviceName, String deviceOS, User user) {
        this.deviceName = deviceName;
        this.deviceOS = deviceOS;
        this.user = user;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceOS;
    }

    public void setDeviceType(String deviceOS) {
        this.deviceOS = deviceOS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}
