# Error Analysis -Jonathan Rieck
##	Dawson College 360-420-DW - Machine Learning - Winter 2019
### Introduction to Object-Oriented-Programming for Machine Learning

## Distributions of Model Accuracy

## Analysis of Different Error Types
# Amount of Confidence
`1) different accuracy`
	The accurancy varies from one run to another due to random number generations, which creates different random numbers at every time the program is ran. 

`2) Baseline`
	A sensible baseline is an above 90% prediction rate between a patient being benign or malignant, anything below this baseline is not condisered a successful algorithm. 

| Trial |  Mean  | Standard Deviation|
|:-----:|:------:|:-----------------:|
|1	|94.63%  |3.91 E-14	     |
|2	|95.61%	 |1.03 E-14	     |
|3      |96.10%|7.33 E -14|

# Types of Errors
`1) False Positive & False Negative`
	A false negative is when a doctor diagnoses a healthy individual as a sick one. While a false positive is when a doctor diagnoses a sick patient a healthy one.

`2) Baseline with Recall & Precision`
	A sensible baseline to ensure everyone's safety and health is to assign everyone as sick, which will ensure that recall and precision acheive maximum scores.