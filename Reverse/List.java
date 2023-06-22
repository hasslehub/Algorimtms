public class List {
    Node head;


    private class Node {
            Integer value;
            Node next;
        }

    public void pushFront(Integer value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public void deleteFront() {
        if (head != null)
            head = head.next;
    }

    public void pushBack(Integer value) {
        Node node = new Node();
        node.value = value;
        if (head == null)
            head = node;
        else {
            Node currentNode = head;
            while (currentNode.next != null)
                currentNode = currentNode.next;
            currentNode.next = node;
        }
    }

    public void deleteBack() {
        if (head != null) {
            if (head.next == null)
                head = null;
            else {
                Node cur = head;
                while (cur.next.next != null) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
    }

    public boolean contains(Integer value) {
        Node node = head;
        while (node != null) {
            if (node.value.equals(value))
                return true;
            node = node.next;
        }
        return false;
    }


    public void print() {
        Node node = head;
        while (node != null) {
            System.out.printf(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    /*
    Необходимо реализовать метод разворота связного списка 
    (двухсвязного или односвязного на выбор).
     */

    // Метод разворота односвязного списка 
    public void reverseList() {
        Node current = head;
        Node previous = null;
        Node temp = null;
        while (current != null) {
            temp = current.next; // сохраняем текущ

            current.next = previous; // меняем ноды
            previous = current;  // следующее значение previous 

            current = temp; // следующее значение current

        }		
		head = previous; // последняя нода -> head 
    }
    

    

    public static void main(String[] args) {
        List list = new List();
        for (int i = 1; i < 10; i++) {
            list.pushFront(i);
        }
        list.print();
//        list.deleteFront();
//        list.deleteFront();
//        list.print();
//        System.out.println(list.contains(2));
//        System.out.println(list.contains(5));
//        list.deleteBack();
//        list.print();
//        list.pushBack(7);
//        list.print();
        list.reverseList();
        list.print();
    }
}