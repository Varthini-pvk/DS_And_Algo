package ArraysAndStrings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.junit.Test;

//find the second least repeated character

//Questions

//is the input case sensitive
//what is expected if there is more than one match
public class P_038_SecondLeastRepeatedNumber {

	//DataSets
	@Test
	public void dataSetOne()
	{
		String input="paypal";
		System.out.println(findleastRepeated(input));
	}

	@Test
	public void dataSetTwo()
	{
		String input="ipaaypaali";
		System.out.println(findleastRepeated(input));
	}

	@Test
	public void dataSetThree()
	{
		String input="payPbl";
		System.out.println(findleastRepeated(input));
	}

	//Solution 1
	private Character findleastRepeated(String input)
	{
		Character result=null;
		if(input.length()>1)
		{
			Map<Character,Integer> count=new HashMap<Character,Integer>();
			List<Integer> values=new ArrayList<Integer>();
			for(int i=0;i<input.length();i++)
			{
				count.put(input.charAt(i), count.getOrDefault(input.charAt(i), 0)+1);
			}

			for (Entry<Character, Integer> entry : count.entrySet())   
			{  
				values.add(entry.getValue());
			}  
			Collections.sort(values);
			Integer required = values.get(2);
			if(values.get(0)!=required)
			{
				for (Entry<Character, Integer> entry : count.entrySet())   
				{  
					if(entry.getValue()==required)
					{
						result= entry.getKey();
						break;
					}

				}

			}


		}
		return result;
	}
//Solution 2
	/*
	 * private Character findleastRepeated1(String input) {
	 * 
	 * }
	 */

}
