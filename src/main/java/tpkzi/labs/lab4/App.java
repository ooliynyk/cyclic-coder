package tpkzi.labs.lab4;

import tpkzi.labs.lab4.coder.CyclicCoder;

public class App 
{
    public static void main( String[] args )
    {
    	int d = 0b1101;
    	int p = 0b1011;
    	
        CyclicCoder coder = new CyclicCoder();
        int x = coder.encode(d);
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(coder.decode(0b1100001)));
        
    }
}
