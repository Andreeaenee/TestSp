package com.testsp;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Message {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date date;

    @JsonProperty("message")
    private String message;

    private String house;

    // Default constructor (if needed)
    public Message() {
        // Add a default constructor if necessary
    }

    // Constructor with fields
    public Message(Date date, String message, String house) {
        this.date = date;
        this.message = message;
        this.house = house;
    }

    // Getters and setters

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
}

