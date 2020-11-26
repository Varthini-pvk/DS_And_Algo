package Learnings;

import java.util.Arrays;

import org.junit.Test;

public class Solution {
	
	
	@Test
	public void dataSetOne()
	{
		int[] array= {5,7,7,8,8,10};
		int[] searchRange = searchRange(array,8);
		System.out.println(Arrays.toString(searchRange));
		
	}
	    public int[] searchRange(int[] nums, int target) {
	        
	        if(nums.length==0)
	        return new int [] {-1,-1};int j=0;int i=0;
	        
	        int start=0; int end=nums.length-1;int mid=0;
	 
	        while(start<=end)
	        {
	            mid=start+((end+1)-start)/2;
	            if(target<nums[mid])
	            {
	                end=mid-1;;
	                
	            }
	            else if(nums[mid]==target)
		        {
	                 i=mid;
	                 end=mid-1;
		        }
	            else
	            {
	                start=mid+1;
	            }
	            
	        
	        }
	        
	      
	        start=0;  end=nums.length-1; mid=0;
	            
	            while(start<=end)
	        {
	            mid=start+((end+1)-start)/2;
	            if(target>nums[mid])
	            {
	                start=mid+1;
	                
	            }
	            else if(nums[mid]==target)
		        {
		                j=mid;
		                 start=mid+1;    
		        }
	            else
	            {
	                end=mid-1;
	            }
	                
	        }
	       
	            return new int[] {i,j};
	                
	        
	        
	    }
	}


