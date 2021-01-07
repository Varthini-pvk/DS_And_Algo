package Learnings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class L005_TwoSumSortedArray 
{
	//@Test
	public void dataSetOne()
	{
		int[] array= {1,4,5,7,8,9,11};
		int k=12;
		for(Integer[] each:indicesToGetSum(array,k))
		{
			System.out.println(Arrays.toString(each));
		}
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] array= {1,4,5,7,7,9,11};
		int k=11;
		for(Integer[] each:indicesToGetSum(array,k))
		{
			System.out.println(Arrays.toString(each));
		}
	}
	
	//Solution 1(Two Pointers Method)
	
	//Declare Two pointers start=0 and end =arraySize;
	//Add the values at 2 pointers
	//if the sum is equal to target, add the indexes to result
	//else if sum is less than target, increment start
	//else if the sum is greater than target, decrement end
	//Continue till start is less than End
	
	
	private List<Integer[]> indicesToGetSum(int[] numbers, int target)
	{
		List<Integer[]> output=new ArrayList<>();
		int start=0;int end=numbers.length-1;
        int temp=0;
        while(start<end)
        {
            temp=numbers[start]+numbers[end];
            
            if(temp==target) output.add(new Integer[] {start+1,end+1});

           if (temp<target) start++;
            
            else end--;
       }
        return output;
    }
	
	
	//Solution 2(Using Hashing)
	
	//Loop through the array
	//Add K-current element as key and index as value in Map, if the current element is not present 
	//in the map
	//if the current element is present in Map, return the current index and index value of the key in the map to result set
	//Remove the key from the map
	//Return the result
	
	private List<Integer[]> indicesToGetSum2(int[] array, int sum)
	{
		List<Integer[]> output=new ArrayList<>();
		Set<Integer> temp=new HashSet<>();
		Map<Integer,Integer> refMap=new HashMap<Integer,Integer>();
		for(int i=0;i<array.length&&array[i]<=sum;i++)
		{
			if(temp.add(array[i]))
			{
				if(refMap.containsKey(array[i]))
				{
					output.add(new Integer[] {i,refMap.get(array[i])});
					temp.add(array[i]);
				}
				else
					 refMap.put(sum-array[i], i);
			}
		}
		return output;
	}
}
