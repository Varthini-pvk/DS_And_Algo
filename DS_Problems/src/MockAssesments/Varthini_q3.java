package MockAssesments;

import org.junit.Test;

//3) Given an input array and two unique numbers, find the smallest distance between those 2 numbers
//Example:a
//
//Input1: [5,6,8,9,1,4,1] Input2: 8,1 Output: 2
//   a) If there are no occurances of the unique numbers, then throw exception
//   b) If there are multiple matches, the least distance should be considered


public class Varthini_q3 
{
	
@Test
public void dataSetOne()
{
	int[] input= {5,6,8,9,1,4,1};
	int num1=8;
	int num2=1;
	System.out.println(findMinDiff(input,num1,num2));
	
}

@Test
public void dataSetTwo()
{
	int[] input= {5,6,8,8,9,1,4,1};
	int num1=8;
	int num2=1;
	System.out.println(findMinDiff(input,num1,num2));
	
	
}

@Test
public void dataSetThree()
{
	int[] input= {5,6,8,9,1,4,1};
	int num1=3;
	int num2=1;
	System.out.println(findMinDiff(input,num1,num2));
	
}

//Solution 1(BruteForce)

//1. Loop through the length of Array(Outer loop)
//2. l


//Solution 2(Using Two Pointers)
//Declare Two variables i and j, set i=0; and j=length of the array
//Loop through the array
	//increment i till value at i is equal to first number
	//Increment j till value at i is equal to first number
	//Check if j-i is minimum,
	//Continue loop by incrementing i and j
//return the minimum difference

private int findMinDiff(int[] array, int num1,int num2)
{
	int i=0;int j=0; int output=array.length+1;
	Boolean flag=false;
	while(j<array.length-1&&i<array.length-1)
	{
		if(array[i]!=num1)
		i++;
		if(array[j]!=num2)
		j++;
		if(array[i]==num1&&array[j]==num2)
		{
		flag=true;
		output=Math.min(output, j-i);
		i++;
		if(i>j)
		j++;
		}
		
	}
	if(flag)
	return output;
	throw new RuntimeException("Number not Present in Array");
}

}
