package org.example.chien.service;

import org.example.chien.model.Dog;

import java.util.List;

public interface InterfaceDogService {

    List<Dog> getAll();
    void addDog(Dog dog);
}
