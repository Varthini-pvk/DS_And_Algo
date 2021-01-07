package arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class P072_WordBreak {

	@Test

	public void example1() {
//		String s = "leetcode";
//		List<String> li = new ArrayList<String>();
//		li.add("leet");
//		li.add("code");
//		System.out.println("One"+wordBreak(s,li));
	}



	@Test

	public void example2() {



		String s = "applepenapple";
		List<String> li = new ArrayList<String>();
		li.add("apple");
		li.add("pen");
		System.out.println("Two"+wordBreak(s,li));



	}
	@Test
	public void example3() {
	String s = "catsanddog";
		List<String> li = new ArrayList<String>();
		li.add("cats");
		li.add("dog");
		li.add("sand");
		li.add("and");
		li.add("cat");
		System.out.println("Three"+wordBreak(s,li));
	}

	@Test
	public void example4() {
		String s = "abcd";
		List<String> li = Arrays.asList(new String[] {"a","abc","d","cd","b"});
		System.out.println("Four"+wordBreak(s,li));
	}
	
	public boolean wordBreak(String s, List<String> wordDict) 
	{
		return wordBreakrec(0,s,wordDict);
	}

	private boolean wordBreakrec(int start, String s, List<String> wordInDict)
	{
		if(start==s.length()) return true;
		
		for(int i=start+1;i<=s.length();i++)
		{
			System.out.println(s.substring(start, i));
			if((wordInDict.contains(s.substring(start, i)))&&(wordBreakrec(i,s,wordInDict)))
			{
				return true;
			}
		}
		return false;
	}
	
}



