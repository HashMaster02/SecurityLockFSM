package SecurityLockFSM;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {

	int readInput(Scanner sc) {
		int in = -1;
		boolean found;
		
		found = false;
		while (!found) {			
			try {
				sc.skip("[^0-9]*");		// skip non-digits
				in = sc.nextInt();
				found = true;
			} catch (InputMismatchException e) {
				found = false;
			} catch (NoSuchElementException e) {
				found = false;
			}
		}

		return in;		
	}
	
	void securityLock() {
		String out;
		int in;
		Scanner sc = new Scanner(System.in);
		FSM fsm = new FSM();
		while (true) {
			in = readInput(sc);
			fsm.input(in);
			out = fsm.output();
			if (out.equals("LOCKED") || out.equals("UNLOCKED")) {
				System.out.println(out);
			}
		}
	}
	

    public static void main(String[] args) {
    	Application app = new Application();
    	app.securityLock();
    }

}
