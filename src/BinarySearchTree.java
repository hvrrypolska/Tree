class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(String value) {
        try {
            this.root = insertNode(this.root, value);
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: Element " + value + " już istnieje w drzewie.");
        }
    }

    private TreeNode insertNode(TreeNode node, String value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value.compareTo(node.value) < 0) {
            node.left = insertNode(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = insertNode(node.right, value);
        } else {
            throw new IllegalArgumentException();
        }

        return node;
    }

    public boolean search(String value) {
        return searchNode(this.root, value);
    }

    private boolean searchNode(TreeNode node, String value) {
        if (node == null) {
            return false;
        }

        if (value.equals(node.value)) {
            return true;
        } else if (value.compareTo(node.value) < 0) {
            return searchNode(node.left, value);
        } else {
            return searchNode(node.right, value);
        }
    }

    public void remove(String value) {
        try {
            this.root = removeNode(this.root, value);
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: Element " + value + " nie istnieje w drzewie.");
        }
    }

    private TreeNode removeNode(TreeNode node, String value) {
        if (node == null) {
            throw new IllegalArgumentException();
        }

        if (value.compareTo(node.value) < 0) {
            node.left = removeNode(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = removeNode(node.right, value);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                TreeNode minNode = findMinNode(node.right);
                node.value = minNode.value;
                node.right = removeNode(node.right, minNode.value);
            }
        }

        return node;
    }

    private TreeNode findMinNode(TreeNode node) {
        if (node.left != null) {
            return findMinNode(node.left);
        }

        return node;
    }

    public String findMin() {
        if (this.root == null) {
            throw new IllegalStateException("Błąd: Drzewo jest puste.");
        }

        TreeNode minNode = findMinNode(this.root);
        return minNode.value;
    }

    public String findMax() {
        if (this.root == null) {
            throw new IllegalStateException("Błąd: Drzewo jest puste.");
        }

        TreeNode maxNode = findMaxNode(this.root);
        return maxNode.value;
    }

    private TreeNode findMaxNode(TreeNode node) {
        if (node.right != null) {
            return findMaxNode(node.right);
        }

        return node;
    }
}