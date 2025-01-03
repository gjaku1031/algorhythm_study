package baek.step.stackQueDeq;


//크기가 고정되어 있어서 완전하지는 않음!!

public class ArrayStack {
    int top;    //인덱스
    int size;    //배열의 크기
    int [] stack;


    public ArrayStack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void arrayStackPush(int item) {
        stack[++top] = item;
        System.out.println(stack[top] + " Push");
    }
    public void arrayStackPop() {
        System.out.println(stack[top] + " Pop");
        int pop = stack[top];
        stack[top--] = 0;
    }
    public void arrayStackPeek() {
        System.out.println(stack[top] + " Peek");
    }

    public void showArrayStack() {
        for (int i : stack) {
            System.out.print(i + " ");
        }
    }
}