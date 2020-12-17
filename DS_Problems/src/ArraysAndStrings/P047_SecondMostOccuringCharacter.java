package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

//Given a string find the second most number of occurrences of a character,
//If there  are multiple matches return the first Second most

public class P047_SecondMostOccuringCharacter {
	
	
@Test
public void dataSetOne()
{
	String input= "Welcome To TestLeaf";
	System.out.println("One:"+findSecondRepeating(input));
}

@Test
public void dataSetTwo()
{
	String input= "Welcome to testLeaf";
	System.out.println("Two:"+findSecondRepeating(input));
}

@Test
public void dataSetThree()
{
	String input= "Welcome";
	System.out.println("Three:"+findSecondRepeating(input));
}

@Test
public void dataSetFour()
{
	String input= "WelcomeWelcome";
	System.out.println("Four:"+findSecondRepeating(input));
}

@Test
public void dataSetFive()
{
	String input= "rat";
	System.out.println("Five:"+findSecondRepeating(input));
}

//Solution 1(Using Map)
private Character findSecondRepeating(String input)
{
	Map<Character,Integer> ref=new LinkedHashMap<>();
	input.replaceAll(" ", "");
	for(char i:input.toCharArray())
	{
		ref.put(i, ref.getOrDefault(i, 0)+1);
	}
	
	List<Integer> count=new ArrayList<>(ref.values());
	Set<Integer> refSet=new HashSet<>(count);
	if(refSet.size()==1)
	return  ' ';
	
	Collections.sort(count);
	for(Map.Entry<Character, Integer> e:ref.entrySet())
	{
		if(e.getValue()==count.get(count.size()-2))
		return e.getKey();
	}

	return  ' ';
	}

//Solution 2
//private Character findSecondRepeating(String input)
{
	
}
}
