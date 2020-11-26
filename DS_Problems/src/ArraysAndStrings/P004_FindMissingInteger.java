package ArraysAndStrings;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class P004_FindMissingInteger {
	
	@Test
	public void dataSetOne()
	{
		Integer[] array= {2,8,10,1,0,2,1};
		System.out.println( "dataSetOne :"+findMissing(array));
		
		
	}
	@Test
	public void dataSetTwo()
	{
		Integer[] array= {2,-1,0,-3,8,10,1,4,6,2};
		System.out.println("dataSetTwo :"+findMissing(array));
		
	}
	@Test
	public void dataSetThree()
	{
		Integer[] array= {2,1,2,3,5,7,9,11,13};
		System.out.println("dataSetThree :"+findMissing(array));
		
	}
	
	@Test
	public void dataSetFour()
	{
		Integer[] array= {1,2,3,4};
		System.out.println("dataSetFour :"+findMissing(array));
		
	}
	
	//Solution 1
	
	private int findMissing1(Integer[] array)
	{
		Arrays.sort(array);//O[log[N]]
		int temp=0;
		for(int i=0;i<array.length;i++)
		{
			if(array[i]>0)//O[N]
			{
			if(array[i]!=array[i+1]&&array[i+1]-array[i]!=1)//O[N]
			{
				return array[i]+1;
				
			}
			}
		}
		throw new RuntimeException("No match");
	
	}
	
	//Total time complexity==> O[log[n]]+O[N]+O[N]==>
	
	//Solution 2
	
	private int findMissing2(Integer[] array)
	{
		Set<Integer> inputSet=new HashSet<>();
		Collections.addAll(inputSet, array);//?(O[N]
		for(int i=1;i<Collections.max(inputSet);i++)
		{
			if(inputSet.add(i))//O[M]
			{
				return i;
			}
		}
		throw new RuntimeException("No match");
	}
	//Total time complexity--> O[M]+O[N]
	
	//Solution 3
	
	private int findMissing(Integer[] array)
	{
		TreeSet<Integer> inputSet=new TreeSet<Integer>();
		Collections.addAll(inputSet, array);//?(O[N])
		for(int i=1;i<inputSet.last();i++)
		{
			if(inputSet.add(i))//O[M]
			{
				return i;
			}
		}
		throw new RuntimeException("No match");
	}
}
