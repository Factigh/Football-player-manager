/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package player;


public class Stack { 
   private Object[] array;
   private int capacity;
   private int index; //top element index for stack

   
   public Stack(int capacity){ //constructor method
    this.capacity=capacity;
    array=new Object[capacity];
    index=-1; //stack is empty at start
    
}
   public void push(Object obj){
       if (index==capacity-1){ //array is full, can't push anymore
           System.out.println("Stack is full");
       }
       else{
           index++;
           array[index]=obj; //place the object
       }
   }
   
   public Object pop(){ //method for removing from stack and printing 
       if (isEmpty()){
           System.out.println("Stack is empty");
           return null;
       }
       Object obj=array[index]; //top element
       index--; //removing by shifting index
       return obj;
   }
   
   public boolean isEmpty(){
       return index==-1;  //if no element has been pushed yet
   }
}
    
   
