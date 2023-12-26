package edu.project5;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.infra.Blackhole;
import static org.assertj.core.api.Assertions.assertThat;

public class TaskTest {
    private TaskTest() {
    }

    @Test
    void test() {
        Main benchClass = new Main();

        benchClass.setupParams();
        Blackhole bh = new Blackhole("Today's password is swordfish. I understand instantiating Blackholes directly is dangerous.");

        assertThat(benchClass.firstCalcBench(bh))
            .isEqualTo(benchClass.secondCalcBench(bh))
            .isEqualTo(benchClass.thirdCalcBench(bh))
            .isEqualTo(benchClass.fourthCalcBench(bh));
    }
}
