package ArraysAndStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class P027_MedianOfTwoArrays {


	// Given two sorted arrays A1, A2. Write a code to find median of the arrays
	//
	//	Example 1:
	//
	//	Input:
	//
	//	A1 = [1,3]
	//	A2 = [2]
	//
	//	Output: 2
	//
	//	Example 2:
	//
	//	Input:
	//
	//	A1 = [1,2]
	//	A2 = [3,4]
	//
	//	Output: 2.5


	
	//Median equal to n+1/2(middle number) or n+(n+1)/2 (average of middle numbers), if the numbers are sorted.
	//DataSets
	@Test
	public void setOne()
	{
		int[] inputOne= {1,3};
		int[] inputTwo= {2};
		System.out.println("One: "+String.format("%.2f", findMedian(inputOne,inputTwo)));

	}

	@Test
	public void setTwo()
	{
		int[] inputOne= {1,1,3};
		int[] inputTwo= {2,2};
		System.out.println("Two: "+String.format("%.2f", findMedian(inputOne,inputTwo)));
	}

	@Test
	public void setThree()
	{
		int[] inputOne= {1,2,7,9,10};
		int[] inputTwo= {3,4,11,56,88,90};
		System.out.println("Three: "+String.format("%.2f", findMedian(inputOne,inputTwo)));

	}
	@Test
	public void setFour()
	{
		int[] inputOne= {-1,2};
		int[] inputTwo= {3,4,5};
		System.out.println("Four: "+String.format("%.2f", findMedian(inputOne,inputTwo)));

	}
	@Test
	public void setFive()
	{
		int[] inputOne= {1,2};
		int[] inputTwo= {3,4};
		System.out.println("Five: "+String.format("%.2f", findMedian(inputOne,inputTwo)));
	}
	
	@Test
	public void setSix()
	{
		int[] inputOne= {0,0,0,0,0};
		int[] inputTwo= {-1,0,0,0,0,0,1};
		System.out.println("Six: "+String.format("%.2f", findMedian(inputOne,inputTwo)));
	}


	//Solution 1

	//1. Create a new Array of length equal to the length of array One and Array Two
	//2. Loop through the first array and add all elements to the new array
	//3. Loop through the second array and add all elements to the new array
	//4.sort the array
	//5. Determine the length of temp array
	//6.if odd, return n/2
	//7.if even return (n/2+(n+1)/2)2, where n is the element at the respective index

	private float findMedian1(int[] arrayOne,int[] arrayTwo)
	{
		List<Integer>arrayThree=new ArrayList<>();
		float sum=0;
		for(int i=0;i<arrayOne.length;i++)//O[N]
		{
			arrayThree.add(arrayOne[i])	;	
		}
		for(int i=0;i<arrayTwo.length;i++)//O[N]
		{
			arrayThree.add(arrayTwo[i]);
		}
		Collections.sort(arrayThree);//O[nlogn]
		
		int midSize=arrayThree.size()/2;//O[1]

		if(arrayThree.size()%2==0)//O[1]
		{
			return (arrayThree.get(midSize-1)+arrayThree.get(midSize))/2;
		}
		else
		{
			return arrayThree.get(midSize);
		}
		//Total time Complexity=O[nlogn]

	}

	//Solution 2
	//1.Merge the two Sorted array
	//Assign a pointer and loop array one form 0->last
	//Assign another pointer and another array from 0->last
	//compare the elements from both arrays and put the lowest in a temp array and increment the respective pointer
	//Continue loop till the length of the smallest array
	//And the remaining element of the largest number to the temp Array
	
	//2.Determine the length of temp array
	//if odd, return n/2
	//if even return (n/2+(n+1)/2)2, where n is the element at the respective index
	
	private double findMedian(int[] arrayOne,int[] arrayTwo)
	{
		List<Integer>arrayThree=new ArrayList<>();//O[1]
		int i=0;int j=0;int absoluteOne=0;int absolutetwo=0;

		//Merging two sorted array to get a sorted list
		while(i<arrayOne.length&&j<arrayTwo.length)//O[N]or[O[M]
		{
			absoluteOne=Math.abs(arrayOne[i]);
			absolutetwo=Math.abs(arrayTwo[j]);
			if(absoluteOne==absolutetwo)
			{
				arrayThree.add(arrayOne[i]);
				arrayThree.add(arrayTwo[j]);
				i++;j++;
			}
			else if(absoluteOne<absolutetwo)
			{
				arrayThree.add(arrayOne[i]);
				i++;
			}
			else
			{
				arrayThree.add(arrayTwo[j]);
				j++;
			}
		}
		
		//To put the remaining elemnts of longer array
		
		for(;i<arrayOne.length;i++)//O[N-M]
		{
			arrayThree.add(Math.abs(arrayOne[i]));
		}


		for(;j<arrayTwo.length;j++)//O[M-N]
		{
			arrayThree.add(Math.abs(arrayTwo[j]));
		}
		
		//To find the median

		int midSize=arrayThree.size()/2;//O[1]

		if(arrayThree.size()%2==0)//O[1]
		{
			return(double) (arrayThree.get(midSize-1)+arrayThree.get(midSize))/2;
		}
		else
		{
			return (double) arrayThree.get(midSize);
		}

	}
	//Total time complexity=O[N*M]
}