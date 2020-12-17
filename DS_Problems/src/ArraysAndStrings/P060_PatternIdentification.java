package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


//Given a pattern and a string s, find if s follows the same pattern.
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
//Example 1:
//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true
//Example 2:
//Input: pattern = "abba", s = "dog cat cat fish"
//Output: false
//Input: pattern = "abc", s = "hello world world"
//Output: false
//Algorithm: HashMap

public class P060_PatternIdentification {
	
@Test
public void dataSetOne()
{
	String pattern ="abba";
	String input="dog cat cat dog";
	System.out.println("One "+checkPattern(pattern,input));
}


@Test
public void dataSetTwo()
{
String pattern ="abba";
String input="dog cat cat fish";
System.out.println("Two "+checkPattern(pattern,input));
}

@Test
public void dataSetThree()
{
String pattern ="abc";
String input="hello world world";
System.out.println("Three "+checkPattern(pattern,input));
}

@Test
public void dataSetFour()
{
String pattern ="abc";
String input="hello world world set";
System.out.println("four "+checkPattern(pattern,input));
}


@Test
public void dataSetFive()
{
String pattern ="abc";
String input="dog dog dog";
System.out.println("Five "+checkPattern(pattern,input));
}
//Solution 1 
//Convert patter to character array
//Split the input strings and store in array
//check if length of both are equal
//if not return false

//Loop through the pattern array 
// check if pattern is present in the map
//(if it is not present in the map add with the value in the same index of input array)
//if it is already present in the map, check if the value in the same index of input array is equal to its key
 	//if not return false
	//if yes continue
//If the loop is done return true

private Boolean checkPattern1(String pattern,String input)
{
	char[] patternArray=pattern.toCharArray();
	String[] inputArray=input.split(" ");
	
	if(patternArray.length!=inputArray.length)
	return false;
	
	Map<Character,String> refMap=new HashMap<Character,String>();
	for(int i=0;i<patternArray.length;i++)
	{
		if(refMap.containsKey(patternArray[i]))
		{
			if(!refMap.get(patternArray[i]).equals(inputArray[i]))
			return false;
		}
		else
		{
			refMap.put(patternArray[i],inputArray[i]);
		}
		
	}
	return true;
	
}

//Solution 2


private Boolean checkPattern(String pattern,String input)
{
	char[] patternArray=pattern.toCharArray();
	String[] inputArray=input.split(" ");
	
	if(patternArray.length!=inputArray.length)
	return false;
	
	Map<Object,Integer> refMap=new HashMap<Object,Integer>();
	for(int i=0;i<patternArray.length;i++)
	{
		refMap.put(patternArray[i], refMap.getOrDefault(patternArray[i], 0)+1);
		refMap.put(inputArray[i], refMap.getOrDefault(inputArray[i], 0)+1);
	}
	
	for(int i=0;i<patternArray.length;i++)
	{
		if(refMap.get(patternArray[i])!=refMap.get(inputArray[i]))
		return false;	
	}
	return true;
	
}
}
