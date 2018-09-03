import java.util.*;

public class coins {
	public void findCoinChange(int[] coins, int amount) {

		//If amount is zero or negative display 'invalid amount' and return
		if(amount <= 0) {
			System.out.println("Amount is not valid");
			return;
		}

		/* This problem is solved using dynamic programming approach.
		Because it can be divided into smaller subproblem and each of that can be solved to get final answer.
		As per dynamic programming approach, I am using lookup table to save previous answer to avoid recomputation of same problem.
        */
		int len = coins.length;

        //This array is of size amount+1. At each index it stores minimum number of coins required to obtain that amount
		int[] res = new int[amount+1];

		//This array is of size amount+1. At each index is stores index of latest used coin to obtain that amount
        int[] ref = new int[amount+1];

		//initialize the array
        res[0] = 0;
        ref[0] = -1;
        for(int i = 1; i <= amount; i++) {
        	res[i] = Integer.MAX_VALUE-1;
        	ref[i] = -1;
        }

		/*
			Iterate over array of coins. For each coin, go over each amount starts with 1.
			If amount is greater than coin, that means coin can be used in obtaining the amount.
			Now, we will pick up that coin as candidate and use previous computed values to decide if that coin should be finalized or not.
		*/
        for(int i=0; i<len; i++) {
            for(int j=1;j<=amount;j++){
                if(j>=coins[i]){
                    if(res[j] > res[j-coins[i]]+1){
                        res[j] = res[j-coins[i]]+1;
                        ref[j] = i;

                    }
                }
            }
        }


        if(ref[amount]==-1){
        	 System.out.println("No amount formed");
        	 return;
        }
        else {
        	printcoins(ref,coins);
        	System.out.println("Total coins " + res[amount]);
        }

    }

	public void printcoins(int[] ref, int[] coins) {
		int start = ref.length-1;
		HashMap<String,Integer> hash = new HashMap<String,Integer>(){{
			put("dimes", 0);
			put("nickels", 0);
			put("quarters", 0);
			put("pennies", 0);}};


		System.out.println("The changes are: ");
		/*
			ref array and hashmap is used to find combination of coins.
			Here 'start' will contain the amount. While start is greater than zero, use ref array to find which coin is used to obtain the amount.
			Since we used that coin, subtract it from start and continue the while loop.
			Once start reaches to zero, iterate over hashmap and display all the values.
		 */
		while(start >0)
		{
			int num = coins[ref[start]];
			String temp = new String();
			if(num == 5)
				temp = "nickels";
			else if(num == 10)
				temp = "dimes";
			else if(num == 25)
				temp = "quarters";
			else
				temp = "pennies";
			hash.put(temp,hash.get(temp)+1);
			start -= num ;
		}
		for(String key:hash.keySet())
			System.out.println(hash.get(key) + " "+ key);

	}

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the number in cents for example 83 or 105");
			int amount = 0;
			try{
				amount = scanner.nextInt();
			}catch(Exception e) {
				System.out.println("Enter amount in Integer");
				return;
			}
		coins c = new coins();
		int[] arr = {25,10,5,1};
			c.findCoinChange(arr,amount);
	}
}
