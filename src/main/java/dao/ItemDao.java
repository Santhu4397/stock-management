package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import dto.ItemDto;

public class ItemDao {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	private EntityManager getEntityManager() {
		 entityManagerFactory=Persistence.createEntityManagerFactory("stocks");
		 return entityManagerFactory.createEntityManager();
		 
	}
	public void saveItem(ItemDto item ) {
		entityManager=getEntityManager();
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();
	}
	public void deleteItem(int id) {
		entityManager=getEntityManager();
		Item item=entityManager.find(Item.class, id);
		if(item != null) {
		entityTransaction.begin();
		entityManager.remove(item);
		entityTransaction.commit();
		}
	}
	

}
