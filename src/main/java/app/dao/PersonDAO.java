package app.dao;

import app.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private  int PERSON_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person("Tom", ++PERSON_COUNT));
        people.add(new Person("Jhon", ++PERSON_COUNT));
        people.add(new Person("Tim", ++PERSON_COUNT));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        for (Person person : people) {
            if (person.getId() == id)
                return person;
        }
        return null;
    }

    public void save(Person person) {
        person.setId(++PERSON_COUNT);
        people.add(person);
    }

    public void update(Person person, int id) {
        Person prevPerson = show(id);
        prevPerson.setName(person.getName());
    }

    public void delete(int id) {
        people.remove(show(id));
    }
}
