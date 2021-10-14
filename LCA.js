class Node
	{
		constructor(value) {
		this.left = null;
		this.right = null;
		this.data = value;
		}
	}
	
	let root;
	let path1 = [];
	let path2 = [];

	function findLCA(n1, n2) {
		path1 = [];
		path2 = [];
		return findLCAInternal(root, n1, n2);
	}

	function findLCAInternal(root, n1, n2) {

		if (!findPath(root, n1, path1) || !findPath(root, n2, path2))
		{
			document.write((path1.length > 0) ?
			"n1 is present" : "n1 is missing");
			document.write((path2.length > 0) ?
			"n2 is present" : "n2 is missing");
			return -1;
		}

		let i;
		for (i = 0; i < path1.length && i < path2.length; i++) {
			
			if (path1[i] != path2[i])
				break;
		}

		return path1[i-1];
	}

	function findPath(root, n, path)
	{

		if (root == null) {
			return false;
		}
	
		path.push(root.data);

		if (root.data == n) {
			return true;
		}

		if (root.left != null && findPath(root.left, n, path)) {
			return true;
		}

		if (root.right != null && findPath(root.right, n, path)) {
			return true;
		}

		path.pop();

		return false;
	}


