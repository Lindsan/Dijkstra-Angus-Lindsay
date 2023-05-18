/**
 * Angus Lindsay
 *27/03
 * queues
 */
public class Queue
{

    private Element head;
    private Element tail;

    /**
     * Constructor for objects of class queue
     */
    public Queue()
    {
        // initialise instance variables

    }

    public void enqueue(Element person){
        queueEmpty();
        if (queueEmpty()==true){
            head=person;
            tail=person;
        } else {
            tail.addFollower(person);
            tail=person;
        }
    }

    public void dequeue(Element person){
        Element remember;
        if (queueEmpty() == true)
            System.out.println("cannot dequeue, queue is empty");
        else{
            remember = this.head;
            //head = remember.getFollower;
        }
    }

    public boolean queueEmpty(){
        if (head==null) {
            return true;
        } else {
            return false;
        }
    }

    public Element dequeue() {
        Element remember;
        queueEmpty();
        if (queueEmpty() == true) {
            System.out.println("queue is empty, can't remove");
            return null;
        } else if (head==tail) { remember=this.head;
            head=remember.getFollower();
            tail=null;
            return remember;
        } else {
            remember=this.head;
            head=remember.getFollower();
            return remember;
        }
    }
    
    public int length(){
        return 1+head.ElementCount();
    }
}