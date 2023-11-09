import java.util.*;


public class Node {
    private String first;
    private String last;
    private String id;
    //initialize variables we want

    //constructor with all 3 args in place
    public Node(String id, String first, String last){
        this.id = id;
        this.first = first;
        this.last = last;
    }


    //default no arg constructor 
    public Node(){

        this("","","");
    }

   
    //getter methods for all vars, return var
    public String getid(){
        return id;
    }


    public String getfirst(){
        return first;
    }


    public String getlast(){
        return last;
    }

    
//overriden string method outputs our variables in correct order
    @Override
    public String toString(){
        return id+ " "+first + " "+ last;
    }



}
