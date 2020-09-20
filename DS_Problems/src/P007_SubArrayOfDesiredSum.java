import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class P007_SubArrayOfDesiredSum {
	
@Test
public void dataSetOne()
{
	int[] array= {1,4,3,1,2,1,5,1};
	int requiredSum=7;
	subArraySum(array,requiredSum);
		/*
		 * List<Integer> subArraySum = subArraySum(array,requiredSum);
		 * System.out.println(subArraySum);
		 */
	
	
}
@Test
public void dataSetTwo()
{
	int[] array= {1,4,3,1,1,2,0,8,9,7,7};
	int requiredSum=7;
	// subArraySum(array,requiredSum);
	//System.out.println(subArraySum);
	
	
}
@Test
public void dataSetThree()
{
	int[] array= {1,2,3,0,8,9,3,4,8,9,6};
	int requiredSum=7;
	
	
}

//Solution 1
private List<Integer> subArraySum1(int[] array,int requiredSum)
{
	int currentSum=0;
	List<Integer> subArray=new ArrayList<>();
	for(int i=0;i<array.length;i++)
	{
		subArray.clear();
		currentSum=0;
		Boolean flag=false;
		for(int j=i;j<array.length;j++)
		{
			if(array[j]==requiredSum)
			{
				subArray.clear();
				subArray.add(array[j]);
				flag=true;
				return subArray;
							}
			if(array[j]>requiredSum)
			{
				flag=true;
			}
			else
			{ 	flag=false;
				currentSum=currentSum+array[j];
				subArray.add(array[j]);
				if(currentSum==requiredSum)
				{
					flag=true;
					return subArray;
				}
				if(currentSum>requiredSum)
				{
					flag=true;;
				}
				if(flag)
				{
					break;
				}
			}
		}
		
		
	}
	throw new RuntimeException("No match");
}

//Solution 2 (Hashing)
private void subArraySum(int[] array,int requiredSum)
{
	int sumSofar=0;int difference=0;
Map<Integer,Integer> map=new HashMap<Integer,Integer>();
for(int i=0;i<array.length;i++)
{
	sumSofar=sumSofar+array[i];
	difference=sumSofar-requiredSum;
	if(map.containsKey(difference))
	{
	
		System.out.println("subarray"+map.get(difference)+1+","+i);
	}
	map.put(sumSofar, i);
}

}}
