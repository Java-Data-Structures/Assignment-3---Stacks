import java.util.EmptyStackException;

public class Stack<E>{

    public Node head;
    public Node tail;
    private int size;

    public Stack(){
        head = null;
        tail = null;
    }

    //Push method adds a new element to the end of the stack(linked list).
    //This is identical to addLastNode in the linked list
    public void push(E e){
        size++;
        if (tail == null)
            head = tail = new Node(e); //empty list
        else
        {
            tail.next = new Node(e); //link new node as last node
            tail = tail.next; //make tail pointer points to last node
        }
    }

    //This method will remove the last node from the linked list and return it back to the user.
    public E pop() throws EmptyStackException{
        if(head == null){ //check to make sure there is a list to begin with.
            System.out.println("List is Empty.");
            throw new EmptyStackException();
        }else if(head.next == null){ //if there is only 1 Node, then just set head and tail to null.
            E poppedElement = head.data;
            head = null;
            tail = null;
            size--; //decrement the size.
            return poppedElement; //return the only node we have.
        }else{
            Node temp = head; //Set the temp pointer to head initially.
            while(temp.next.next!=null){ //Iterate through the list until we hit the second-to-last Node.
                temp = temp.next;
            }
            E poppedElement = temp.next.data; //save the last node.
            temp.next = null; //Change the pointer to the last Node to null, effectively deleting it.
            size--; //decrement the size.
            tail = temp;
            return poppedElement; //return the last node.
        }
    }

    //Peek at the top node of the stack. (which is the last node in the linked list.)
    public E top() throws EmptyStackException{
        if(head == null) throw new EmptyStackException(); //the stack is empty, how can we return a null value.
        return tail.data;
    }

    //Gets the size of the Stack.
    public int size() {
        return size;
    }

    //Returns true if the Stack is empty
    public boolean isEmpty(){
        return (head==null);
    }

    //helper method to print out the list, prints out the list in reverse.
    public void print(){ //Helper method that calls the actual recursive method.
        if(head == null){ //Edge case check to make sure that the list is not empty.
            System.out.print("Stack is empty.");
        }else{
            print(head);
        }
    }

    //Actual recursive print method that is called from the helper method.
    private void print(Node L) //actual recursive method that prints the list in reverse.
    {
        if(L.next != null){
            print(L.next); //Recursive call to make it to the end of the linked list.
        }
        //Non-tail recursion that will make it to the end of the linked list, and then start printing out values.
        System.out.println(L.data);

    }

    //class to create nodes as objects
    private class Node
    {
        private E data;  //data field
        private Node next; //link field

        public Node(E element) //constructor method
        {
            data = element;
            next = null;
        }
    }
}
