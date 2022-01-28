package controller;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import dao.ItemDao;
import dto.ItemDto;

public class Testtosave {
	public static void main(String[] args) {
		ItemDto item=new ItemDto();
		item.setName("pen");
		item.setQuantity(2);
		item.setCost(120.0);
		item.setType("camle");
		ItemDao dao=new ItemDao();
		dao.saveItem(item);
	}

}
