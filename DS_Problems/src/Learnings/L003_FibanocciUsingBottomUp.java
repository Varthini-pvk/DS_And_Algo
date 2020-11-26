package Learnings;

import java.util.Arrays;

import org.junit.Test;

public class L003_FibanocciUsingBottomUp 
{
	@Test
	public void dataSetOne()
	{
		int n=8;
		
		findFib(n);
	}


	private void findFib(int n)
	{
		if(n<=1)
		{
			System.out.println(1);
		}
		int[] intermediate=new int[n+1];
		
		intermediate[0]=1;
		intermediate[1]=1;
		for(int i=2;i<=n;i++)
		{
			intermediate[i]=intermediate[i-1]+intermediate[i-2];
		}
		System.out.println(Arrays.toString(intermediate));
	}
}
