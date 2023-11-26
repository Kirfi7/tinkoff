package edu.hw7;

import edu.hw7.Task3.Person;
import edu.hw7.Task3.PersonDB;
import edu.hw7.Task3.PersonDatabase;
import edu.hw7.Task3.Task35.Task35;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    private Task3Test() {
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
            Arguments.of(
                List.of(
                    new Person(0, "John", "address_1", "+12345678"),
                    new Person(1, "Antony", "address_11", "+987433"),
                    new Person(2, "Mike", "address_1", "+75423"),
                    new Person(3, "Alice", "address_4", "+3457534"),
                    new Person(4, "John", "address_4", "+5735354"),
                    new Person(5, "Roby", "address_78", "+5754542"),
                    new Person(6, "Don", "address_12", "+55542"),
                    new Person(7, "Alex", "address_2", "+256785"),
                    new Person(8, "Maria", "address_41", "+87564"),
                    new Person(9, "Elizabeth", "address_40", "+86789453"),
                    new Person(10, "Anna", "address_9", "+986326")
                ),
                List.of(
                    new Person(0, "John", "address_1", "+12345678"),
                    new Person(4, "John", "address_4", "+5735354")
                ),
                List.of(
                    new Person(1, "Antony", "address_11", "+987433"),
                    new Person(2, "Mike", "address_1", "+75423"),
                    new Person(3, "Alice", "address_4", "+3457534"),
                    new Person(5, "Roby", "address_78", "+5754542"),
                    new Person(6, "Don", "address_12", "+55542"),
                    new Person(7, "Alex", "address_2", "+256785"),
                    new Person(8, "Maria", "address_41", "+87564"),
                    new Person(9, "Elizabeth", "address_40", "+86789453"),
                    new Person(10, "Anna", "address_9", "+986326")
                )
            ),
            Arguments.of(
                List.of(
                    new Person(0, "John", "address_1", "+12345678"),
                    new Person(1, "Antony", "address_11", "+987433"),
                    new Person(2, "Mike", "address_1", "+75423"),
                    new Person(3, "Alice", "address_4", "+3457534"),
                    new Person(4, "John", "address_4", "+5735354"),
                    new Person(5, "Roby", "address_78", "+5754542"),
                    new Person(6, "Don", "address_12", "+55542"),
                    new Person(7, "Alex", "address_2", "+256785"),
                    new Person(8, "Maria", "address_41", "+87564"),
                    new Person(9, "Elizabeth", "address_40", "+86789453"),
                    new Person(10, "Anna", "address_9", "+986326")
                ),
                List.of(),
                List.of(
                    new Person(0, "John", "address_1", "+12345678"),
                    new Person(1, "Antony", "address_11", "+987433"),
                    new Person(2, "Mike", "address_1", "+75423"),
                    new Person(3, "Alice", "address_4", "+3457534"),
                    new Person(4, "John", "address_4", "+5735354"),
                    new Person(5, "Roby", "address_78", "+5754542"),
                    new Person(6, "Don", "address_12", "+55542"),
                    new Person(7, "Alex", "address_2", "+256785"),
                    new Person(8, "Maria", "address_41", "+87564"),
                    new Person(9, "Elizabeth", "address_40", "+86789453"),
                    new Person(10, "Anna", "address_9", "+986326")
                )
            ),
            Arguments.of(
                List.of(
                    new Person(0, "John", "address_1", "+12345678"),
                    new Person(1, "Antony", "address_11", "+987433"),
                    new Person(2, "Mike", "address_1", "+75423"),
                    new Person(3, "Alice", "address_4", "+3457534"),
                    new Person(4, "John", "address_4", "+5735354"),
                    new Person(5, "Roby", "address_78", "+5754542"),
                    new Person(6, "Don", "address_12", "+55542"),
                    new Person(7, "Alex", "address_2", "+256785"),
                    new Person(8, "Maria", "address_41", "+87564"),
                    new Person(9, "Elizabeth", "address_40", "+86789453"),
                    new Person(10, "Anna", "address_9", "+986326")
                ),
                List.of(
                    new Person(0, "John", "address_1", "+12345678"),
                    new Person(1, "Antony", "address_11", "+987433"),
                    new Person(2, "Mike", "address_1", "+75423"),
                    new Person(3, "Alice", "address_4", "+3457534"),
                    new Person(4, "John", "address_4", "+5735354"),
                    new Person(5, "Roby", "address_78", "+5754542"),
                    new Person(6, "Don", "address_12", "+55542"),
                    new Person(7, "Alex", "address_2", "+256785"),
                    new Person(8, "Maria", "address_41", "+87564"),
                    new Person(9, "Elizabeth", "address_40", "+86789453"),
                    new Person(10, "Anna", "address_9", "+986326")
                ),
                List.of()
            ),
            Arguments.of(
                List.of(
                    new Person(0, "John", "address_1", "+12345678"),
                    new Person(1, "Antony", "address_11", "+987433"),
                    new Person(2, "Mike", "address_1", "+75423"),
                    new Person(3, "Alice", "address_4", "+3457534"),
                    new Person(4, "John", "address_4", "+5735354"),
                    new Person(5, "Roby", "address_78", "+5754542"),
                    new Person(6, "Don", "address_12", "+55542"),
                    new Person(7, "Alex", "address_2", "+256785"),
                    new Person(8, "Maria", "address_41", "+87564"),
                    new Person(9, "Elizabeth", "address_40", "+86789453"),
                    new Person(10, "Anna", "address_9", "+986326")
                ),
                List.of(
                    new Person(6, "Don", "address_12", "+55542"),
                    new Person(7, "Alex", "address_2", "+256785"),
                    new Person(8, "Maria", "address_41", "+87564"),
                    new Person(9, "Elizabeth", "address_40", "+86789453"),
                    new Person(10, "Anna", "address_9", "+986326")
                ),
                List.of(
                    new Person(0, "John", "address_1", "+12345678"),
                    new Person(1, "Antony", "address_11", "+987433"),
                    new Person(2, "Mike", "address_1", "+75423"),
                    new Person(3, "Alice", "address_4", "+3457534"),
                    new Person(4, "John", "address_4", "+5735354"),
                    new Person(5, "Roby", "address_78", "+5754542")
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testInMemoryPersonDatabase(List<Person> add, List<Person> delete, List<Person> expected) {
        testDB(new PersonDB(), add, delete, expected);
        testDB(new Task35(), add, delete, expected);
    }

    private void testDB(PersonDatabase db, List<Person> add, List<Person> delete, List<Person> expected) {
        var threadsAdd = new ArrayList<Thread>();

        for (int i = 0; i < add.size(); i++) {
            int finalI = i;
            threadsAdd.add(new Thread(() -> db.add(add.get(finalI))));
        }
        threadsAdd.forEach(Thread::start);
        for (Thread thread : threadsAdd) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        var threadsDelete = new ArrayList<Thread>();
        for (int i = 0; i < delete.size(); i++) {
            int finalI = i;
            threadsDelete.add(new Thread(() -> db.delete(delete.get(finalI).id())));
        }
        threadsDelete.forEach(Thread::start);

        for (Thread thread : threadsDelete) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (var i : expected) {
            var withName = db.findByName(i.name());
            assertThat(withName).isNotNull();

            var withPhone = db.findByPhone(i.phoneNumber());
            assertThat(withPhone).isNotNull();

            var withAddress = db.findByAddress(i.address());
            assertThat(withAddress).isNotNull();
        }
    }
}
