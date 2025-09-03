package com.generation;

import com.generation.entities.BaseEntity;
import com.generation.entities.Product;
import com.generation.repositories.RepositoryProductSqlite;
import database.SqliteDatabase;

import java.util.ArrayList;

public class Executable
{
	public static void main(String[] args)
	{
		//crea la connessione il db
		SqliteDatabase.initializeSinglenton("db.sqlite");

		RepositoryProductSqlite repo = new RepositoryProductSqlite();
		Product p = new Product();
		p.setProductName("Mozzarella di Bufala Campana DOP");
		p.setCategory("Latticini");
		p.setQuantityPerUnit("Confezione da 250g");
		p.setUnitPrice(4.50);
		p.setUnitsInStock(120);
		p.setUnitsOnOrder(30);
		p.setDiscontinued(false);

		repo.update(p);

	}
}
