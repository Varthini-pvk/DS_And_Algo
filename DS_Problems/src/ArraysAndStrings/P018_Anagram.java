package ArraysAndStrings;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P018_Anagram {

	@Test
	public void dataSetOne()
	{
		String one="cbaebabacd";
		String two="abc";
		System.out.println(findAnagrams(one,two));
	}
	

	@Test
	public void dataSetTwo()
	{
		String one="af";
		String two="be";
		System.out.println(findAnagrams(one,two));
	}
	
	public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result =new ArrayList<Integer>();
        int ascii_Expected=0;
        for(int i=0;i<p.length();i++)
        {
           ascii_Expected=ascii_Expected+p.charAt(i);
        }
        
        int ascii_Current=0;
        for(int i=0;i<=s.length()-p.length();i++)
        {
            int j=i;
            for(;j<i+p.length();j++)
            {
            ascii_Current=ascii_Current+s.charAt(j);
            }
        
            if(ascii_Current==ascii_Expected)
            {
                result.add(i);
            }
            ascii_Current=0;
        }
         return result;
    }
}
