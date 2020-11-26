package ArraysAndStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//Here, use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//Example 1:
//
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
//Example 2:
//
//Input: nums = [2,0,1]
//Output: [0,1,2]
//Example 3:
//
//Input: nums = [0]
//Output: [0]
//Example 4:
//
//Input: nums = [1]
//Output: [1]

public class P029_arrange3Colors {

	@Test
	public void setOne()
	{
		Integer[] array= {2,0,2,1,1,0};
		sortThreeNumbers(array);
	}
	@Test
	public void setTwo()
	{
		Integer[] array= {2,0,1};
		sortThreeNumbers(array);
	}
	@Test
	public void setThree()
	{
		Integer[] array= {1};
		sortThreeNumbers(array);
	}
	@Test
	public void setFour()
	{
		Integer[] array= {2};
		sortThreeNumbers(array);
	}
	@Test
	public void setFive()
	{
		Integer[] array= {0,1,2,1,0,0,2,2,1,1,0,0};
		sortThreeNumbers(array);
	}

	//Solution 1-using Arrays.sort
	//Solution 2
	private void sortThreeNumbers(Integer[] array)
	{
		if(array.length>1)
		{
			List<Integer> inputList = Arrays.asList(array);
			Set<Integer> temp= new HashSet<Integer>(inputList);
			List<Integer> outputList = new ArrayList<Integer>();
			int i=0;
			for (Integer integer : temp) //O[N]
			{
				i=0;				
				while(i<(Collections.frequency(inputList, integer)))//O[N^2]
				{
					outputList.add(integer);
					i++;
				}
			}

			System.out.println(outputList);
		}
		else
		{
			System.out.println(Arrays.toString(array));
		}

	}


	//Solution 3
	//Sorting using three pointers
	//Declare three pointers, start=0, middle=0, end=arraylength
	//loop and check each element (till middle is less than end)
	//if the element in first and increment the start pointer and middle pointer
	//if the element is one, put the element in index of middle pointer and increment middle pointer
	//if the element is 2, put the element in the index of end and decrement the end pointer
	private void sortThreeNumbers3(Integer[] array)
	{
		if(array.length>1)
		{

			int start=0;int middle=0;int end=array.length-1;int i=0;int temp=0;
			while(middle<end)//O[N]
			{
				if(array[middle]==0)
				{
					temp=array[start];
					array[start]=array[middle];
					array[middle]=temp;
					start++;middle++;
				}
				else if(array[middle]==1)
				{

					middle++;
				}
				else if(array[middle]==2)
				{
					temp=array[end];
					array[end]=array[middle];
					array[middle]=temp;
					end--;
				}

			}}
		System.out.println(Arrays.toString(array));
	}
	//Total time complexity=O[N]
}
