package arraysandstrings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class P076_MostCommonWord {
	
	@Test
	public void dataSetOne()
	{
		String paragraph="Bob. hIt, baLl";
		String[] banned= {"bob", "hit"};
		System.out.println(commonWord(paragraph,banned));
	}
	
	//@Test
	public void dataSetTwo()
	{
		String paragraph="Bob hit a ball, the hit BALL flew far after it was hit ball";
		List<String> banned=new LinkedList<>(Arrays.asList(new String[] {"hit"} ));
	//	System.out.println(commonWord(paragraph,banned));
	}
	
	
	//@Test
	public void dataSetThree()
	{
		String paragraph="Bob hit a ball, the hit BALL flew far far after it was hit";
		List<String> banned=new LinkedList<>(Arrays.asList(new String[] {"hit"} ));
		//System.out.println(commonWord(paragraph,banned));
	}
	
	//Remove special characters from String
	//Convert the String to Array of strings using split by space
	//Loop over the array and Map the string and their occurence(if the string is not available in Banned list) using a map
	//Find the max occurance 
	
	private String commonWord1(String input,List<String> banned)
	{
		//input=input.toLowerCase();
		String[] inputArray=input.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
		int max=0;String Output="";
		Map<String,Integer> map=new HashMap<String,Integer>();
		for(int i=0;i<inputArray.length;i++)
		{
			if(!banned.contains(inputArray[i]))
			{
				map.put(inputArray[i], map.getOrDefault(inputArray[i], 0)+1);
//				
//				if(map.get(inputArray[i])>=max)
//				{
//					max=map.get(inputArray[i]);
//					Output=inputArray[i];
//					
//				}
			}
		}
		return Collections.max(map.entrySet(),Map.Entry.comparingByValue()).getKey();
		
	}
	
	public String commonWord(String paragraph, String[] banned) 
    {
        char[] array=paragraph.toCharArray();
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        //System.out.println(bannedWords);
        Map<String,Integer> map=new HashMap<>();
        String temp="";int max=0; String output="";int newCount=0;
        int start=0;int end=0;
        while(end<array.length)
        {
            if((Character.isLetter(array[end])||Character.isDigit(array[end]))&&end<array.length-1)
                end++;
            else 
            {
            if(end==array.length-1&&(Character.isLetter(array[end])||Character.isDigit(array[end]))) end++;
            temp= paragraph.substring(start,end).toLowerCase();
            // System.out.println(temp);
           // System.out.println(!bannedWords.contains(temp));
            if(!bannedWords.contains(temp)&& ! temp.equals(""))
            {
                newCount=map.getOrDefault(temp,0)+1;
                map.put(temp,newCount);
                if(newCount>max)
                {
                    max=newCount;
                    output=temp;
                }
                
            }
            end++;
            start=end;
            }
        }
            
        return output;
    }

}
