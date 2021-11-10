package com.regtech;

import java.util.LinkedList;
import java.util.List;

public class House extends LinkedList<Room> {

    public House(List<Room> rooms) {
        super(rooms);
    }

    public Integer countUnhappiness() {
        return this.stream().mapToInt(Room::getUnhappiness).sum();
    }

    public Boolean contains(Person person) {
        return this.stream().anyMatch(p -> p.contains(person));
    }
}
