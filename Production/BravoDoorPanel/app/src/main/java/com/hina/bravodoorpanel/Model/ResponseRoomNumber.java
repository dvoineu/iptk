package com.hina.bravodoorpanel.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseRoomNumber {

    @SerializedName("rooomNumber")
    public String getRooomNumber() {
        return roomNumber;
    }

    public void setRooomNumber(String rooomNumber) {
        this.roomNumber = rooomNumber;
    }

    private String roomNumber;

}
