import java.util.*;
import java.io.*;


public class DataBase {
    private static DoubleLL dll;
    //our structure for storing, referenced in read.java as arg, end product user sees
    private Scanner scnr;
    //scanner object specific to this class


  //constructor
    public DataBase(){
            try{
            dll = new DoubleLL(); //creates our structure 
            scnr = new Scanner(System.in); //makes a scanner for us to use
            read.fill(dll); //invokes fill class to get data from input
            }catch(Exception e){
                e.printStackTrace(); //prints exception trace to find why
            }
    }


    //method to add record into dll
    public void addIt(){

        //instance all values to empty string ("")
        String id = "";
        String first = "";
        String last = "";
        

        System.out.println("\nadding ");
        System.out.println("enter id: ");
        id = this.scnr.nextLine();

        //checks if id already exists
        if(dll.search(id)){
            //invokes search method, enters this block if found
            System.out.println("id already in use.");
            return;
        }

        //else
        System.out.println("enter first name: ");
        first = this.scnr.nextLine();

        System.out.println("enter last name: ");
        last = this.scnr.nextLine();

        //inserts the record where you want in the database
        dll.insert(first,last,id);
        //record added
    }


    //method deletes a record in the database
    public void deleteIt(){
        String deleteIt;
        Scanner scan = new Scanner(System.in);
        //create new scanner object
        System.out.println("enter record to be deleted: ");
        deleteIt = scan.nextLine();


        //invokes delete record, if returns -1 record doesnt exist otherwise returns index of record you want
        if (dll.deleteRec(deleteIt) == -1){
            System.out.println("record not found");
        }
        else System.out.println("record deleted");
    }


    public static void findIt(){
        String rec;
        Scanner scan = new Scanner(System.in);
        //creates scanner

        System.out.println("Enter id of record to be found");
        rec = scan.nextLine();

        //invokes 
        int index = dll.find(rec);

        //index being -1 means not found
        if(index == -1){
            System.out.println("record not found");
        }
        else{
            //invokes to string method to turn the data we want into a string to output in the print line
            System.out.println(dll.getdbRec(index).toString());
        }
    }


    //all methods for listing Linked List in all orders and cases
    public static void ListByIDAscending(){
        dll.listIt(3, 1);
    }

    public static void ListByFirstAscending(){
        dll.listIt(1, 1);
    }

    public static void ListByLastAscending(){
        dll.listIt(2, 1);
    }

    public static void ListByIDDescending(){
        dll.listIt(3, 2);
    }

    public static void ListByFirstDescending(){
        dll.listIt(1, 2);
    }

    public static void ListByLastDescending(){
        dll.listIt(2, 2);
    }


}
