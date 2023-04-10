package com.ctu.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Users")
@Table(name = "Users", schema = "PUBLIC")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    @Column(name = "userName")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "userPhone")
    private String userPhone;

    @Column(name = "userAvt")
    private String userAvt;

    @Column(name = "userDisplayname")
    private String userDisplayname;

    @Column(name = "userBio")
    private String userBio;

    @JsonIgnore
    @OneToMany(mappedBy = "user", targetEntity = Device.class, fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Device> devices = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Libraries", joinColumns = {
            @JoinColumn(name = "userId", nullable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "productId", nullable = false, updatable = false) })
    private Set<Product> library = new HashSet<>();

    // @OneToMany(mappedBy = "user", targetEntity = Request.class, fetch =
    // FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    // private List<Request> requests = new ArrayList<>();

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAvt() {
        return userAvt;
    }

    public void setUserAvt(String userAvt) {
        this.userAvt = userAvt;
    }

    public String getUserDisplayname() {
        return userDisplayname;
    }

    public void setUserDisplayname(String userDisplayname) {
        this.userDisplayname = userDisplayname;
    }

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    public Set<Product> getLibrary() {
        return library;
    }

    public void setLibrary(Set<Product> library) {
        this.library = library;
    }

    public boolean setSingleProductToLibrary(Product product) {
        return this.library.add(product);
    }

    public boolean unSetSingleProductToLibrary(Product product) {
        return this.library.remove(product);
    }
}
