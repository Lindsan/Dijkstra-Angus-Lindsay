
/**
 * has elements
 *
 * Angus Lindsay
 * @27/03
 */
public class Element
{
    // instance variables - replace the example below with your own
    private String name;
    private Element follower;
    Element element;
    /**
     * Constructor for objects of class element
     */
    public Element(String name)
    {
        // initialise instance variables
        this.name=name;
        
    }
 
    void addFollower(Element element)
    {
        this.element = element;
    }
    
    public Element getFollower()
    {
        return this.follower;
    }
    
    public int ElementCount(){
        if (getFollower()==null)
            return 0;
        else 
            return 1+follower.ElementCount();
    }
}
