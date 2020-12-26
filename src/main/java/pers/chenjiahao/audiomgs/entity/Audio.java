package pers.chenjiahao.audiomgs.entity;

public class Audio {
    private Long id;

    private String audioName;

    private Double dayRent;

    private Double deposit;

    private Integer inventory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public Double getDayRent() {
        return dayRent;
    }

    public void setDayRent(Double dayRent) {
        this.dayRent = dayRent;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}