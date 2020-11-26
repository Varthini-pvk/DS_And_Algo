package ArraysAndStrings;
import java.util.Arrays;

import org.junit.Test;

public class P015_FindSumExcluded 
{

//Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//Input:  [1,2,3,4]
//Output: [24,12,8,6]
	
//DataSet
	
@Test
public void dataSetOne()
{
	int[] input = {1,2,3,4};
	int[] findProduct = findProduct(input);
	System.out.println("One");
	System.out.println(Arrays.toString(findProduct));
}

@Test
public void dataSetTwo()//With Duplicates
{
	int[] input = {2,3,4,2,3,4,2,3};
	System.out.println("Two");
	int[] findProduct = findProduct(input);
	System.out.println(Arrays.toString(findProduct));
}

@Test
public void dataSetThree()//with negative Number
{
	int[] input= {-4,-5,-3,0,3,4};
	System.out.println("Three");
	int[] findProduct = findProduct(input);
	System.out.println(Arrays.toString(findProduct));
}

@Test
public void dataSetFour()//with negative Number
{
	int[] input= {-4,-4,-4,-4,-4};
	System.out.println("Four");
	int[] findProduct = findProduct(input);
	System.out.println(Arrays.toString(findProduct));
}

//Solution 1
//Loop Through the array
//For current element exclude and the element and calculate the product and store in result array

private int[] findProduct1(int[] array)
{
int[] result=new int[array.length];
Arrays.fill(result, 1);
for(int i=0;i<array.length;i++)
{
	for(int j=0;j<array.length;j++)//O[N^2]
	{
		if(i!=j)
		{
			result[i]=result[i]*array[j];
		}
	}
}

//Total Time Complexity=O[N^2]
return result;
}
//Solution 2

//loop through the length of Array and find the product of array
//Loop through the length of Array and in result array add product/current element

private int[] findProduct(int[] array)
{
int[] result=new int[array.length];//O[1]
int product=1;int indexOfZero=0;//O[1]


for(int i=0;i<array.length;i++)//O[N]
{
	if(array[i]==0)
	{
		indexOfZero=i;
		continue;
	}
	product=product*array[i];
}
if(indexOfZero>0)
{
	result[indexOfZero]=product;
}
else
{
	for(int i=0;i<array.length;i++)//O[N]
	{
		result[i]=product/array[i];
	}
}
return result;
}
//Total Time Complexity=2*O[1]+2*O[N]==>O[N]
}
