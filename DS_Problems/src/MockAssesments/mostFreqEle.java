package MockAssesments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class mostFreqEle {

	@Test
	public void TestCase1()
	{
		int[] input = {4,5,2,1,5,4,2,1,0,1};
		List<Integer> output = findFreq(input);
		System.out.println(output);
	}
	
	@Test
	public void TestCase2()
	{
		int[] input = {1,2,3,4,2,3,4};
		List<Integer> output = findFreq(input);
		System.out.println(output);
	}
	
	private List<Integer> findFreq(int[] input)
	{
		List<Integer> res = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		
		for (int i : input) 
		{
			map.put(i, map.getOrDefault(map.get(i), 0)+1);
		}
		
		List<Integer> len = new ArrayList<>(map.values());
		Collections.sort(len);
		int max = len.get(len.size()-1);
		
		for (Integer i : map.keySet()) 
		{
			if(map.get(i) == max)
			{
				System.out.println(map.get(i));
				res.add(i);
			}
		}
		
		
		
		System.out.println(map);
		return res;
	}
}
