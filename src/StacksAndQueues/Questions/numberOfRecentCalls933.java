package StacksAndQueues.Questions;

import java.util.*;

public class numberOfRecentCalls933 {

    Queue<Integer> ans;

    public numberOfRecentCalls933(){
        ans = new LinkedList<>();        // the RecentCounter method creates a queue.
    }

    public int ping(int t) {
        ans.add(t); // add the current time to the queue
        // remember, if the example is, 1,100,3001,3002,
        // these all are added one by one for example ping,ping,ping like this,
        // and the return type of the function is int so you only have to return the count for only one ping in one function call,
        // now if you have to return till 3001, you will have to only check for t till 3001 because the ping for 3002 has not even been called yet,
        // so what we do for 3001 is 3001(current time) - 3000 = range(1 to 3001),
        // so all the t stamps which do not lie in this range in the front of the queue needs to be removed,
        // it is given that value will only increase with the time as we pass through the queue

        while(!(ans.isEmpty()) && ans.peek() < t - 3000) {
            ans.remove();
        }
        return ans.size();  // all the remaining elements lie in the range
    }
    public static void main(String[] args) {

    }
}