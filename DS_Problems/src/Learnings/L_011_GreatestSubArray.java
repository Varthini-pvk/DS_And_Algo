package Learnings;

import java.util.Arrays;

import org.junit.Test;

//An array A is larger than some array B if for the first index i where A[i] != B[i], A[i] > B[i].
//For example, consider 0-indexing:
//[1,3,2,4] > [1,2,2,4], since at index 1, 3 > 2.
//[1,4,4,4] < [2,1,1,1], since at index 0, 1 < 2.
//A subarray is a contiguous subsequence of the array.
//Given an integer array nums of distinct integers, return the largest subarray of nums of length k.
// 
//Example 1:
//Input: nums = [1,4,5,2,3], k = 3
//Output: [5,2,3]
//Explanation: The subarrays of size 3 are: [1,4,5], [4,5,2], and [5,2,3].
//Of these, [5,2,3] is the largest.
//Example 2:
//Input: nums = [1,4,5,2,3], k = 4
//Output: [4,5,2,3]
//Explanation: The subarrays of size 4 are: [1,4,5,2], and [4,5,2,3].
//Of these, [4,5,2,3] is the largest.



//1. Loop through the Array till size k, store the elements as BiggerSubArray
//2. Loop from k+1 to length of the array
//3.remove the first element and add the next element to the subarray
//4. Compare the BiggerSubArray and current SubArray and assign the bigger in prev sub array
//5. return the BiggerSubArray

public class L_011_GreatestSubArray 
{
	@Test
	public void dataSetOne()
	{
		int[] input= {1,4,5,2,3};
		int k=3;
		System.out.println(Arrays.toString(findBiggestSubArray(input,k)));
	}

	@Test
	public void dataSetTwo()
	{
		int[] input= {1,4,5,2,3};
		int k=4;
		System.out.println(Arrays.toString(findBiggestSubArray(input,k)));
	}

	@Test
	public void dataSetThree()
	{
		int[] input= {1,1,1,4};
		int k=3;
		System.out.println(Arrays.toString(findBiggestSubArray(input,k)));
	}

	@Test
	public void dataSetFour()
	{
		int[] input= {1,1,1,4,5};
		int k=3;
		System.out.println(Arrays.toString(findBiggestSubArray(input,k)));
	}

	@Test
	public void dataSetFive()
	{
		int[] input= {4,6,4,2,6,6,6};
		int k=3;
		System.out.println(Arrays.toString(findBiggestSubArray(input,k)));
	}
	@Test
	public void dataSetSix()
	{
		int[] input= {4,6,2,6,2,2};
		int k=3;
		System.out.println(Arrays.toString(findBiggestSubArray(input,k)));
	}
	@Test
	public void dataSetSeven()
	{
		int[] input= {4,0,6,0,2,6,2,2};
		int k=3;
		System.out.println(Arrays.toString(findBiggestSubArray(input,k)));
	}
	@Test
	public void dataSetEight()
	{
		int[] input= {4,0,2,0,2,4,0,3};
		int k=3;
		System.out.println(Arrays.toString(findBiggestSubArray(input,k)));
	}

	private int[] findBiggestSubArray(int[] array, int k)
	{
		int length=array.length;
		if(k>length) throw new RuntimeException();

		int CurrentarrayCount=1;int BiggerarrayCount=0;int localCount=0;
		int[] result=new int[k];

		while(CurrentarrayCount+localCount<=array.length-k)
		{		
			while(localCount<k)
			{
				if(array[CurrentarrayCount+localCount]==array[BiggerarrayCount+localCount])	
					localCount++;
				else
				{
					if(array[CurrentarrayCount+localCount]>array[BiggerarrayCount+localCount])
						BiggerarrayCount=CurrentarrayCount;
					break;
				}
			}
			localCount=0;
			CurrentarrayCount++;
		}

		int j=0;
		for(int i=BiggerarrayCount;i<k+BiggerarrayCount;i++)
		{
			result[j]=array[i];
			j++;
		}
		return result;
	}


}
