import java.util.*;
class GFG
{
//my node class
static class Node
{
int data;
Node left, right;
};

static Node newNode(int data)
{
Node temp = new Node();
temp.data = data;
temp.left = temp.right = null;
return temp;
}

static Node flipBinaryTree(Node root)
{
// Initialize pointer
Node curr = root;
Node next = null;
Node temp = null;
Node prev = null;

while(curr != null)
{
next = curr.left;
curr.left = temp;

temp = curr.right;

curr.right = prev;

prev = curr;
curr = next;
}
return prev;
}

static void printLevelOrder(Node root)
{

if (root == null) return;

Queue q = new LinkedList();

q.add(root);

while (true)
{
int nodeCount = q.size();
if (nodeCount == 0)
break;

while (nodeCount > 0)
{
Node node = (Node) q.peek();
System.out.print(node.data + " ");
q.remove();

if (node.left != null)
q.add(node.left);

if (node.right != null)
q.add(node.right);
nodeCount--;
}
System.out.println();
}
}

// Driver function
public static void main(String args[])
{
Node root = newNode(1);
root.left = newNode(2);
root.right = newNode(3);
root.right.left = newNode(4);
root.right.right = newNode(5);

printLevelOrder(root);

root = flipBinaryTree(root);

printLevelOrder(root);
}
}
