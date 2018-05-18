package com.cz.Package;
/**
 * An interface that describes the operation
 *  of a bag of onjects
 * @author ChenZhao
 *
 * @param <T>
 */
public interface BagInterface<T> {
	/**
	 * get the current size of the aray
	 * @return the number of objects in the bag
	 */
	int getCurrentSize();
	//weather the bag is empty
	boolean isEmpty();
	//add a object into the bag
	boolean add(T newEntry);
	//remove a object from the bag
	T remove();
	//Remove
	boolean remove(T anEntry);
	//empty the bag
	void clear();
	//get the frequency of an object
	int getFrequenceOf(T anEntry);
	//whether contains an object
	boolean contains(T anEntry);
	// Retrieve all the entry in the bag
	T[] toArray();
}
