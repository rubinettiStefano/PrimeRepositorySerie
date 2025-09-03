package com.generation.entities;

public class Product extends BaseEntity
{
	private String productName;
	private String category;
	private String quantityPerUnit;
	private double unitPrice;
	private int unitsInStock;
	private int unitsOnOrder;
	private boolean discontinued;


	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getQuantityPerUnit()
	{
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit)
	{
		this.quantityPerUnit = quantityPerUnit;
	}

	public double getUnitPrice()
	{
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice)
	{
		this.unitPrice = unitPrice;
	}

	public int getUnitsInStock()
	{
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock)
	{
		this.unitsInStock = unitsInStock;
	}

	public int getUnitsOnOrder()
	{
		return unitsOnOrder;
	}

	public void setUnitsOnOrder(int unitsOnOrder)
	{
		this.unitsOnOrder = unitsOnOrder;
	}

	public boolean isDiscontinued()
	{
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued)
	{
		this.discontinued = discontinued;
	}
}
