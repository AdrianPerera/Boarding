package com.io.boarding.Model;

public class SearchQuery {
    private String address;
    private Integer roomNos;
    private Boolean availability;
    private String userName;

    public SearchQuery(String address, Integer roomNos, Boolean availability, String userName) {
        this.address = address;
        this.roomNos = roomNos;
        this.availability = availability;
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRoomNos() {
        return roomNos;
    }

    public void setRoomNos(Integer roomNos) {
        this.roomNos = roomNos;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
