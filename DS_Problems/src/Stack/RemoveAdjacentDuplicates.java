package Stack;

import java.util.Stack;

import org.junit.Test;

public class RemoveAdjacentDuplicates {
	
	@Test
	public void setOne()
	{
		String input="aabbccaab";
		System.out.println(removeadjacentDuplicates(input));
	}
	@Test
	public void setTwo()
	{
		String input="aabbbccaaaaa";
		System.out.println(removeadjacentDuplicates(input));
	}
	@Test
	public void setThree()
	{
		String input="aabbccaabbbbaa";
		System.out.println(removeadjacentDuplicates(input));
	}
	
	//Solution 1
	public String removeadjacentDuplicates1(String input)
	{
		Stack<Character> check=new Stack<>();
		for(Character each:input.toCharArray())
		{
			
				if(check.isEmpty()||check.peek()!=each)
				{
					check.push(each);
				}
				else
				{
					check.pop();
				}
			
		}
		
		return String.valueOf(check);
	}
	
	//Solution 2
		public String removeadjacentDuplicates(String input)
		{
			 StringBuilder output=new StringBuilder();
		        for(char i:input.toCharArray())
		       {
		            if (output.length()==0||output.charAt(output.length()-1)!=i)
		                {
		                     output.append(i);
		                }
		                else
		                {
		                   
		                    output.deleteCharAt(output.length()-1);
		                }
		       }
		                return output.toString();
		        
		}

}
