from LCA import *  # The code to test
import unittest   # The test framework

class Test_TestLCA(unittest.TestCase):
    def test_Node(self):
        testNode = Node(4)
        #Node constructs correctly 
        self.assertEqual(testNode.key, 4)
        testNode = Node(0)
        #Node constructs correctly with 0 param
        self.assertEqual(testNode.key, 0)

        #Node left and right are null for new nodes
        self.assertEqual(testNode.left, None)
        self.assertEqual(testNode.right, None)

    def test_findLCA(self):
        root2 = Node(None)
        root = Node(7)
        root.left = Node(9)
        root.right = Node(8)
        root.left.left = Node(10)
        root.left.right = Node(11)
        root.right.left = Node(12)
        root.right.right = Node(13)
        root.right.right.right= Node(14)

        #Null Tree
        self.assertEqual(-1, findLCA(root2, 0,0))
        #N1 not on path
        self.assertEqual(-1, findLCA(root, 1, 7,))
        #N2 not on path
        self.assertEqual(-1, findLCA(root, 8, 4,))
        #N1 equals N2
        self.assertEqual(7, findLCA(root, 7, 7,))
        #N1 is same generation as N2
        self.assertEqual(9, findLCA(root, 10, 11,))
        #N1 is higher than N2
        self.assertEqual(7, findLCA(root, 9, 14,))
        #N2 is higher than N1
        self.assertEqual(7, findLCA(root, 8, 10,))


if __name__ == '__main__':
    unittest.main()
