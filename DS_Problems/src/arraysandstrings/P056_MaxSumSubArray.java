package arraysandstrings;

import java.util.Arrays;

import org.junit.Test;

//
//Write a program to fetch the sub array of length k from a given array and the sub array must have maximum sum of all combinations (without sorting the array)
//
//Input: [4,2,11,1,23,2,3,15,14] , k = 3
//Output: [11,1,23]
//
//Input: [4,2,1,-7,23,2,-3,15,14], k = 4
//Output: [2,-3,15,14]

public class P056_MaxSumSubArray {
	
@Test
public void dataSetOne()
{
	int[] input= {4,2,11,1,23,2,3,15,14};
	int k=3;
	System.out.println(Arrays.toString(maxSumSubArray(input,k)));
}

@Test
public void dataSetTwo()
{
	int[] input= {4,2,1,-7,23,2,-3,15,14};
	int k=4;
	System.out.println(Arrays.toString(maxSumSubArray(input,k)));
}

//Declare 2 variables start and end
//loop till start-end ==k, 
	//keep adding the elements
	//increment end
//loop till the length of array
//if sum is max store start and end
//increment start and subract element at start
//increment end and add element at end
//check if sum is max

	

private int[] maxSumSubArray(int[] array,int k)
{
	int outputStart=0;int outputEnd=0;
	
	if(k<array.length)
	{
		int start=0;int end=0;int maxsum=0;int currentSum=0;
		
		while((end-start)!=k)
		{
			currentSum+=array[end];
			end++;
		}
		while(end<array.length)
		{
			if(maxsum<currentSum)
			{
				maxsum=currentSum;
				outputStart=start;
				outputEnd=end;			
			}
			currentSum-=array[start];
			start++;
			currentSum+=array[end];
			end++;
		}
		
		
	}
	return Arrays.copyOfRange(array, outputStart, outputEnd);
}
}
