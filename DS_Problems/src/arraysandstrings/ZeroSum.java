package arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ZeroSum {

	int[] array2= {-1,0,1,2,-1,-4};
	@Test
	public void DataSetOne()
	{
		int[] array= {-1,0,1,2,-1,-4};
		System.out.println(findTriplet(array));

	}

	public List<List<Integer>> findTriplet(int[] nums) 
	{
		Set<List<Integer>> temp=new HashSet<>();
		if(nums.length>2)
		{
			Arrays.sort(nums);
			HashMap<Integer,Integer> refMap=new HashMap<>();

			for(int i =0;i<nums.length;i++)
			{
				if(i==0||nums[i]!=nums[i-1])
				{
					for(int j=0;j<nums.length;j++)
					{
						if(i!=j)
						{
							if((refMap.containsKey(nums[j])&&nums[j]>=i))
							{
								List<Integer> triplet = Arrays.asList(nums[i], nums[j], refMap.get(nums[j]));
								//Collections.sort(triplet);
								temp.add(triplet);
							}
							else
								refMap.put(0-nums[i]-nums[j],nums[j]);   
						}


					}
					refMap.clear();
				}
			}
		}
		return new ArrayList<>(temp);
	}
}


