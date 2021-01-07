package arraysandstrings;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class P009_LuckyInteger {
	
	@Test
	public void dataSetOne()
	{
		Integer[] array= {1,2,2,3,3,4,4,4,4,5,5,6,7,9,9,9};
		System.out.println(luckyNumber(array));
		
		
	}
	@Test
	public void dataSetTwo()
	{
		Integer[] array= {-4,-3,-3,-3,0,1,2};
		System.out.println(luckyNumber(array));
	}
	@Test
	public void dataSetThree()
	{
		Integer[] array= {3,4,6,5,3,2,1,0,3};
		System.out.println(luckyNumber(array));
	}
	
	@Test
	public void dataSetFour()
	{
		Integer[] array= {	2,3,4,5,6,7};
		System.out.println(luckyNumber(array));
	}
	
	//Solution 1
	private int luckyNumber1(Integer[] input)
	{
		int count=1;int maxLuckyNumber=-1;
		for(int i=0;i<input.length;i++)
		{
			count=1;//O[N]
			for(int j=i+1;j<input.length;j++)
			{
				if(input[i]==input[j])//O[N^2]
				count++;
			}
			int absolute = Math.abs(input[i]);//O[1]
			if(count==absolute&&absolute>maxLuckyNumber)//O[N]
			{
				maxLuckyNumber=absolute;
			}
		}
		return maxLuckyNumber;
	}
	
	//Total Time Complexity-->O[N]+O[N^2]+O[N]-->O[N^2]
	
	//Solution 2
	private int luckyNumber2(Integer[] input)
	{
		int luckyNumber=-1;//O[1]
		Map<Integer,Integer> tempMap=new HashMap<>();//O[1]
		for(int i=0;i<input.length;i++)
		{
			
			if(tempMap.get(input[i])>1)//O[N]
			{	
			tempMap.put(input[i], tempMap.get(input[i]));
			}
			else
			{
				tempMap.put(input[i], 1);
			}
		}
		for(Entry<Integer,Integer> i:tempMap.entrySet())
		{
			if(i.getKey().equals(i.getKey())&& i.getKey()>luckyNumber)//O[N]
			{
				luckyNumber=i.getKey();
			}
		}
		return luckyNumber;
		
	}
	
	//Total Time Complexity-->O[N]+O[N]+O[1]+O[1]==>O[N]
	
	//Solution 3
	//Only for Sorted Array(Need to modify to support -ve numbers)
	private int luckyNumber3(Integer[] input)
	{
		int currentValue=0;int count=0;int luckyValue=0;
		int maxLucky=-1;int i=0;
		//Initialization block
		for(;i<=input.length;i++)
		{
			if(input[i-1]-i<0)
			{
				currentValue=input[i-1];//O[M]//Worst Case O[N]
				count++;//O[M]
				break;
			}
		}
		for(;i<input.length;i++)
		{
		
			if(input[i-1]-i==input[i]-(i+1))//O[N-M]
			{
				if(currentValue==count)//O[K] //Worst Condition O[M]
					{
					luckyValue=currentValue;
					count=0;
					if(maxLucky<luckyValue)
					{
						maxLucky=luckyValue;
					}
				
				}
				count=0;
				currentValue=input[i];
			}
			count++;//O[N-M]
		}
		return maxLucky;
	}
	
	//Total Time Complexity=O[M]+O[N-M]+O[K](K<N-M)-->O[N]
	
	public int luckyNumber(Integer[] input) {
		int lucky=-1;
		int count=1;
		for (int i = 0; i < input.length-1; i++) {
			if(input[i]==input[i+1]) {
				count++;
			}
			else {
				if(input[i]==count) {
					lucky=Math.max(count, lucky);
				}
				count=1;
			}
		}
		return lucky;
	}

}
