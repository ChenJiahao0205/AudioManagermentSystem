package pers.chenjiahao.audiomgs.entity;

import java.util.Date;

public class Lease {
    private Long id;

    private String username;

    private String realName;

    private Long audioId;

    private String audioName;

    private Double deposit;

    private Date startRentDate;

    private Date endRentDate;

    private Double rent;

    private Double returnRent;

    private String leaseStatus;

    public Lease() {
    }

    public Lease(String username, String realName, Long audioId, String audioName, Double deposit, Date startRentDate, String leaseStatus) {
        this.username = username;
        this.realName = realName;
        this.audioId = audioId;
        this.audioName = audioName;
        this.deposit = deposit;
        this.startRentDate = startRentDate;
        this.leaseStatus = leaseStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getAudioId() {
        return audioId;
    }

    public void setAudioId(Long audioId) {
        this.audioId = audioId;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Date getStartRentDate() {
        return startRentDate;
    }

    public void setStartRentDate(Date startRentDate) {
        this.startRentDate = startRentDate;
    }

    public Date getEndRentDate() {
        return endRentDate;
    }

    public void setEndRentDate(Date endRentDate) {
        this.endRentDate = endRentDate;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public Double getReturnRent() {
        return returnRent;
    }

    public void setReturnRent(Double returnRent) {
        this.returnRent = returnRent;
    }

    public String getLeaseStatus() {
        return leaseStatus;
    }

    public void setLeaseStatus(String leaseStatus) {
        this.leaseStatus = leaseStatus;
    }
}