package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Christopher Howarth - chowarth1
 * CIS175 - Fall 2021
 * Feb 11, 2023
 */

@Entity
@Table(name="shipName")
public class ShipList {
	
	// Attributes
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="SHIPNAME")
	private String shipName;
	@Column(name="SHIPMODEL")
	private String shipModel;
	@Column(name="PILOT")
	private String pilot;
	
	/**
	 * Default, no arg constructor
	 */
	public ShipList() {
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the shipName
	 */
	public String getShipName() {
		return shipName;
	}

	/**
	 * @param shipName the shipName to set
	 */
	public void setStarshipName(String shipName) {
		this.shipName = shipName;
	}

	/**
	 * @return the starshipModel
	 */
	public String getShipModel() {
		return shipModel;
	}

	/**
	 * @param shipModel the shipModel to set
	 */
	public void setShipModel(String shipModel) {
		this.shipModel = shipModel;
	}

	/**
	 * @return the pilot
	 */
	public String getPilot() {
		return pilot;
	}

	/**
	 * @param pilot the pilot to set
	 */
	public void setPilot(String pilot) {
		this.pilot = pilot;
	}
	
	public ShipList(String shipName, String shipModel, String pilot) {
		this.shipName = shipName;
		this.shipModel = shipModel;
		this.pilot = pilot;
	}
	
	public String returnShipDetails() {
		return this.shipName + " Model: " + this.shipModel + " Pilot: " + this.pilot;
	}
	

}
