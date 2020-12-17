package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P063_SumCombinations {
	
	
	@Test
	public void dataSetOne() 
	{
		int k=3;
		int n=9;
		System.out.println(findCombinations(k,n));
		System.out.println(j);
		
		
	}
	

	@Test
	public void dataSetTwo() 
	{
		int k=4;
		int n=9;
		System.out.println(findCombinations(k,n));
		System.out.println(j);
		
	}
	
	@Test
	public void dataSetThree() 
	{
		int k=3;
		int n=7;
		System.out.println(findCombinations(k,n));
		System.out.println(j);
		
	}
	
	int j=0;
	private List<List<Integer>> findCombinations(int k,int n)
	{
		
		List<List<Integer>> output=new ArrayList<>();
		findcombination(k,n,1,output,new ArrayList<>());
		return output; 
		
		
		
	}
    private void findcombination(int k,int n,int start,List<List<Integer>> output,List<Integer> current)
    {
    	if(current.size()==k&& n==0)
    	{
    		List<Integer> temp=new ArrayList<>(current);
    		output.add(temp);
    		return;
    	}
		
		if((n<start)) return;
    	
    	
    		for(int i=start;i<10;i++)
    		{
    			current.add(i);j++;
    			findcombination(k,n-i,i+1,output,current);
    			current.remove(current.size()-1);
    		}
    	
    }
}
