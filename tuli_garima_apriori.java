package tuli_garima_midtermproj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class tuli_garima_apriori {
		
		// ArrayList to store unique items from all transactions
		private static ArrayList<String> uniqueItemsList = new ArrayList<String>();
		// Data Structures to store all transactions
		private static ArrayList<HashSet<String>> transactionAllItemsList = new ArrayList<HashSet<String>>();
		// HashMap to store count per item in each transaction
		private static HashMap<String,Integer> currentCandidacyList = new HashMap<String,Integer>();
		// ArrayList to store frequent items
		private static ArrayList<String> frequentItemsList = new ArrayList<String>();
		// HashMap to store items whose count/no of transactions >= support
		private static HashMap<String,Integer> frequentItemsForAssociations = new HashMap<String,Integer>();
		// ArrayList to store frequent List after first iteration
		private static ArrayList<String> frequentItemsListAfterFirstIteration = new ArrayList<String>();
		// ArrayList to store each possible combination from frequent list
		private static ArrayList<String> combinationItemsList	 = new ArrayList<String>();
		
		// Main Function
		public static void main(String args[]) {
			
			System.out.println("\nWelcome to Garima Tuli's Apriori Algorithm\n");
			System.out.println("****************************");
			System.out.println("\nFollowing is the Input Dataset:");
			System.out.println();
			
			// Call Function to read dataset from file
			readDataFromFile();
			System.out.println("\n****************************");
			System.out.println();
			
			// Input Support from User
			System.out.println("Enter Minimum Support Value: ");
			
			Scanner sc = new Scanner(System.in);
			double support = sc.nextDouble();
			System.out.println();
			
			// Input Confidence from User
			System.out.println("Enter Minimum Confidence Value: ");
			double confidence = sc.nextDouble();
			
			System.out.println("Assosciation Rules satisfying the minimum Support & Confidence Values entered by user above are as follows:");
			
			// Logic to generate candidacy List, frequent item set and associations
			int itemCount = 1;
			if (itemCount == 1) {
				candidacyListforOneorAllCombinations(uniqueItemsList, itemCount);
				frequentList(support);
				frequentItemsListAfterFirstIteration = new ArrayList<String>(frequentItemsList);
				itemCount = itemCount + 1;
			}
			if (itemCount == 2) {
				String[] itemCountArray = new String[itemCount];
				combinationItemsList.clear();
				ListWithTwoItems(frequentItemsListAfterFirstIteration, frequentItemsListAfterFirstIteration.size(), itemCount, 0, itemCountArray, 0);
				candidacyListforOneorAllCombinations(combinationItemsList, itemCount);
				frequentList(support);
				itemCount = itemCount + 1;
			}
			if (itemCount == 3) {
				while(frequentItemsList.size() != 0) {
				ListWithThreeOrMoreItems(frequentItemsList, itemCount);
				candidacyListforOneorAllCombinations(combinationItemsList, itemCount);
				frequentList(support);
				itemCount = itemCount + 1;
				}
			}
			
			findAllAssociations(frequentItemsForAssociations, confidence);
		}
		
		

		// Read Data from File
		public static void readDataFromFile() {
			// Replace different file name here for different data set
			String fileName = "dataset\\database1.txt";
			// Local variable for each line
			String eachLine = null;
			// Unique Items
			HashSet<String> uniqueItems = new HashSet<String>();
			try {
				FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				while((eachLine = bufferedReader.readLine()) != null) {
					// Local Items to form transactionItemsList
					HashSet<String> localItems = new HashSet<String>();
					String formedList[] = eachLine.split(",");
					for (int i=0;i<formedList.length;i++) {
						localItems.add(formedList[i]);
						uniqueItems.add(formedList[i]);
					}
					
					System.out.println(eachLine);
					// transactionItemsList will contain set of all itemset
					transactionAllItemsList.add(localItems);
				}
				
			} catch (Exception e) {
				System.out.println("In to Exception"+e);
			}
			
			// finalList is arraylist of unique items from itemset
			uniqueItemsList = new ArrayList<String>(uniqueItems);
		//	System.out.println("Final List is"+uniqueItemsList);
		
		}
		
		// Function to form candidacy list (for one or all possible combinations in all transactions)
		public static void candidacyListforOneorAllCombinations(ArrayList<String> receivedUniqueItemsList, int receivedCount ) {
			if (receivedCount == 1) {
				currentCandidacyList.clear();
				// Loop through final List which is a unique list (finalList) 
				// and all items (transactionItemsList)
				// to generate count per item in each transaction
				for(int i = 0;i < receivedUniqueItemsList.size();i++) {
					String oneItem = receivedUniqueItemsList.get(i);
					for(int j = 0; j < transactionAllItemsList.size();j++) {
						if(transactionAllItemsList.get(j).contains(oneItem)) {
							if (currentCandidacyList.containsKey(oneItem)) {
							int counter = currentCandidacyList.get(oneItem);
							currentCandidacyList.put(oneItem, ++counter);
						} else {
							currentCandidacyList.put(oneItem,1);
						}
					}
				}
			}
		} else {
			currentCandidacyList.clear();
			for (int i = 0; i< receivedUniqueItemsList.size(); i++) {
				String st = receivedUniqueItemsList.get(i);
				String [] splitString = st.split(" ");
				for (int j=0; j< transactionAllItemsList.size();j++) {
					boolean fl = true;
					for (int k = 0; k< splitString.length; k++) {
						if(!transactionAllItemsList.get(j).contains(splitString[k])) {
							fl=false;
							break;
						}
					}
					if (fl==true) {
						if(currentCandidacyList.containsKey(st)) {
							int value = currentCandidacyList.get(st);
							currentCandidacyList.put(st, ++value);
						} else {
							currentCandidacyList.put(st, 1);
						}
					}
				}
			}
		}
	}
		
		// Function to form ArrayList for two items per transaction
		public static void ListWithTwoItems(ArrayList<String> receivedFrequentItemsList,
				int receivedFrequentItemsListSize,int itemCountSize, int i, String[] itemCountArray, int j) {
			if (i == itemCountSize) {
				String st = "";
				for (int k = 0; k <  itemCountSize; k++)  {
					st = st + itemCountArray[k] + " ";				
				}
				combinationItemsList.add(st);
				return;	
			}
			if (j >= receivedFrequentItemsListSize) {
				return;
			}
			
			itemCountArray[i] = receivedFrequentItemsList.get(j);
			ListWithTwoItems(receivedFrequentItemsList, receivedFrequentItemsListSize, itemCountSize, i+1, itemCountArray, j+1);
			ListWithTwoItems(receivedFrequentItemsList, receivedFrequentItemsListSize, itemCountSize, i, itemCountArray, j+1);
			
		}
		
		// Function to form ArrayList for three or more items per transaction
		private static void ListWithThreeOrMoreItems(ArrayList<String> receivedFrequentItemsList, int receivedCount) {
			combinationItemsList.clear();
			for (int i=0; i< receivedFrequentItemsList.size(); i++) {
				String eachString = receivedFrequentItemsList.get(i).trim();
				String st = eachString.substring(0, eachString.lastIndexOf(" "));
				for (int j =i+1; j< receivedFrequentItemsList.size(); j++) {
					String eachString1 = receivedFrequentItemsList.get(j).trim();
					String st1 = eachString1.substring(0, eachString1.lastIndexOf(" "));
					if (st.equals(st1)) {
						combinationItemsList.add(eachString + " " + eachString1.substring(eachString1.lastIndexOf(" ")+1));
					}
				}
			}
			
		}
		
		// Function to form frequent List and frequent List for association
		public static void frequentList(double receivedSupport) {
			frequentItemsList.clear();
			receivedSupport = receivedSupport/100;
			Set<String> items = currentCandidacyList.keySet();
			for (String eachItem: items) {
				if ( (double) currentCandidacyList.get(eachItem)/transactionAllItemsList.size() >= receivedSupport) {
					frequentItemsList.add(eachItem);
					frequentItemsForAssociations.put(eachItem, currentCandidacyList.get(eachItem));
				}	
			}
		}
		
		// Function to form all the associations
		public static void findAllAssociations(HashMap<String, Integer> receivedFrequentItemsForAssociations, double confidenceFromUser) {
			for (String st: receivedFrequentItemsForAssociations.keySet()) {
				String[] splitArray = st.split(" ");
				if (splitArray.length == 2) {
					printAssociationBasedOnConfidence(st, receivedFrequentItemsForAssociations.get(st), splitArray[0], splitArray[1], confidenceFromUser);
					printAssociationBasedOnConfidence(st, receivedFrequentItemsForAssociations.get(st), splitArray[1], splitArray[0], confidenceFromUser);
				} else if (splitArray.length == 3) {
					for (int i = 0; i< splitArray.length; i++) {
						if (i==0) {
							printAssociationBasedOnConfidence(st, receivedFrequentItemsForAssociations.get(st), splitArray[i], splitArray[i+1]+" "+splitArray[i+2], confidenceFromUser);
							printAssociationBasedOnConfidence(st, receivedFrequentItemsForAssociations.get(st), splitArray[i+1]+" "+splitArray[i+2], splitArray[i], confidenceFromUser);
						} else if (i==1) {
							printAssociationBasedOnConfidence(st, receivedFrequentItemsForAssociations.get(st), splitArray[i], splitArray[i-1]+" "+splitArray[i+1], confidenceFromUser);
							printAssociationBasedOnConfidence(st, receivedFrequentItemsForAssociations.get(st), splitArray[i-1]+" "+splitArray[i+1], splitArray[i], confidenceFromUser);
						} else {
							printAssociationBasedOnConfidence(st, receivedFrequentItemsForAssociations.get(st), splitArray[i], splitArray[i-2]+" "+splitArray[i-1], confidenceFromUser);
							printAssociationBasedOnConfidence(st, receivedFrequentItemsForAssociations.get(st), splitArray[i-2]+" "+splitArray[i-1], splitArray[i], confidenceFromUser);
						}
					}
				}
			}
				
		}

		// Function to print associations for confidence greater than user provided confidence
		public static void printAssociationBasedOnConfidence(String eachFrequentListItem, int countOfEachFrequentListItem, String leftHandSide, String rightHandSide, double confidenceFromUser) {
			int count = 0;
			String[] splitArray = leftHandSide.split(" ");
			int length = splitArray.length;
			for (int i=0; i< transactionAllItemsList.size(); i++) {
				boolean fl = true;
				for (int j=0; j< length; j++) {
					if(!transactionAllItemsList.get(i).contains(splitArray[j])) {
						fl = false;
						break;
					}
				}	
					if (fl == true) {
						count = count + 1;
					}
				}
		
			double confidenceOfEachAssociation = (double) countOfEachFrequentListItem/(count*1.0);
			double percentageUserConfidence = (double) confidenceFromUser/100;
			if (confidenceOfEachAssociation >= percentageUserConfidence) {
				System.out.println(leftHandSide + "->" + rightHandSide );
			}
		}

	}

