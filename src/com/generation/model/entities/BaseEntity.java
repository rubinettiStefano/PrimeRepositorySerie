package com.generation.model.entities;


//Incapsulamento
//Rendere OGGETTO responsabile del proprio STATO
//Forniamo lo stretto indispensabile all'esterno

//Ereditarietà
//Uso una altra classe come PUNTO DI PARTENZA
//Vado a specializzare un qualcosa di già esistente aggiungendo
//nuove proprietà e/o metodi
//inoltre fa da tipo formale in comune
//per diversi tipi concreti

//TIPO FORMALE -> TIPO DEL RIFERIMENTO ALL'OGGETTO
//riferimento può essere ->
//proprietà di un oggetto
//variabile
//parametro
//ritorno di un metodo
//singolo elemento di una collezione (posizione di una lista, di un array,ecc...)
//variabile di scorrimento di un ciclo


//Definire le nostre classi
public abstract class BaseEntity
{
	private Long id;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
}
