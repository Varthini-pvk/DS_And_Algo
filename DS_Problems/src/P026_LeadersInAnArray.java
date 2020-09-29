import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class P026_LeadersInAnArray 
{
	@Test
	public void dataSetOne()
	{
		int[] array= {3,4,7,2,1,4,5};
		Set<Integer> leader = leader(array);
		System.out.println(leader);
		
	}

	@Test
	public void dataSetTwo()
	{
		int[] array= {4,9,3,5,6,5,2};
		Set<Integer> leader = leader(array);
		System.out.println(leader);
		
	}

	@Test
	public void dataSetThree()
	{
		int[] array= {2,1};
		Set<Integer> leader = leader(array);
		System.out.println(leader);
		
	}
	@Test
	public void dataSetFour()
	{
		int[] array= {3,3,3,3};
		Set<Integer> leader = leader(array);
		System.out.println(leader);
		
	}
	//Solution 2
	
	//Initalize leaders index with last element
	//Loop through the element in the reverse order
	//When an element greater than the start index is found,
	//return the current element as leader
	//continue the loop with start index as i
	private Set<Integer> leader(int[] array)
	{
		Set<Integer> leaders=new HashSet<>();
		leaders.add(array[array.length-1]);//O[N]
		int startIndex=array.length-1;	//O[N]
		for(int i=array.length-1;i>0;i--)//O[N]
		{
			if(array[i]>array[startIndex])
			{
				leaders.add(array[i]);
				startIndex=i;
			}
		}
		return leaders;
		
	}

}
