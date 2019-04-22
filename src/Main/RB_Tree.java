package Main;


public class RB_Tree {
    public Node root;
    public static final boolean RED   = true;
    public static final boolean BLACK = false;
    
    public boolean isRed(Node x){
        if(x==null)
            return false;
        return x.color==RED;
    }
    public void insert(int key,String val){
        if(val==null){
            delete(key);
            return;
        }
        root=insert(root,key,val);
        root.color=BLACK;
            
        
    }
    public Node insert(Node h,int key,String val){
        if(h==null){
            return new Node(key,val,RED,1);
        }
        int cmp=key.compareTo(h.key);
        if(cmp<0){
            h.left=insert(h.left,key,val);
        }
        else if(cmp>0){
            h.right = insert(h.right, key, val);
        }
        else
            h.val=val;
        }
        return h;
    }
    

    
    
}
