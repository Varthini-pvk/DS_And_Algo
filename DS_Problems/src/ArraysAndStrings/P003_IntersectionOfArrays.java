package ArraysAndStrings;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class P003_IntersectionOfArrays {
	
	@Test
	public void dataSetOne()
	{
		Integer[] arrayOne= {1,2,4,5};
		Integer[] arrayTwo= {2,4,7,9};
		Set<Integer> findIntersection = findIntersection(arrayOne,arrayTwo);
		System.out.println(findIntersection);
	}
	
	@Test
	public void dataSetTwo()
	{
		Integer[] arrayOne= {1,2,-4,5};
		Integer[] arrayTwo= {2,4,7,9};
		Set<Integer> findIntersection = findIntersection(arrayOne,arrayTwo);
		System.out.println(findIntersection);
	}
	
	@Test
	public void dataSetThree()
	{
		Integer[] arrayOne= {1,2,4,5,6,6};
		Integer[] arrayTwo= {2,2,4,7,9};
		Set<Integer> findIntersection = findIntersection(arrayOne,arrayTwo);
		System.out.println(findIntersection);
	}
	
	//Solution 1//O[N^2]
	private List<Integer> findIntersection1(int[] arrayOne,int[] arrayTwo)
	{
		List<Integer> intersection=new LinkedList<>();
		for(int i=0;i<arrayOne.length;i++)
		{
			for(int j=0;j<arrayTwo.length;j++)
			{
				if(arrayOne[i]==arrayTwo[j])//O[N^2]
					
				{
					intersection.add(arrayOne[i]);
				}
			}
		}
		return intersection;
	}
	
	//Solution 2//O[N^2]
	private Set<Integer> findIntersection2(Integer[] arrayOne,Integer[] arrayTwo)
	{
		Set<Integer> intersection=new HashSet<>();
		Set<Integer> setOne=new HashSet<>();
		Set<Integer> setTwo=new HashSet<>();
		Collections.addAll(setOne,arrayOne);//O[N]
		Collections.addAll(setTwo,arrayTwo);//O[N]
		for(Integer each:setOne)
		{
			for(Integer eachTwo:setTwo)
			{
				if(each==eachTwo)//O[N^2]
				{
					intersection.add(each);
				}
			}
		}
		return intersection;
		
		
		
	}
	
	//Solution 3//O[N]
	public Set<Integer> findIntersection3(Integer[] arrayOne,Integer[] arrayTwo)
	{
		Set<Integer> intersection=new HashSet<>();
		Set<Integer> setOne=new HashSet<>();
		Collections.addAll(setOne, arrayOne);//O[N]
		for(int i=0;i<arrayTwo.length;i++)
		{
			if(!setOne.add(arrayTwo[i]))//O[N]
			{
				intersection.add(arrayTwo[i]);
			}
		}
		return intersection;
	}
	
	//Total timeComplexity==>O[N]+O[N]-->O[N]
	
	//Solution 4//?
	
	public Set<Integer> findIntersection(Integer[] arrayOne,Integer[] arrayTwo)
	{
		Set<Integer> intersection=new HashSet<>();
		Set<Integer> setOne=new HashSet<>();
		Set<Integer> setTwo=new HashSet<>();
		Collections.addAll(setOne, arrayOne);//O[N]
		Collections.addAll(setTwo, arrayTwo);//O[N]
		setOne.retainAll(setTwo);//O[log[n]]
		return setOne;
	}
	
	//Total Time Complexity: O[N]+O[N]+O[log[N]==>
	

}
