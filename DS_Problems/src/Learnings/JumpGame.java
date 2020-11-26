package Learnings;

import org.junit.Test;

//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//
// 
//
//Example 1:
//
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//Example 2:
//
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
// 
//
//Constraints:
//
//1 <= nums.length <= 3 * 10^4
//0 <= nums[i][j] <= 10^5

public class JumpGame {

//@Test
//public void dataSetOne()
//{
//	int[] input= {2,3,1,1,4};
//	System.out.println(JumpGame(input));
//
//}

@Test
public void dataSetTwo()
{
	int[] input= {0,2,3};
	System.out.println(JumpGame(input));
}
	
//BackTracking Recurrsive approach

public Boolean JumpGame(int[] array)
{ 
	int j=0;
	for(int k=0;k<array.length-1;k++)
	{
	j=0;
	for(int i=k;i<array.length-1;i=j)
	{
		j=j+array[i];
		if(j==array.length-1)
		{
			return true;
		}
		if(array[i]==0)
		{
			break;
		}
	}
	}
	return false;
}
	
}
