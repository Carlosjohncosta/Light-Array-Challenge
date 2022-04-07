package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.*;

class DecoderTests {
	InstructionDecoder decoder;
	
	@Test
	void decoderTest() {
		LightArray lightArray = new RangeLightArray();
		decoder = new InstructionDecoder(lightArray);
		decoder.runInstructions("test_script.txt");
		assertEquals(lightArray.getActiveCells(), 1003996);
		lightArray = new BasicLightArray();
		decoder = new InstructionDecoder(lightArray);
		decoder.runInstructions("test_script.txt");
		assertEquals(lightArray.getActiveCells(), 998004);
	}

}
