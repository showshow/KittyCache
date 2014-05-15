package com.insightsource.pool;

/**
 * Represents the mechanism to create new objects to be used in an object pool.
 * 
 * @author Mac
 *
 * @param <T> the type of the object to create.
 */
public interface ObjectFactory<T>
{
	/**
	 * Returns a new instance of an object of type T.
	 * 
	 * @return T an new instance of the object of type T
	 */
	public T createNew();
}
