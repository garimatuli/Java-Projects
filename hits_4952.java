/**
 * GARIMA TULI cs610 4952 prp
 * This is the java implementation for calculating hub and authority score
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.Math.*;

public class hits_4952 {

	/**
	 * @param args iterations, initialvalue, filename
	 */

	int iterations; // positive integer or an errorrate for a negative or zero integer value
					// for eg: iteration 0 means errorrate of 10 ^ -5,

	int initialvalue; 	// common initial value of the vector used, sets the intial vector value, if it
						// is 0, set to 0, if it is 1, set to 1
						// if it is -1, set to 1/N, where N is number of webpages (vertices of the
						// graph), if it is -2, set to 1/sq. root of N

	String filename; // stores the input graph
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
	// In such a case, the hub/authority will be calculated at the stopping
	// iteration are only shown one per line
	// The graph is stored as samplegraph.txt

	int[][] adjMatrix; // Adjacency Matrix
	double[] h0; // h0 hub array
	double[] a0; // a0 authority array
	double errorrate = 0.0; // errorrate variable

	// Default Constructor
	hits_4952() {

	}

	// Parameterized Constructor

	hits_4952(int iterations, int initialvalue, String filename) {

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

			h0 = new double[n]; // h0 size is made equal to no of vertices
			a0 = new double[n]; // a0 is made equal to no of vertices

			switch (initialvalue) {
			case 0: // If initialvalue = 0; assign the initial hub and authority matrix with 0
				for (int q = 0; q < n; q++) {
					h0[q] = 0;
					a0[q] = 0;
				}
				break;
			case 1: // If initialvalue = 1; assign the initial hub and authority matrix with 1
				for (int q = 0; q < n; q++) {
					h0[q] = 1;
					a0[q] = 1;
				}
				break;

			case -1: // If initialvalue = -1; assign the initial hub and authority matrix with 1.0/n
				for (int q = 0; q < n; q++) {
					h0[q] = 1.0 / n;
					a0[q] = 1.0 / n;
				}
				break;
			case -2: // If initialvalue = -2; assign the initial hub and authority matrix with 1.0/Sq
						// rt of N
				for (int q = 0; q < n; q++) {
					h0[q] = 1.0 / Math.sqrt(n);
					a0[q] = 1.0 / Math.sqrt(n);
				}
				break;
			}

		} catch (FileNotFoundException e) {
			System.out.println("File is not found" + e);
		}
	}

	// Calculate the Hub and Authority Score

	public void calculateHubAuthorityScore() {
		double[] h = new double[n]; // hub Matrix with size of no of vertices
		double[] a = new double[n]; // authority Matrix size of no of vertices
		double h_scaleFactor = 0.0; // hub scale factor
		double h_sumSquare = 0.0;
		double a_scaleFactor = 0.0; // authority scale factor
		double a_sumSquare = 0.0; //

		double[] h_previousValue = new double[n]; // store the last value and use it for convergence
		double[] a_previousValue = new double[n]; // store the last value and use it for convergence

		if (n <= 10) { // When no of vertices is less than or equal to 10

			// Initialization of hub and authority current and previous array.

			for (int q = 0; q < n; q++) {
				h[q] = h0[q];
				a[q] = a0[q];
				h_previousValue[q] = h[q];
				a_previousValue[q] = a[q];
			}

			// Base case
			System.out.print("Base : 0 :");
			for (int q = 0; q < n; q++) {
				System.out.printf("A/H[ %d]= %.7f/%.7f ", q, Math.round(a0[q] * 10000000.0) / 10000000.0,
						Math.round(h0[q] * 10000000.0) / 10000000.0);
			}

			// First case where iteration is not equal to 0

			if (iterations > 0) {

				for (int i = 1; i <= iterations; i++) { // Start of Iteration

					for (int p = 0; p < n; p++) {
						a[p] = 0.0;
					}

					// Calculate the authority score without convergence
					for (int q = 0; q < n; q++) {
						for (int r = 0; r < n; r++) {
							if (adjMatrix[r][q] == 1) {
								a[q] = a[q] + h[r];
							}
						}
					}

					// Calculate the hub score without convergence
					for (int p = 0; p < n; p++) {
						h[p] = 0.0;
					}

					for (int q = 0; q < n; q++) {
						for (int r = 0; r < n; r++) {
							if (adjMatrix[q][r] == 1) {
								h[q] = h[q] + a[r];
							}
						}
					}

					// a scaling factor
					a_scaleFactor = 0.0;
					a_sumSquare = 0.0;

					for (int s = 0; s < n; s++) {
						a_sumSquare = a_sumSquare + a[s] * a[s];
					}

					a_scaleFactor = Math.sqrt(a_sumSquare);

					for (int s = 0; s < n; s++) {
						a[s] = a[s] / a_scaleFactor;
					}

					// h scaling factor
					h_scaleFactor = 0.0;
					h_sumSquare = 0.0;

					for (int s = 0; s < n; s++) {
						h_sumSquare = h_sumSquare + h[s] * h[s];
					}

					h_scaleFactor = Math.sqrt(h_sumSquare);

					for (int s = 0; s < n; s++) {
						h[s] = h[s] / h_scaleFactor;
					}

					System.out.println();
					System.out.print("Iter : " + i + " :");
					for (int s = 0; s < n; s++) {
						System.out.printf("A/H[ %d]= %.7f/%.7f ", s, Math.round(a[s] * 10000000.0) / 10000000.0,
								Math.round(h[s] * 10000000.0) / 10000000.0);
					}

				} // End of Iteration

			} else { // End of First Case, and start of when iteration less than or equal to 0

				int i = 0; // Initialize counter for no. of iterations
				do { // At least run once or while a and h (current - previous > errorrate)

					for (int t = 0; t < n; t++) {
						a_previousValue[t] = a[t];
						h_previousValue[t] = h[t];
					}

					for (int p = 0; p < n; p++) {
						a[p] = 0.0;
					}

					// Calculate the authority score without convergence
					for (int q = 0; q < n; q++) {
						for (int r = 0; r < n; r++) {
							if (adjMatrix[r][q] == 1) {
								a[q] = a[q] + h[r];
							}
						}
					}

					// Calculate the hub score without convergence
					for (int p = 0; p < n; p++) {
						h[p] = 0.0;
					}

					for (int q = 0; q < n; q++) {
						for (int r = 0; r < n; r++) {
							if (adjMatrix[q][r] == 1) {
								h[q] = h[q] + a[r];
							}
						}
					}

					// a scaling factor
					a_scaleFactor = 0.0;
					a_sumSquare = 0.0;

					for (int s = 0; s < n; s++) {
						a_sumSquare = a_sumSquare + a[s] * a[s];
					}

					a_scaleFactor = Math.sqrt(a_sumSquare);

					for (int l = 0; l < n; l++) {
						a[l] = a[l] / a_scaleFactor;
					}

					// h scaling factor

					h_scaleFactor = 0.0;
					h_sumSquare = 0.0;

					for (int s = 0; s < n; s++) {
						h_sumSquare = h_sumSquare + h[s] * h[s];
					}

					h_scaleFactor = Math.sqrt(h_sumSquare);

					for (int s = 0; s < n; s++) {
						h[s] = h[s] / h_scaleFactor;
					}
					i++; // Increment the value of counter for no. of iterations
					System.out.println();
					System.out.print("Iter : " + i + " :");
					for (int s = 0; s < n; s++) {
						System.out.printf("A/H[ %d]= %.7f/%.7f ", s, Math.round(a[s] * 10000000.0) / 10000000.0,
								Math.round(h[s] * 10000000.0) / 10000000.0);
					}

				} while (true == hasConverged(a, a_previousValue) || true == hasConverged(h, h_previousValue));
			}

		} else if (n > 10 && n < 1000000) { // End of If condition when no of vertices is less than or equal to 10
			iterations = 0; // Set Iterations to 0

			// Initialization of hub and authority current and previous array.

			for (int q = 0; q < n; q++) {
				h[q] = 1.0 / n;
				a[q] = 1.0 / n;
				h_previousValue[q] = h[q];
				a_previousValue[q] = a[q];
			}

			// Base case
			System.out.print("Base : 0 :");
			for (int q = 0; q < n; q++) {
				System.out.printf("A/H[ %d]= %.7f/%.7f ", q, Math.round(a0[q] * 10000000.0) / 10000000.0,
						Math.round(h0[q] * 10000000.0) / 10000000.0);
			}

			int i = 0; // Initialize counter for no. of iterations
			do { // At least run once or while a and h (current - previous > errorrate)

				for (int t = 0; t < n; t++) {
					a_previousValue[t] = a[t];
					h_previousValue[t] = h[t];
				}

				for (int p = 0; p < n; p++) {
					a[p] = 0.0;
				}

				// Calculate the authority score without convergence
				for (int q = 0; q < n; q++) {
					for (int r = 0; r < n; r++) {
						if (adjMatrix[r][q] == 1) {
							a[q] = a[q] + h[r];
						}
					}
				}

				// Calculate the hub score without convergence
				for (int p = 0; p < n; p++) {
					h[p] = 0.0;
				}

				for (int q = 0; q < n; q++) {
					for (int r = 0; r < n; r++) {
						if (adjMatrix[q][r] == 1) {
							h[q] = h[q] + a[r];
						}
					}
				}

				// a scaling factor
				a_scaleFactor = 0.0;
				a_sumSquare = 0.0;

				for (int s = 0; s < n; s++) {
					a_sumSquare = a_sumSquare + a[s] * a[s];
				}

				a_scaleFactor = Math.sqrt(a_sumSquare);

				for (int l = 0; l < n; l++) {
					a[l] = a[l] / a_scaleFactor;
				}

				// h scaling factor

				h_scaleFactor = 0.0;
				h_sumSquare = 0.0;

				for (int s = 0; s < n; s++) {
					h_sumSquare = h_sumSquare + h[s] * h[s];
				}

				h_scaleFactor = Math.sqrt(h_sumSquare);

				for (int s = 0; s < n; s++) {
					h[s] = h[s] / h_scaleFactor;
				}
				i++; // Increment the value of counter for no. of iterations
				System.out.println();
				System.out.print("Iter : " + i + " :");
				for (int s = 0; s < n; s++) {
					System.out.printf("A/H[ %d]= %.7f/%.7f ", s, Math.round(a[s] * 10000000.0) / 10000000.0,
							Math.round(h[s] * 10000000.0) / 10000000.0);
				}

			} while (true == hasConverged(a, a_previousValue) || true == hasConverged(h, h_previousValue));
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

	public boolean hasConverged(double[] currentValue, double[] previousValue) {
		for (int q = 0; q < n; q++) {
			if (abs(currentValue[q] - previousValue[q]) > calculateErrorrate()) {
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
			hits_4952 hs = new hits_4952(iterations, initialvalue, filename);

			hs.calculateHubAuthorityScore();

		} else {
			System.out.println("Hits Algorithm requires 3 arguments: iterations initialvalue filename");
			return;
		}
	}

}
