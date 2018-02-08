//Team ChickenBagel: Thet Htay Zaw, Kathleen Wong, Jerry Ye
//APCS2 pd2
//L00 -- But What Does the Data Say? 
//2018-02-02

/* Our algorithm starts by traversing diagonally through the array, starting
   from the top left corner, until the next diagonal value is greater than the
   target value. At this point, we traverse through the rest of the row(to the right)
   to search for our target. If we find a value in the row greater than the target,
   we break because we know that the 2d array is in ascending order, and instead
   traverse down the rest of the column starting at the original diagonal location. */

public class MatrixFinder{

    //variables
    public static int _xCor, _yCor;

    public static String search(int target, int[][] arr) {

	_xCor = 0;
	_yCor = 0;

	int counter = 0;
	int storeValue = 0;

	//if the target is smaller than the smallest value in the array, print (-1,-1)
	//immediately
	if (target < arr[0][0]) {
	    return "(-1,-1)";
	}

	//traverse diagonally
	while (counter < arr.length) {
	    //if target is found, return location
	    if (target == arr[_xCor][_yCor]) {
		return "(" + _xCor + "," + _yCor + ")";
	    }

	    //stop when the next diagonal value is greater than the target
	    if (target < arr[_xCor][_yCor]) {
		_xCor = _xCor - 1;
		_yCor = _yCor - 1;
		break;
	    }

	    //otherwise, keep moving diagonally
	    _xCor += 1;
	    _yCor += 1;
	    counter += 1;
	}

	counter = _yCor;
	storeValue = _yCor;

	//traverse across the row
	while (counter < arr.length) {
	    if (target == arr[_xCor][_yCor]) {
		return "(" + _xCor + "," + _yCor + ")";
	    }

	    if (target < arr[_xCor][_yCor]) {
		_yCor = storeValue;
		break;
	    }

	    _yCor += 1;
	    counter += 1;
	    
	}

	if (_yCor >= arr.length ) {
	    _yCor = arr.length - 1;
	}
	
	counter = _xCor;
	storeValue = _xCor;

	//traverse down the column
	while (counter < arr.length) { 
	    if (target == arr[_xCor][_yCor]) {
		return "(" + _xCor + "," + _yCor + ")";
	    }

	    if (target < arr[_xCor][_yCor]) {
		break;
	    }

	    _xCor += 1;
	    counter += 1;
	}

	//if target is never found, return (-1,-1)
	_xCor = -1;
	_yCor = -1;

	return "(" + _xCor + "," + _yCor + ")";

    }

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
    //Yes the value not being in the matrix at all is also a worst case scenario
    //The worst case is incorrect, I need to fix it
    //If you guys want to do that, we can edit this method or take it out of this method
    //Populate is designed to work with this specifically
    //If a 2D array is made without populate, getTime will not work properly
    public static void getTime(int[][] arr, int runAmount) {
	long startTime = 0; 
	long totalTime = 0;
	long averageTime = 0;
	int area = arr.length * arr[0].length;
	int target = arr[arr.length - 1][0];

	System.out.println("Matrix Size: " + arr.length + "x" + arr.length  + ", Looking For: " + target );
	startTime = System.nanoTime();
	for (int i = 0 ; i < runAmount ; i++ ) {
	    search( target , arr );
	}

	totalTime = System.nanoTime() - startTime;
	averageTime = totalTime / runAmount;
	System.out.println("Run Amount: " + runAmount); 
	System.out.println("Total time: " + totalTime);
	System.out.println("\nAverage time: " + averageTime); 
    } 

    public static void main(String[] args) {
	// test case
	
	/*
	int[][] example = { {1, 2, 6} , {2, 3, 7} , {3, 4, 8} };
	System.out.println(search(8, example));
	System.out.println(search(0, example));
	System.out.println(search(10, example));
	System.out.println(search(7, example));

	int[][] example2 = { {1, 2, 6, 10} , {2, 3, 7, 13} , {3, 4, 8, 14}, {5,6,7,16} };
	System.out.println(search(6, example2));
	System.out.println(search(1, example2));
	System.out.println(search(100, example2));
	System.out.println(search(7, example2));

	int[][] example3 = { {1} };
	System.out.println(search(1,example3));
	System.out.println(search(2,example3));
	*/

	int[][] example = new int[1000][1000];
	populate(example);
	getTime(example, 1000); 
	
	
    }

}
