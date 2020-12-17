package ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class P058_DifferenceBetweenDuplicateIndices {
	
//1. Get two Inputs Array and k
//2. Declare Two Variables Start and End and assign zero to both
//3. Loop over the length of array with end position
//	4. till Start-end less than or equal to k,
//		add the elements to a set, if the add functions returns false
//		return the output as true
//		Else
//	5.remove of start value from the set
//	6.increment start,   and continue


	//1. Get two Inputs Array and k
	//2. Declare Two Variables Start and End and assign zero to both
	//3. Loop over the length of array with end position
//		4. till Start-end less than or equal to k,
//			add the elements and occurrence to map, if occurrence is greater than 1
//			return the output as true
//			Else
//		5.decrement the occurrence of start value in the map
//		6.increment start,   and continue

	
@Test
public void dataSetOne()
{
	int[] nums= {1,2,3,1};
	int k=3;
	System.out.println("One:"+checkDistance(nums,k));
}

@Test
public void dataSetTwo()
{
	int[] nums= {1,0,1,1};
	int k=1;
	System.out.println("Two:"+checkDistance(nums,k));
}

@Test
public void dataSetThree()
{
	int[] nums= {1,2,3,1,2,3};
	int k=2;
	System.out.println("Three:"+checkDistance(nums,k));
}

@Test
public void dataSetFour()
{
	int[] nums= {1,2,3,2,2,3};
	int k=2;
	System.out.println("four:"+checkDistance(nums,k));
}
	
//Using Set
private Boolean checkDistance(int[] array, int k)
{
	int start=0;int end=0;
	Set<Integer> tempSet=new HashSet<>();
	while(end<array.length)
	{
		while(end-start<=k)
		{
			if(!tempSet.add(array[end]))
			return true;
			end++;
		}
		tempSet.remove(array[start]);
		start++;
	}
	return false;
	
}

//Using Map
//private Boolean checkDistance2(int[] array, int k)
//{
//	int start=0;int end=0;
//	Map<Integer,Integer> tempMap=new HashMap<Integer,Integer>();
//	while(end<array.length)
//	{
//		while(end-start<=k)
//		{
//			if(!tempSet.add(array[end]))
//			return true;
//			end++;
//		}
//		tempSet.remove(array[start]);
//		start++;
//	}
//	return false;
//	
//}

}
