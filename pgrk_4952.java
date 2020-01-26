/**
 * GARIMA TULI cs610 4952 prp
 * This is the java implementation for page rank
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.Math.*;


public class pgrk_4952 {

	/**
	 * @param args iterations, initialvalue, filename
	 */

	int iterations; // Declare iterations global variable
					// positive integer or an errorrate for a negative or zero integer value
					// for eg: iteration 0 means errorrate of 10 ^ -5,

	int initialvalue; // Declare initialvalue global variable
						// common initial value of the vector used, sets the intial vector value, if it
						// is 0, set to 0, if it is 1, set to 1
						// if it is -1, set to 1/N, where N is number of webpages (vertices of the
						// graph), if it is -2, set to 1/sq. root of N

	String filename; // Declare filename global variable
						// stores the input graph
						// The first line contain two numbers: No of vertices followed by No of edges
						// which is also no of remaining lines

	int n, m; // no of vertices followed by no of edges
				// Each edge is represented by i,j, thus for our program, according to sample
				// graph, edges are (0,2), (0,3), (1,0), (2,1)

	// For every vertex, compare the previous and current iteration value, if the
	// difference is less than errorrate
	// for every vertex, then and only then stop the iteration
	// Vector values are printed to 7 decimal digits
	// If Graph has N Greater than 10 , then values of iterations, initialvalue are
	// set to 0 and -1
	// In such a case, page rank will be calculated at the stopping iteration are
	// only shown one per line
	// The graph is stored as samplegraph.txt or verylargegraph.txt

	int[][] adjMatrix; // Declare Adjacency Matrix

	final double d = 0.85; // Declare and initialize Parameter d
	double errorrate = 0.0; // Declare and initialize errorrate variable
	int[] C; // Declare Array to store Number of outgoing link of Ti
	double[] src; // Declare vector/intial page rank
	double[] srcPrevious;
	double[] D; // Declare Page Rank Vector for ith iteration

	// Default Constructor
	pgrk_4952() {

	}

	// Parameterized Constructor

	pgrk_4952(int iterations, int initialvalue, String filename) {

		// Read the samplegraph.txt file, initialize the adjacency matrix and form the
		// adjacency matrix based on initial value
		// Set the global variable with user input
		this.iterations = iterations;
		this.initialvalue = initialvalue;
		this.filename = filename;

		File file = new File(filename); // create File Object

		try {
			Scanner sc = new Scanner(file); // create scanner object with file reference
			n = sc.nextInt(); // Get number of vertices
			m = sc.nextInt(); // Get number of edges

			adjMatrix = new int[n][n]; // Initialize adjacency Matrix with size of number of vertices
			src = new double[n]; // Initialize the initial page rank vector
			C = new int[n]; // Initialize the C array with number of vertices

			for (int q = 0; q < n; q++) { // Loop through the vertices length and initialize each value of matrix with
											// value 0
				for (int r = 0; r < n; r++) {
					adjMatrix[q][r] = 0;
				}
			}

			while (sc.hasNext()) { // Read the file and put 1 in the matrix at the position based on values in the
									// file.
				adjMatrix[sc.nextInt()][sc.nextInt()] = 1;
			}

			for (int q = 0; q < n; q++) { // Calculating the number of outgoing links using adjacency matrix
				C[q] = 0;
				for (int r = 0; r < n; r++) {
					C[q] = C[q] + adjMatrix[q][r];
				}
			}

			switch (initialvalue) {
			case 0: // If initialvalue = 0; assign the initial page rank vector with 0
				for (int q = 0; q < n; q++) {
					src[q] = 0;
				}
				break;
			case 1: // If initialvalue = 1; assign the initial page rank vector with 1
				for (int q = 0; q < n; q++) {
					src[q] = 1;
				}
				break;

			case -1: // If initialvalue = -1; assign the initial page rank vector with 1.0/n
				for (int q = 0; q < n; q++) {
					src[q] = 1.0 / n;
				}
				break;
			case -2: // If initialvalue = -2; assign the initial page rank vector with 1.0/Sq rt of N
				for (int q = 0; q < n; q++) {
					src[q] = 1.0 / Math.sqrt(n);
				}
				break;
			}

		} catch (FileNotFoundException e) {
			System.out.println("File is not found" + e);
		}
	}

	// Calculate the Page Rank Score

	public void calculatePageRank() {
		D = new double[n];
		int counter = 0; // counter variable to skip initial initialization of page rank vector

		if (n <= 10) { // When no of vertices is less than or equal to 10

			// Base case
			System.out.print("Base : 0 :");
			for (int p = 0; p < n; p++) {
				System.out.printf("P[ " + p + "]=%.7f ", Math.round(src[p] * 10000000.0) / 10000000.0);
			}

			// First case where iteration is not equal to 0

			if (iterations > 0) {

				for (int i = 1; i <= iterations; i++) { // Start of Iteration

					// Initialize the Page rank Vector
					for (int p = 0; p < n; p++) {
						D[p] = 0.0;
					}

					// Calculate the page rank
					for (int q = 0; q < n; q++) {
						for (int r = 0; r < n; r++) {
							if (adjMatrix[r][q] == 1) {
								D[q] = D[q] + src[r] / C[r];
							}
						}
					}

					System.out.println();
					System.out.print("Iter : " + i + " :");
					for (int p = 0; p < n; p++) {
						D[p] = d * D[p] + (1 - d) / n;
						System.out.printf("P[ " + p + "]=%.7f ", Math.round(D[p] * 10000000.0) / 10000000.0);
					}

					// update the value of page rank vector to be used for next iteration
					for (int p = 0; p < n; p++) {
						src[p] = D[p];
					}

				} // End of Iteration

			} else { // End of First Case, and start of when iteration less than or equal to 0

				int i = 0; // Initialize variable for no. of iterations
				do { // At least run once or while src - D > errorrate
					if (counter > 0) { // Counter variable to skip first time initialization of initial page rank
										// vector
						for (int p = 0; p < n; p++) {
							src[p] = D[p];
						}
					}
					// Reset the page rank vector with initial value
					for (int p = 0; p < n; p++) {
						D[p] = 0.0;
					}

					// Calculate the page rank
					for (int q = 0; q < n; q++) {
						for (int r = 0; r < n; r++) {
							if (adjMatrix[r][q] == 1) {
								D[q] = D[q] + src[r] / C[r];
							}
						}
					}
					i++; // Increment the value of i for no. of iterations
					System.out.println();
					System.out.print("Iter : " + i + " :");
					for (int p = 0; p < n; p++) {
						D[p] = d * D[p] + (1 - d) / n;
						System.out.printf("P[ " + p + "]=%.7f ", Math.round(D[p] * 10000000.0) / 10000000.0);
					}

					counter++; // Increment the counter to allow update of initial page rank vector with
								// current page rank vector

				} while (true == hasConverged(src, D));
			}

		} else if (n > 10 && n < 1000000) { // End of If condition when no of vertices is less than or equal to 10

			int i = 0; // Initialize counter for no. of iterations
			iterations = 0; // Set Iterations to 0
			for (int p = 0; p < n; p++) { // Set Initial Page rank vector with 1.0/n
				src[p] = 1.0 / n;
			}

			do { // At least run once or while src - D > errorrate
				if (counter > 0) {
					for (int p = 0; p < n; p++) {
						src[p] = D[p];
					}
				}
				for (int p = 0; p < n; p++) {
					D[p] = 0.0;
				}

				// Calculate the page rank
				for (int q = 0; q < n; q++) {
					for (int r = 0; r < n; r++) {
						if (adjMatrix[r][q] == 1) {
							D[q] = D[q] + src[r] / C[r];
						}
					}
				}
				i++; // Increment the value of i for no. of iterations
				System.out.println();
				System.out.print("Iter : " + i + " :");
				for (int p = 0; p < n; p++) {
					D[p] = d * D[p] + (1 - d) / n;
					System.out.printf("P[ " + p + "]=%.7f ", Math.round(D[p] * 10000000.0) / 10000000.0);
				}

				counter++; // Increment the counter to allow update of initial page rank vector with
							// current page rank vector

			} while (true == hasConverged(src, D));
		}
	}

	// calculate errorrate

	public double calculateErrorrate() {
		if (iterations == 0) {
			errorrate = Math.pow(10, -5);
		} else if (iterations < 0) {
			errorrate = Math.pow(10, iterations);
		}
		return errorrate;
	}

	// Convergence Function

	public boolean hasConverged(double[] src, double[] D) {
		for (int p = 0; p < n; p++) {
			if (abs(src[p] - D[p]) > calculateErrorrate()) {
				return true;
			}
		}
		return false;
	}

	// Main Method

	public static void main(String[] args) {
		if (args.length == 3) {
			System.out.println();
			System.out.println("Your passed arguments are: iterations: " + args[0] + ", initialvalue: " + args[1]
					+ ", filename: " + args[2]);
			System.out.println();
			System.out.println("*** Program Output ***");

			// set the command line arguments to local variables
			int iterations = Integer.parseInt(args[0]);
			int initialvalue = Integer.parseInt(args[1]);
			String filename = args[2];

			// Check for Initial Values from user input
			if (initialvalue < -2 || initialvalue > 1) {
				System.out.println("Initial Value can be only -2, -1, 0 or 1");
				return;
			}

			// Call the argument constructor and pass the user input
			pgrk_4952 pg = new pgrk_4952(iterations, initialvalue, filename);

			pg.calculatePageRank();

		} else {
			System.out.println("Page Rank Algorithm requires 3 arguments: iterations initialvalue filename");
			return;
		}
	}

}
