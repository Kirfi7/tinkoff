package edu.hw7.Task3;

import java.util.HashMap;
import java.util.function.Predicate;
import org.jetbrains.annotations.Nullable;

public class PersonDB implements PersonDatabase {
    private final HashMap<Integer, Person> database = new HashMap<>();

    @Override
    public void add(Person person) {
        synchronized (person) {
            database.put(person.id(), person);
        }
    }

    @Override
    public void delete(int id) {
        synchronized (database) {
            database.remove(id);
        }
    }

    @Override
    public @Nullable Person findByName(String name) {
        return findBy(person -> person.name().equals(name));
    }

    @Override
    public @Nullable Person findByAddress(String address) {
        return findBy(person -> person.address().equals(address));
    }

    @Override
    public @Nullable Person findByPhone(String phone) {
        return findBy(person -> person.phoneNumber().equals(phone));
    }

    private Person findBy(Predicate<? super Person> predicate) {
        synchronized (database) {
            return database.values().stream()
                .filter(predicate)
                .findFirst()
                .orElse(null); }
    }
}
