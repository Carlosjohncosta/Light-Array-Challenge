package main;

public class RangeLightArray extends BasicLightArray{
	
	/* Overrides "receiveInstruction" method, with relevant methods changed for each instruction
	* (instructions passed as lambdas.) */
	@Override
	public void receiveInstruction(InstructionDecoder.Instructions instruction, int[][] area) {
		switch (instruction) {
		case ON: 
			execInstruction(x -> x + 1, area);
		break;
		case OFF:	
			execInstruction(x -> x-- < 0 ? 0 : x, area);
		break;
		case TOGGLE:
			execInstruction(x -> x + 2, area);
			break;
		}
	}
}
