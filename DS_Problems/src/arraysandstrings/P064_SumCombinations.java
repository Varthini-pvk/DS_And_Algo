package arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class P064_SumCombinations {
	
	
@Test
public void dataSetOne() 
{
	int[] array= {2,3,6,7,1};
	int n=7;
	System.out.println(findCombinations(array,n));
	
	
	
}

private List<List<Integer>> findCombinations(int[] array, int n)
{
	List<List<Integer>> output=new ArrayList<>();
	Arrays.sort(array);
	findcombination(array,n,0,output,new ArrayList<>());
	return output; 
}

private void findcombination(int[] array,int n,int start,List<List<Integer>> output,List<Integer> current)
{
	if(n==0)
	{
		List<Integer> temp=new ArrayList<>(current);
		Collections.sort(temp);
		if(!output.contains(temp))
		output.add(temp);
		return;
	}
	if(n<0)
	{
		return;
	}

	for(int i=start; i<array.length;i++)
	{
		current.add(array[i]);
		findcombination(array,n-array[i],start,output,current);
		current.remove(current.size()-1);
		
	}
}


private void findcombination1(int[] array,int n,int start,List<List<Integer>> output,List<Integer> current)
{
	if(n==0)
	{
		List<Integer> temp=new ArrayList<>(current);
			/*
			 * Collections.sort(temp); if(!output.contains(temp)) output.add(temp);
			 */
		return;
	}
	if(n<0)
	{
		return;
	}

	for(int i=start; i<array.length;i++)
	{
		current.add(array[i]);
		findcombination(array,n-array[i],i,output,current);
		current.remove(current.size()-1);
		
	}
}
}
