/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package player;
import java.util.ArrayList;


public class Player { 
    private String name;
    private String surname;
    private Date birthDate;
    private ArrayList<String> clubs;
   
    public Player(){ //no parameter constructor method
        name="no_name";
        surname="no_name";
        birthDate=new Date(1,1,1900);
        clubs=new ArrayList<>();
    }

    public Player(String name, String surname, Date birthDate, ArrayList<String> clubs) { //constructor method
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.clubs = clubs;
    }
    //getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<String> getClubs() {
        return clubs;
    }

    public void setClubs(ArrayList<String> clubs) {
        this.clubs = clubs;
    }
    
    //toString method
    @Override 
    public String toString() {
        return "Name:" + getName() + "\n Surname:" + getSurname() + "\n BirthDate:" + getBirthDate() + "\n Clubs:" + getClubs();
    }
}



