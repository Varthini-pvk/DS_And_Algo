package arraysandstrings;

import java.util.Arrays;

import org.junit.Test;

public class P070_MaximumSubArraySequence {

	@Test
	public void dataSetOne()
	{
		int[] array= {-2,-3,4,-1,-2,1,5,-3};
		System.out.println(Arrays.toString(maxSum(array)));
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] array= {11,-3,-4,-1,-2,1,5,-3};
		System.out.println(Arrays.toString(maxSum(array)));
	}
	
	@Test
	public void dataSetThree()
	{
		int[] array= {11,-5,2,-3,-7,1};
		System.out.println(Arrays.toString(maxSum(array)));
	}
	
	
	public int[] maxSum(int[] array)
	{
		int maxSum=0;
		int localSum=0;
		int start=0; int end=0;
		int outputStart=0;int outputEnd=0;
		while(end<array.length)
		{
			localSum+=array[end];
			end++;
			if(localSum<0)
			{
				localSum=0;
				start++;
			}
			else
			{
				if(maxSum<localSum)
				{
					maxSum=localSum;
					outputStart=start;
					outputEnd=end;
					
				}
			}
		}
		return Arrays.copyOfRange(array, outputStart,outputEnd);
	}
}
