package com.generation.controller;

import com.generation.controller.bl.BusinessLogicProduct;
import database.SqliteDatabase;

import java.util.Scanner;

public class Executable
{
	public static void main(String[] args)
	{
		//Inizializza database, BusinessLogic e scanner
		SqliteDatabase.initializeSinglenton("db.sqlite");
		BusinessLogicProduct pbl = new BusinessLogicProduct();
		Scanner sc = new Scanner(System.in);

		//ciclo principale per richiesta comandi utente
		String cmd;
		help();
		do
		{
			System.out.println("Inserisci comando");
			cmd = sc.nextLine().toLowerCase();//metto l'input in minuscolo

			switch (cmd)
			{
				case "printall" 		-> pbl.printAllProducts();
				case "printcat" 		-> pbl.printProductsByCategory();
				case "delete"			-> pbl.deleteProduct();
				case "create"			-> pbl.createProduct();
				case "update"			-> pbl.updateProduct();
				case "help"            	-> help();
				case "quit"            	-> System.out.println("BYE BYE");
				default                	-> System.out.println("Comando non valido");
			}

		}while (!cmd.equals("quit"));
	}

	private static void help()
	{
		System.out.println("Lista comandi disponibili:");
		System.out.println("  printall   -> Stampa tutti i prodotti");
		System.out.println("  printcat   -> Stampa i prodotti per categoria");
		System.out.println("  delete     -> Elimina un prodotto");
		System.out.println("  create     -> Crea un nuovo prodotto");
		System.out.println("  update     -> Aggiorna un prodotto");
		System.out.println("  help       -> Mostra questo elenco di comandi");
		System.out.println("  quit       -> Esci dal programma");
	}
}
