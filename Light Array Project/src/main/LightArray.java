package main;

//Common methods of different light array classes; used to pass round different objects under the same type.
//Not totally necessary for this specific program, but useful for different LightArray implementations.
public interface LightArray {
	void receiveInstruction(InstructionDecoder.Instructions instruction, int[][] area);
	int getActiveCells();
}
