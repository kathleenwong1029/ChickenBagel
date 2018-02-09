//Team ChickenBagel: Thet Htay Zaw, Kathleen Wong, Jerry Ye
//APCS2 pd2
//L00 -- But What Does the Dat Say?
//2018-02-08

public class MFDriver {

    //assumes that n is equal to one side of the 2D Array
    //This is only to populate the 2D Array so please use this correctly. 
    public static void populate(long[][] arr) {
	long counter = 0;
	for (int i = 0; i < arr.length ; i++) {
	    for (int j = 0 ; j < arr[i].length ; j++ ) {
		arr[i][j] = counter;
		counter++;
	    }
	}
    }

    //Note: This will only look for the worst case scenario (in which the value is the final value)
    //Method edited such that it will always search 1000 times and find the average time for that
    //If you guys want to do that, we can edit this method or take it out of this method
    //Populate is designed to work with this specifically
    //If a 2D array is made without populate, getTime will not work properly
    public static void getTime(long[][] arr) {
	long startTime = 0; 
	long totalTime = 0;
	long averageTime = 0;
	int area = arr.length * arr[0].length;
	long target = arr[arr.length - 1][0];

	//System.out.println("Matrix Size: " + arr.length + "x" + arr.length  + ", Looking For: " + target );
	startTime = System.nanoTime();
	for (int i = 0 ; i < 1000 ; i++ ) {
	    MatrixFinder.search( target , arr );
	}

	totalTime = System.nanoTime() - startTime;
	averageTime = totalTime / 1000;
	/*
	  System.out.println("Run Amount: " + runAmount); 
	  System.out.println("Total time: " + totalTime);
	  System.out.println("\nAverage time: " + averageTime); 
	*/
	System.out.println(arr.length + "," + averageTime );   
    } 

    public static void main(String[] args) {
	// test case

	System.out.println("Matrix Length, Average Time");
	for (int i = 1000 ; i <= 5600 ; i += 50) {
	    long[][] example = new long[i][i];
	    populate(example);
	    getTime(example);
	}
	
	//Stops at 5600 because somewhere above 5600 (and before 5700), I start getting a Java Heap Space error
	

	
    }



} 
