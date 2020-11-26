package ArraysAndStrings;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class P006_findDuplicates {
	
	@Test
	public void dataSetOne()
	{
		Integer[] array= {2,1,3,1,3,1,3,4};
		Set<Integer> findDuplicates = findDuplicate(array);
		System.out.println("One: "+findDuplicates);
		
		
	}
	
	@Test
	public void dataSetTwo()
	{
		Integer[] array= {1,2,3,5,6,8,2,1};
		Set<Integer> findDuplicates = findDuplicate(array);
		System.out.println("Two: "+findDuplicates);
		
	}
	
	
	@Test
	public void dataSetThree()
	{
		Integer[] array= {1,-1,3,0,6,9,0,1,34};
		Set<Integer> findDuplicates = findDuplicate(array);
		System.out.println("Three: "+findDuplicates);
		
	}
	
	//Solution1
	private Set<Integer> findDuplicate1(Integer[] array)
	{
		Set<Integer> result=new HashSet<>();
		for(int i=0;i<array.length;i++)
		{
			for(int j=i+1;j<array.length;j++)//O[N]
			{
				if(array[i]==array[j])//O[N^2]
				{
					result.add(array[i]);
				}
					
			}
		}
		return result;
	}
	//Total time Complexity -->O[N]+O[N^2]==O[N^2]
	
	//Solution 2
	private Set<Integer> findDuplicate2(Integer[] array)
	{
		Set<Integer> result=new HashSet<>();
		Arrays.sort(array);//O[log(N)]
		for(int i=0;i<array.length-1;i++)
		{
			if(array[i]==array[i+1])//O[N]
			{
				result.add(array[i]);//O[N]
			}
		}
		System.out.println(array[array.length-1]);
		return result;
	}
	
	//Solution 3
		private Set<Integer> findDuplicate(Integer[] array)
		{
			Set<Integer> result=new HashSet<>();
			Set<Integer> temp=new HashSet<>();
			
			for(int i=0;i<array.length;i++)
			{
				if(!temp.add(array[i]))//O[N]
				{
					result.add(array[i]);//O[N]
				}
			}
			
			return result;
		}
	//Total time complexity==>O[N]+O[N]==>O[N]

}
