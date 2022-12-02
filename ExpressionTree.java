import java.util.ArrayList;

public class ExpressionTree 
{

    Node root;
    String expression;
    ArrayList<String> infixExpression;
/**
 * 
 * @param expression
 */
    public ExpressionTree(String expression)
    {
        this.expression = expression;
        this.root = getExpressionTreeFromExpression();
        this.infixExpression = getInorderTraversal();
    }
    /**
     * 
     * @param root
     * @param expression
     */
    public ExpressionTree(Node root, String expression) 
    {
        root = getExpressionTreeFromExpression();
        this.root = root;
        this.expression = expression;
        this.infixExpression = getInorderTraversal();
    }
    /**
     * 
     * @return
     */
    public Node getRoot() 
    {
        return root;
    }
    /**
     * 
     * @return
     */
    public String getExpression() 
    {
        return expression;
    }
    /**
     * 
     * @return
     */
    public Node getExpressionTreeFromExpression()
    {
        String expression = this.expression;
        ArrayList<String> postFixOrder = Driver.infixToPostFix(expression);
        Node root = Driver.getExpressionTreeFromPostFix(postFixOrder);
        return root;
    }
    /**
     * 
     * @return
     */
    public ArrayList<String> getInorderTraversal()
    {
        return expressionTreeIterator(this.root, "inorder");
    }
    /**
     * 
     * @return
     */
    public ArrayList<String> getPreorderTraversal()
    {
        return expressionTreeIterator(this.root, "preorder");
    }
    /**
     * 
     * @return
     */
    public ArrayList<String> getPostorderTraversal()
    {
        return expressionTreeIterator(this.root, "postorder");
    }
    /**
     * 
     * @param root
     * @param type
     * @return
     */
    public ArrayList<String> expressionTreeIterator(Node root, String type)
    {
        ArrayList<String> result = new ArrayList<String>();
        if(root == null){
            return result;
        }

        ArrayList<String> leftList = expressionTreeIterator(root.left, type);
        ArrayList<String> rightList = expressionTreeIterator(root.right, type);


        if(type.equals("inorder"))
        {
            result.addAll(leftList);
            result.add(root.val);
            result.addAll(rightList);
            }
        else if(type.equals("preorder"))
        {
            result.add(root.val);
            result.addAll(leftList);
            result.addAll(rightList);
            }
        else
        {
            result.addAll(leftList);
            result.addAll(rightList);
            result.add(root.val);
        }
        return result;
    }
     
    @Override
    public boolean equals(Object o) 
    {
        if (this == o) return true;
        if (!(o instanceof ExpressionTree)) return false;
        ExpressionTree that = (ExpressionTree) o;
        return getRoot().equals(that.getRoot());
    }

    @Override
    public String toString() 
    {
        return "ExpressionTree{ " +
                "type = " + getClass().getSimpleName()+
                ", infix expression = '" + infixExpression + '\'' +
                ", prefix expression = '" + this.getPreorderTraversal() + '\'' +
                ", postfix expression = '" + this.getPostorderTraversal() + '\'' +
                '}';
    }

}
