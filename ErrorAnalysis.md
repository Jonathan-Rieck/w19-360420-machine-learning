# Error Analysis -Jonathan Rieck
##	Dawson College 360-420-DW - Machine Learning - Winter 2019
### Introduction to Object-Oriented-Programming for Machine Learning

## Distributions of Model Accuracy & Analysis of Different Error Types
# Amount of Confidence in Model
`1) different accuracy`

	The accurancy varies from one run to another due to random number generation, which creates different random numbers at every time the program is ran. 

`2) Baseline`

	A sensible baseline is an above 90% prediction rate between a patient having a benign or malignant cancer. Furthermore, anything below this baseline is not condisered a successful algorithm. 

| Trial |  Mean  | Standard Deviation|
|:-----:|:------:|:-----------------:|
|1	|94.63%  |3.91 E-14	     |
|2	|95.61%	 |1.03 E-14	     |
|3      |96.10%|7.33 E -14|

# Types of Errors
`1) False Positive & False Negative`

	A **false negative** is when a doctor diagnoses a *healthy* individual as a *sick one*. While **false positive** is when a doctor diagnoses a *sick* patient a *healthy* one.

`2) Recall & Precision`
	
	These two measures vary in the variables they take into account: For Recall, the number of false negatives are taken into account to view the accuracy of sick people wrongly diagnosed . On the other hand, the precision measures how accurate the algorithm is in regards to predicting a sick person as healthy, by using the false positives along with the correctly predicted malignant people.

`3) Baseline with Recall & Precision`

	A sensible baseline to ensure everyone's safety and health is to assign everyone as sick, which will ensure that recall and precision acheive maximum scores.

| Trial |  Mean  | Standard Deviation|k|Precision|Recall|
|:-----:|:------:|:-----------------:|:---:|:---:|:----:|
|1	|94.15%  |3.819 E-14	     |4|0.915|0.956|
|2	|96.56%	 |5.93 E-14	     |4|1|0.894|
|3      |94.63%|3.91 E -14|8|0.905|0.963|

`4) Hyper k Values`

	Although, the program does not seem to enjoy running any k value higher that 8. Mathematically if the program were to take the whole plot of points, all possible points, into account as nearest neighbors then the precision would decrease and the recall would increase as a result. Due to all the points being correctly diagnosed as having cancer, and the opposite,healthy people being diagnosed properly is not being evaluated.
