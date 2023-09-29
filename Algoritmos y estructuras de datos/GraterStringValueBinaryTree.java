import java.util.Scanner;
import java.util.ArrayList;


class BinaryNode
{
    private char element;
    private BinaryNode rigthNode;
    private BinaryNode lefNode;

    BinaryNode(char e){
        element=e;
        rigthNode = null;
        lefNode=null;
    }


    public void setElement(char element) {
        this.element = element;
    }

    public void setLefNode(BinaryNode lefNode) {
        this.lefNode = lefNode;
    }

    public void setRigthNode(BinaryNode rigthNode) {
        this.rigthNode = rigthNode;
    }

    public char getElement() {
        return element;
    }

    public BinaryNode getLefNode() {
        return lefNode;
    }

    public BinaryNode getRigthNode() {
        return rigthNode;
    }
}

class BinaryTree
{
    protected BinaryNode root;
    static boolean val;

    BinaryTree()
    {
        root=null;
    }

    BinaryTree(BinaryNode object)
    {
        root= new BinaryNode(object.getElement());
    }

    private boolean isEmpty()
    {
        return root==null;
    }

    public boolean find(BinaryNode binaryNode,char c)
    {
        if(binaryNode.getElement()==c)
        {
            val=false;
            return val;
        }else if(binaryNode.getElement()<c)
        {
            if(binaryNode.getRigthNode()==null)
            {
                binaryNode.setRigthNode(new BinaryNode(c));
                val=true;
                return val;
            }else
            {
             find(binaryNode.getRigthNode(),c);  
            }
        }else if(binaryNode.getElement()>c)
        {
            if(binaryNode.getLefNode()==null)
            {
                binaryNode.setLefNode(new BinaryNode(c));
                val=true;
                return val;
            }else
            {
                find(binaryNode.getLefNode(), c);
            }
        }
        return val;
    }
}


public class GraterStringValueBinaryTree{
    private static String biggerSubStr(String str){
        /*take any character in the string str and compare if it exist in the linked list, if exist, then ignore it, if not, then add it.*/

        String resultStringRigth="";
        String resultStringLeft="";
        if(str.equals(null) || str.equals(""))
        {
            return "-1";
        }else{
            resultStringRigth=resultStringRigth+str.charAt(0);
            BinaryNode rootRigth = new BinaryNode(str.charAt(0));
            BinaryTree binaryTreeRigth= new BinaryTree(rootRigth);
            for(int i=1;i<str.length();i++)
            {
                if(binaryTreeRigth.find(rootRigth, str.charAt(i)))
                {
                   resultStringRigth=resultStringRigth+str.charAt(i);
                }
            }

            resultStringLeft=resultStringLeft+str.charAt(str.length()-1);
            BinaryNode rootLeft = new BinaryNode(str.charAt(str.length()-1));
            BinaryTree binaryTreeLeft= new BinaryTree(rootLeft);
            for(int i=str.length()-1;i>-1;i--)
            {
                if(binaryTreeLeft.find(rootLeft, str.charAt(i)))
                {
                   resultStringLeft=resultStringLeft+str.charAt(i);
                }
            }
        }
        if(resultStringLeft.compareTo(resultStringRigth)>0)
        {
            return resultStringLeft.toString();
        }else
        {
            return resultStringRigth.toString();
        }
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Introduce una cadena de texto:");
        String string = sc.nextLine();
        String resulString=biggerSubStr(string);
            System.out.println(resulString);
        sc.close();
    }
}