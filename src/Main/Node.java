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
    int key;
    
    private static final boolean RED   = true;
    private static final boolean BLACK = false;
    
    public Node (int key,String val,boolean color,int size){
        this.key=key;
        this.val=val;
        this.color=color;
        this.size=size;
    }

    @Override
    public int compareTo(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
            
    
}
