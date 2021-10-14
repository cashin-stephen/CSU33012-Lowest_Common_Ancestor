package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class LCommonATest {

	@Test
	void TestNode(){
        Node testNode = new Node(2);
        // Node constructs correctly 
        assertEquals(2, testNode.data);
        //Node constructs correctly with 0 param
        Node testNode2 = new Node(0);
        assertEquals(0, testNode2.data);
        
        //Node left and right are null for new nodes
        assertEquals(null, testNode.left);
        assertEquals(null, testNode.right);
        
	}
	
	@Test
	void TestFindLCA() {
		LCommonA tree = new LCommonA();
		LCommonA nullTree = new LCommonA();
		tree.root = new Node(7);
		tree.root.right = new Node(8);
		tree.root.left = new Node(9);
		tree.root.left.left = new Node(10);
		tree.root.left.right = new Node(11);
		tree.root.right.left = new Node(12);
		tree.root.right.right = new Node(13);
		tree.root.right.right.right = new Node(14);
		
		//Null Tree
		assertEquals(-1, nullTree.findLCA(0, 0));
		//N1 not on path
		assertEquals(-1, tree.findLCA(1,7));
		//N2 not on path
		assertEquals(-1, tree.findLCA(8,4));
		//N1 equals N2
		assertEquals(7, tree.findLCA(7,7));
		//N1 is same generation as N2
		assertEquals(9, tree.findLCA(10, 11));
		//N1 is higher than N2
		assertEquals(7, tree.findLCA(9, 14));
		//N2 is higher than N1
		assertEquals(7, tree.findLCA(8, 10));
		
	}
		

}
