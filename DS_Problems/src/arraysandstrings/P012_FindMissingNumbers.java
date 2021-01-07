package arraysandstrings;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class P012_FindMissingNumbers {

//Problem:
//	Find all the missing numbers in the given array
//
//	Input: [4,3,2,7,8,2,3,1]
//	Output: [5,6]

//DataSet
	
@Test
public void dataSetOne()
{
	int[] array= {4,3,2,7,8,2,3,1};
	findMissingNumber(array);
	
}

@Test
public void dataSetTwo()//with duplicate numbers
{
	int[] array= {4,3,2,7,8,2,3,1,1,3,4,4};
	findMissingNumber(array);
	
}
@Test
public void dataSetThree()//with negative Numbers
{
	int[] array= {4,3,2,-7,8,2,-3,1};
	findMissingNumber(array);
	
}



//Solution 3
private void findMissingNumber(int[] array)
{
	int start=array[0];int end=array[0];int temp=0;
	Set<Integer> result=new HashSet<Integer>();
	for(int i=0;i<array.length;i++)//O[N]
	{
		if(start>array[i])//to find lowest number
		{			
			start=array[i];
		}
	}
	for(int i=0;i<array.length;i++)//O[N]
	{
		if(start<array[i])//to find largest number
		{			
			start=array[i];
		}
	}
	for(int i=0;i<array.length;i++)
	{
		result.add(array[i]);
	}
	for(int i=start;i<end;i++)//O[N]
	{
		
		if(result.add(i))
		{
			System.out.println(i);
		}
	}
	
}

}
