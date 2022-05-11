package com.example.MoneyLion.client;

import javax.persistence.*;

@Entity
@Table
public class Client{

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )

    private Long id;
    private String featureName;
    private String email;
    private Boolean enable;
    @Transient
    private Boolean canAccess;

    public Client() {
    }

    public Client(Boolean canAccess) {
        this.canAccess = canAccess;
    }

    public Client(String featureName, String email, Boolean enable) {
        this.featureName = featureName;
        this.email = email;
        this.enable = enable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getCanAccess() {
        return this.enable;
    }

    public void setCanAccess(Boolean canAccess) {
        this.canAccess = canAccess;
    }

    @Override
    public String toString() {
        return "Client{" +
                ", featureName='" + featureName + '\'' +
                ", email='" + email + '\'' +
                ", enable=" + enable +
                ", canAccess=" + canAccess +
                '}';
    }
}
