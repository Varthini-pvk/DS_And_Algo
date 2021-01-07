package arraysandstrings;

import java.util.Arrays;

import org.junit.Test;

//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//Note:
//
//The number of elements initialized in nums1 and nums2 are m and n respectively.
//You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
//Example:
//
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]

public class P061_MergeTwoArrays_NoextraArray {
	
@Test
public void dataSetone()
{
	int[] nums1= {1,2,3,0,0,0};
	int[] nums2= {2,5,6};
	merge(nums1,nums2);
}

@Test
public void dataSetTwo()
{
	int[] nums1= {8,9,10,10,0,0,0,0,0};
	int[] nums2= {5,13,13,14,15};
	merge(nums1,nums2);
}


@Test
public void dataSetThree()
{
	int[] nums1= {5,13,13,14,15,0,0,0,0};
	int[] nums2= {8,9,10,10};
	merge(nums1,nums2);
}

//Get Two Input Arrays one and two
//Intialize two variables i and j, i= 0, and j = length of firstArray
//loop through the size of array one
	//for each element , compare if its is smaller than first element of array two
	//if not swap the two values
	//when ever h=the swap happens,
	//	check if the first element is order in the second array, else move that element to correct position

private void merge(int[] arrayOne,int[] arrayTwo)
{
	int j=0;int temp=0;int k=1;
	for(int i=0;i<arrayOne.length;i++)
	{
		if(arrayOne[i]>arrayTwo[j])
		{
			temp=arrayOne[i];
			arrayOne[i]=arrayTwo[0];
			arrayTwo[0]=temp;
			
			while(k<arrayTwo.length&&arrayTwo[k]<arrayTwo[j])
			{
					temp=arrayTwo[j];
					arrayTwo[j]=arrayTwo[k];
					arrayTwo[k]=temp;
					j++;k++;
			}
			j=0;k=1;
				
		}
	}
	System.arraycopy(arrayTwo, 0, arrayOne, arrayOne.length-arrayTwo.length, arrayTwo.length);
	System.out.println(Arrays.toString(arrayOne));
}
}
