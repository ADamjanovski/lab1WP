package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LocationRepository{
    public List<Location> findAll(){
        return DataHolder.locations;
    }

    public Optional<Location> findById(long id){
        return DataHolder.locations.stream().filter(location -> location.getId()==id).findFirst();
    }

    public boolean delete(long id){
        return DataHolder.locations.removeIf(location -> location.getId()==id);
    }
    public Location save(Location location){
        DataHolder.locations.removeIf(location1 -> location.getId()==location1.getId());
        DataHolder.locations.add(location);
        return location;
    }
}
