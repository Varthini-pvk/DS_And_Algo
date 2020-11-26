
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

//Write a program that tells all the words containing same letters(anagram)
//Input  : "Stale are there in tesla and you can steal the pears"
//Output : [Stale, tesla, steal]


public class P031_findAnagrams 
{

	//DataSets

	@Test
	public void dataSetOne()
	{
		String input="Stale are there in tesla and you can steal the pears";
		findAnagrams(input);
	}

	@Test
	public void dataSetTwo()
	{
		String input="Stale are there in tesla and you can steal the pears tessa";
		findAnagrams(input);
	}

	@Test
	public void dataSetThree()
	{
		String input="Stal3eeee are there in eetesla3e and you can steala the pears tessla";
		findAnagrams(input);
	}

	@Test
	public void dataSetFour()
	{
		String input="Stale are rea in teslae and you can steala the pears tessla";
		findAnagrams(input);
	}
	
	//Solution 1
	//Split the String in to words
	//for each word compare with all other words
	//if lengths are equal,
	//Add all the characters of both the strings to maps with their occurance as value
	//Compare the two maps
	//if equal add to result set , and clear the maps
	//print the result test

	private void findAnagrams(String input)
	{
		String[] words=input.toLowerCase().split(" ");
		Map<Character,Integer> countOne=new HashMap<Character,Integer>();
		Map<Character,Integer> countTwo=new HashMap<Character,Integer>();
		Set<String> result=new HashSet<>();
		for(int i=0;i<words.length;i++)//O[N]
		{
			for(int j=0;j<words.length;j++)//O[N^M]
			{
				if(i!=j)
				{
					if(words[i].length()==words[j].length())
					{
						countOne.clear();
						countTwo.clear();

						for(int k=0;k<words[i].length();k++)//O[K]
						{
							countOne.put(words[i].charAt(k), countOne.getOrDefault(words[i].charAt(k), 0)+1);//O[K]
							countTwo.put(words[j].charAt(k), countTwo.getOrDefault(words[j].charAt(k), 0)+1);

						}
						if(countOne.equals(countTwo))//O[N*M]
						{
							result.add(words[i]);
						}	
					}
				}
			}
		}
		System.out.println(result);
	}
	//Total Time complexity-->O[N*M], worst case O[N^2]
//	
//	//Solution 2
//	//Split the string in to words
//	//Loop through the array and add , the word and ASCII in the map, with ASCII as key
//	//if the ASCII value is already present in the map, check for length of 2 Strings, if length is equal add to result set
//	//else add to map
//	private void findAnagrams(String input)
//	{
//		String[] words=input.toLowerCase().split(" ");int ascii=0;
//		Map<Integer,String> temp=new HashMap<Integer,String>();
//		Set<String> result=new HashSet<String>();
//		for(int i=0;i<words.length;i++)//O[N]
//		{
//			ascii=0;
//			for(int j=0;j<words[i].length();j++)//O[M]
//			{
//				ascii=ascii+words[i].charAt(j);
//			}
//			if(temp.containsKey(ascii))
//			{
//				if(temp.get(ascii).length()==words[i].length())
//				{
//					result.add(words[i]);
//					result.add(temp.get(ascii));
//				}
//			}
//			else
//			{
//				temp.put(ascii,words[i]);
//			}
//			
//		}
//		System.out.println(result);
//		
//}
	
//Solution 2

}
