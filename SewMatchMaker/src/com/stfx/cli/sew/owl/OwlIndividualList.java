package com.stfx.cli.sew.owl;

import java.net.URI;
import java.util.List;

public interface OwlIndividualList extends List{
	
	/**
	 * Return the OWLIndividual at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 */
	public OwlIndividual individualAt(int index);
	
	/**
	 * Return the individual from the list that has the given URI
	 * 
	 * @param resourceURI
	 * @return
	 */
	public OwlIndividual getIndividual(URI resourceURI);
	
	/**
	 * Return the individual from the list that has the given local name. If there is 
	 * more than one individual with the same local name than any one of them is returned 
	 * 
	 * @param localName
	 * @return
	 */
	public OwlIndividual getIndividual(String localName);

}
