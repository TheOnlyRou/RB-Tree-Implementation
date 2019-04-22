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
    
    public int size(Node x){
        if(x==null)
            return 0;
        return x.size;
    }
    
    public boolean isEmpty(){
        return root==null;
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
<<<<<<< HEAD
            h.val=val;        
        return h;
    }
        public void delete(float key) {
        if (0.0f == key) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;
 
        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
 
        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }
 
    private Node delete(Node h, float key) {
        if (h.compareTo(key) < 0)  {
            if (!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        }
        else {
            if (isRed(h.left))
                h = rotateRight(h);
            if (h.compareTo(key) == 0 && (h.right == null))
                return null;
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if (h.compareTo(key) == 0) {
                Node x = min(h.right);
                h.key = x.key;
                h.val = x.val;
                h.right = deleteMin(h.right);
            }
            else h.right = delete(h.right, key);
        }
        return balance(h);
    }
    
    private Node balance(Node h) {
 
        if (isRed(h.right))                      h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);
 
=======
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
>>>>>>> parent of 256eb3e... maroooo
        h.size = size(h.left) + size(h.right) + 1;
        
        return h;
    }
<<<<<<< HEAD
    
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
=======
    public Node rotateLeft(Node h){
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        x.color=x.left.color;
        x.left.color=RED;
        x.size=h.size;
        h.size=size(h.left)+size(h.right)+1;
>>>>>>> parent of 256eb3e... maroooo
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
    
    public void insert(String val){
        if(val==null){
            return;
        }
        float key = generateKey(val);
        root=insert(root,key,val);
        root.color=BLACK;        
    }
    
    public Node insert(Node h, float key, String val){
        if(h==null)
            return new Node(key,val,RED);
        
        int cmp= h.compareTo(key);
        
        if(cmp<0)
            h.left=insert(h.left,key,val);
        else if(cmp>0)
            h.right = insert(h.right, key, val);
        else
            h.val=val;        
        return h;
<<<<<<< HEAD
    }
 public boolean isEmpty() {
        return root == null;
    }
 public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
 
        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
    }
    private Node deleteMin(Node h) {
        if (h.left == null)
            return null;
 
        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);
 
        h.left = deleteMin(h.left);
        return balance(h);
    }
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
 
        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
       
    }
    private Node deleteMax(Node h) {
        if (isRed(h.left))
            h = rotateRight(h);
 
        if (h.right == null)
            return null;
 
        if (!isRed(h.right) && !isRed(h.right.left))
            h = moveRedRight(h);
 
        h.right = deleteMax(h.right);
 
        return balance(h);
    }
 
    public float min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    }
    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }
 
    public float max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    }
    private Node max(Node x) {
        // assert x != null;
        if (x.right == null) return x;
        else                 return max(x.right);
    }
     private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }
    public int size() {
        return size(root);
    }
    public boolean contains(float key) {
        return get(key) != null;
    }
     public String get(float key) {
        if (0.0f == key) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }
 
    private String get(Node x, float key) {
        while (x != null) {
            int cmp = x.compareTo(key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.val;
        }
        return null;
    }
=======
    }    
>>>>>>> parent of 256eb3e... maroooo
}
