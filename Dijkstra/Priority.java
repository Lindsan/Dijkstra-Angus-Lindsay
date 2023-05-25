/**
 * demponstrates priority queues
 *
 * Angus Lindsay
 * 31/03/23
 */
public class Priority
{
    private Queue lowP;
    private Queue highP;
    public Priority()
    {
        lowP = new Queue();
        highP = new Queue();
    }

    void enqueue(Element name, boolean high){
        if (high)
            highP.enqueue(name);
        else
            lowP.enqueue(name);
    }
    
    String dequeue(){
        if (highP.queueEmpty()) 
            return ""+lowP.dequeue();
        else
            return""+highP.dequeue();
    }
    
    boolean queueEmpty(){
        if (highP.queueEmpty() && lowP.queueEmpty())
            return true;
        else 
            return false;
    }
}
