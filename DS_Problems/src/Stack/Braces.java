package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

public class Braces {
	
	@Test
	public void setOne()
	{
		String s="){[()}";
		System.out.println("1: "+valid(s));
	}

	@Test
	public void setTwo()
	{
		String s="[({})[]]";
		System.out.println("2: "+valid(s));
	}
	

	@Test
	public void setThree()
	{
		String s="{{(())))[[[[]]]]}}";
		System.out.println("3: "+valid(s));
	}
	
	@Test
	public void setFour()
	{
		String s="(((((())))))";
		System.out.println("4: "+valid(s));
	}
	
	//Solution 1
	public boolean valid1(String s)
	{
		Map<Character,Character> ref=new HashMap<>();
		ref.put('}','{');
		ref.put(']','[');
		ref.put(')','(');
		
		Stack<Character> check=new Stack<>();
		
		for(Character each:s.toCharArray())
		{
			if(ref.containsKey(each))
			{
				if( check.isEmpty()||check.pop()!=ref.get(each))
				{
					return false;
				}
			}
			else
			{
				check.push(each);
			}
		}
		return true;
	}
	//Solution 2
	
	public boolean valid(String s)
	{
		int counta=0;
		int countb=0;
		int countc=0;
		char[] array=s.toCharArray();
		for(Character eachChar:array)
		{
		switch(eachChar)
		{
		case '[':counta++;
				 break;
		case ']':counta--;
		 break;
		case '(':countb++;
		 break;
		case ')':countb--;
		 break;
		case '{':countc++;
		 break;
		case '}':countc--;
		 break;
		}
		if(counta<0||countb<0||countc<0)
		{
			return false;
		}
		
		}
		return (counta==0&&countb==0&&countc==0);
	}
	
}
