package com.application.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.application.model.StandardOntology;
import com.application.utils.TrainingData;

public class MainActivity {
	private static ArrayList<String> relationships = new ArrayList<String>();
	private static HashMap<String, ArrayList<StandardOntology>> stdVocab = new HashMap<>();
	private static String actor1;
	private static String actor2;

	public static void main(String[] args) {

		stdVocab = new TrainingData().initVocabulary();
		takeInput();
		PerformOperation mOperation = new PerformOperation();
		String relation = mOperation.getStandardRelationship(relationships, stdVocab);

		if (!relation.isEmpty()) {
			System.out.println("Triple with standard ontology mapping");
				System.out.println(actor1 + "----" + relation + "----" + actor2);
		} else {
			System.out.println("Standard Ontology cannot be found");
		}

	}

	private static void takeInput() {

		System.out.println("Enter two Actors in the relationship");
		Scanner sc = new Scanner(System.in);
		actor1 = sc.next();
		actor2 = sc.next();
		System.out.println("Enter number of relationships");
		int n = sc.nextInt();
		System.out.println("Enter the list of relationship between them");

		for (int i = 0; i < n; i++)
			relationships.add(sc.next());
	}
}
