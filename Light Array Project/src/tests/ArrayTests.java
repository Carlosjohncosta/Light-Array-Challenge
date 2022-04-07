package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.*;

class ArrayTests {
	
	@Test
	void basicLightArrTest() {
		BasicLightArray basic = new BasicLightArray();
		basic.receiveInstruction(InstructionDecoder.Instructions.ON, new int[][] {{0, 0}, {999, 999}});
		assertEquals(basic.getActiveCells(), 1000000);
		basic.receiveInstruction(InstructionDecoder.Instructions.OFF, new int[][] {{0, 0}, {499, 999}});
		assertEquals(basic.getActiveCells(), 500000);
		basic.receiveInstruction(InstructionDecoder.Instructions.TOGGLE, new int[][] {{0, 0}, {999, 999}});
		assertEquals(basic.getActiveCells(), 500000);
	}
	
	@Test
	void rangeLightArrTest() {
		RangeLightArray basic = new RangeLightArray();
		basic.receiveInstruction(InstructionDecoder.Instructions.ON, new int[][] {{0, 0}, {999, 999}});
		basic.receiveInstruction(InstructionDecoder.Instructions.ON, new int[][] {{0, 0}, {999, 999}});
		assertEquals(basic.getActiveCells(), 2000000);
		basic.receiveInstruction(InstructionDecoder.Instructions.OFF, new int[][] {{0, 0}, {499, 999}});
		assertEquals(basic.getActiveCells(), 1500000);
		basic.receiveInstruction(InstructionDecoder.Instructions.TOGGLE, new int[][] {{0, 0}, {999, 999}});
		assertEquals(basic.getActiveCells(), 3500000);
	}
	

}
