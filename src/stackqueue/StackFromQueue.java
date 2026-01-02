package stackqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class StackFromQueue {
    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>();
        q.addAll(List.of(1,2,4,55,7,7,89,65,45));
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while (!q.isEmpty()){
            int a =  q.poll();
            System.out.println(a);
            st1.push(a);
            st2.push(a);
        }

    }
}
