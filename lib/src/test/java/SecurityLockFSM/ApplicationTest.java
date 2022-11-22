package SecurityLockFSM;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

public class ApplicationTest {
	
	@Test
    void application_readInput_method_returns_the_digit_entered() {
        Application app = new Application();
        String str = "1";
        Scanner sc = new Scanner(str);
        assertEquals(1, app.readInput(sc));
        sc.close();
    }
	
	@Test
    void application_ignores_non_digit_inputs() {
		Application app = new Application();
        String str = "a bcd e 2";
        Scanner sc = new Scanner(str);
        assertEquals(2, app.readInput(sc));
        sc.close();
    }

}
