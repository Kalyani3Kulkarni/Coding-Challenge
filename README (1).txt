Coin Problem
======================================================

1. This program is implemented in Java
2. To run type following in command line:
   javac Coins.java
   java Coins
3. Then enter amount for which you want minimum number of Coins
4. Program will display minimum number of coins required to get this amount.
   It will also display what combination of cents, dimes, nickels and pennies is formed 

Logic:

1. This problem is solved using dynamic programming approach. Because it can be divided into smaller subproblem and 
   each of that can be solved to get final answer. As per dynamic programming approach, 
   I am using lookup table to save previous answer to avoid recomputation of same problem.    
2. Use two arrays:
   res = This array is of size amount+1. At each index it stores minimum number of coins required to obtain that amount
   ref = This array is of size amount+1. At each index is stores index of latest used coin to obtain that amount
3. Initialize these two arrays
4. Iterate over array of coins. For each coin, go over each amount starts with 1.
   If amount is greater than coin, that means coin can be used in obtaining the amount.
   Now, we will pick up that coin as candidate and use previous computed values to decide if that coin should be finalized or not.
5. After completion of 4th step last index of res array will have minimum number coins used to obtain the amount
6. To print the coins combination -
   Used ref array and hashmap. Hashmap contains pair of coin denomiation and its count.  
   Here 'start' will contain the amount. While start is greater than zero, use ref array to find which coin is used to obtain the amount.
   Since we used that coin, subtract it from start and continue the while loop. 
   Once start reaches to zero, iterate over hashmap and display all the values.

Space complexity : O(amount) --> Since I used two array of size amount+1  
Time complexity : O(nV) where n = size of coin array. In this case it is 4. We are using 4 denominations.
                              V = amount for which minimum combination required.
                              

Stock Problem 
============================

1. This program is implemented in python 3
2. To run type following in command line: python Stock.py
3. Then enter comma separated stock prices
4. I am displaying maximum profit, stock buy day and sell day.
5. If maximum profit cannot be found, I am displaying profit, buy day, sell day as 0

Logic:

1. Take stock prices in python list.
2. Iterate over list till reach end of it. 
3. During iteration, find local minima and store that index in variable 'buy'. Local minima is the number which is smaller than next element.
   If no minima found, I am printing profit, buy day , sell day as 0
4. Find local maxima and store that index in variable 'sell'. Local maxima is the number greater than next element.
   If I reach to end of list then store ending index in 'sell'.
5. find current profit by subtracting sell and buy index element. Update profit by comparing with current profit.     
6. Final profit is stored in 'profit' variable. Buy day is buy+1 and sell day is sell+1 


Space complexity : O(1)
Time complexity : O(n) where n = size of stock prices list. Since outer while loop runs till i reach to length-1
Two inner while loops are incrementing value of i till reach certain condition





