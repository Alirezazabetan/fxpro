package com.regtech;

import java.util.LinkedList;

public class Room extends LinkedList<Person> {

    private Integer capacity;

    public Room(Integer capacity) {
        super();
        this.capacity = capacity;
    }

    public Integer getUnhappiness() {
        return this.stream().mapToInt(p -> p.countDislikes(this)).sum();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Boolean hasCapacity() {
        return this.size() < capacity;
    }

    public Room copy() {
        return new Room(this.capacity);
    }

    @Override
    public boolean add(Person person) {
        if (this.size() >= capacity) {
            throw new IllegalStateException("Room capacity " + capacity + " exceeded.");
        }

        return super.add(person);
    }
}
