import java.util.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;



public class kNNMain
{
//to enable the different print statements
public final static boolean task5 = false;       //to enable task5 enter true, otherwise false
public final static boolean task6 = false;       //to enable task6 enter true, otherwise false
public final static boolean taskRun = true;      //to enable n number of runs enter true, otherwise false
public final static int n = 1000;				 //number of runs

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label

		List<DataPoint> data = new ArrayList<DataPoint>();
		String file = "C:\\Users\\Jonathan Rieck\\Desktop\\College\\4th Semester\\Programing\\Java Code\\Flower Lab\\src\\breastCancer.csv.csv";
		data = DataSet.readDataSet(file);
		DataPoint list= data.get(14);
		
		//Print Statements
			String printablelist = Arrays.toString(list.getX());
			System.out.println("Label " + list.getLabel()+ " "+printablelist);

    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
		double fraction = .3;
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
			System.out.print(sum/training.size() * 100 + "%");
		}//end task 6
		
	// 									1000 Runs
	// _____________________________________________________________________________
		
		if (taskRun)
		{
			double [] indScore = new double [n];					//individual score one each run 
			double sumInd = 0.; 									//Individual sum of each run
			double sumTotal = 0.; 									// sum of all right answers
			String [] wrong = new String [n*n];     					//collection of all wrong predictions
			int k = 0;												// number of wrong entries
			int false_positive = 0;									//Number of false positives								
			int false_negative = 0; 								//Number of false negatives
			int malignant = 0;										//Number of malignant
			int benign = 0;											//Number of Benign 
			double precision =0.;
			double recall = 0.;
			
			//looping a 1000 times over the array 
				for ( int j = 0; j < n ; j++)
				{
					sumInd = 0.; 
				//Looping over all values of the array of data points of the test set
					for ( int i=0; i< training.size(); i++ )
					{
						KNNClassifier set = new KNNClassifier (4);
						DataPoint point = test.get(i);
						String label = point.getLabel();
						String prediction = set.predict(training, point);
						
						if (label.equals(prediction))
						{
						  sumInd ++;	
						  sumTotal ++;
						}
						if (!label.equals(prediction))
						{
						  wrong[k] = prediction;
						  k++;
						}
						if(prediction.equals("malignant"))
						{
							malignant++;
						}
						else
						{
							benign++; 
						}
						indScore[j] = (sumInd/training.size() * 100);
					}
				}
				System.out.println((sumTotal/training.size()/n) * 100 + "% after 1000 runs");
				double mean = mean(indScore);
				System.out.println(mean + "% is the mean score");
				System.out.println(standDev(indScore, mean) + "is the standard deviation");
				
			//Later tasks
				System.out.println("BASELINE:");
				DataSet.printLabelFrequencies(training); 
				System.out.println("Total malignant: " + malignant + " Total benign: " +benign);
				
				
				for (int i = 0; i<k;i++)
				{
					String b = wrong[i] ;
					if (b.equals("benign"))
					{
						false_negative++;
					}
					else
					{
						false_positive++;
					}
				}
				System.out.println("total false positives: "+ false_positive + "\ntotal false negatives: " +false_negative+ "\ntotal wrong: "+ k);
				
				precision = malignant/(false_positive + malignant);
				recall = malignant/(false_negative + malignant);
				
				System.out.println("Precision: " + precision);
				System.out.println("Recall: " + recall );
				
		}
  }//end main class
  
  public static double mean(double [] arr)
  {
	  double sum = 0; 
	  for (int i = 0; i < n; i++)
	  {
		  sum = sum + arr[i];
	  }
	  return sum/1000; 
  }
  public static double standDev(double [] arr, double m)
  { 
	  double sum = 0;
	  for (int i = 0; i <n; i++)
	  {
		  sum = Math.pow(m-arr[i], 2);
	  }
	  return Math.sqrt(sum/n); 
  }
}//end class
