package SecurityLockFSM;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FSMTest {
	
	@Test
	void current_state_initialized_to_0()
	{
		FSM machine = new FSM();
		assertEquals(0, machine.state());
	}
	
	@Test
	void current_output_initialized_to_blank_string()
	{
		FSM machine = new FSM();
		assertEquals("", machine.output());
	}
	
	@Test
	void entering_lock_code_changes_state_to_locked()
	{
		FSM machine = new FSM();
		machine.input(8);
		machine.input(9);
		machine.input(8);
		machine.input(5);
		machine.input(3);
		machine.input(1);
		assertEquals(1, machine.state());
	}
	
	@Test
	void entering_unlock_code_changes_state_to_locked()
	{
		FSM machine = new FSM();
		machine.input(8);
		machine.input(9);
		machine.input(8);
		machine.input(5);
		machine.input(3);
		machine.input(4);
		assertEquals(2, machine.state());
	}
	
	@Test
	void entering_multi_digit_number_throws_ArrayIndexOutOfBounds() throws Exception
	{
		FSM machine = new FSM();
		machine.input(13);
	}
	
	@Test
	void entering_negative_numbers_throws_ArrayIndexOutOfBounds() throws Exception
	{
		FSM machine = new FSM();
		machine.input(-14);
	}
	
	@Test
	void check_if_lockDevice_method_locks_device()
	{
		FSM machine = new FSM();
		machine.lockDevice();
		assertEquals(1, machine.state());
	}

}
