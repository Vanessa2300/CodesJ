import java.util.Scanner;

interface stack{
    void push(int item);
    int pop();
    void display();
}

interface queue{
    void enqueue(int item);
    void dequeue();
    void show();
}

class StackImplementation implements stack{
    private int stk[ ];
    private int top;
    StackImplementation(int size)
    {
        stk=new int[size];
        top=-1;
    }
    public void push(int item)
    {
        if(top>=stk.length-1)
            System.out.println("Stack Overflow");
        else {
            top++;
            stk[top]=item;
        }

    }
    public int pop()
    {
        if(top<0)
        {
            System.out.println("Stack Underflows");
            return 0;
        }
        else
            return stk[top--];
    }

    public void display(){
        if(top>=0) {
            for(int i=top; i>=0; i--){
                System.out.println(stk[i]);
            }
            System.out.println("NULL");
        } else
            System.out.println("Stack is empty");

    }
}


class QueueImplementation implements queue{

    private static int front, rear, qsize;
    private static int[] queue;

    QueueImplementation(int size) {
        front = rear = 0;
        qsize = size;
        queue = new int[qsize];
    }

    public void enqueue(int item) {
        if (qsize == rear) {
            System.out.println("\nQueue is full\n");
        }

        else {
            queue[rear] = item;
            rear++;
        }
    }

    public void dequeue() {
        if (front == rear) {
            System.out.println("\nQueue is empty\n");
        }
        else {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }
            if (rear < qsize)
                queue[rear] = 0;

           rear--;
        }
    }

    public void show() {
        int i;
        if (front == rear) {
            System.out.println("Queue is Empty\n");
            return;
        }

        // traverse front to rear and print elements
        for (i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
    }
}


public class stack_queue {
    public  static  void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        int value;

        System.out.println("\nImplementation of Stack");
        System.out.println("Enter number of elements for stack: ");
        n = sc.nextInt();
        StackImplementation s =new StackImplementation(n);

        for(int i=0; i<n; i++){
            System.out.println("Enter value: ");
            value =  sc.nextInt();
            s.push(value);
        }

        System.out.println("Stack elements: ");
        s.display();

        System.out.println("Stack after popping element: ");
        s.pop();

        System.out.println("Stack elements: ");
        s.display();

        System.out.println("-----------------------------------");

        System.out.println("Implementation of Queue");
        System.out.println("Enter number of elements for queue: ");
        n = sc.nextInt();
        QueueImplementation q =new QueueImplementation(n);

        for(int i=0; i<n; i++){
            System.out.println("Enter value: ");
            value =  sc.nextInt();
            q.enqueue(value);
        }

        System.out.println("Queue elements: ");
        q.show();

        System.out.println("\nQueue after dequeing element: ");
        q.dequeue();

        System.out.println("Queue elements: ");
        q.show();

        System.out.println("\n-----------------------------------");

    }
}
