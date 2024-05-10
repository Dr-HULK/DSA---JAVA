/*
class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data1) {
        this.data = data1;
        next = null;
    }
}

public class SingleLinkedList{

    private static Node convert2Arr(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i =1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            //System.out.print(mover.next + " ");
            mover.next = temp;
            //System.out.print(mover.next + "\n");
            mover = temp;
        }
        return head;
    }

    private static void print(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static int searchInLl(Node head, int k){
        Node temp = head;
        while( temp != null){
            if(temp.data == k) {
                return 1;
            }
            temp = temp.next;
        }
        return 0;
    }

    private static Node removeNode(Node head) {
        //To Check for empty node and 1 elemnet node
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node removeTail(Node head){
        //To check if the LL is null or has a single element
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node removeK(Node head, int k){
        //To Check if teh LL is null or has a single element
        if(head == null) return head;
        if(k == 1) return head = head.next;

        int count = 0; //To count the index
        Node temp = head;
        Node previous = null; //To Store previous

        while(temp != null){
            count++;
            if (k == count) {
                previous.next = previous.next.next;
                break;
            }
            previous = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node removeEl(Node head, int el){
        //To Check if the LL is null or has a single element
        if(head == null) return head;
        if(head.data == el) return head = head.next;

        Node temp = head;
        Node previous = null; //To Store previous

        while(temp != null){
            if (temp.data == el) {
                previous.next = previous.next.next;
                break;
            }
            previous = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node insertHead(Node head, int val){
        Node temp = new Node(val,head);
        return temp;
    }

    private static Node insertTail(Node head, int val){
        if(head == null) return new Node(val);
        Node newNode = new Node(val);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    private static Node insertK(Node head, int el, int k){
        //Check if the LL is empty
        if(head == null) {
            if(k == 1 ) {
                return new Node(el);
            }
            else return head;
        }

        //Check if LL has a single element
        if(k == 1){
            Node temp = new Node (el,head);
            return temp;
        }

        //For the rest of the cases

        Node temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            if (count == k - 1) {
                Node newNode = new Node(el,temp.next);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private static Node insertBeforeValue(Node head, int newElement, int val){
        //Check if the LL is empty
        if(head == null) {
            return null;
        }

        //Check if LL has a single element
        if(head.data == val){
            Node temp = new Node (newElement,head);
            return temp;
        }

        //For the rest of the cases
        Node temp = head;
        boolean found = false;
        while(temp.next != null) {
            if (temp.next.data == val) {
                Node newNode = new Node(newElement,temp.next);
                temp.next = newNode;
                found = true;
                break;
            }
            temp = temp.next;
        }
        if(found == false ){
            return null;
        }
        return head;
    }

    public static void main(String[] args) {
        int arr[] = {12,5,6,8};
        Node head = convert2Arr(arr);
        print(head);

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            System.out.print(temp.next + " " + "\n");
            temp = temp.next;
        }

        int numberToSearch = 8;
        int result = searchInLl(head,numberToSearch);
        if(result == 1){
            System.out.println("Number is found in LL");
        }else{
            System.out.println("Number is not present in LL");
        }

        head = removeTail(head);
        print(head);
    }
}
*/
