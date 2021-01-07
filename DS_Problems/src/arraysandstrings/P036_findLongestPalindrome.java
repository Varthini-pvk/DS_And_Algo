package arraysandstrings;
import org.junit.Test;

//Find the longest palindrome in a given String: ababcacbab

//Quetsions:
//1. is the input case sensitive
//2. if there are multiple palindromes with maximum size, do we need to get all or first or last matching

public class P036_findLongestPalindrome {

	//DataSets

	@Test
	public void dataSetOne()
	{
		String input="ababcacbab";
		//String input="aaaaa";
		
		System.out.println(findLongestPalindrome(input));

	}

	//palindrome is on the left of the sequence, length is odd
	@Test

	public void dataSetTwo()
	{
		String input="aaabbbaaaefgjaaeeaa";
		System.out.println(findLongestPalindrome(input));
	}


	//Length is even

	@Test

	public void dataSetThree()
	{
		String input="aaaeeaagthggdaabe";
		System.out.println(findLongestPalindrome(input));
	}
	//Solution 1
	//Loop through the length of the charArray
	//Check the all combinations by starting current character with all other characters and check if palindrome
	//Store the maximum length of the palindrome and the palindrome
	//in the loop continue checking for palindrome if only the of the current sequence is greater than the maximum length
	//return the palindrome of maximum length

	private String findLongestPalindrome1(String input)
	{
		String longestPlaindrome="";int lengthOfLongestPalindrome=0;
		String currentSubstring="";
		for(int i=0;i<input.length();i++) 
		{
			for(int j=i;j<input.length();j++)
			{
				currentSubstring = input.substring(i, j+1);
				if(currentSubstring.length()>lengthOfLongestPalindrome)
				{
					if(isPalindrome(input.substring(i, j+1)))
					{
						longestPlaindrome=currentSubstring;
						lengthOfLongestPalindrome=currentSubstring.length();
					}
				}
			}
		}
		return longestPlaindrome ;
	}
	
	private Boolean isPalindrome(String currentString)
	{
		char[] temp=currentString.toCharArray();
		int i=0; int j=temp.length-1;
		while(i<j)
		{
			if(temp[i]!=temp[j])
			{
				return false;
			}
			i++;j--;
		}
		return true;
	}

	//Solution 2
	//initialize 3 variables: start=0, middle=0, end=length;
	//loop till middle<end
	//for each middle,intialize start -> middle-0 and end ->middle+0
	//continue, till start>0 or end <length
	//check if current sequence is palindrome and if yes check for longest
	//if not increment the middle and reset start and end

	private String findLongestPalindrome(String input)
	{
		String even = findLongestPalindromePart(input,1);
		String odd = findLongestPalindromePart(input,0);
		
		if(even.length()<odd.length())
		{
			return odd;
		}
		else
		{
			return even;
		}
	}
	
	private String findLongestPalindromePart(String input, int i)
	{
		String longestPalindrome="";String currentSubstring="";int lengthOfLongestPalindrome=0;
		int start=0; int middle=0;int end=0;int counter=0;
		while(middle<input.length())//O[N]
		{
			start=middle-0;
			end=middle+i;
			while(start>=0&&end<input.length())//O[M];M--> length of palindrome
			{
			
				counter++;
				currentSubstring=input.substring(start,end+1);
				if(input.charAt(start)==input.charAt(end))
				{
					if(lengthOfLongestPalindrome<currentSubstring.length())
					{
						longestPalindrome=currentSubstring;
						lengthOfLongestPalindrome=currentSubstring.length();
					}
						
						start--;					
						end++;
				}
				else
				break;
			}
			middle++;
			
		}
	System.out.println(input.length());
	System.out.println(counter);
	return longestPalindrome;
	}

}
