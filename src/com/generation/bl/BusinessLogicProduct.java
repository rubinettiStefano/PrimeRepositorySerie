package com.generation.bl;

import com.generation.entities.Product;
import com.generation.repositories.RepositoryProductSqlite;

import java.util.ArrayList;
import java.util.Scanner;

public class BusinessLogicProduct
{

	private RepositoryProductSqlite repo = new RepositoryProductSqlite();
	private Scanner sc = new Scanner(System.in);

	public void printAllProducts()
	{
		System.out.println("Eccoti tutti i prodotti, marrano");
		for (Product p : repo.readAll())
			System.out.println("Id " + p.getId() + " - " + p.getProductName());
	}

	public void printProductsByCategory()
	{
		System.out.println("Dammi la categoria");
		String cat = sc.nextLine();//readString
//		String primaLettera = cat.substring(0,1);
//		String resto = cat.substring(1);
//		String conPrimaMaiuscola = primaLettera.toUpperCase()+resto;
//		ArrayList<Product> prods = repo.readWhere("category = '" + conPrimaMaiuscola + "'");
		ArrayList<Product> prods = repo.readWhere("category like '" + cat + "'");
		if (prods.isEmpty())
			System.out.println("Non ho prodotti per quella categoria");
		else
		{
			System.out.println("Eccoti tutti i prodotti della categoria scelta, marrano");
			for (Product p : prods)
				System.out.println("Id " + p.getId() + " - " + p.getProductName());
		}
	}

	public void deleteProduct()
	{
		printAllProducts();
		System.out.println("Dammi id di quello da cancellare");
		Long id = Long.parseLong(sc.nextLine());
		repo.deleteById(id);
	}

	public void createProduct()
	{
		Product p = new Product();
		//NO NO NO ID
		System.out.println("Dammi nome");
		p.setProductName(sc.nextLine());
		System.out.println("Dammi categoria");
		p.setCategory(sc.nextLine());
		//e tutti gli altri

		repo.create(p);

	}

	public void updateProduct()
	{
		printAllProducts();
		System.out.println("Dammi id di quello da modicare");
		Long id = Long.parseLong(sc.nextLine());
		Product p = repo.readById(id);

//		System.out.println("Vuoi modificare il nome, scrivi quello nuovo se si, invio per lasciarlo uguale");
//		String in = sc.nextLine();
//		if(!in.isBlank())
//			p.setProductName(in);
//		System.out.println("Vuoi modificare la categoria, scrivi quello nuovo se si, invio per lasciarlo uguale");
//		in = sc.nextLine();
//		if(!in.isBlank())
//			p.setCategory(in);
//		System.out.println("Vuoi modificare il prezzo, scrivi quello nuovo se si, invio per lasciarlo uguale");
//		in = sc.nextLine();
//		if(!in.isBlank())
//			p.setUnitPrice(Double.parseDouble(in));
		int n = 0;
		System.out.println("Metti il numero della proprietà da modificare");
		System.out.println("1 - nome");
		System.out.println("2 - categoria");
		System.out.println("3 - prezzo");
		System.out.println("0 - fine modifiche");
		System.out.println("ecc..");
		do
		{
			n = Integer.parseInt(sc.nextLine());
			switch (n)
			{
				case 1 ->
				{
					System.out.println("Metti nuovo nome");
					p.setProductName(sc.nextLine());
				}
				case 2 ->
				{
					System.out.println("Metti nuova categoria");
					p.setCategory(sc.nextLine());
				}
				case 3 ->
				{
					System.out.println("Metti nuovo prezzo");
					p.setUnitPrice(Double.parseDouble(sc.nextLine()));
				}
				case 0  -> System.out.println("Modifiche finite");
				default  -> System.out.println("Maledetto, metti un numero valido");
			}

			if(n!=0)
				System.out.println("Inserisci altro numero");
		}while(n!=0);

		repo.update(p);
	}

}
