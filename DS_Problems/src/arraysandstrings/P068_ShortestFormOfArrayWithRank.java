package arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class P068_ShortestFormOfArrayWithRank 
{
	@Test
	public void dataSetOne()
	{
		int[] array= {10,2,1,4,10,2,5,13,5};
		System.out.println(Arrays.toString(rankArray(array)));
	}
	
	@Test
	public void dataSetTwo()
	{
		int[] array= {2,1,2,3,5,3,3};
		System.out.println(Arrays.toString(rankArray(array)));
	}
	
	private int[]  rankArray(int[] input)
	{
		Map<Integer,List<Integer>> refMap=new HashMap<>();
		int start=0; int end=0;
		int maxRank=0;int minSize=input.length;int temp=0;
		for(int i=0;i<input.length;i++)
		{
			refMap.computeIfAbsent(input[i], k -> new ArrayList<>()).add(i);
			//maxRank=Math.max(refMap.get(input[i]).size(),maxRank);
			temp=refMap.get(input[i]).size();
			if(temp>1&&temp>=maxRank)
			{
				
				if(refMap.get(input[i]).get(temp-1)-refMap.get(input[i]).get(0)<=minSize||temp>=maxRank)
				{
					minSize=refMap.get(input[i]).get(temp-1)-refMap.get(input[i]).get(0);
					start=refMap.get(input[i]).get(0);
					end=refMap.get(input[i]).get(temp-1);
				}
				maxRank=temp;
			}
		}
		return Arrays.copyOfRange(input, start, end+1);
	}
	
	

}
