package mylinkedlist;





public class MyLinkedList {
    private Node head;
    
    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null ){
            temp = temp.next;
        }
        //sau câu lệnh này, tìm được temp cuối cùng và được
        //gắn cho temp
        temp.next = newNode;

    }

    public void add(int data, int index){
        Node newNode = new Node(data);
        if (index == 0 ) {
            addFirst(data);
            return;
        }else{
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node nextNode = temp.next;
            temp.next = newNode;
            newNode.next = nextNode;
        }

    }

    public int length(){
        int count = 0;
        if(head == null){
            return 0;
        } else count = 1;
        Node temp = head;
        while(temp.next != null){
            count++;
            temp = temp.next;
        }
        return count ;

    }

    public void display(){
        Node current = head;  
          
        if(head == null) 
            return; 
        System.out.println("Nodes of singly linked list: ");  
        while(current != null) {  
            System.out.print(current.getData() + " -> ");  
            current = current.next;  
        }  
        System.out.println();
        System.out.println();
        
    }  

    public void deleteFirst(){
        if(head == null)
            return;
        head = head.next;
    }

    public void deleteLast(){
        if (head == null)
            return;
        
        if(head.next == null){
            deleteFirst();
        }
        Node temp = head; // temp làm nhiệm vụ tìm ra node cuối cùng để xóa
        Node previous = null; // ghi lại Node đứng trước temp
        while(temp.next != null){
            previous = temp;
            temp = temp.next;
        }
        previous.next = null;
       
    }

    public void delete(int index){
        if(index == 0){
            deleteFirst();
            return;
        } else if(index == length()  -1){
            deleteLast();
            return;
        } else{
            Node preNodeDelete = head;
            for (int i = 1; i <= index-1; i++) {
                preNodeDelete = preNodeDelete.next;
            }
            preNodeDelete.next = preNodeDelete.next.next;
        }

    }
    
    /*
    * temp != null : sử dụng khi muốn cầm tất cả các node 
    * trong linkedlist đem ra xử lí, hay làm gì đó. Căn
    * bản là câu lệnh này sẽ bốc từ node đầu đến khi 
    * kết thúc (temp = null)
    * 
    * temp.next != null : sử dụng khi cần tìm ra cái node cuối 
    * cùng và gán nó cho temp
    */

    public boolean search(int data){
        if(head == null)
            return false;
        Node temp = head;
        while(temp != null){
            if(temp.getData() == data)
                return true;
        }
        return false;
    }

    public Node searchAtPosition(int index){
        if( index < 0 || index >= length())
            return null;
        Node temp = head;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    

        /*Xác định một nút hiện tại ban đầu trỏ tới đầu danh sách.
Duyệt qua danh sách cho đến khi điểm hiện tại trỏ tới null.
Hiển thị từng nút bằng cách trỏ đến nút bên cạnh nó trong mỗi lần lặp. */
    

    //void delete(int index)
    //void deleteLast()
    //boolean search(int data)
    //Node search(int index/ tìm kiếm tại 1 vị trí)
    //Node maxNode()
    //Node minNode()
    //void sortByPositionToAndEnd(int to, int end)
    
    public void delete2(int index){
        if(index == 0){
            deleteFirst();
            return;
        } else if(index == length() - 1){
            deleteLast();
            return;
        } else if(index >= length() ){
            throw new IndexOutOfBoundsException(index + "over linkedlist");
        }
        else{
            Node preNodeDelete = head;
            int count = 0;
            while(count < index - 1){
                preNodeDelete = preNodeDelete.next;
                count++;
            

            }
            
            preNodeDelete.next = preNodeDelete.next.next;
        }

    }

    public  void selectionSorting(){
        if(head == null)
            return;
        else if( head.next == null )
            return;
        else{
            Node temp = head;
            while( temp != null ){
                Node min = temp;
                Node nextNode = temp.next;
                while( nextNode != null ){
                    if(min.getData() > nextNode.getData())
                        min = nextNode;
                    nextNode = nextNode.next;
                }

                int variable = temp.getData();
                temp.setData(min.getData());
                min.setData(variable);
                

                temp = temp.next;
            }

        }
        

    }


   

    
}
