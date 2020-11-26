package ArraysAndStrings;


import org.junit.Test;

//Given a string, how many palindromic substrings in this string.
//
//Example 1:
//
//Input: "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//
//Example 2:
//
//Input: "aabc"
//Output: 4
//Explanation: Three palindromic strings: "a", "b", "c", "aa"

public class P009_FindPalindromeSubSttrings 
{
	@Test
	public void dataSetOne()
	{
		String input="aaa";
		System.out.println(countPalindrome(input));
	}
	
	@Test
	public void dataSetTwo()
	{
		String input="aabc";
		System.out.println(countPalindrome(input));
	}
	
	
	@Test
	public void dataSetThree()
	{
		String input="ffeaacddeeff";
		System.out.println(countPalindrome(input));
	}
	
	//Solution 1
//	1. Loop through the length of string and print all individual characters
//	2. Loop through the length of string , 
//		for the current element keep adding the all other elements and check if it is a palindrome
//		if yes increase the counter 
		
	private int countPalindrome1(String input)
	{
			char[] inputArray=input.toCharArray();
			String temp="";String temptwo="";
			int palindromeCount=inputArray.length;//for single characters
			for(int i=0;i<inputArray.length;i++)
			{
				temp="";
				temp=temp+inputArray[i];
				for(int j=i+1;j<inputArray.length;j++)
				{
		
					temp=temp+inputArray[j];
					if(isPalindrome(temp))
					palindromeCount++;
				}
			}
			return palindromeCount;
			
	}
	
	private Boolean isPalindrome(String toCheck)
	{
		Boolean flag=true;
		char[] temp=toCheck.toCharArray();
		int i=0;int j=temp.length-1;
		while(i<j)
		{
			if(temp[i]!=temp[j])
			{
				flag= false;
				break;
				
			}
			i++;j--;
		}
		return flag;
		
	}
//Solution 2
	
//count single character and two adjacent characters
//Loop using two pointers to find the the largest palindrome
	//if not break the loop
	//move the right pointer to continue to find the panlindromes
	private static int countPalindrome(String S) {
        int N = S.length(), result = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                result++;
                left--;
                right++;
            }
        }
        return result;
}
}
