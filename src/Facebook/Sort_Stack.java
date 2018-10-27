package Facebook;

import java.util.Stack;

public class Sort_Stack {
    /**
     * The idea is that when we have a small element, pop and push back peek elements in retStack that is greater
     * than small element in original stack to the original stack. Such that we make sure that the elements in retStack
     * are in order
     * @param inputStack input stack
     * @return sorted stack
     */
    public static Stack<Integer> sortStack(Stack<Integer> inputStack){

        Stack<Integer> retStack = new Stack<>();

        while (!inputStack.isEmpty()) {
            int tmp = inputStack.pop();
            while (!retStack.isEmpty() && tmp < retStack.peek()) {
                inputStack.push(retStack.pop());
            }
            // Now all elements in retStack are in order and are smaller than tmp, now safely push to retStack
            retStack.push(tmp);
        }

        return retStack;
    }

    public static void main(String a[]){

        Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);
        System.out.println("input: "+input);
        System.out.println("final sorted list: "+sortStack(input));
    }
}
