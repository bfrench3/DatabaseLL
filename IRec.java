public class IRec implements Comparable<IRec>{
    private String info; //elements in records
    private int index; // Index of record in LL
    // References to next and previous Nodes in database
    private IRec next;
    private IRec previous; 


    //OVERRIDEN TOSTRING METHOD, PRINTS INFO OF RECORD AND INDEX OF RECORD INTO A STRING
    @Override
   public String toString() {
       return info + " " + index;
   }


    //constructs index record w elms and reference to index, no reference points
    public IRec(String info, int index) {
        //next and last dont go anywhere
        next = null;
        previous = null;
        this.info = info.toLowerCase(); // Store data in lowercase for case-insensitive comparison
        this.index = index;
    }


   //uses compareTo to see if info between 2 records match, if yes will return a 0
   public int compareTo(IRec rec) {
    // Compare this record's data with another record's data.
    return this.info.compareTo(rec.getInfo());
}


    //gets index of record we want
    public int getIndex() {
        return index;
    }

 
    //gets info related to records
    public String getInfo() {
        return info;
    }

 
    //sets next record in the structure
    public void setNextRecord(IRec rec) {
        next = rec;
    }

 
    //sets previoud record in strcuture
    public void setPreviousRecord(IRec rec) {
        previous = rec;
    }


    //gets next record in structure
    public IRec getNext() {
        return next;
    }

 
    //gets previous record in structure
    public IRec getPrevious() {
        return previous;
    }


    //boolean return on if any records after this
    public boolean end() {
        return (next == null);
    }

 
    //boolean return on if any records before this
    public boolean beginning() {
        return (previous == null);
    }
}
