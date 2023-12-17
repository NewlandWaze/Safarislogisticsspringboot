package com.Safari.Safari.service;

import com.Safari.Safari.model.Safari;
import com.Safari.Safari.repository.SafariRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StafariServiceImpl implements StafariService {

    @Autowired
    private SafariRepo safariRepo;

    @Override
    public List<Safari> getAllTrips() {
        return safariRepo.findAll();
    }

    @Override
    public void saveTrip(Safari safari) {
        this.safariRepo.save(safari);
    }

    @Override
    public Safari updateTrip(Long id, Safari safari) {
        return null;
    }


    @Override
    public Safari getTripById(long id) {
        Optional<Safari> optional = safariRepo.findById(id);
        Safari safari = null;
        if(optional.isPresent()){
            safari = optional.get();
        }else{
            throw  new RuntimeException("Safari not found for id: " + id);
        }
        return safari;
    }


    @Override
    public void deleteTrip(long id) {
    this.safariRepo.deleteById(id);
    }

    @Override
    public Page<Safari> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo -1, pageSize, sort);
        return this.safariRepo.findAll(pageable);
    }


}
