public class deletedIndex {
    private int nums;
    private int[] deletedA;


//defaults deleted array to 250(same size as array)
    public deletedIndex(){
        this(250);
    }


    //checks if any in array
    public boolean isEmpty(){
        return(nums == 0);
    }


    //creates custom constructor for array
    public deletedIndex(int size){
        nums = 0;
        deletedA = new int[size];
    }

    
    //get number of elements
    public int getNums(){
        return nums;
    }


    //gets index to add into, increments num
    public void IndexToAdd(int in){
        deletedA[nums] = in;
        nums++;
    }


    //peeks index without altering
    public int checkIndexFast(){
        if(this.isEmpty()){
            return -1;
        }
        else
            return deletedA[nums--];
    }


    //gets index with altering
    public int checkIndex(){
        if(this.isEmpty()){
            return -1;
        }
        else
            nums--;
            return deletedA[nums];
    }

    
    public void printIt(){
        for(int i = 0;i<nums;i++){
            System.out.println(deletedA[i]);
        }
    }
}
