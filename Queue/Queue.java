package Queue;

public class Queue {
    int size = 5;
    int maya[] = new int[5];
    int front, rear;

    Queue() {
        front = rear = -1;

    }

    boolean isFull() {
        if ( front == 0 && rear == size-1) {
            return true;
        }
        else 
            return false;
        }

        boolean isEmpty() {
            if ( front == -1) {
                return true;
            }
            else return false;
        }

        void enQueue ( int a) {
            if ( isFull()) {
                System.out.println( " Q is full.");
            }
            else {
                if ( front == -1 ) 
                front = 0;
                rear ++;
                maya[rear] = a;
                System.out.println(" inserted element is "+a);

            }
        }

        int deQueue() {
            int a;
            if(isEmpty()) {
                System.out.println("Q is empty.");
                return -1;
            }
            else {
                a = maya[front];
                if( front >= rear) {
                    front = rear = -1;
               }
               else front++;
            } 
            System.out.println(" Deleted element is "+a);  
            return a;     
        }

    

    void display() {
        int i;
        if ( isEmpty()) {
            System.out.println(" Q is empty.");
        }
        else {
            System.out.println( "\n front index is "+ front);
            System.out.print(" Elements are => ");
            for ( i = 0; i<= rear; i++)
            System.out.print( maya[i]+" ");
            System.out.println("\n Rear index is "+ rear);

        }
    }
    public static void main(String[] args) {
       Queue q = new Queue();
       q.deQueue();


       q.enQueue(1);
       q.enQueue(2);
       q.enQueue(3);
       q.enQueue(4);
       q.enQueue(5);
       
       q.enQueue(6);
       q.display();

       q.deQueue();

       q.display();


    }

}


    
    

