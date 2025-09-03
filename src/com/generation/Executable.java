package com.generation;

import com.generation.bl.BusinessLogicProduct;
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
		BusinessLogicProduct pbl = new BusinessLogicProduct();

		pbl.deleteProduct();

	}
}
