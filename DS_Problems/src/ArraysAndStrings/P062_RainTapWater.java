package ArraysAndStrings;

import org.junit.Test;

//
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
//
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
//In this case, 6 units of rain water (blue section) are being trapped





public class P062_RainTapWater {
	
	
@Test
public void dataSetOne()
{
	int[] input= {0,1,0,2,1,0,1,3,2,1,2,1};
	System.out.println(ComputeWaterAmount(input));
	
}

//Loop Through the length of array
//for each element traverse in both direction to find the max element
//Claculate the difference between the current eleemnt and the minimum of two max element--> water stored in that point
//Add water stored in all points and return the output

public int ComputeWaterAmount(int[] array)
{
	int waterAmount=0;
	for(int i=0;i<array.length;i++)
	{
		int leftMax=array[i];
		int rightMax=array[i];
		for(int j=i-1;j>=0;j--)
		{
			if(array[j]>leftMax)
			{
				leftMax=array[j];
			}
		}
		for(int j=i+1;j<array.length;j++)
		{
			if(array[j]>rightMax)
			{
				rightMax=array[j];
			}
		}
		waterAmount=waterAmount+(Math.min(leftMax-array[i], rightMax-array[i]));
		
	}
	return waterAmount;
}

}
