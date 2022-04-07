package main;
import java.io.File;
import java.io.FileNotFoundException;  
import java.util.Scanner; 

//Decodes instruction in script file, and passes instructions to "LightArrayObj" instance.
public class InstructionDecoder {
	
	//Functional interface to be used for method of instruction as a lambda.
	public static interface InstructionMethod { int exec(int val); }
	public static enum Instructions { ON, OFF, TOGGLE }
	
	private LightArray lightArrayObj;
	
	public InstructionDecoder(LightArray lightArrayObj) {
		this.lightArrayObj = lightArrayObj;
	};
	
	public void runInstructions(String fileName) {
		try {
			
			//Creates File and Scanner object for passed fileName.
			File script = new File(fileName);
			Scanner reader = new Scanner(script);
			
			try {
				while(reader.hasNextLine()) {
					
					//Gets each word/number from current line of script.
					String[] lineTokens = reader.nextLine().split("\\s+");
					
					//Passes instruction and area to LightArray object described by current line of script.
					if (lineTokens[0].equals("turn")) {
						
						int[][] coords =  {getCoords(lineTokens[2].split(",")), getCoords(lineTokens[4].split(","))};
						if (lineTokens[1].equals("on")) {
							lightArrayObj.receiveInstruction(InstructionDecoder.Instructions.ON, coords);
						} else if (lineTokens[1].equals("off")) {
							lightArrayObj.receiveInstruction(InstructionDecoder.Instructions.OFF, coords);
						}
						
					} else if(lineTokens[0].equals("toggle")) {
						
						int[][] coords =  {getCoords(lineTokens[1].split(",")), getCoords(lineTokens[3].split(","))};
						lightArrayObj.receiveInstruction(InstructionDecoder.Instructions.TOGGLE, coords);
						
					}
					
				}
			} 
			catch(Exception e) {
				System.out.println("Unexpected script format...");
				throw e;
			}
		} 
		catch(FileNotFoundException e) {
			
			System.out.println("File not found...");
			e.printStackTrace();
			
		}
	}
	
	//Converts coordinates in string format to int array type.
	private int[] getCoords(String[] strCoord) {
		return new int[] {Integer.parseInt(strCoord[0]), Integer.parseInt(strCoord[1])};
	}
}
