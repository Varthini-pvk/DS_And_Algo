package arraysandstrings;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

//Given a string, find the length of the longest substring T that 
//contains at most k distinct characters.

//Example 1: 
//
//Input: s = "eceba", k = 2
//Output: 3
//Explanation: T is "ece" which its length is 3.
//
//Example 2:
//
//Input: s = "aa", k = 1
//Output: 2
//Explanation: T is "aa" which its length is 2.

public class P065_LongestSubArrayWithKDistinct {
	
	
	
	@Test
	public void dataSetOne()
	{
		String input="eceba";
		int k=2;
		System.out.println("One:"+findLongestSubString(input,k));
	}

	
	@Test
	public void dataSetTwo()
	{
		String input="aa";
		int k=1;
		System.out.println("Two:"+findLongestSubString(input,k));
	}
	

	@Test
	public void dataSetThree()
	{
		String input="aabab";
		int k=2;
		System.out.println("Three:"+findLongestSubString(input,k));
	}
	
	@Test
	public void dataSetFour()
	{
		String input="ABCDEFSFSl";
		int k=2;
		System.out.println("Four:"+findLongestSubString(input,k));
	}
	
	@Test
	public void dataSetFive()
	{
		String input="ecebaaaaee";
		int k=2;
		System.out.println("Five:"+findLongestSubString(input,k));
	}
	
	@Test
	public void dataSetSix()
	{
		String input="bacaab";
		int k=2;
		System.out.println("Six:"+findLongestSubString(input,k));
	}
	
	
	@Test
	public void dataSetSeven()
	{
		String input="aabccc";
		int k=2;
		System.out.println("Seven:"+findLongestSubString(input,k));
	}
	
	
	
	
	//Solution 1(Sliding window+HashSet)
	
	//Get the input String and K value
	//Set Two pointers start and end both equal to zero
	//Set a count variable to zero
	//Loop through the string, till end pointer is less than the length of string
	//Add the  element at end point to a temp set
		//if the add returns true, increment count
		//check if the count equals to K
			//Check if end-start is max and assign to max variable
			//remove the element at start position form set, if remove returns true
				//Decrement count
			//increment Start
	//Increment end
	private int findLongestSubString1(String input, int k)
	{
		
		
		char[] inputArray=input.toCharArray();
		int start=0;int end=0;int count=0;int maxLength=0;
		Set<Character> temp=new HashSet<>();
		while(end<inputArray.length)
		{
			if(temp.add(inputArray[end])) count++;//O[1]
			end++;
			if(count>k)
			{
				maxLength=Math.max(maxLength, end-start-1);
				if(temp.remove(inputArray[start])) count--;//0[1]
				start++;
			}
			if(end==inputArray.length)
			{
				maxLength=Math.max(maxLength, end-start);
			}
			
			
		}
		return maxLength;
		
	}
	//Time Complexity=O[N]
	
	//Solution 2(Sliding window+ASCII array)
	
	//Get the input String and K value
	//Set Two pointers start and end both equal to zero
	//Set a count variable to zero
	//Loop through the string, till end pointer is less than the length of string
	//if the value at the index of the ascii value of character is zero, increment count
	//Increment  the occurrence of the element at end pointer in the array 
	//check if the count is greater than K
			//Check if end-start is max and assign to max variable
			//Decrement  the occurrence of the element at start pointer in the array 
			//if the value  at the index of the ascii value of character(at start) is zero, decrement count
			//increment Start
	//Increment end
	
	private int findLongestSubString(String input, int k)
	{
		char[] inputArray=input.toCharArray();
		int start=0;int end=0;int count=0;int maxLength=0;
		int[] tempArray=new int[256];
		while(end<inputArray.length)
		{
			if(tempArray[inputArray[end]]==0)   count++;
			tempArray[inputArray[end]]++;
			end++;
			
			if(count>k)
			{
				maxLength=Math.max(maxLength, end-start-1);
				tempArray[inputArray[start]]--;
				if(tempArray[inputArray[start]]==0)   count--;
				start++;
			}
			if(end==inputArray.length)
			{
				maxLength=Math.max(maxLength, end-start);
			}
			
			
		}
		return maxLength;
		
	}
	
	//Time Complexity=O[N]

}
