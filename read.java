import java.util.*;
import java.io.*;

public class read {

    // fill method, throws IO exception, 
    public static void fill(DoubleLL dll) throws IOException{
        //doubly ended double linked list as arg for this
        try{
        //finds data file
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("data.html")));
        
        //line variable to hold scanned lines
        String line;
        while ((line = reader.readLine()) != null){ //whle more data exists
            line = line.trim(); //put line of data into string 
            String[] ar = line.split("\\s+"); //split up via spaces, 
            
            //makes sure id isnt already in database
            if( dll.search(ar[2].trim()) == false){
                dll.insert(ar[1].trim(), ar[0].trim(), ar[2].trim()); //insert id, first, last
            }

        }
        reader.close();
    
    //catches any exception and prints what exception and where
    }catch(Exception e){
        e.printStackTrace();
    }


    }
}
