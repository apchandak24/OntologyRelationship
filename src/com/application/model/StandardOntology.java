package com.application.model;

public class StandardOntology {
	private String ontology;
	private int value;
	public String getOntology() {
		return ontology;
	}
	public void setOntology(String ontology) {
		this.ontology = ontology;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return ontology+" "+value;
	}
}
