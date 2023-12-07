package edu.hw7.Task3.Task35;

import edu.hw7.Task3.Person;
import edu.hw7.Task3.PersonDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Predicate;

public class Task35 implements PersonDatabase {
    private final Map<Integer, Person> database = new HashMap<>();

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    @Override
    public void add(Person person) {
        try {
            writeLock.lock();
            database.put(person.id(), person);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void delete(int id) {
        try {
            writeLock.lock();
            database.remove(id);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public synchronized Person findByName(String name) {
        return findBy(person -> person.name().equals(name));
    }

    @Override
    public synchronized Person findByAddress(String address) {
        return findBy(person -> person.address().equals(address));
    }

    @Override
    public synchronized Person findByPhone(String phone) {
        return findBy(person -> person.phoneNumber().equals(phone));
    }

    private Person findBy(Predicate<? super Person> predicate) {
        Person result;

        try {
            readLock.lock();
            result = database.values().stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
        } finally {
            readLock.unlock();
        }

        return result;
    }
}

