public class IArray {
    //declare vars
    
    private IRec head; //head node (first)
    private IRec tail; //tail node (last)
    private int NumRec; //num of recs


    //default construct for index array, sets everything to 0/null
    public IArray(){
        head = null;
        tail = null;
        NumRec = 0;
    }

    //gets number of records
    public int getNumRec(){
        return NumRec;
    }

    //checks if there are no recs in class
    public boolean isEmpty(){
        return (NumRec == 0);
    }

    //gets head node
    public IRec getHead(){
        return head;
    }

    //gets tail node
    public IRec getTail(){
        return tail;
    }

    //method getter for getting index record you desire
    public IRec getIRec(int index) {
        IRec rec = head; //starts at head (first node)
        int spot = 0; //index 0
 
        //loops thru ++ while spot < arg, then returns the record at spot, do while loop
        do {
            rec = rec.getNext();
            spot++;
        }while(spot < index);

        return rec;
    }

    //prints incrementally thru LinkedList
    public void printUp(Node[] db){

        //boolean yes when isEmpty returns true, NumRec = 0
        if(this.isEmpty()){
            System.out.println("database is empty");
        }
        //if not
        else{
            //rec = head node
            IRec rec = head;
            //checks if list empty
            while(!rec.end()){
               System.out.println(db[rec.getIndex()].toString());
               rec = rec.getNext();
           }

           //separate print for the tail node, its excluded in do while loop
           System.out.println(db[rec.getIndex()]
                   .toString());
        }
    }

    //prints decrementally thru LinkedList, same method as above but head and tail swapped and getPrevious
    //instead of getnext
    public void printDown(Node[] db){
        if(this.isEmpty()){
            System.out.println("database is empty");
        }
        else{
            IRec rec = tail;
            while (!rec.beginning()) {
               System.out.println(db[rec.getIndex()].toString());
               rec = rec.getPrevious();
           }
           //Print last record
           System.out.println(db[rec.getIndex()]
                   .toString());
        }
    }

    //add record indexrecord 
    public void AddRec(IRec rec){
        if (this.isEmpty()) {
            head = rec;
            tail = rec;
        }else if (NumRec == 1) {
        // New record comes in second
        if (head.getInfo().compareTo(rec.getInfo()) < 0) {
            head.setNextRecord(rec);
            rec.setPreviousRecord(head);
            tail = rec;
        }// New record comes before single record in list
        else {
            head.setPreviousRecord(rec);
            rec.setNextRecord(head);
            head = rec;
        }
    }
        else // List has at least two elements
       {
        //FIND ALL CASES AND REACT ACCORDINGLY
           // Inserting in beginning of filled list
           //insert a record before head node
           if (head.getInfo().compareTo(rec.getInfo()) > 0) {
               head.setPreviousRecord(rec);
               rec.setNextRecord(head);
               head = rec;
           }
            // Inserting at end of filled list
            //insert a record after tail, tail becomes node
            else if (tail.getInfo().compareTo(rec.getInfo()) < 0) {
                tail.setNextRecord(rec);
                rec.setPreviousRecord(tail);
                tail = rec;
            }
            // Inserting in the middle of a list
           else {
            IRec current = head.getNext();

            //current is not at end of LL
            while (!current.end()) {
                if (current.compareTo(rec) >= 0) {
                    rec.setNextRecord(current);
                    rec.setPreviousRecord(current
                            .getPrevious());
                    current.getPrevious().setNextRecord(
                            rec);
                    current.setPreviousRecord(rec);
                    break;
                } else {
                    current = current.getNext();
                }
            }
        }
    }
    //increment number of records once gets inserted
    NumRec++;
}


    //method for deleting a record at desired index
    public void DeleteRec(int index){
        if(NumRec == 0){
            //do nothing
        }

        //if one record, LinkedList becomes null
        else if (NumRec == 1) {
            if (head.getIndex() == index) {
                head = null;
                tail = null;
            }
        } else // List has at least two elements
            //FIND ALL CASES AND REACT ACCORDINGLY
        {
            // Record at beginning, move head to next record
            if (head.getIndex() == index) {
                head = head.getNext();
                head.setPreviousRecord(null);
            }// Record at end, move tail to previous record
           else if (tail.getIndex() == index) {
            tail = tail.getPrevious();
            tail.setNextRecord(null);
        }
        // Record in the middle
        else {
            IRec current = head.getNext();
            while (!current.end()) {
                if (current.getIndex() == index) {
                    //remove references for index and moves it to before and after node we are deleting
                    IRec last = current.getPrevious();
                    IRec next = current.getNext();


                    last.setNextRecord(next);
                    next.setPreviousRecord(last);
                    current.setNextRecord(null);
                    current.setPreviousRecord(null);
                    break;
                } else {
                    current = current.getNext();
                }
            }
        }
    }
    //decrement because deleted record
    NumRec--;
}



    }
