package com.qa.javaAssessment;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {
		//First, put the string in lower case
		input = input.toLowerCase();
		//Next, count how many times 'bert' appears in the input
		String findbert = input;
		int index = findbert.indexOf("bert");
		int count = 0;
		while (index != -1) {
			count++;
			findbert = findbert.substring(index + 1);
			index = findbert.indexOf("bert");
		}
		//If there are two instances, get the letters in between the two instances
		if(count == 2) {
			int pFrom = input.indexOf("bert") + 4;
			int pTo = input.lastIndexOf("bert");
			String nobert = input.substring(pFrom, pTo);
		//Reverse the letters in nobert
			String reversed = new StringBuilder(nobert).reverse().toString();
			return reversed;
		}
		else return "";
	}
		
	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		//First, find the differences and make them absolute values
		 	int diff1 = Math.abs(a - b);
	        int diff2 = Math.abs(a - c);
	        int diff3 = Math.abs(b - c);
	        // Then, for each of the letters being the middle letter, check if the differences between them are the same
	        if(a > b && a < c || a < b && a > c) {
	            if(diff1 == diff2)
	                return true;
	            else return false;
	        }
	        else if(b > a && b < c || b < a && b > c) {
	            if (diff1 == diff3)
	                return true;
	            else return false;
	        }
	        else if(c > a && c < b || c < a && c > b) {
	            if (diff2 == diff3)
	                return true;
	            else return false;
	        }
	        else return false;
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		//Find how many character from each end to keep
		//Remember index starts from 0
		//Remember starting index is inclusive, ending is exclusive
		int charsToKeep = (input.length() - a) / 2;
		//If the string length is at least n and is odd when n is odd/even when n is even, return the outside characters
		if(input.length() > a && (input.length() + a)%2 == 0)
        return(input.substring(0, charsToKeep) + input.substring(input.length() - charsToKeep));
		else return "";
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		//initialise everything to 0 except for newletter, which will be looking at the second letter from the start
		int newletter = 1;
	       int index = 0;
	       int blocklength = 0;
	       int biggest = 0;
	       //while loop that will compare each character (newletter) with the one before it (index) and if they match
	       //will add one to the blocklength, but if they don't will put the block length to 0
	       //there can't be a blocklength of 1 as two letters are either the same which would be 2, or not which would be 0
	       while(newletter < input.length()) {
	           if (input.charAt(newletter) == input.charAt(index)) {
	                   if(blocklength ==0)
	                       blocklength = blocklength + 2;
	                   else blocklength++;
	           }
	           else blocklength = 0;
	           if(blocklength > biggest)
	               biggest = blocklength;
	           newletter++;
	           index++;
	       }
	       return biggest;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		//make them all lower case
		arg1 = arg1.toLowerCase();
        int i = 0;
        int count = 0;
        //cycling through the string to find where i is a, and then whether the conditions around it are correct
        for (i = 0; i < arg1.length(); i++) {
            if (arg1.charAt(i) == 'a') {
                if (i == 0 && arg1.charAt(i + 1) == 'm' && arg1.charAt(i + 2) == ' ')
                    count++;
                else if (i > 0 && arg1.charAt(i - 1) == ' ' && arg1.charAt(i + 1) == 'm' && arg1.charAt(i + 2) == ' ')
                    count++;
                else if (i > 0 && arg1.charAt(i - 1) == ' ' && arg1.charAt(i + 1) == 'm' && i + 1 == arg1.length())
                    count++;
            }
        }
        return count;
		
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		if(arg1 %3 ==0) {
			if(arg1 %5 ==0)
				return "fizzbuzz";
				else return "fizz";
		}
		else if(arg1 %5 ==0)
				return "buzz";
				else return null;
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		 int newnumber = 1;
	       int index = 0;
	       int addition = Character.getNumericValue(arg1.charAt(index));
	       int biggest = 0;
	       //going through each number and seeing if the one before is also a number
	       //if they are, add them together
	       //if either are spaces, they'll move to the next place along and set the sum back to 0
	       //when two numbers are added, this is stored as the biggest addition and is only overridden once a bigger addition is found
	       while(newnumber < arg1.length()) {
	           while(Character.getNumericValue(arg1.charAt(newnumber)) == -1 || Character.getNumericValue(arg1.charAt(index)) == -1) {
	               index++;
	               newnumber++;
	               addition = Character.getNumericValue(arg1.charAt(index));
	           }
	           addition += Character.getNumericValue(arg1.charAt(newnumber));
	           if(addition > biggest)
	               biggest = addition;
	           index++;
	           newnumber++;
	       }
	     return biggest;
	}
}
