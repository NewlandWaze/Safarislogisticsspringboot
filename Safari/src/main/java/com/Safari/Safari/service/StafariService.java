package com.Safari.Safari.service;

import com.Safari.Safari.model.Safari;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StafariService {
    List <Safari> getAllTrips();

    void saveTrip(Safari safari);


    Safari updateTrip(Long id,Safari safari);

    Safari getTripById(long id);
    void deleteTrip(long id);
    Page<Safari> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
