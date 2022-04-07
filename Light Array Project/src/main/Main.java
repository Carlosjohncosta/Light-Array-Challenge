package main;

public class Main {
	
	//Compiled .jar file uses args as script file name.
	//run.bat can be used to run program, or normally through command line.
	public static void main(String[] args) {
		
		//Part 1:
		LightArray lightArray = new BasicLightArray();
		InstructionDecoder decoder = new InstructionDecoder(lightArray);
		decoder.runInstructions("coding_challenge_input.txt");
		System.out.println(lightArray.getActiveCells());
		
		//Part 2:
		lightArray = new RangeLightArray();
		decoder = new InstructionDecoder(lightArray);
		decoder.runInstructions("coding_challenge_input.txt");
		System.out.println(lightArray.getActiveCells());
		
	}
}
