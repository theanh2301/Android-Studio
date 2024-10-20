package com.example.app2.Domain;

public class FoodDomain {
    private String pic;
    private String name;
    private String type;
    private Double rate;
    private String description;
    private Double fee;
    private Integer mins;

    public FoodDomain(String pic, String name, String type, Double rate, String description, Double fee, Integer mins) {
        this.pic = pic;
        this.name = name;
        this.type = type;
        this.rate = rate;
        this.description = description;
        this.fee = fee;
        this.mins = mins;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Integer getMins() {
        return mins;
    }

    public void setMins(Integer mins) {
        this.mins = mins;
    }
}
