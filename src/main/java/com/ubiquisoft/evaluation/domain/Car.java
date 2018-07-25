package com.ubiquisoft.evaluation.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {

	private String year;
	private String make;
	private String model;

	private List<Part> parts;

	public Map<PartType, Integer> getMissingPartsMap() {
		/*
		 * Return map of the part types missing.
		 *
		 * Each car requires one of each of the following types:
		 *      ENGINE, ELECTRICAL, FUEL_FILTER, OIL_FILTER
		 * and four of the type: TIRE
		 *
		 * Example: a car only missing three of the four tires should return a map like this:
		 *
		 *      {
		 *          "TIRE": 3
		 *      }
		 */

		Map<PartType, Integer> missingParts = new HashMap<PartType, Integer>();

		int engine = 1, electrical = 1, tires = 4, fuel_filter = 1, oil_filter = 1;

		for (Part part : parts){

			if (part.getType() == PartType.ENGINE) engine--;
			if (part.getType() == PartType.ELECTRICAL) electrical--;
			if (part.getType() == PartType.TIRE) tires--;
			if (part.getType() == PartType.FUEL_FILTER) fuel_filter--;
			if (part.getType() == PartType.OIL_FILTER) oil_filter--;

		}

		if (engine != 0) missingParts.put(PartType.ENGINE, 1);
		if (electrical != 0) missingParts.put(PartType.ELECTRICAL, 1);
		if (tires != 0) missingParts.put(PartType.TIRE, tires);
		if (fuel_filter != 0) missingParts.put(PartType.FUEL_FILTER, 1);
		if (oil_filter != 0) missingParts.put(PartType.OIL_FILTER, 1);

		return missingParts;
	}

	@Override
	public String toString() {
		return "Car{" +
				       "year='" + year + '\'' +
				       ", make='" + make + '\'' +
				       ", model='" + model + '\'' +
				       ", parts=" + parts +
				       '}';
	}

	/* --------------------------------------------------------------------------------------------------------------- */
	/*  Getters and Setters *///region
	/* --------------------------------------------------------------------------------------------------------------- */

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	/* --------------------------------------------------------------------------------------------------------------- */
	/*  Getters and Setters End *///endregion
	/* --------------------------------------------------------------------------------------------------------------- */

}
