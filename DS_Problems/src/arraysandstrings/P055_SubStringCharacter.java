//4) Given 2 input strings, return the minimum window in the first string which will contain 
//all the characters in second string.
//
//Input: str1 = "KSTRKSE", str2 = "KST"
//Output: "KST"
//
//Input: str1 = "KASRTRKSE", str2 = "ST"
//Output: "SRT"

package arraysandstrings;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class P055_SubStringCharacter {

	@Test
	public void dataSetOne()
	{
		String inputOne="KSTRKSE";
		String inputTwo="KST";
		System.out.println(checkSubString(inputOne,inputTwo));
	}

	@Test
	public void dataSetTwo()
	{
		String inputOne="KASRKTRKSTE";
		String inputTwo="ST";
		System.out.println(checkSubString(inputOne,inputTwo));
	}

	@Test
	public void dataSetThree()
	{
		String inputOne="abc";
		String inputTwo="abc";
		System.out.println(checkSubString(inputOne,inputTwo));
	}

	@Test
	public void dataSetFour()
	{
		String inputOne="ADOBECODEBANC";
		String inputTwo="ABC";
		System.out.println(checkSubString(inputOne,inputTwo));
	}

	@Test
	public void dataSetFive()
	{
		String inputOne="a";
		String inputTwo="a";
		System.out.println(checkSubString(inputOne,inputTwo));
	}
	
	@Test
	public void dataSetSix()
	{
		String inputOne="b";
		String inputTwo="a";
		System.out.println(checkSubString(inputOne,inputTwo));
	}
	
	@Test
	public void dataSetSeven()
	{
		String inputOne="bba";
		String inputTwo="ab";
		System.out.println(checkSubString(inputOne,inputTwo));
	}
	//Solution 1(Using Sliding window and HashMap) (Assumes multiple Match)

	//1. Find the smallest String'
	//2. In a hashmap, add the elements and its occurance of the smallest string
	//3. Declare two variables start and end, assign both to zero 
	//4.declare a variable count
	//5. Loop over the length of the larger string
	//	if for the element at end position , the map value is greater than 0
	//		decrease the value and increment count
	//	else
	//		increment end
	//	
	//	if count is equal to zero, check if end-start is minimum length
	//		increment the value for element at start position in map
	//		and increment start

	private String checkSubString(String inputOne, String inputTwo)
	{
		int outputStart=0;int outputEnd=0;int min=inputOne.length()+1;
		Map<Character,Integer> refMap=new HashMap<Character,Integer>();

		for( char i:inputTwo.toCharArray())
		{
			refMap.put(i, refMap.getOrDefault(i, 0)+1);
		}

		int start=0;int end=0;int count=0;
		char[] array=inputOne.toCharArray();

		while(end<inputOne.length())
		{
			if(refMap.containsKey(array[end]))
			{
				if(refMap.get(array[end])>0)
				{
					count++;
				}
				refMap.put(array[end], refMap.get(array[end])-1);
				
				
			}
			end++;
			while(count==inputTwo.length())
			{
				if(min>end-start)
				{
					min=end-start;
					outputStart=start;
					outputEnd=end;
				}
				
				if(refMap.containsKey(array[start]))
				{
					refMap.put(array[start], refMap.get(array[start])+1);
					if(refMap.get(array[start])>0)
					count--;
				}
				start++;
				
			}

		}
		return inputOne.substring(outputStart, outputEnd);

	}
	
	

	//Solution 2 Using Slidingwindow and ASCII array(Assumes only one match)

	//Declare two Arrays of Size 256: refrence array and window Array
	//In refrence array, increment the values as per occurance of characters is string two
	//Copy refrence array to Window array
	//Declare two Variables, start and end and assign both values to zero and count equals to zero
	//Loop till the length of array 
	//For each element at end position,if the elements occurrence is greater than zero in ref array, 
	//in window array decrement	the value and increment count , end
	//if not, increment end only

	//if count is equal to length return the substring from start to end 


	private String checkSubString2(String inputOne, String inputTwo)
	{
		int[] windowArray=new int[256];
		int length=inputTwo.length();
		for(int i=0;i<length;i++)
		{
			windowArray[inputTwo.charAt(i)]++;
		}
		int start=0;int end=0;int count=0;
		int min=inputOne.length()+1;int outputStart=0; int outputEnd=0;
		while(end<inputOne.length())
		{
			if(windowArray[inputOne.charAt(end)]>0)
			count++;
			windowArray[inputOne.charAt(end)]--;
			end++;

			while(count==length)
			{
				if(min>end-start)
				{
					min=end-start;
					if(min==length)
					{
						return inputOne.substring(start, end);
					}
					outputStart=start;
					outputEnd=end;
				
			}
			windowArray[inputOne.charAt(start)]++;
			if(windowArray[inputOne.charAt(start)]>0)
				count--;
			start++;
			}
		}


	return inputOne.substring(outputStart, outputEnd);
}


}
