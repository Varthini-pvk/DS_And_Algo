package MockAssesments;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

///*A subsequence is a sequence of letters in a string, in order, but with any
//number of characters removed. Vowels in order are the letters in the
//string aeiou. Given a string, determine the length of the longest
//subsequence that contains all of the vowels, in order, and no vowels
//out of order.*/


//Examples
//s = 'aeeiiouu'
//All 5 vowels are present in the correct order, so the length of the
//entire string, 8, is returned.
//s = 'aeeiiaouu'
//Again, all 5 vowels are present in the correct order, though they don't
//make the entire string. The 'a' at position 5 must be removed since it is
//Question - 5
//Fun With Vowels
///
//out of order, leaving 'aeeiiouu' with length 8.
 
public class A1P05 {
	
@Test
public void dataSetOne()
{
	String input="aeiaaioooaauuaeiu";
}

@Test
public void dataSetTwo()
{
	String input="aeiaaiooaa";
	System.out.println(funWithVowels(input));
}

@Test
public void dataSetThree()
{
	String input="aeiaaioooaauuaeiu";
	System.out.println(funWithVowels(input));
}

public int funWithVowels(String input)
{
	char[] charArray=input.toCharArray();
	List<Character> tempList=new LinkedList<>();
	for(int i=0;i<charArray.length;i++)
	{
		tempList.add(charArray[i]);
	}
	int i=1;
	while(i<tempList.size()-1)
	{
		if((int)tempList.get(i)<(int)tempList.get(i-1))
		{
			tempList.remove(i);
		}
		else
		{
			i++;
		}
	}
	return tempList.size();
	
	
}

}
