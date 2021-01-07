package Learnings;

import org.junit.Test;

public  class L010_findNearestPrimeNumber 
{
	@Test
	public void dataSetOne()
	{
		int n=135;
		System.out.println(findNearestPrime(n));
	}
	

	@Test
	public void dataSetTwo()
	{
		int n=133;
		System.out.println(findNearestPrime(n));
	}
	
	private int findNearestPrime(int input)
	{
		if(input<2) 
		throw new RuntimeException("Not Valid");
		
		int i=input,j=input-1;
		while(i<Integer.MAX_VALUE)
		{
			if(j>=2)
			{
			if(isPrime(j)) return j;
			}
			if(isPrime(i)) return i;
			j--;i++;
		}
		throw new RuntimeException("Not Valid");
	}
	
	private Boolean isPrime(int i)
	{
		for(int j=2;j<i/2;j++)
		{
			if(i%j==0) return false;
		}
		return true;
	}

}
