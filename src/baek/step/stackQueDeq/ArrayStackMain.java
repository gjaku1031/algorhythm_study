package baek.step.stackQueDeq;

import java.util.Scanner;

public class ArrayStackMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayStack stack = new ArrayStack(3);
        stack.arrayStackPush(1);
        stack.arrayStackPush(2);
        stack.showArrayStack();
        stack.arrayStackPeek();
        stack.arrayStackPush(3);
        stack.showArrayStack();
        stack.arrayStackPop();
        stack.showArrayStack();
        stack.arrayStackPop();
        stack.arrayStackPeek();
        stack.arrayStackPop();
        sc.close();
    }
}
