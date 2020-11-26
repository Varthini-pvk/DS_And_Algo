package Learnings;

import org.junit.Test;

public class L004_findSubArrayOFSumK_Recurssion {
	
	@Test
	public void dataSetOne()
	{
		int[] input= {16,2,4,6,10,16};
		int k=16;
		System.out.println(countSubArray(input,k,input.length-1));
	}
	
	private int countSubArray(int[] input,int k,int pointer)
	{
		
		if(k==0)
		{
			return 1;
		}
		if(pointer<0)
		{
			return 0;
		}
		if(k<input[pointer])
		{
		return	countSubArray(input,k,pointer-1);
		}
		else
		{
			return countSubArray(input,k,pointer-1)+countSubArray(input,k-input[pointer],pointer-1);
			
		}
	}

}
