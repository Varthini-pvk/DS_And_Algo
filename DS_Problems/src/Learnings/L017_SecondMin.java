package Learnings;

import java.util.Arrays;

import org.junit.Test;

public class L017_SecondMin
{

	@Test
	public void dataSetOne()
	{
		int[] array= {1,4,5,0,-8};
		System.out.println(findSecondMin(array));
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] array= {1,4,5,0,-8,-8};
		System.out.println(findSecondMin(array));
	}
	

	@Test
	public void dataSetThree()
	{
		int[] array= {1,4,5,0,8,8};
		System.out.println(findSecondMin(array));
	}
	
	//Bruteforce
	
	//Loop through the array twice
	//Find the minimum numbers by comparing against each other element
	//return the second minimum
	
	private int findSecondMin1(int[] array)
	{
		int temp=0;
		for(int i=0;i<2;i++)
		{
			for(int j=i;j<array.length;j++)
			{
				if(array[i]>array[j])
				{
				temp=array[i];
				array[i]=array[j];
				array[j]=temp;
				}
			}
		}
		return array[1];
	}
	
	//Solution 2 
	//Using Arrays.sort
	private int findSecondMin2(int[] array)
	{
		Arrays.sort(array);
		return array[1];
	}
	
	//Solution 3
	
	//Declare two variables min and second Min
	
	//Loop through the length of array
	//Find min  comparing current element and min
	//Find second min by comparing second min and current element
	
	private int  findSecondMin(int[]array)
	{
		int min=Integer.MAX_VALUE,secondMin=Integer.MAX_VALUE;
		for(int i=0;i<array.length;i++)
		{
			if(array[i]<=min)
			{
				secondMin=min;
				min=array[i];
			}
			if(array[i]>min&&array[i]<=secondMin)
			{
				secondMin=array[i];
			}
		}
		return secondMin;
	}
}


