//Team ChickenBagel: Thet Htay Zaw, Kathleen Wong, Jerry Ye
//APCS2 pd2
//L00 -- But What Does the Dat Say?
//2018-02-08

public class MFDriver {

    //assumes that n is equal to one side of the 2D Array
    //This is only to populate the 2D Array so please use this correctly. 
    public static void populate(int[][] arr) {
	int counter = 0;
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
    public static void getTime(int[][] arr) {
	long startTime = 0; 
	long totalTime = 0;
	long averageTime = 0;
	int area = arr.length * arr[0].length;
	int target = arr[arr.length - 1][0];

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

	/*
	int[][] example = new int[500][500];
	populate(example);
	getTime(example);

	int[][] example2 = new int[1000][1000];
	populate(example2);
	getTime(example2);

	int[][] example3 = new int[1500][1500];
	populate(example3);
	getTime(example3);

	int[][] example4 = new int[2000][2000];
	populate(example4);
	getTime(example4);

	int[][] example5 = new int[2500][2500];
	populate(example5);
	getTime(example5);

	int[][] example6 = new int[3000][3000];
	populate(example6);
	getTime(example6);

	int[][] example7 = new int[3500][3500];
	populate(example7);
	getTime(example7);
	*/

	//data1.csv cuts off here

	/*

	int[][] example8 = new int[4000][4000];
	populate(example8);
	getTime(example8);

	int[][] example9 = new int[4500][4500];
	populate(example9);
	getTime(example9);

	int[][] example10 = new int[5000][5000];
	populate(example10);
	getTime(example10);

	*/

	//data2.csv cuts off here


	int[][] example11 = new int[5500][5500];
	populate(example11);
	getTime(example11);

	//data3.csv


	//I need to get the rest of these bottom into a csv file too, I'll do it when I get home
	/*

	int[][] example12 = new int[6000][6000];
	populate(example12);
	getTime(example12);


	int[][] example13 = new int[6500][6500];
	populate(example13);
	getTime(example13);

	int[][] example14 = new int[7000][7000];
	populate(example14);
	getTime(example14);


	int[][] example15 = new int[7500][7500];
	populate(example15);
	getTime(example15);

	int[][] example16 = new int[8000][8000];
	populate(example16);
	getTime(example16);

	int[][] example17 = new int[8500][8500];
	populate(example17);
	getTime(example17);

	int[][] example18 = new int[9000][9000];
	populate(example18);
	getTime(example18);

	int[][] example19 = new int[9500][9500];
	populate(example19);
	getTime(example19);

	int[][] example20 = new int[10000][10000];
	populate(example20);
	populate(example20);
	
	*/
	
    }





} 
