package org.om.aec.concurrency.connectionpool;

/**
 * Hello world!
 *
 */
public class DBConnection 
{
	private int id;

	public DBConnection(int id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return "DBConnection [id=" + id + "]";
	}
}
