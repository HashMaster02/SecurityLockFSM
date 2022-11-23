package LockBreaker;

public class FSM {
	
	private int current_state; 
	private String current_output;
	private int[][] stt;			// state transition table
	private String[] out;
	
	private void init_stt()
	{
		this.stt = new int[8][10];
		this.out = new String[8];
		for (int i=0; i<8; i++) {
			for (int j=0; j < 10; j++) {
				this.stt[i][j] = 0;
			}
		}
		
		for (int i=0; i<8; i++) {
			this.out[i] = "";
		}
		
		stt[0][8] = 3;
		stt[3][9] = 4;
		stt[4][8] = 5;
		stt[5][5] = 6;
		stt[6][3] = 7;
		stt[7][1] = 1;
		stt[7][4] = 2;
		stt[1][8] = 3;
		stt[2][8] = 3;
		
		out[1] = "LOCKED";
		out[2] = "UNLOCKED";
	}
	
	public FSM()
	{
		init_stt();
		this.current_state = 0;
		this.current_output = this.out[current_state];
	}
	
	public int state() {
		return  current_state;
	}

	public String output() {
		return current_output;
	}
	
	public void input(int in) {
		int ns;	//next state from the stt
		
		try {
			ns = stt[current_state][in];
			current_state = ns;
			current_output = out[current_state];
			return;
		}
		catch(ArrayIndexOutOfBoundsException i)
		{
			System.out.println("Digits 0-9 allowed!");
			this.current_state = 0;
			this.current_output = this.out[current_state];
		}
	}

}
