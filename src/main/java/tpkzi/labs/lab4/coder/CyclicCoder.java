package tpkzi.labs.lab4.coder;

import tpkzi.labs.lab4.BinaryDivider;
import tpkzi.labs.lab4.DivResult;

public class CyclicCoder {
	private static final int IRREDUCIBLE_POLYNOMIAL = 0b1011;
	private BinaryDivider binaryDivider = new BinaryDivider();
	

	public int encode(int signal) {
		int G = signal << 3;
		
		DivResult divResult = binaryDivider.div(G, IRREDUCIBLE_POLYNOMIAL);
		int F = G | divResult.getRemainder();
		
		return F;
	}

	public int decode(int signal) {
		int sourceSignal = signal;
		
		int errorPosition = 0;
		while (binaryDivider.div(signal, IRREDUCIBLE_POLYNOMIAL).getRemainder() > 1) {
			int t = signal & 1;
			signal = signal >> 1;
			signal = signal | (t << 6);
			errorPosition++;
		}
		
		if (binaryDivider.div(signal, IRREDUCIBLE_POLYNOMIAL).getRemainder() == 1) {
			sourceSignal ^= (1 << errorPosition);
		}

		return sourceSignal >> 3;
	}

}

