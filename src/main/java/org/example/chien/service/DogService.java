package org.example.chien.service;

import org.example.chien.model.Dog;
import org.example.chien.repository.DogRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class DogService implements InterfaceDogService {
    private DogRepository dogRepository;
    private SessionFactory _sessionFactory;
    private Session session;

    public DogService(SessionFactory _sessionFactory) {
        this._sessionFactory = _sessionFactory;
    }

    @Override
    public List<Dog> getAll() {
        List<Dog> dogs = new ArrayList<>();
        session = _sessionFactory.openSession();
        dogRepository = new DogRepository(session);
        try {
            dogs = dogRepository.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return dogs;
    }

    @Override
    public void addDog(Dog dog) {
        session = _sessionFactory.openSession();
        session.beginTransaction();
        dogRepository = new DogRepository(session);
        try {
            dogRepository.create(dog);
            session.getTransaction().commit();
        }catch(Exception e){
            try {
                session.getTransaction().rollback();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }finally {
            session.close();
        }
    }

}
