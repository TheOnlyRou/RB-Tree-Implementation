package Main;

/**
 *
 * @author user
 */
public class Node implements Comparable{
    Node left,right;
    String val ;
    boolean color;
    int size;
    float key;
    
    private static final boolean RED   = true;
    private static final boolean BLACK = false;
    
    public Node (float key,String val,boolean color){
        this.key=key;
        this.val=val;
        this.color=color;
    }

    @Override
    public int compareTo(Object t) {
        float key = (float)t;
        if(key == this.key)
            return 0;
        else if(key > this.key)
            return 1;
        else 
            return -1;
    }
}
