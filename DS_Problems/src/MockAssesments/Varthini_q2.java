package MockAssesments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

//Find the second least character in a given string
//Example:
//Input: "tesla-service" Output: s 
//   a) If there are more than one match, return the last match "aabbccc" -> 'b'
//   b) If there are no second match, return ''



//Assumed Second Least Occuring Character
public class Varthini_q2 {
	
@Test
public void dataSetOne()
{
	String Input="tesla-service";
	System.out.println("one "+findSecondLeast(Input));
}

@Test
public void dataSetTwo()
{
	String Input="WelcomeWelcome";
	System.out.println("two "+findSecondLeast(Input));
}

@Test
public void dataSetThree()
{
	String Input="iaabbccc";
	System.out.println("Three "+findSecondLeast(Input));
}


//Solution 1(BruteForce)
//Convert the string to char Array
//Loop through the array
//For each element check the count of each element and store in a list
//check for the second lesser value and return

//Solution 2
//Convert the string to char Array
//Loop through the array
//Add the character and occurance to Linked hash map
//Add the key set to a set (to remove duplicates)
//Add the key set to list and sort
//loop through the entry set of map and store the element whose value is equal to the second smallest in output
//return output

private char findSecondLeast1(String input)
{
	char output=' ';
	Map<Character,Integer> refMap=new LinkedHashMap<Character,Integer>();
	for(Character i:input.toCharArray()) 
	{
		refMap.put(i, refMap.getOrDefault(i, 0)+1);
	}
	Set<Integer> distinctvalues=new HashSet<>(refMap.values());
	if(!(distinctvalues.size()==1))
	{
		List<Integer> values=new LinkedList<>(distinctvalues);
		Collections.sort(values);
		int secondLeast=values.get(1);
		for(Map.Entry<Character,Integer> each:refMap.entrySet())
		{
			if(each.getValue()==secondLeast)
			output=each.getKey();
				
		}
	}
	return output;
	
	
}

//Traverse the map from Reverse Direction after geting key Set
private char findSecondLeast2(String input)
{
	char output=' ';
	Map<Character,Integer> refMap=new LinkedHashMap<Character,Integer>();
	for(Character i:input.toCharArray()) 
	{
		refMap.put(i, refMap.getOrDefault(i, 0)+1);
	}
	Set<Integer> distinctvalues=new HashSet<>(refMap.values());
	if(!(distinctvalues.size()==1))
	{
		List<Integer> values=new LinkedList<>(distinctvalues);
		Collections.sort(values);
		int secondLeast=values.get(1);
		List<Character> keys=new LinkedList<>(refMap.keySet());
		for(int i=keys.size()-1;i>0;i--)
		{
			
			if(refMap.get(keys.get(i))==secondLeast)
			output=keys.get(i);
			break;
		}
	}
	return output;
	
	
}


//fetch Key using Lambda expression
private char findSecondLeast(String input)
{
	char output=' ';
	Map<Character,Integer> refMap=new LinkedHashMap<Character,Integer>();
	for(Character i:input.toCharArray()) 
	{
		refMap.put(i, refMap.getOrDefault(i, 0)+1);
	}
	Set<Integer> distinctvalues=new HashSet<>(refMap.values());
	if(!(distinctvalues.size()==1))
	{
		List<Integer> values=new LinkedList<>(distinctvalues);
		Collections.sort(values);
		Integer secondLeast=values.get(1);
									List<Character> outputList = refMap
							      .entrySet()
							      .stream()
							      .filter(entry -> secondLeast.equals(entry.getValue()))
							      .map(Map.Entry::getKey).collect(Collectors.toList());
	  
	     output=outputList.get(outputList.size()-1);
	     
		
	}
	return output;
	
	
}

private char findSecondLeast4(String input)
{
	char output=' ';
	int[] refArray=new int[256];
	for(Character i:input.toCharArray()) 
	{
		refArray[i]++;//o[N]
	}
	int least=refArray.length;int SecondLeast=refArray.length;
	
	for(int i=0;i<refArray.length;i++)//O[256]
	{
		if(refArray[i]<least&&refArray[i]>0)
		{
			SecondLeast=least;
			least=refArray[i];
		}
		else if(refArray[i]<SecondLeast && refArray[i]>least)
		{
			SecondLeast=refArray[i];
		}
	}
	for(int i=0;i<refArray.length;i++)
	{
		if(refArray[i]==SecondLeast)
		{
			if(input.lastIndexOf((char)i)>input.lastIndexOf((output))||output==' ')
			output=(char)i;
		}
	}
	
	return output;
	
	
}
}
