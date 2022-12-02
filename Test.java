import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test 
{
	/**
	 * 
	 * @param expression
	 */
    public static void testExpressionTree(String expression)
    {
        ExpressionTree expressionTree = new ExpressionTree(expression);
        System.out.println("Preorder Traversal = " + expressionTree.getPreorderTraversal());
        System.out.println("Inorder Traversal = " + expressionTree.getInorderTraversal());
        System.out.println("Postorder Traversal = " + expressionTree.getPostorderTraversal());
        System.out.println("toString() Output = \n" + expressionTree.toString());
        System.out.println();
    }
    
    /**
     * 
     * @param filename
     * @throws Exception
     */
    public static void ExpressionTreeTesting(String filename) throws Exception 
    {
        try {
            File bookData = new File(filename);
            Scanner readFile = new Scanner(bookData);
            while (readFile.hasNextLine()) {
                String information = readFile.nextLine();
                testExpressionTree(information);
            }
            readFile.close();
            System.out.println("Testing finished for ExpressionTree Class.\n");
        } catch (FileNotFoundException e) 
        {
            throw new FileNotFoundException("File not present!!");
        }
    }
     
    /**
     *  
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception 
    {
        System.out.println("Initializing testing for ExpressionTree Class.\n");
        ExpressionTreeTesting("expressions.txt");
    }

}
