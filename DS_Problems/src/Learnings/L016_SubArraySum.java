package Learnings;

import org.junit.Test;

//
//Given an integer array nums, find the contiguous subarray (containing at least one number) 
//which has the largest sum and return its sum.
public class L016_SubArraySum 
{

	@Test
	public void dataSetOne()
	{
		int[] array= {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(findMaxSum(array));
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] array= {11,-5,2,-3,-7,1};
		System.out.println(findMaxSum(array));
	}
	
	@Test
	public void dataSetThree()
	{
		int[] array={-2,-3,4,-1,-2,1,5,-3};
		System.out.println(findMaxSum(array));
	}
	
	@Test
	public void dataSetFour()
	{
		int[] array={4,-1,2,1};
		System.out.println(findMaxSum(array));
	}
	
	//Solution 1(BruteForce)[O[n^2]
	//Loop through the array
	//starting from each element i , find sum for all subarrays
	//return the Maximum Sum
	
	public int findMaxSum1(int[] array)
	{
		int sum=0;int max=Integer.MIN_VALUE;
		for (int i=0;i<array.length;i++)
		{
			sum=array[i];
			for(int j=i+1;j<array.length;j++)
			{
				sum+=array[j];
				max=Math.max(sum, max);
			}
		}
		return max;
	}
	
	//Solution 2(Kandane's Algorithm)[O[N]]
	
	//Declare Two pointer start, end=0
	//Add the value at end to local Sum
	//if the Local Sum becomes less than zero , reset the sum to zero 
	//Else check if the local sum is maximum
	//return the maximum Sum
	
	public int findMaxSum(int[] array)
	{
		int maxSum=Integer.MIN_VALUE;
		int localSum=0;
		int start=0;int end=0;
		while(end<array.length)
		{
			localSum+=array[end];
			end++;
			if(localSum<0)
			{
				localSum=0;
				//start++;
			}
			maxSum=Math.max(localSum, maxSum);
		}
		return maxSum;
	}
	
	//Solution 3(Divide and Conquer)
	
	//Find mid point=(left+right)/2
	//if left<right
	//Divide further 
	//add the left sum and right sum
	
	
//	private int  findmaxSum(int[] array)
//	{
//		findMaxRec(0,array.length-1,array);
//	}
//	
//	private void findMaxRec(int start,int end,int[] array)
//	{
//		if(left<right)
//		{
//			int mid=(left+right)/2;
//			findMaxRec(start,mid,array);
//			findMaxRec(mid+1,end,array);
//			sum(findMaxRec(start,mid,array))
//			
//			
//		}
//		else
//			return array[left];
//	}
//	
}
