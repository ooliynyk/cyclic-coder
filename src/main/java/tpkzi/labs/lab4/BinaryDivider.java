package tpkzi.labs.lab4;

public class BinaryDivider {

	private static DivResult divOneStep(int a, int b) {
		int ha = Integer.highestOneBit(a);
		int hb = Integer.highestOneBit(b);

		if (ha < hb)
			return new DivResult(a, -1);

		DivResult result = new DivResult();

		// calculation of a quotient part
		int x = 0;
		while (ha > hb) {
			ha >>= 1;
			x++;
		}
		result.setQuotient(1 << x);

		// calculation of a remainder part
		int db = b << x;
		result.setRemainder(a ^ db);

		return result;
	}

	public DivResult div(int a, int b) {
		int ha = Integer.highestOneBit(a);
		int hb = Integer.highestOneBit(b);
		if (ha < hb)
			return new DivResult(a, 0);

		int len = 0;
		int r = a;
		while (r > 0) {
			r >>= 1;
			len++;
		}

		int remainder = a;
		int quotient = 0;
		for (int i = 0; i < len; i++) {
			DivResult dr = divOneStep(remainder, b);
			
			if (dr.getRemainder() == -1)
				break;
			
			remainder = dr.getRemainder();
			quotient |= dr.getQuotient();
			
			if (dr.getRemainder() == 0)
				break;
		}

		return new DivResult(quotient, remainder);
	}

}