package Learnings;

import java.util.Arrays;

import org.junit.Test;

public class L011_PalindromSubStrings 
{
	//Loop through the string
//Add all the characters to result
//Loop through the length of array

//For odd number Palindromes
//To check if it is palindrome
//calculate mid=left+right/2
//Check if previous and next element are equal if yes add the substring to result 
	//if not break the loop
//Increment mid on both sides and continue

	//For even length number Palindromes
//assign left =mid and right=mid+1
	//Check if previous and next element are equal if yes add the substring to result 
		//if not break the loop
	
//Increment left and right and continue
	
	
	@Test
	public void dataSetOne()
	{
		String s="ac";
		System.out.println(longestPalindrome(s));
	}
	
	
	public String longestPalindrome(String s) 
    {
        char[] input=s.toCharArray();
        int max=0;String maxpalindrome="";
        for(int i=0;i<input.length;i++)
        {
            
            String odd=findPalindromes(i,i,input);
            String even=findPalindromes(i,i+1,input);
            int oddLength=odd.length();
            int evenLength=even.length();
            
            if(oddLength>max)
            {
                max=oddLength;
                maxpalindrome=odd;
                
            }
            if(evenLength>max)
            {
                max=evenLength;
                maxpalindrome=even;
                
            }
        }
return maxpalindrome;
        
    }
    
    private String findPalindromes(int start,int end, char[] array)
    {
        while(start>=0&&end<array.length&&array[start]==array[end])
        {
            start--;end++;
            
        }
       return String.copyValueOf(array,start+1,end-start-1);
    }
}
