package com.insightsource.pool.jdbc;

import java.sql.Connection;

import com.insightsource.pool.BoundedBlockingPool;
import com.insightsource.pool.Pool;
import com.insightsource.pool.PoolFactory;

public class JDBCPoolTest
{
	
	public static void main(String[] args)
	{
		Pool<Connection> pool = new BoundedBlockingPool<Connection>(10, 
				new JDBCConnectionValidator(), 
				new JDBCConnectionFactory("", "", "", ""));
		
		//factory method.
		Pool<Connection> pool2 = PoolFactory.newBoundedNonBlockingPool(10, 
				new JDBCConnectionFactory("", "", "", ""), 
				new JDBCConnectionValidator());
	}
	
}
