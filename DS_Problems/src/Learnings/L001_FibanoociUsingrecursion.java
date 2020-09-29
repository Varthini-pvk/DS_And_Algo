package Learnings;

import org.junit.Test;

public class L001_FibanoociUsingrecursion 
{

	@Test
	public void dataSetOne()
	{
		int n=5;
		System.out.println(fibanociGen(5));
	}
	private int fibanociGen(int n)
	{
		if(n>2)
		{
			return fibanociGen(n-1)+ fibanociGen(n-2);
		}
		else
			return 1;
	}
}
