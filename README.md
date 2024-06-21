# Program to solve TSP problem with Divide and Conquer method

## Requirements:
To run this program, you must have the following installed:
- Kotlin
- Any Lunix OS
  
## How to install the project
Follow these steps to install the project:
1. **Clone the repository**: Clone the repository using the following git command:
   ```https://github.com/PanquecaFuriosa/Divide-and-Conquer-for-TSP```

## How to compile the project
Follow these steps to compile the project:
1. **Run the following bash command**:
   ```make```

## How to run the project
Follow these steps to run the project:
1. **Run the following bash command**:
   ```./runDACTSP.sh input_file output_file```

Where:<br>
- input file: file with a TSP instance in TSPLIB format.<br>
- Output file: consists of the tour that is the solution of the TSP instance in TSPLIB format.<br>

Please note that in the TSPLIB format for files containing TSP solutions, a tour must always begin in the city identified with the number 1. You must add a comment indicating the distance of the solution tour on the second line of the output file. with the following format: COMMENT : Length X, where X is the length of the tour.
For example, given the tour in Figure 1, the following comment should be added: COMMENT : Length 31.
