import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class P007_SubArrayOfDesiredSum {
	
@Test
public void dataSetOne()
{
	int[] array= {1,7,4,3,4,1,2,1,5,1};
	int requiredSum=7;
Map<Integer, Integer> subArraySum = subArraySum(array,requiredSum);
System.out.println("One");
for(Map.Entry<Integer,Integer> eachArray :subArraySum.entrySet())
{
	System.out.println("----");
	for(int i=eachArray.getKey();i<=eachArray.getValue();i++)
	{
		System.out.print(array[i]);
		
	}
}
	
	
}

	
	  @Test public void dataSetTwo() 
	  { 
		  int[] array= {1,4,3,1,1,2,0,8,9,7,7}; 
		  int
	  requiredSum=7; 
		  Map<Integer, Integer> subArraySum = subArraySum(array,requiredSum);
		  System.out.println("One");
		  for(Map.Entry<Integer,Integer> eachArray :subArraySum.entrySet())
		  {
		  	System.out.println("----");
		  	for(int i=eachArray.getKey();i<=eachArray.getValue();i++)
		  	{
		  		System.out.print(array[i]);
		  		
		  	}
		  }
	  
	  }
	  
	  @Test public void dataSetThree() 
	  { int[] array= {1,2,3,0,8,9,3,4,8,9,6};
	  int requiredSum=7;
	  
	  Map<Integer, Integer> subArraySum = subArraySum(array,requiredSum);
	  System.out.println("One");
	  for(Map.Entry<Integer,Integer> eachArray :subArraySum.entrySet())
	  {
	  	System.out.println("----");
	  	for(int i=eachArray.getKey();i<=eachArray.getValue();i++)
	  	{
	  		System.out.print(array[i]);
	  		
	  	}
	  }}
	 
//Solution 1
private Map<Integer,Integer> subArraySum1(int[] array,int requiredSum)
{
	int currentSum=0;int tempSum=0;
	Map<Integer,Integer> subArray=new HashMap<>();
	for(int i=0;i<array.length;i++)
	{
		currentSum=0;
		if(array[i]==requiredSum)//O[N]
		{
			subArray.put(i, i);
			
		}
		else if(array[i]<=requiredSum)
		{
		currentSum=array[i];
		for(int j=i+1;j<array.length;j++)
		{
			tempSum=currentSum+array[j];
		
			if(tempSum==requiredSum)
			{
				subArray.put(i,j);
				break;
			}
			else if(tempSum<requiredSum)
			{
				currentSum=tempSum;
			}
			else
			{
				break;
			}
		}
		
		}
		
	}
	return subArray;
	
	//throw new RuntimeException("No match");
}

//Solution 2(Using  windows Sliding technique)

private Map<Integer,Integer> subArraySum(int[] array,int requiredSum)
{ 
	int startIndex=0;int windowSum=0;
	Map<Integer,Integer> subArrays=new HashMap<>();
	for(int i=0;i<array.length;i++)
	{
		windowSum=windowSum+array[i];
		if(windowSum==requiredSum)
		{
			subArrays.put(startIndex, i);
		}
		while(windowSum>requiredSum)
		{
			windowSum=windowSum-array[startIndex];
			startIndex++;
			
		}
		if(windowSum==requiredSum)
		{
			subArrays.put(startIndex, i);
		}
		
		
	}
	return subArrays;

}

//Solution 2 (Hashing)
private void subArraySum2(int[] array,int requiredSum)
{ 

}}
