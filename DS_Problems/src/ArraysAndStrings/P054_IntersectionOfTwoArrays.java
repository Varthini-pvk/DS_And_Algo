//2) Given two arrays,find the intersection of 2 arrays.
//
//Input: nums1 = [11,2,12,1], nums2 = [2,12]
//Output: [2,12]
//
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4]

package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

//Sort  two Arrays
//Intialize two varaiables i and j
//(i to loop over one array A and j to loop over another array)
//Loop till the length of smaller array
	//if element in i and j are equal, add that element to result array
	//if the element in i is smaller than element in j , increment i
	//else if element in j is smaller, increment j
public class P054_IntersectionOfTwoArrays {

	
@Test
public void dataSetOne()
{
	int[] nums1= {11,2,12,1};
	int[] nums2= {2,12};
	System.out.println(findIntersection(nums1,nums2));
}

@Test
public void dataSetTwo()
{
	int[] nums1= {4,9,5};
	int[] nums2= {9,4,9,8,4};
	System.out.println(findIntersection(nums1,nums2));
}


private Set<Integer> findIntersection(int[] inputOne, int[] inputTwo)
{
	Set<Integer> output=new HashSet<Integer>();
	Arrays.sort(inputOne);
	Arrays.sort(inputTwo);
	int i=0;int j=0;
	while(i<inputOne.length&&j<inputTwo.length)
	{
		if(inputOne[i]==inputTwo[j])
		{
		output.add(inputOne[i]);
		i++;j++;
		}
		else if(inputOne[i]<inputTwo[j])
		i++;
		else
		j++;
	}
	return output;
	
}
}
