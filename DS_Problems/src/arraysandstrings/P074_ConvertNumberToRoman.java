package arraysandstrings;

import org.junit.Test;

public class P074_ConvertNumberToRoman 
{
	public String[] Thousands= {"", "M","MM","MMM"};
	public String[] Hundreds= {"", "C","CCC","CCC","CD","D","DC","DCC","DCCC","CM"};
	public String[] Tens= {"", "X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
	public String[] Ones= {"", "I","II","III","IV","V","VI","VII","VIII","IX"};

@Test
public void dataSetOne()
{
	int number=1;
	System.out.println(intToRoman(number));
}

@Test
public void dataSetTwo()
{
	int number=1000;
	System.out.println(intToRoman(number));
}

@Test
public void dataSetThree()
{
	int number=1994;
	System.out.println(intToRoman(number));
}

@Test
public void dataSetFour()
{
	int number=0;
	System.out.println(intToRoman(number));
}

@Test
public void dataSetFive()
{
	int number=50000;
	System.out.println(intToRoman(number));
}

private String intToRoman(int number)
{
	if(number==0) return "Zero";
	if(number<0||number>3999) return "invalid input";
	return toRoman(number);
	
}

private String toRoman(int number)
{
	if(number>=1000) return Thousands[number/1000]+toRoman(number%1000);
	if(number>=100) return Hundreds[number/100]+toRoman(number%100);
	if(number>=10) return Tens[number/10]+toRoman(number%10);
	return Ones[number];
}
}
