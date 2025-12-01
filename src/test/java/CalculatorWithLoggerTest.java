import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorWithLoggerTest {

    @Mock
    Logger logger;

    @InjectMocks
    CalulatorWithLogger calulator;

    @Test
    public void addLogTest() {
        int result = calulator.add(10, 3);
        assertEquals(13, result);
        verify(logger).log("Adding 10 + 3");
        verify(logger).log("The result is 13");
    }

    @Test
    public void divideLogTest() {
        int result = calulator.divide(70, 2);
        assertEquals(35, result);
        verify(logger).log("Dividing 70 by 2");
        verify(logger).log("The result is 35");
    }

    @Test
    public void divideExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> calulator.divide(70, 0));
        verify(logger).log("Attempted divide by zero");
        verify(logger).log("Dividing 70 by 0");
    }

}
