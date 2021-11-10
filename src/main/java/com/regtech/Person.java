package com.regtech;

import java.util.*;

class Person {

    private String id;
    private String name;
    private List<Person> dislikes;

    public Person() {
        this.dislikes = new LinkedList<>();
        this.id = UUID.randomUUID().toString();
    }

    public Person(String name, Person... dislikes) {
        this();
        this.name = name;
        if (dislikes != null) {
            this.dislikes.addAll(Arrays.asList(dislikes));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getDislikes() {
        return dislikes;
    }

    public Integer countDislikes(List<Person> people) {
        return Math.toIntExact(people.stream().filter(p -> dislikes.contains(p)).count());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}