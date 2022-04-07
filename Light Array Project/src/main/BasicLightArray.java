package main;

//Class holding light array, with each light having only 2 values.
public class BasicLightArray implements LightArray {
	private int lightArray[][];
	private int numActive;
	
	public BasicLightArray() {
		lightArray = new int[1000][1000];
		numActive = 0;
	}
	
	//Loops through specified range of lights within grid.
	void execInstruction(InstructionDecoder.InstructionMethod instruction, int[][] area) {
		for (int x = area[0][0]; x <= area[1][0]; x++) {
			for (int y = area[0][1]; y <= area[1][1]; y++) {
				int currState = lightArray[x][y];
				lightArray[x][y] = instruction.exec(lightArray[x][y]);
				numActive += lightArray[x][y] - currState;
			}
		}
	}
	
	//Receives instruction, and passes lambda function to "execFunction" as the method of changing state of lights.
	@Override
	public void receiveInstruction(InstructionDecoder.Instructions instruction, int[][] area) {
		switch (instruction) {
		case ON: 
			execInstruction(x -> 1, area);
		break;
		case OFF:	
			execInstruction(x -> 0, area);
		break;
		case TOGGLE:
			execInstruction(x -> x == 1 ? 0 : 1, area);
			break;
		}
	}
	
	@Override
	public int getActiveCells() { return numActive; }
}
