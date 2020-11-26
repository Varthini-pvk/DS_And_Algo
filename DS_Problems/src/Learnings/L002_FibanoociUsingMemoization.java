package Learnings;

import org.junit.Test;

public class L002_FibanoociUsingMemoization {

	@Test
	public void dataSetOne()
	{
		int n=8;
		int[] intermediate=new int[n+1];
		findFib(n,intermediate);
	}

	private int findFib(int n,int[] memo)
	{
		int result=0;
		if(memo[n]!=0)
			return memo[n];
		if(n<=1)
		{
			result= 1;
		}
		else
		{
			result=findFib(n-1,memo)+findFib(n-2,memo);
		}
		memo[n]=result;
		System.out.println(result);
		return result;
	}

}
