package com.io.boarding.Data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Boarding {

    @Id
    @GeneratedValue
    private Integer id;

    private String address;
    private Integer noOfRooms;
    private Boolean availability;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_user_name")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    public Boarding() {
    }

    public Boarding(Integer id, String address, Integer noOfRooms, Boolean availability, User user) {
        this.id = id;
        this.address = address;
        this.noOfRooms = noOfRooms;
        this.availability = availability;
        this.user = user;
    }


}
