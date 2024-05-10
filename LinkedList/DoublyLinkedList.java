class Node {
    int data;
    Node next;
    Node back;

    public Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    public Node(int data){
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

public class DoublyLinkedList {

    private static Node convert2ArrDLL(int[] arr){
        Node head = new Node(arr[0]);
        Node previous = head;

        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i],null,previous);
            previous.next = temp;
            previous = temp;
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

    private static Node deleteHeadDll(Node head){
        //Check if the head is empty or has a single element
        if(head == null || head.next == null){
            return null;
        }

        //For rest of elements
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;

        return head;
    }

    private static Node deleteTailDll(Node head){
        //Check if the head is empty or has a single element
        if(head == null || head.next == null){
            return null;
        }

        //For rest of elements
        Node tail = head;

        while(tail.next != null){
            tail = tail.next;
        }

        Node prev = tail.back;
        tail.back = null;
        prev.next = null;

        return head;
    }

    private static Node removeKDll(Node head, int k){
        if(head == null){
            return null;
        }

        Node temp = head;
        int count = 0;

        //Iterating to the Kth element
        while(temp != null){
            count++;
            if(count == k) break;
            temp = temp.next;
        }

        //After reaching Kth element we store Previous and Front node of temp Node
        Node previous = temp.back;
        Node front = temp.next;

        //Handling the edge cases
        //If there is single element
        if(previous == null && front == null){
            return null;
        }
        //If we are at the head of Dll
        else if(previous == null){
            return deleteHeadDll(head);
        }
        //if we are at the tail of Dll
        else if(front == null){
            return deleteTailDll(head);
        }

        //Rest of scenarios where we are in between Head and tail
        //removing temp linkage from previous and front
        previous.next = front;
        front.back = previous;

        //free the temp linkage from previous and front
        temp.next = null;
        temp.back = null;

        return  head;
    }

    private static Node removeElDll(Node head, int k){
        if(head == null){
            return null;
        }

        Node temp = head;
        //Iterating to the Kth element
        while(temp != null){
            if(temp.data == k) break;
            temp = temp.next;
        }

        //After reaching Kth element we store Previous and Front node of temp Node
        Node previous = temp.back;
        Node front = temp.next;

        //Handling the edge cases
        //If there is single element
        if(previous == null && front == null){
            return null;
        }
        //If we are at the head of Dll
        else if(previous == null){
            return deleteHeadDll(head);
        }
        //if we are at the tail of Dll
        else if(front == null){
            return deleteTailDll(head);
        }

        //Rest of scenarios where we are in between Head and tail
        //removing temp linkage from previous and front
        previous.next = front;
        front.back = previous;

        //free the temp linkage from previous and front
        temp.next = null;
        temp.back = null;

        return  head;
    }

    private static void deleteNode(Node temp){
        Node prev = temp.back;
        Node front = temp.next;

        if(front == null){
            prev.next = null;
            temp.back = null;
        }
        prev.next = front;
        front.back = prev;

        temp.next = null;
        temp.back = null;
    }

    private static Node insertBeforeHead(Node head,int val){
        Node newNode = new Node(val, head, null);
        head.back = newNode;
        return newNode;
    }

    private static Node insertBeforeTail(Node head, int val){
        if(head.next == null){
            return insertBeforeHead(head, val);
        }

        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        Node previous = tail.back;
        Node newNode = new Node(val, tail, previous);
        previous.next = newNode;
        tail.back = newNode;

        return head;

        //My method
        //        Node newNode = new Node(val, null, null);
        //        Node temp = head;
        //        while(temp.next.next != null){
        //            temp = temp.next;
        //        }
        //        Node front = temp.next;
        //        newNode.back = temp;
        //        newNode.next = front;
        //        front.back = newNode;
        //        temp.next = newNode;
        //
        //        return head;
    }

    private static Node insertBeforeK(Node head, int val, int k){

        if(head == null){
            if(k == 1){
                return new Node (val, null, null);
            }else return null;
        }
        if(k == 1){
            return insertBeforeHead(head, val);
        }

        Node temp = head;
        int count = 0;

        while(temp.next != null){
            count++;
            if(count == k){
                break;
            }
            temp = temp.next;
        }
        Node previous = temp.back;
        Node newNode = new Node(val, temp, previous);

        previous.next = newNode;
        temp.back = newNode;
        return head;
    }

    private static void insertBeforeNode(Node node, int val){

        Node previous = node.back;
        Node newNode = new Node(val, node, previous);

        previous.next = newNode;
        node.back = newNode;
    }
    
    public static void main(String[] args) {
        int arr[] = {12,5,6,8};
        Node head = convert2ArrDLL(arr);
        insertBeforeNode(head.next, 100);
        print(head);
    }
}
