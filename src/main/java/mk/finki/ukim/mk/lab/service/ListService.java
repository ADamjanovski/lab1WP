package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Location;

import java.util.List;

public interface ListService {
    public List<Location> findAll();
    public boolean delete(long id);
    public Location findById(long id);
    public Location save(Location location);
}
