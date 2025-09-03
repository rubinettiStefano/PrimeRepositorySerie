package com.generation.model.repositories;

import com.generation.model.entities.Product;
import database.SqliteDatabase;
import database.VirtualTable;

import java.util.ArrayList;

public class RepositoryProductSqlite
{
	//si fa passare la connessione verso db
	private SqliteDatabase db = SqliteDatabase.getInstance();
	//readById
	//readAll
	//readWhere
	//create
	//update
	//delete
	//deleteById

	public ArrayList<Product> readAll()
	{
		ArrayList<Product> res = new ArrayList<>();

		VirtualTable v = db.executeSelect("SELECT * FROM product");
		//convertirli in oggetti Product
		while (v.hasRow())
		{
			res.add(convertRowToObject(v));
			v.nextRow();
		}
		return res;
	}

	public ArrayList<Product> readWhere(String condition)
	{
		ArrayList<Product> res = new ArrayList<>();

		VirtualTable v = db.executeSelect("SELECT * FROM product WHERE "+condition);
		//convertirli in oggetti Product
		while (v.hasRow())
		{
			res.add(convertRowToObject(v));
			v.nextRow();
		}
		return res;
	}

	public Product readById(Long id)
	{

		VirtualTable v = db.executeSelect("SELECT * FROM product WHERE id="+id);
		if (v.hasRow())
			return convertRowToObject(v);
		else
			return null;

	}

	public void create(Product p)
	{
		String query = "INSERT INTO product (product_name, category, quantity_per_unit, unit_price, units_in_stock, units_on_order, discontinued) " +
				"VALUES ('[productName]','[category]','[qntUnit]',[unitPrice],[unitsStock],[unitsOrder],[discontinued])";

		query = query
				.replace("[productName]",p.getProductName()+"")
				.replace("[category]",p.getCategory()+"")
				.replace("[qntUnit]",p.getQuantityPerUnit()+"")
				.replace("[unitPrice]",p.getUnitPrice()+"")
				.replace("[unitsStock]",p.getUnitsInStock()+"")
				.replace("[unitsOrder]",p.getUnitsOnOrder()+"")
				.replace("[discontinued]",p.isDiscontinued()+"");

		db.executeOthers(query);
	}

	public void update(Product p)
	{
		String query = "UPDATE product SET product_name='[productName]', category='[category]', " +
				"quantity_per_unit='[qntUnit]', unit_price=[unitPrice], units_in_stock=[unitsStock], " +
				"units_on_order=[unitsOrder], discontinued=[discontinued] WHERE id="+p.getId();
		query = query
				.replace("[productName]",p.getProductName())
				.replace("[category]",p.getCategory())
				.replace("[qntUnit]",p.getQuantityPerUnit())
				.replace("[unitPrice]",p.getUnitPrice()+"")
				.replace("[unitsStock]",p.getUnitsInStock()+"")
				.replace("[unitsOrder]",p.getUnitsOnOrder()+"")
				.replace("[discontinued]",p.isDiscontinued()+"");

		db.executeOthers(query);
	}

	public void delete(Product p)
	{
		deleteById(p.getId());
	}

	public void deleteById(Long id)
	{
		String query = "DELETE FROM product WHERE id="+id;

		db.executeOthers(query);
	}
	/**
	 * Converte una singola riga della virtual table in un oggetto Product
	 */
	private Product convertRowToObject(VirtualTable v)
	{
		Product p = new Product();
		p.setId(v.readAsLong("id"));
		p.setProductName(v.readAsString("product_name"));
		p.setCategory(v.readAsString("category"));
		p.setQuantityPerUnit(v.readAsString("quantity_per_unit"));
		p.setUnitPrice(v.readAsDouble("unit_price"));
		p.setUnitsInStock(v.readAsInt("units_in_stock"));
		p.setUnitsOnOrder(v.readAsInt("units_on_order"));
		p.setDiscontinued(v.readAsBoolean("discontinued"));

		return p;
	}
}
