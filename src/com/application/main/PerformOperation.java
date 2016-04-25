package com.application.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.application.model.StandardOntology;

public class PerformOperation {

	public String getStandardRelationship(ArrayList<String> input,
			HashMap<String, ArrayList<StandardOntology>> stdVocab) {

		HashMap<String, Integer> result = new HashMap<>();
		for (String s : input) {
			String str = s.toLowerCase().trim();
			ArrayList<StandardOntology> temp = stdVocab.get(str);
			if (temp != null) {
				for (StandardOntology std : temp) {
					String name = std.getOntology();
					if (result.containsKey(std.getOntology())) {
						int val = result.get(name);
						val += std.getValue();
						result.put(name, val);
					} else {
						result.put(name, std.getValue());
					}
				}
			}
		}
		int maxVal =0;
		String relation="";
		for (Map.Entry<String, Integer> map : result.entrySet()) {
			if(map.getValue()>=maxVal){
				maxVal = map.getValue();
				relation=map.getKey();
			}
				
		}
		return relation;
	}

}
