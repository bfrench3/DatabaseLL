
import java.util.*;



public class DoubleLL {
    private Node[] db; //array of Node for database
    private IArray idSpot, firstSpot, lastSpot; //array for indexes
    private deletedIndex deletedIndex; //indexes for deleted
    int numRec; //number of records


    //perameter is size of size
    public DoubleLL(int size){
        db = new Node[size]; // new node arr(3 elms) of size
        deletedIndex = new deletedIndex(size); 
        numRec = 0; //0 records
        firstSpot = new IArray();
        lastSpot = new IArray();
        idSpot = new IArray();
    }


    //finds an id tag in db returns if found, implements find method from later in class
    public boolean search(String id){
        return(find(id) != -1);
    }


    //method for insert a record and all elms
    public void insert(String fName, String lName, String id){
        //if id is already in LL
        // Trim whitespace for our args
       fName = fName.trim();
       lName = lName.trim();
       id = id.trim();


       // Check if ID is in use
       while (search(id)) {
           Scanner scnr = new Scanner(System.in);
           System.out.print("id " + id
                   + " is already in use.\nPlease enter a unique ID: ");
           id = scnr.nextLine();
           System.out.println();
       }

       //make a new record Node with args if id is unique 
       Node record = new Node(fName, lName, id);

       //initialized index var
       int index;

       // Use index from deletedIndex for the next record location if available, else use numRec
       if (deletedIndex.isEmpty())
           index = numRec;
       else
           index = deletedIndex.checkIndex();


       // Add record to database and OrderedIndexes
       db[index] = record;
       firstSpot.AddRec(new IRec(fName, index));
       lastSpot.AddRec(new IRec(lName, index));
       idSpot.AddRec(new IRec(id, index));

       //increment number of records since added one
       numRec++;
   }


    //returns record at index
    public Node getdbRec(int index){
        return db[index];
    }


    //get number of records
    public int getNumRec(){
        return numRec;
    }


    //default constructor of 250
    public DoubleLL(){
        this(250);
    }


    //getter for firstSpot
    public IArray getfirstSpot(){
        return firstSpot;
    }


    //getter for lastSpot
    public IArray getlastSpot(){
        return lastSpot;
    }


    //getter for idSpot
    public IArray getidSpot(){
        return idSpot;
    }


    //getter for deletedIndex
    public deletedIndex getdeletedIndex(){
        return deletedIndex;
    }


    //method for deleting a rec, argument is the id we test for
    public int deleteRec(String id){
        int index = this.find(id);
        boolean found = (index >= 0);

        //boolean returning true
        if (found){
            //deletes all indexes at index
            deletedIndex.IndexToAdd(index); //use index from argument for all elms of LL
            firstSpot.DeleteRec(index);
            lastSpot.DeleteRec(index);
            idSpot.DeleteRec(index);
            numRec--; //decrement number of records since deleted
        
        }
        return index;
    }


    //prints entire LinkedList while there are more elms
   public void print() {
    int i = 0;
    while (db[i] != null) {
        System.out.println("[" + i + "] " + db[i].toString());
        i++;
    }
}


    public void listIt(int what, int how){
        IArray index = null; //initialize to null

        //depending on perameter input output these facets of record are used
        switch(what){
            case 1:
                index = firstSpot;
                break;
            case 2:
                index = lastSpot;
                break;
            case 3:
                index = idSpot;
                break;
            default:
            //if no cases get chose, invalid only these cases should be used
                System.out.println("error, invalid input");
                break;
        }
        
        if (index.isEmpty()){
            System.out.println("database empty");
        }//if arg is 1, print increasing
        else if(how == 1){
            index.printUp((Node[]) db);
        } //if 2, print decreasing
        else if(how == 2){
            index.printDown(db);
        } //else invalid
        else{
            System.out.println("error, invalid input");
        }
    }

    
    //finds record thats arg
    public int find(String id){

    //if empty node, not found return -1
    if (idSpot.isEmpty())
        return -1;

    //index record gets head node
    IRec currentRecord = idSpot.getHead();
    boolean found;

    //while not end of list, iterate thru LL, if found return record at index, else get next node
    while (!currentRecord.end()) {
        found = (currentRecord.getInfo().compareTo(id) == 0);


        if (found) {
            return currentRecord.getIndex();
        } else {
            currentRecord = currentRecord.getNext();
        }
    }

    //if record found and is true, return record index else -1 (not found)
    found = (currentRecord.getInfo().compareTo(id) == 0);


    if (found) {
        return currentRecord.getIndex();
    } else {
        return -1; // Not found
    } 

}

    
//end of double LL
}


