package arraysandstrings;

import org.junit.Test;

public class P084_JumpGame_2 
{

	@Test
	public void dataSetOne()
	{
		int[] nums= {2,1};
		System.out.println(jump(nums));

	}
	int jumps=Integer.MAX_VALUE;
	public int jump(int[] nums) {

		int currentJumps=0;
		jumprec(0,nums,currentJumps);
		return jumps;

	}

	private void jumprec(int startIndex,int[] nums,int currentJumps)
	{
		if(startIndex==nums.length-1)
		{
			
			jumps=Math.min(jumps,currentJumps);
			currentJumps=0;  
			return;
		}
		
		for(int i=1;i<=nums[startIndex];i++)
		{
			if(i==1) currentJumps++;
			if(startIndex+i>nums.length-1) return;
			jumprec(startIndex+i,nums,currentJumps);
			
		}
	}
}
