package Main;

import static java.lang.Math.pow;


public class RB_Tree {
    public Node root;
    public static final boolean RED   = true;
    public static final boolean BLACK = false;
    
    public boolean isRed(Node x){
        if(x==null)
            return false;
        return x.color==RED;
    }
    
    public float generateKey(String val)
    {
        float key = 0;
        val = val.toUpperCase();
        char[] arr = val.toCharArray();
        for(int i=0; i<val.length();i++)
        {
            System.out.println(arr[i]);
            key += arr[i]/pow(10,2*i);
        }
        System.out.println(key);
        return key;
    }    
    
  public Node insert(Node h,int key,String val){
        if(h==null)
            return new Node(key,val,RED);
        
        int cmp= h.compareTo(key);
        
        if(cmp<0)
            h.left=insert(h.left,key,val);
        else if(cmp>0)
            h.right = insert(h.right, key, val);
        else
            h.val=val; 
        if(isRed(h.right)&&!isRed(h.left)){
            h=rotateLeft(h);
        }
        if(isRed(h.left)&&isRed(h.left.left)){
            h=rotateRight(h);
        }
        if(isRed(h.left)&&isRed(h.right)){
            flipColors(h);
        }
        h.size = size(h.left) + size(h.right) + 1;
        
        return h;
    }
    public Node rotateLeft(Node h){
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        x.color=x.left.color;
        x.left.color=RED;
        x.size=h.size;
        h.size=size(h.left)+size(h.right)+1;
        return x;
    }
    public Node rotateRight(Node h){
        Node x=h.left;
        h.left=x.right;
        x.right=h;
        x.color=x.right.color;
        x.right.color=RED;
        x.size=h.size;
        h.size=size(h.left)+size(h.right);
        return x;
    }
    public void flipColors(Node h){
        h.color=!h.color;
        h.left.color=!h.left.color;
        h.right.color=!h.right.color;
    }
    public Node search(String inp){
        
    }
    public void insert(int key,String val){
        if(val==null){
            return;
        }
        root=insert(root,key,val);
        root.color=BLACK;        
    }
    public int size(Node x){
        if(x==null)
            return 0;
        return x.size;
    }
    public boolean isEmpty(){
        return root==null;
