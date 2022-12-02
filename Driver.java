import java.util.ArrayList;
import java.util.Stack;

public class Driver 
{
	/**
	 * 
	 * @param c
	 * @return
	 */
    static int getPrecedence(String c)
    {
        switch (c)
        {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
        }
        return -1;
    }
    
    /**
     * 
     * @param expression
     * @return
     */
    static ArrayList<String> infixToPostFix(String expression)
    {

        ArrayList<String> postorderArray = new ArrayList<String>();
        Stack<String> stack = new Stack<>();
        String[] arrOfStr = expression.split(" ", 0);

        for (String c : arrOfStr) 
        {
            if(getPrecedence(c)>0)
            {
                while(!stack.isEmpty() && getPrecedence(stack.peek())>=getPrecedence(c))
                {
                    postorderArray.add(stack.pop());
                }
                stack.push(c);
            }
            else if(c.equals(")"))
            {
                String x = stack.pop();
                while(!x.equals("("))
                {
                    postorderArray.add(x);
                    x = stack.pop();
                }
            }
            else if(c.equals("("))
            {
                stack.push(c);
            }
            else
            {
                postorderArray.add(c);
            }
        }
        while(!stack.isEmpty())
        {
            postorderArray.add(stack.pop());
        }
        return postorderArray;
    }

    /**
     *  
     * @param listOfTokens
     * @return
     */
    static Node getExpressionTreeFromPostFix(ArrayList<String> listOfTokens)
    {

        Stack<Node> stack = new Stack<>();
        for(String x : listOfTokens){
            Node node;
            if(getPrecedence(x) < 0)
            {
                node = new Node(x, "Operand");
            }
            else
            {
                node = new Node(x, "Operator");
                Node right = stack.pop();
                Node left = stack.pop();
                node.right = right;
                node.left = left;
            }
            stack.push(node);
        }

        return stack.pop();
    }

}