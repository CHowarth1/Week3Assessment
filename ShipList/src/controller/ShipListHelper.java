package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ShipList;

/**
 * @author Christopher Howarth - chowarth1
 * CIS175 - Fall 2021
 * Feb 12, 2023
 */
public class ShipListHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ShipList");
	
	public void insertShip(ShipList ss) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ss);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<ShipList> showAllShips(){
		EntityManager em = emfactory.createEntityManager();
		List<ShipList> allShips = em.createQuery("SELECT i FROM ShipList i").getResultList();
		return allShips;
		
	}
	
	public void deleteShip(ShipList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ShipList> typedQuery = em.createQuery("select i from ShipList i where i.shipName = :selectedShipName and i.shipModel = :selectedShipModel and i.pilot = :selectedPilot", ShipList.class);
		
		typedQuery.setParameter("selectedShipName", toDelete.getShipName());
		typedQuery.setParameter("selectedShipModel", toDelete.getShipModel());
		typedQuery.setParameter("selectedPilot", toDelete.getPilot());
		
		typedQuery.setMaxResults(1);
		
		ShipList result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public List<ShipList> searchForShipByShipName(String shipName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ShipList> typedQuery = em.createQuery("select i from ShipList i where i.shipName = :selectedShipName", ShipList.class);
		typedQuery.setParameter("selectedShipName", shipName);
		
		List<ShipList> foundShips = typedQuery.getResultList();
		em.close();
		return foundShips;
	}

	public List<ShipList> searchForShipByShipModel(String shipModel) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ShipList> typedQuery = em.createQuery("select i from ShipList i where i.shipModel = :selectedShipModel", ShipList.class);
		typedQuery.setParameter("selectedShipModel", shipModel);
		
		List<ShipList> foundShips = typedQuery.getResultList();
		em.close();
		return foundShips;
	}

	public List<ShipList> searchForShipByPilot(String pilot) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ShipList> typedQuery = em.createQuery("select i from ShipList i where i.pilot = :selectedPilot", ShipList.class);
		typedQuery.setParameter("selectedPilot", pilot);
		
		List<ShipList> foundShips = typedQuery.getResultList();
		em.close();
		return foundShips;
	}

	public ShipList searchForShipById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ShipList found = em.find(ShipList.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateShip(ShipList toEdit) {
		//TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
