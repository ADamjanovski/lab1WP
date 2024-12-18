package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.model.exception.NoLocationFoundException;
import mk.finki.ukim.mk.lab.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.lab.service.ListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListServiceImpl implements ListService {
    public final LocationRepository locationRepository;

    public ListServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public boolean delete(long id) {
        return locationRepository.deleteById(id);

    }

    @Override
    public Location findById(long id) {
        return locationRepository.findById(id).orElseThrow();
    }

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }


}
