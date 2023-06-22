
public class LinkedList {
    Node head;
    Node tail;


    private class Node {
            Integer value;
            Node next;
            Node prev;
        }

    public void pushFront(Integer value) {  // O(1)
        Node node = new Node();
        node.value = value;
        if (head == null) {
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    public void deleteFront() {  // O(1)
        if (head != null) {
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        }
    }

    public void pushBack(Integer value) {  // O(1)
        Node node = new Node();
        node.value = value;
        if (tail == null) {
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
    }

    public void deleteBack() {  // O(1)
        if (tail != null) {
            if (tail.prev == null) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
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

    public void reversPrint(){
        Node node = tail;
        while (node != null) {
            System.out.printf(node.value + " ");
            node = node.prev;
        }
        System.out.println();
    }

    public void sort(){
        boolean flag = true;
        do{
            flag = false;
            Node node = head;
            while (node != null && node.next != null) {
                if (node.value > node.next.value) {
                    Node before = node.prev;
                    Node cur = node;
                    Node next = node.next;
                    Node after = next.next;

                    cur.next = after;
                    cur.prev = next;
                    next.next = cur;
                    next.prev = before;

                    if (before != null)
                        before.next = next;
                    else
                        head = next;
                    if (after != null)
                        after.prev = cur;
                    else
                        tail = cur;
                    flag = true;
                }
                node = node.next;
            }
        } while (flag);

    }

    /*
    Необходимо реализовать метод разворота связного списка 
    (двухсвязного или односвязного на выбор).
     */

    // Метод разворота двухсвязного списка 
	public void reverse()
	{
		Node temp = null;
		Node current = head;

		// Меняем местами next и prev ноды двусвязного списка
		while (current != null)
		{
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}

		/* Если список не пустой и не с одним узлом */
		if (temp != null)
		{
			head = temp.prev; // замена head
		}
	}

    

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
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
//        list.sort();

        list.reverse();
        list.print();

    }
}
