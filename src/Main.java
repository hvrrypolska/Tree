public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert("apple");
        bst.insert("banana");
        bst.insert("cherry");
        bst.insert("date");

        System.out.println(bst.search("banana"));
        System.out.println(bst.search("grape"));

        System.out.println(bst.findMin());
        System.out.println(bst.findMax());

        bst.remove("banana");
        System.out.println(bst.search("banana"));

        bst.remove("grape");

        bst.insert("date");

        bst.remove("apple");
        System.out.println(bst.findMin());
    }
}





