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

  
}
