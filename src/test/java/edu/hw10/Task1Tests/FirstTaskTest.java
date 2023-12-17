package edu.hw10.Task1Tests;

import edu.hw10.Task1.RandomObjectGenerator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class FirstTaskTest {
    private final static RandomObjectGenerator ROG = new RandomObjectGenerator();
    private FirstTaskTest() {
    }

    @Test
    void testStandartRecords() {
        MyStandartRecord standartRecord = ROG.nextObject(MyStandartRecord.class);
        MyRecordWithoutArgs recordWithoutArgs = ROG.nextObject(MyRecordWithoutArgs.class);

        assertThat(standartRecord).isNotNull();
        assertThat(recordWithoutArgs).isNotNull();
    }

    @Test
    void testAnnotations() {
        MyRecordWithAnnotations recordWithAnnotations = ROG.nextObject(MyRecordWithAnnotations.class);

        assertThat(recordWithAnnotations).isNotNull();
        assertThat(recordWithAnnotations.real()).isGreaterThan(0);
        assertThat(recordWithAnnotations.doubl()).isLessThanOrEqualTo(0);
        assertThat(recordWithAnnotations.real2())
            .isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(10);
    }

    @Test
    void testAnnotationError() {
        assertThatThrownBy(() -> ROG.nextObject(MyRecordWithError.class))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testStandartClass() {
        MyStandartClass standartClass = ROG.nextObject(MyStandartClass.class);

        assertThat(standartClass).isNotNull();
        assertThat(standartClass.getInt())
            .isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(10);
        assertThat(standartClass.getStr()).isNotNull();
    }

    @Test
    void testClassWithFabric() {
        MyClassWithFabric classWithFabric = ROG.nextObject(MyClassWithFabric.class, "create");

        assertThat(classWithFabric).isNotNull();
        assertThat(classWithFabric.getInt())
            .isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(10);
        assertThat(classWithFabric.getStr()).isNotNull();
    }
}
