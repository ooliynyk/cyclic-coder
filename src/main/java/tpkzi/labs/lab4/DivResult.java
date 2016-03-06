package tpkzi.labs.lab4;

public class DivResult {
	private int quotient;
	private int remainder;

	public DivResult() { }

	public DivResult(int quotient, int remainder) {
		this.quotient = quotient;
		this.remainder = remainder;
	}

	public int getQuotient() {
		return quotient;
	}

	public void setQuotient(int quotient) {
		this.quotient = quotient;
	}

	public int getRemainder() {
		return remainder;
	}

	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public String toString() {
		return "DivResult [quotient=" + Integer.toBinaryString(quotient) + ", remainder="
				+ Integer.toBinaryString(remainder) + "]";
	}

}