package BinarySearch;

import org.junit.Test;

public class P082_findNumberinRotatedArray {

	
@Test
public void setOne()
{
	int[] array= {4,5,6,7,0,1,2};
	int target=4;
	System.out.println(findElement(array,target));

}


@Test
public void setTwo()
{
int[] array= {4,5,6,7,0,1,2};
int target=3;
System.out.println(findElement(array,target));

}

@Test
public void setThree()
{
int[] array= {4,5,6,7,0,1,2};
int target=2;
System.out.println(findElement(array,target));

}


//Loop through Array
//Declare two variables low=0 and high=end
//calculate mid=low+high /2
//check if mid-1 is less than mid and mid+1 is greater than mid
//if true low=mid+1 and high=mid-1
//else
//check if low is greater than mid	
//Check if target id greater than low and less than mid
 // if true high=mid-1 and low=mid+1
//else
//Check if target id greater than mid and less than high
// if true low=mid+1 and high=mid-1



private int findElement(int[] nums, int target)
{
	int low=0,high=nums.length-1;int mid=0;
	while(low<=high)
	{
		mid=(low+high)/2;
		if(nums[mid]==target) return mid;
		else if(nums[low]<nums[mid])
		{
			if(target>=nums[0]&&target<nums[mid])
			{
				high=mid-1;
			}
			else 
				{
				low=mid+1;
				}
		}
	
	else
	{
		if(target> nums[mid]&&target<=nums[mid])
		{
			low=mid-1;
		}
		else high=mid+1;
	}
	
}
 return -1;
}
}
