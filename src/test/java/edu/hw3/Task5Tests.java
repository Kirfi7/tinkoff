package edu.hw3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Tests {

    @Test
    void testParseContactsASC() {
        String[] names = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        List<Task5.Contact> sortedContacts = Task5.parseContacts(names, "ASC");
        assertEquals("Thomas Aquinas", sortedContacts.get(0).getFullName());
        assertEquals("Rene Descartes", sortedContacts.get(1).getFullName());
        assertEquals("David Hume", sortedContacts.get(2).getFullName());
        assertEquals("John Locke", sortedContacts.get(3).getFullName());
    }

    @Test
    void testParseContactsDESC() {
        String[] names = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        List<Task5.Contact> sortedContacts = Task5.parseContacts(names, "DESC");
        assertEquals("Carl Gauss", sortedContacts.get(0).getFullName());
        assertEquals("Leonhard Euler", sortedContacts.get(1).getFullName());
        assertEquals("Paul Erdos", sortedContacts.get(2).getFullName());
    }

    @Test
    void testParseContactsEmptyInput() {
        String[] names = {};
        List<Task5.Contact> sortedContacts = Task5.parseContacts(names, "ASC");
        assertEquals(0, sortedContacts.size());
    }

    @Test
    void testParseContactsNullInput() {
        List<Task5.Contact> sortedContacts = Task5.parseContacts(null, "ASC");
        assertEquals(0, sortedContacts.size());
    }

    @Test
    void testContactConstructorWithFullName() {
        Task5.Contact contact = new Task5.Contact("John Doe");
        assertEquals("John", contact.firstName);
        assertEquals("Doe", contact.lastName);
    }

    @Test
    void testContactConstructorWithFirstNameOnly() {
        Task5.Contact contact = new Task5.Contact("John");
        assertEquals("John", contact.firstName);
        assertEquals("", contact.lastName);
    }
}
