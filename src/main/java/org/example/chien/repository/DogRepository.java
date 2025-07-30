package org.example.chien.repository;

import org.example.chien.model.Dog;
import org.hibernate.Session;

import java.util.List;

public class DogRepository extends Repository<Dog>{


    public DogRepository(Session session) {
        super(session);
    }

    @Override
    public List<Dog> findAll() {
        return _session.createQuery("from Dog").list();
    }
}
