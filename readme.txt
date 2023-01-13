This program is mainly a test for graphing out data.

The test data used is derived from a mathematical algorithm, This algorithm generates a random pattern string of size 'search_len'(2)
using the lower case alphabet, it then generates a new string of the same size also filled using the lower case alphabet for
guesses(10000) permutations and every time that the pattern string is within the search string
it increments the counter 'c'. The program runs for 'trys'(200000) permutations and generates a graph using all the values of c.
The x-axis represents the size of c, and the y-axis represents how many times this value of c was achieved after being run for many permutations.

The value of these variables can be changed in lines 18 and 19, however a larger 'search_len' will produce fewer results for c so
guesses may also need to be increased. This can drastically increase the time it takes the program to run, however there is an estimated
time to run the program displayed once the program starts.

