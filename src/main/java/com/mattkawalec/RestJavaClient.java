package com.mattkawalec;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.mattkawalec.domain.Product;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class RestJavaClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = Client.create();

		/*
		 * WebResource resource = client.resource("http://localhost:8080/beers");
		 * 
		 * List<Beer> response =
		 * resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
		 * .get(new GenericType<List<Beer>>(){});
		 * System.out.println(response.get(0).getColor());
		 */

/*		WebResource resource = client.resource("http://localhost:8080/beers/Lezajsk");

		List<Beer> response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Beer>>() {});
		System.out.println(response.get(0).getColor());
		*/
	
		
/*		WebResource resource = client.resource("http://localhost:8080/products/TAT2");

		Product response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.get(Product.class);
		System.out.println(response.getFullName());
		*/
		
		WebResource resource = client.resource("http://localhost:8080/add_product");
		Product p1 = new Product("XXX", "bimber X", 44.0, 2.8);
		String response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.post(String.class, p1);
		System.out.println(response);
	}

}
