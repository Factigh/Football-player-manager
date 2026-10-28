/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package player;



public class DoublyLinkedList { 
    
    private Node head;
    private Node tail;
    
    
    public DoublyLinkedList(){ //no parameter constructor method
        head=null;
        tail=null;
    }
    
    public class Node{ // inner Node class
        private Player info;
        private Node previous;
        private Node next;
        
        public Node(Player info){ //Node constructor method
            this.info=info;
            this.previous=null;
            this.next=null;
        }
        
        //getter and setter methods for Node class
        public Player getInfo() {
            return info;
        }

        public void setInfo(Player info) {
            this.info = info;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }         
    }
    
    //getter and setter methods for DoublyLinkedList class
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
    
    
    public void insert(Player newInfo){ //method for inserting in alphabetical order by name then surname
       Node added=new Node(newInfo);
       
       if (head==null){ // list is empty, inserting the first node
           head=added;
           tail=added;
       }
       else if(newInfo.getName().compareToIgnoreCase(head.info.getName())<0 || //inserting before head
               (newInfo.getName().equalsIgnoreCase(head.info.getName()) &&
               newInfo.getSurname().compareToIgnoreCase(head.info.getSurname())<0)){
         added.next=head;
         head.previous=added;
         head=added;
       }
       else{ //searcing the list for correct spot to insert
           Node current=head;
           
           while (current.next!=null){
               String currName=current.next.info.getName();
               String currSurname=current.next.info.getSurname();
               
               int nameEqual=newInfo.getName().compareToIgnoreCase(currName);
               int surnameEqual=newInfo.getSurname().compareToIgnoreCase(currSurname);
               
               if (nameEqual<0 || (nameEqual==0 && surnameEqual<0)){ //finding the spot
                   break;
               }
               current=current.next;
           }
           if (current.next==null){ //reached end, inserting at the tail
               current.next=added;
               added.previous=current;
               tail=added;
           }
           else{
               added.next=current.next; //inserting in the middle
               added.previous=current;
               current.next.previous=added;
               current.next=added;
           }
           
       }
    }
    
    public void delete(String name,String surname){ //method for removing the node with given name and surname
        Node current=head;
        while (current!=null){
            if(current.info.getName().equalsIgnoreCase(name) && current.info.getSurname().equalsIgnoreCase(surname)){ 
                //comparing given name and surname with node's name and surname
                if(current==head){
                    //removing the head
                    head=head.next;
                    if(head!=null){
                        head.previous=null;
                    }
                    else{
                         //list is empty
                        tail=null;
                    }
                }
                else if(current==tail){
                    //removing the tail
                    tail=tail.previous;
                    if(tail!=null){
                        tail.next=null;
                    }
                }
                else{
                    //removing from middle
                    current.previous.next=current.next;
                    current.next.previous=current.previous;
                }
             break;   
            }
            current=current.next;
        }
    }
    
    public void printAscending(){ //printing from head to tail
        Node current=head;
        while (current!=null){
            System.out.println(current.info);
            current=current.next;
        }
    }
    public void printDescending(){ //printing from tail to head
        Node current=tail;
        while (current!=null){
            System.out.println(current.info);
            current=current.previous;
        }
    }
 
}

