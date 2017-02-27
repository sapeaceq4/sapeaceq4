package springboot.org.om.product.services.dto;

import java.io.Serializable;

public final class Request<T> implements Serializable
{
	private static final long serialVersionUID = 1L;
	private T data;
	public Request()
	{
		
	}
	public Request(T data)
	{
		this.data = data;
	}

	public T getData() 
	{
		return data;
	}
}
