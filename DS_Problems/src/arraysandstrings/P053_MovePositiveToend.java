package arraysandstrings;
import java.util.Arrays;

import org.junit.Test;

public class P053_MovePositiveToend {
	
	
@Test
public void dataSetOne()
{
	int[] array= {4,-1,9,0,2,-4,5};
	System.out.println(Arrays.toString(arrange(array)));
	
}

@Test
public void dataSetTwo()
{
	int[] array= {4,3,45,6,7};
	System.out.println(Arrays.toString(arrange(array)));
	
}

//Declare two Variable i,j; Assign i equal to zero and j to size of array
//Declare an output array
//Loop over the array and 
	//if element in i position is negative, add to the ouput array,form start
	//if element in j position is positive add to output array from end
private int[] arrange(int[] array)
{
	int[] output=new int[array.length];
	int i=0;int j=array.length-1;
	int negative=i;int positive=j;
	while(negative<=positive)
	{
		if(array[i]<=0)
		{
		output[negative]=array[i];
		negative++;
		}
		if(array[j]>0)
		{
		output[positive]=array[j];
		positive--;
		}
		j--;i++;
		
		
	}
	return output;
}
}
