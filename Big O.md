Big O is a notation used in programming that helps us determine how scalable our code is i.e., how much time will each part of code take for increasing number of inputs/operations

#### 1. O(n) - Linear
	For loops and while loops, which involve iterating over 'n' number of items

#### 2. O(1) - Constant Time
	This is declarative statement, a single line of code

### 3. O(n^2) - Quadratic
	This is when ever element of input needs to be compared/operate on other elements of 
	the input. 

### 4. O(n!) - Factorial 
	There is a loop for every input element that exists, This is the worst algorithm 
	you'll encounter, if your code has this REMOVE IT

  ![[s_2D428973624E7FC84C7D69D11421DE762BEA6B6F3361231FCDCAE0425D14526F_1664885448372_Untitled.drawio+17.png]]
### Rules of O(n)
#### 1. Rule 1 - Worst Case
	We always assume the worst case when calculating the Big O

### 2. Rule 2 - Remove constants
	When calculating the runtime for a program, the significance of constant runtime statements becomes less. Eg. If there are a million inputs to work with, the significance of statements have O(1) runtime becomes less valuable to calculating Big O

### 3. Rule 3 - Different terms for different inputs
	You need to specify different variables for different inputs while calculating Big O, this is significant as two different inputs might have different sizes i.e., one might have 200k inputs while the other has 1m 
``` 
function (box1, box2) {
	function printBoxes(b) {
		print(b)
	}
	
	box1.forEach(printBoxes(box))
	box2.forEach(printBoxes(box))
	# Big O = O(n + m)
	
	box1.forEach(function (a) {
		box2.forEach(function (b) {
			print(a, b)
		})
	} 
	# Big O = O(n * m)
```

### 4. Rule 4 - Drop all non dominant terms 
	To simply our runtimes even further, we drop elements that are insignifact as the scale of inputs increases

```
O(n^2 + 3*n + 175 + n/10) 
=> O(n^2) as it is the most significant of these all
```


### Factors that affect Space complexity - 
- Variables
- Function calls
- Data Structures
- Allocation