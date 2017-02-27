package springboot.org.om.product.services.dto;


public class Response<V>
{
	private V response;
	
	public Response()
	{
	}
	public Response(V value)
	{
		this.response = value;
	}

	public V getResponse() 
	{
		return response;
	}
}
