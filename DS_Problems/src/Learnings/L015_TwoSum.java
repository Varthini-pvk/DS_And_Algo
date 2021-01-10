package Learnings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class L015_TwoSum 
{
	@Test
	public void dataSetOne()
	{
		int[] array= {2,7,11,15};
		int target=9;
		twoSum(array,target);
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] array= {3,2,4};
		int target=6;
		twoSum(array,target);
	}
	
	//BruteForce[O[n]]
	public void twoSum1(int[] array, int target)
	{
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array.length;j++)
			{
				if(i!=j)
				{
				if(array[i]+array[j]==target)
				{
					System.out.println(i+" "+j);
					return;
				}
				}
			}
		}
	}
	
	//Sort and Two Pointer[O[Nlogn]
	public void twoSum(int[] array,int target)
	{
		Map<Integer,Integer> refMap=new HashMap<Integer,Integer>();
		for(int i=0;i<array.length;i++)
		{
			
				refMap.put(array[i], i);

		}
		Arrays.sort(array);
		int start=0; int end=array.length-1;
		while(start<end)
		{
			if(array[start]+array[end]==target)
			{
				System.out.println(refMap.get(array[start])+" "+refMap.get(array[end]));
				return;
			}
			else if(array[start]+array[end]>target) end--;
			
			else start++;
		}
	}
	
	//Solution 3(Usinh hashMap)[O[N]]
	public void twoSum3(int[] array, int target)
	{
		Map<Integer,Integer> refMap=new HashMap<Integer,Integer>();
		for(int i=0;i<array.length;i++)
		{
			if(refMap.containsKey(array[i]))
			{
				System.out.println(i+" "+refMap.get(array[i]));
			}
			else
			{
				refMap.put(target-array[i], i);
			}
		}
	}

}
