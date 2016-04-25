package com.application.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import com.application.model.StandardOntology;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class TrainingData {
	public TrainingData() {
	}

	public HashMap<String, ArrayList<StandardOntology>> initVocabulary() {
		Gson gson = new Gson();
		HashMap<String, ArrayList<StandardOntology>> vocabulary = new 
				HashMap<String, ArrayList<StandardOntology>>();
		try {
			FileReader fileReader = new FileReader("Input/training_data.json");
			BufferedReader br = new BufferedReader(fileReader);
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line.trim());
				line = br.readLine();
			}
			br.close();
			String jsonString = sb.toString();
			JsonElement jelement = new JsonParser().parse(jsonString);
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("vocabulary");

			for (int i = 0; i < jarray.size(); i++) {
				JsonElement obj = jarray.get(i);
				String word = obj.getAsJsonObject().get("relation").getAsString();
				String distribution = obj.getAsJsonObject().get("percentage").toString();
				ArrayList<StandardOntology> dis = new ArrayList<>();
				Type type = new TypeToken<ArrayList<StandardOntology>>() {
				}.getType();
				dis = gson.fromJson(distribution, type);
				vocabulary.put(word, dis);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return vocabulary;
	}

}
