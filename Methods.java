
public class Methods {


	//method1
	public int minOf3(int a, int b, int c) {
		if(a<=b) {
			if (a<=c) return a;
			//if we reach here it means that c<a<=b
			return c;
		}
		//if we reach here it means that b<a 
		if (b<=c) return b;
		//if we reach here it means that c<b<a
		return c;
	}

	//method2
	public boolean lollipopParty(int lollipops, boolean isNight) {
		//if each condition is met then the part is successful otherwise not
		if ((isNight == true) && (lollipops<77)) return true;
		if ((isNight == false) && (lollipops >=22) && (lollipops <=66) ) return true;
		//if we get here it means that none of the conditions were met and the part is not successful
		return false;		
	}

	//method3
	public int countDuplicates(String[] letters, int n) {
		//checking to see if the index is valid
		if (n>= letters.length) return 0;
		String myLetter = letters[n];
		int total = 0;
		//we check to see if each of the strings in array are equal to the chosen string (including the chosen string)
		// if they're equal we add 1 to total
		for (int i =0; i< letters.length ; i++) {
			if (myLetter.equals(letters[i])) total++;
		}
		return total;
	}

	//method4
	public String connectStrings(String str1, String str2) {

		int a = str1.length();
		int b = str2.length();

		//returning the proper strings based on what the question has asked 
		if ((a%2 == 0) && (b%2 == 0)) return str1.substring(0,(a/2)) + str2.substring(b/2);

		if ((a%2 == 0) && (b%2 == 1)) return str1.substring(0,a/2) + str2 + str1.substring(a/2);

		if ((a%2 == 1) && (b%2 == 0)) return str2.substring(0,b/2) + str1 + str2.substring(b/2);

		if ((a%2 ==1) && (b%2 == 1)) return str1.substring(0,1) + str2.substring(b-1);

		//we never get here but java doesn't know that
		return "";			

	}

	//method5
	public boolean equallyApart(int a, int b, int c) {

		int d1,d2,d3 = 0;

		// d1,d2 and d3 should be distances between a and b, b and c, and c and a respectively
		//so we have to return the positive value

		//d1
		if (b>=a) {
			d1 = b-a;
		}
		else {
			d1 = a-b;
		}

		//d2
		if (c>=b) {
			d2 = c-b;
		}
		else {
			d2 = b-c;
		}

		//d3
		if (a>=c) {
			d3 = a-c;
		}
		else {
			d3 = c-a;
		}

		// if two of the distances are the same then the answer is true otherwise false
		if ((d1==d2) || (d1==d3) || (d2==d3)) return true;
		//if we get here it means that none of the distances were not equal
		return false;

	}
	//method6
	public String grumpyHost(int yourClothes, int dateClothes) {

		//checking the conditions and returning based on each of them
		if ((yourClothes <= 2) || (dateClothes <= 2)) return "no";
		if ((yourClothes >= 8) || (dateClothes >= 8)) return "yes";
		// if we get here it means that the answer is not yes nor no and should be maybe
		return "maybe";
	}




	//method7
	public int sumFactors(int n) {

		// we go from 1 to n and check if n is divisible to each
		//if yes then we add it to total
		//if not we move on
		int total = 0;
		for (int i=1; i<=n; i++) {
			if (n%i == 0) total +=i;
		}
		return total;
	}

	//method8
	public String[ ] comingUp(String[ ] battingOrder,int leadOffPosition) {

		//if the batting order index is more than 8 then we have to go to first position and starts from there
		//so it means that we have to put the index remaining to 9 as the index each time
		//just the first time we know that the index is between 0 and 8 because:
		//leadOffPosition - 1 is between 0 and 8
		String[] result = { battingOrder[leadOffPosition-1],
				battingOrder[(leadOffPosition) % 9 ],
				battingOrder[(leadOffPosition+1) % 9] };

		return result;		
	}

	//method9
	public String evilE(String str) {

		//firstly for preventing any exception we add an space to the first and last of our string
		// cause we want x-1 and x+1 to be in our proper range
		//we will eliminate these two at last 
		//these two wont effect the result
		str = " " + str + " ";

		//x is the first occurrence of E 
		int x = str.indexOf("E");

		//if there is no E in the string then we don't change anything
		if (x == -1) return str;

		//if the letter in the x+1 place is not e or E it has to get replaced
		if (!(str.substring(x+1 , x+2).equalsIgnoreCase("e"))) {
			str = str.substring(0,x+1) + " " + str.substring(x+2);
		}

		//if the letter in x-1 place is not e or E it has to get replaced
		if (!(str.substring(x-1 , x).equalsIgnoreCase("e"))) {
			str = str.substring(0,x-1) + " " + str.substring(x);
		}

		//eliminating the two spaces we add at first
		return str.substring(1,str.length()-1);

	}

	//method10
	public boolean avoidWashingDishes(double amount, MenuItem[ ] order) {

		//firstly we calculate the total of our items
		double total = 0;
		for (MenuItem x : order) {
			total += x.getItemCost();
		}

		//then we return proper answer based on our calculation
		if (amount < total) return false;
		return true;
	}

	//method11
	public String[ ] parseString(String str) {

		// we eliminate the first part of our sentence up to the first space
		int x = str.indexOf(" ");
		str = str.substring(x+1);

		//we find the first space of our cut string 
		//which is the second space in our original one
		x = str.indexOf(" ");
		//the noun is between these two spaces
		String noun = str.substring(0,x);

		//then we cut this part again 
		str = str.substring(x+1);

		//now we find the first space in our newly changed string
		//which is the third space in our original one
		x = str.indexOf(" ");
		//adjective is everything after the third space
		String adjective = str.substring(x+1);

		//putting our noun and adjective into an array 
		String[] result = {noun , adjective};

		return result;
	}

	//method12
	public boolean canBuildFence(int numSmall, int numBig, int goal) {

		//we can't build fences with negative length
		if ( goal < 0 ) return false;
		//we can make 0 length fences by doing nothing
		if (goal == 0) return true;

		// if we reach here it means that our goal is bigger than 0

		if (numSmall == 0) {
			//we can't make a fence without having any fence pieces
			if (numBig == 0) return false;
			//if we reach here it means that we just have Big pieces 
			//we only can make the fence with numBig amount of 5 feet pieces if
			//we can make a 5 feet smaller fence with numBig-1 amount of 5 feet pieces
			return canBuildFence(0,numBig-1,goal-5);
		}
		//if we reach here it means that we have at least one small piece
		//if we get to the bellow if statement it means that we only have small pieces
		//it's the same as above but the length of the fence should be decreased by 1 
		//because the length of our smaller pieces are 1
		if (numBig == 0) return canBuildFence(numSmall-1,0,goal-1);

		//if we get here it means that we have both small pieces and big pieces
		//we only can make this fence with our pieces if we can make either 
		//a 1 feet smaller fence with 1 piece less of our small fences or
		//a 5 feet smaller fence with 1 piece less of our big fences
		return (canBuildFence(numSmall-1,numBig,goal-1)) || (canBuildFence(numSmall,numBig-1,goal-5));

		//it's OK if our return has a negative goal in it because in our method
		//we first check to see if it is negative and if it is negative we return false
	}


}