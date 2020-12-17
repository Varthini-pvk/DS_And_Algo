import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P065_FindPermuatations 
{

	@Test
	public void dataSetOne() 
	{
		int[] array= {1,2,3};
		
		System.out.println(permute(array));
	
	}
	
public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> output=new ArrayList<>();
        findPermutation(nums,0,output,new ArrayList());
        return output;
        
        
    }
    
    private void findPermutation(int[] array, int start, List<List<Integer>> output,List<Integer> current)
    {
        if(current.size()==array.length)
        {
            List<Integer> temp=new ArrayList<>(current);
            output.add(temp);
            return;
        }
        for(int i=start;i<array.length;i++)
        {
        	
        	//if(!current.contains(array[i])) 
        	{
            current.add(array[i]);
        	
            findPermutation(array,0,output,current);
            current.remove(current.size()-1);
        	}
        	
            
                
            
        }
    }

}
