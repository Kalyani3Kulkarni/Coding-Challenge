import sys

def maxProfit(li, length):
    if li is None or length <= 1:
        return

    i = 0
    buy = -1 
    sell = -1
    profit =  -sys.maxsize - 1
    while(i < length - 1):

        '''
        find local minima and store that index in buy. if no minima found, I am printing 
        profit as 0 and buy sell index as 0 
        Local minima is the number which is smaller than next element
        '''
        while ((i < length - 1) and (li[i + 1] <= li[i])):
            i = i+1

        if(i == length - 1):
            break
        buy = i
        i = i+1

        '''
        find local maxima and store that index in sell. if I reach to end of list then store 
        ending index in sell. Local maxima is the number greater than next element
        '''
        while ((i < length) and (li[i] >= li[i - 1])):
            i = i+1
        
        sell = i-1

        '''
        find current profit by subtracting sell and buy index element.
        Update profit by comparing with current profit.
        '''
        cp = li[sell] - li[buy]

        if(cp > profit):
            profit = cp

    if(profit == -sys.maxsize - 1):
        profit = 0

    print("Profit is :: {0}".format(profit))
    print("Buy on day :: {0}".format(buy+1))
    print("Sell on day :: {0}".format(sell+1) )    
        

if __name__ == "__main__":
    '''
    Tested following conditions
    3,8,8,55,38,1,7,42,54,53  8,3,7,15  3,3,1,7  3,3,3,3,3   8,0,0,0
    '''
    print("Enter comman separated stock prices...")
    x = input()
    li = x.split(',')
    li = list(map(int, li))
    maxProfit(li, len(li))