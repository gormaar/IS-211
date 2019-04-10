package DataStructures;

import java.util.Stack;

public class Stack1 {

    private Stack<Integer> stack;

    public Stack1()  {

        stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
    }

    public void stack() {

        while (!stack.empty())  {

            System.out.println(stack.pop());
            System.out.println(stack);
        }


    }
}
