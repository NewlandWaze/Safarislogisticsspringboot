package com.Safari.Safari.repository;

import com.Safari.Safari.model.Safari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SafariRepo extends JpaRepository<Safari, Long> {

    // Custom method for updating a Safari
    @Transactional
    @Modifying
    @Query("UPDATE Safari s " +
            "SET s.names = :names, " +
            "s.email = :email, " +
            "s.mobileNumber = :mobileNumber, " +
            "s.gender = :gender, " +
            "s.occupation = :occupation, " +
            "s.nationality = :nationality, " +
            "s.location = :location, " +
            "s.date = :date, " +
            "s.timeOfDeparture = :timeOfDeparture, " +
            "s.timeOfArrival = :timeOfArrival, " +
            "s.numberOfGuests = :numberOfGuests, " +
            "s.typeOfCar = :typeOfCar " +
            "WHERE s.id = :id")
    int updateSafari(
            Long id,
            String names,
            String email,
            String mobileNumber,
            String gender,
            String occupation,
            String nationality,
            String location,
            String date,
            String timeOfDeparture,
            String timeOfArrival,
            String numberOfGuests,
            String typeOfCar
    );
}
