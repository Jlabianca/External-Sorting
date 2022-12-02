

public class Node
{
    String val;
    String type;
    Node left, right;
    /** 
     * 
     * @param item
     * @param item_type
     */
    public Node(String item, String item_type)
    {
        val = item;
        type = item_type;
        left = right = null;
    }
    
    /**
     * 
     * @param val
     */
    public Node(String val) 
    {
        this.type = null;
        this.val = val;
    }
    
    /**
     * 
     * @return
     */
    public String getVal() 
    {
        return val;
    }
    
    /**
     * 
     * @param val
     */
    public void setVal(String val) 
    {
        this.val = val;
    }
    
    /**
     * 
     * @return
     */
    public String getType() 
    {
        return type;
    }
    
    /**
     * 
     * @param type
     */
    public void setType(String type) 
    {
        this.type = type;
    }
    
    /**
     * 
     * @return
     */
    public Node getLeft() 
    {
        return left;
    }
    
    /**
     * 
     * @param left
     */
    public void setLeft(Node left) 
    {
        this.left = left;
    }
    
    /**
     * 
     * @return
     */
    public Node getRight() 
    {
        return right;
    }
    
    /**
     * 
     * @param right
     */
    public void setRight(Node right) 
    {
        this.right = right;
    }

    @Override
    public String toString() 
    {
        return "Node{" +
                "val='" + val + '\'' +
                ", type='" + type + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public boolean equals(Object o) 
    {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return getVal().equals(node.getVal()) && getType().equals(node.getType()) && this.left.equals(node.left) && this.right.equals(node.right);
    }

}
