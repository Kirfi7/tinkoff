package edu.hw8;

import edu.hw8.Task3.Task3;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Tests {
    private final static int MIN_LEN = 1;
    private final static int MAX_LEN = 4;
    private final static char[] alphabet = new char[62];
    private final static Map<String, String> EXPECTED = Map.of(
        "a.v.petrov", "AaAa",
        "v.v.belov", "FKa",
        "a.s.ivanov", "Java",
        "k.p.maslov", "d17L"
    );
    private final List<String> DATA = List.of(
        "a.v.petrov 5548f6b3b896d214889d6be66ad190f1",
        "v.v.belov 4dbfe947b5e76012517afeefef47f2f8",
        "a.s.ivanov d52387880e1ea22817a72d3759213819",
        "k.p.maslov ca5e8b3e00551f313ce433178e632367"
    );

    private Task3Tests() {
    }

    @Test
    void testPasswordCracking() {
        int index = 0;

        for (int i = 20; i < 155; i++) {
            char symb = (char) i;
            if (Character.isLetter(symb) || Character.isDigit(symb)) {
                alphabet[index++] = symb;
            }
        }

        Map<String, String> actual_1 = new Task3().getPasswordsMultiThreads(DATA, MIN_LEN, MAX_LEN, alphabet);
        Map<String, String> actual_2 = new Task3().getPasswords(DATA, MIN_LEN, MAX_LEN, alphabet);

        assertThat(actual_1).isEqualTo(actual_2).isEqualTo(EXPECTED);
    }
}
