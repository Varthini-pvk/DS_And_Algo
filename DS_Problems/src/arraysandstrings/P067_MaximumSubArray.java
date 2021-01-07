package arraysandstrings;

import org.junit.Test;

public class P067_MaximumSubArray {

	@Test
	public void dataSetOne()
	{
		int[] array= {-2,-3,4,-1,-2,1,5,-3};
		System.out.println(maxSum(array));
	}
	
	public int maxSum(int[] array)
	{
		int maxSum=0;
		int localSum=0;
		
		for(int i=0;i<array.length;i++)
		{
			localSum=Math.max(array[i], localSum+array[i]);
			maxSum=Math.max(maxSum, localSum);
		}
		return maxSum;
	}
}
