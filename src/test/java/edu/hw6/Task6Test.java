package edu.hw6;

import edu.hw6.Task6.Task6;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task6Test {

    @Test
    void testGetBusyPortsInfo() {
        Task6.getBusyPortsInfo();
    }

    @Test
    void testGetFreeAndBusyPorts() {
        int minPort = 8080;
        int maxPort = 8085;

        Task6.getFreeAndBusyPorts(minPort, maxPort);
    }

    @Test
    void testScanPortFree() {
        int freePort = 9090;
        String status = Task6.scanPort(freePort);
        assertEquals("Свободен", status);
    }

    @Test
    void testScanPortBusy() {
        int busyPort = 46;
        String status = Task6.scanPort(busyPort);
        assertEquals("Свободен", status);
    }
}
