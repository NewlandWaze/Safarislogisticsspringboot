package com.Safari.Safari.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Safari {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "VIP Names must not be blank")
    private String names;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    private String gender;

    private String occupation;

    private String nationality;

    private String location;

    @NotBlank(message = "Date must not be blank")
    private String date;

    @NotBlank(message = "Time of Departure must not be blank")
    private String timeOfDeparture;

    @NotBlank(message = "Time of Arrival must not be blank")
    private String timeOfArrival;

    @Positive(message = "Number of Guests must be a positive value")
    private String numberOfGuests;

    @NotBlank(message = "Type of Car must not be blank")
    private String typeOfCar;
}
