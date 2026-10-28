/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package player;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
        public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        DoublyLinkedList list=new DoublyLinkedList();
        Stack stack = new Stack(100);
        
        boolean running=true;
        while (running){
            
            int option=0; //a value assigned
            boolean error=true;
            while(error){ //control loop for invalid inputs
                try{
                    //showing the menu
                    System.out.println("1) Load players from file");
                    System.out.println("2) Add new player");
                    System.out.println("3) Search and display player");
                    System.out.println("4) Remove player");
                    System.out.println("5) Print A-Z");
                    System.out.println("6) Print Z-A");
                    System.out.println("7) Copy to stack and print");
                    System.out.println("8) Save to file and exit");
                    System.out.print("Choose: ");
                    option = input.nextInt();
                    error=false;
                    input.nextLine(); //cleaning for the next input
            }
                catch(InputMismatchException err){ //input exception handling
                    System.out.println("Invalid input. Try again");
                    input.nextLine();
                }
            }
   
            switch (option) {
                case 1:
                    loadFile("players.txt", list); //method for loading from file 
                    break;
                case 2:
                    addPlayer(input, list); //method for adding new player
                    break;
                case 3:
                    showPlayer(input, list); //method for searching and showing player
                    break;
                case 4:
                    error=true;
                    while (error){ //control loop for invalid inputs
                        try{
                            //inputs are taken from user to delete player
                            System.out.print("Enter name to delete: ");
                            String name = input.nextLine();
                            
                            System.out.print("Enter surname to delete: ");
                            String surname = input.nextLine();

                            list.delete(name, surname);
                            error=false;
                        }
                        catch(InputMismatchException err){ //input exception handling
                            System.out.println("Invalid input");
                            input.nextLine();
                        }
                    }
                    
                    break;
                case 5:
                    list.printAscending(); //method for printing A to Z
                    break;
                case 6:
                    list.printDescending(); //method for printing Z to A
                    break;
                case 7:
                    //load stack with elements from linkedlist
                    DoublyLinkedList.Node current = list.getHead(); 
                    while (current != null) {
                        stack.push(current.getInfo()); 
                        current = current.getNext();
                    }
                    //printing with LIFO logic
                    while (!stack.isEmpty()) {
                        Player player = (Player) stack.pop(); //casting from Object type to Player type
                        System.out.println(player); 
                    }
                    break;
                case 8:
                    saveFile("text.txt",list); //method for saving file
                    System.out.println("Bye");
                    running=false; //exiting program
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
        }
        }
    }    
    public static void loadFile(String fileName, DoublyLinkedList list){
        try{
            File file=new File(fileName);
            Scanner scan=new Scanner(file);
            
            while (scan.hasNextLine()){ //reading each line and splitting them
                String line=scan.nextLine();
                String[] words=line.split(",");
                
                String name=words[0];
                String surname=words[1];
                
                //splitting the date
                String[] dateParts=words[2].split("/");
                int day=Integer.parseInt(dateParts[0]); //changing String type to int type
                int month=Integer.parseInt(dateParts[1]);
                int year=Integer.parseInt(dateParts[2]);
                
                Date birthDate=new Date(month,day,year);
                ArrayList<String> clubs=new ArrayList<>();
                for (int i=3;i<words.length;i++){ //adding the rest of words as clubs
                    clubs.add(words[i]);
                }
                Player player=new Player(name,surname,birthDate,clubs);
                list.insert(player); //adding alphabetically
            }
            scan.close();
        }
        catch(FileNotFoundException err){ //file exception handling
            System.out.println("File not found.");  
        }
    }
    
    public static void addPlayer(Scanner input, DoublyLinkedList list){
        boolean error=true;
        while (error){ //control loop for invalid inputs
            try{
            //getting the info from user to add new player    
            System.out.println("Enter player's name: "); 
            String name=input.nextLine();
            
            System.out.println("Enter player's surname: ");
            String surname=input.nextLine();
            
            System.out.println("Enter birth day: ");
            int day=input.nextInt();
            
            System.out.println("Enter birth month: ");
            int month=input.nextInt();
            
            System.out.println("Enter birth year: ");
            int year=input.nextInt();
            
            Date birthDate=new Date(month,day,year);
            input.nextLine(); //cleaning for the next input
            
            ArrayList<String> clubs = new ArrayList<>();
            System.out.println("Enter clubs. (Type n/N to finish): ");
            String club=input.nextLine();
            while (!club.equalsIgnoreCase("n")){ //taking inputs until user stops it
                clubs.add(club);
                club=input.nextLine();
            }
            
            Player player1=new Player(name,surname,birthDate,clubs);
            list.insert(player1);
            error=false;
        }
        catch(InputMismatchException err){ //input exception handling
            System.out.println("Invalid input.");
            input.nextLine();
        }
        }
    }
    
    public static void showPlayer(Scanner input, DoublyLinkedList list){
    System.out.println("Enter name: ");
    String name = input.nextLine();

    System.out.println("Enter surname: ");
    String surname = input.nextLine();

    DoublyLinkedList.Node current = list.getHead();

    //searching the list for the matching name and surname
    while (current != null) {
        if (current.getInfo().getName().equalsIgnoreCase(name) &&
            current.getInfo().getSurname().equalsIgnoreCase(surname)) {
            System.out.println(current.getInfo()); 
            break;
        }
        current = current.getNext();
    }
    if (current==null){
        System.out.println("Player not found.");
    }
    
    }
    public static void saveFile(String fileName, DoublyLinkedList list){
        PrintWriter writer=null; //a value assigned
        try{
            writer=new PrintWriter(new FileWriter(fileName));
            DoublyLinkedList.Node current = list.getHead();
            while (current!=null){
                Player player=current.getInfo();
                //writing player's info to file
                writer.print(player.getName()+","+player.getSurname()+","+player.getBirthDate().toString());
                for (int i=0;i<player.getClubs().size();i++){
                    String club=player.getClubs().get(i);
                    writer.print(","+club);
                }
                writer.println(); //new line after each player
                current=current.getNext();
            }
            
        }
        catch(IOException err){ //file writing exception handling
            System.out.println("Error while writing to file");
        }
        finally{
            if (writer!=null){
                writer.close();
            }
        }
    }
    
}
