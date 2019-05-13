import java.util.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;



public class kNNMain
{
//to enable the different print statements
public final static boolean task5 = false;       //to enable task5 enter true, otherwise false
public final static boolean task6 = true;        //to enable task6 enter true, otherwise false

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label

		List<DataPoint> data = new ArrayList<DataPoint>();
		String file = "C:\\Users\\Jonathan Rieck\\Desktop\\College\\4th Semester\\Programing\\Java Code\\Flower Lab\\src\\breastCancer.csv";
		data = DataSet.readDataSet(file);
		DataPoint list= data.get(14);
		
		//Print Statements
			String printablelist = Arrays.toString(list.getX());
			System.out.println("Label " + list.getLabel()+ " "+printablelist);

    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
		double fraction = .25;
		List<DataPoint> training = new ArrayList<DataPoint>();
		List<DataPoint> test = new ArrayList<DataPoint>();
		training = DataSet.getTrainingSet(data, fraction);  
		test = DataSet.getTestSet(data, fraction);
		
    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)
		
		/**Refer to lines 248 to 264 of DataSet.java*/
		
    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
		if(task5)
		{
		//Random chosen point
			int k = 8;
		//declaration 
			KNNClassifier set = new KNNClassifier (k);
			DataPoint point = test.get(k);
			String label = point.getLabel();
		//Computations
			System.out.println(label + " at " + k+": " + set.predict(training, point));
		}//end task 5		

    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
<<<<<<< HEAD
		if (task6)
		{
		//the accuracy of the the model
			double sum = 0.; 		// sum of all right answers
			
		//Looping over all values of the array of data points of the test set
			for ( int i=0; i< training.size(); i++ )
			{
				KNNClassifier set = new KNNClassifier (4);
				DataPoint point = test.get(i);
				String label = point.getLabel();
				String prediction = set.predict(training, point);
				System.out.println(label + ": " + prediction);
				if (label.equals(prediction))
				{
				  sum ++;	
				}
			}
			System.out.print(sum/training.size() * 100);
		}//end task 6
  }//end main class
}//end class
=======


  }

  public static double mean(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: average of the elements of array, as a double
    */
    double sum = 0.0;

    for (double a : arr){
      sum += a;
    }
    return (double)sum/arr.length;
  }

  public static double standardDeviation(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: standard deviation of the elements of array, as a double
    Dependencies: requires the *mean* method written above
    */
    double avg = mean(arr);
    double sum = 0.0;
    for (double a : arr){
      sum += Math.pow(a-avg,2);
    }
    return (double)sum/arr.length;
  }

}
>>>>>>> ac8b64ec5ad33c35bb9f6ee98f2b36d7a3b0f37c
