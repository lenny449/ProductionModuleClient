package com.mattkawalec.connection;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.mattkawalec.domain.Document;
import com.mattkawalec.domain.Product;
import com.mattkawalec.domain.Recipe;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class ConnectionClient {
	Client client;

	public ConnectionClient() {
		client = Client.create();
	}

	// Function related with Product.class Objects

	public void addProduct(Product product) {
		WebResource resource = client.resource("http://localhost:8080/add_product");
		String response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.post(String.class, product);
	}

	public void deleteProduct(String id) {
		WebResource resource = client.resource("http://localhost:8080/delete_product/" + id);
		String response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.put(String.class);
	}

	public List<Product> getAllProducts() {
		WebResource resource = client.resource("http://localhost:8080/get_all_products");
		List<Product> response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Product>>() {
				});
		return response;
	}

	public Product getProduct(String id) {
		WebResource resource = client.resource("http://localhost:8080/products/"+id);
		Product response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.get(Product.class);
		return response;
	}
	
	public void updateProduct(Product product, String id){
		WebResource resource = client.resource("http://localhost:8080//update_product/"+id);
		String response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.put(String.class, product);
	}

	// Function related with Recipe.class Objects

	public void addRecipe(Recipe recipe) {
		WebResource resource = client.resource("http://localhost:8080/add_recipe");
		String response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.post(String.class, recipe);
	}

	public void deleteRecipe(String id) {
		WebResource resource = client.resource("http://localhost:8080/delete_recipe/" + id);
		String response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.put(String.class);
	}

	public List<Recipe> getAllRecipe() {
		WebResource resource = client.resource("http://localhost:8080/get_all_recipe");
		List<Recipe> response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Recipe>>() {
				});
		return response;
	}

	public Recipe getRecipe(String id) {
		WebResource resource = client.resource("http://localhost:8080/recipe/"+id);
		Recipe response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.get(Recipe.class);
		return response;
	}
	
	public void updateRecipe(Recipe recipe, String id){
		WebResource resource = client.resource("http://localhost:8080//update_recipe/"+id);
		String response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.put(String.class, recipe);
	}
	
	// Function related with Document.class Objects

		public void addDocument(Document document) {
			WebResource resource = client.resource("http://localhost:8080/add_document");
			String response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
					.post(String.class, document);
		}

		public void deleteDocument(String id) {
			WebResource resource = client.resource("http://localhost:8080/delete_document/" + id);
			String response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
					.put(String.class);
		}

		public List<Document> getAllDocuments() {
			WebResource resource = client.resource("http://localhost:8080/get_all_document");
			List<Document> response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<Document>>() {
					});
			return response;
		}

		public Document getDocument(String id) {
			WebResource resource = client.resource("http://localhost:8080/document/"+id);
			Document response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
					.get(Document.class);
			return response;
		}
		
		public void updateDocument(Document document, String id){
			WebResource resource = client.resource("http://localhost:8080/update_document/"+id);
			String response = resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
					.put(String.class, document);
		}

	

	// public static void main(String[] args) {
	// TODO Auto-generated method stub
	// Client client = Client.create();

	/*
	 * WebResource resource = client.resource("http://localhost:8080/beers");
	 * 
	 * List<Beer> response =
	 * resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
	 * .get(new GenericType<List<Beer>>(){});
	 * System.out.println(response.get(0).getColor());
	 */

	/*
	 * WebResource resource =
	 * client.resource("http://localhost:8080/beers/Lezajsk");
	 * 
	 * List<Beer> response =
	 * resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
	 * .get(new GenericType<List<Beer>>() {});
	 * System.out.println(response.get(0).getColor());
	 */

	/*
	 * WebResource resource =
	 * client.resource("http://localhost:8080/products/TAT2");
	 * 
	 * Product response =
	 * resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
	 * .get(Product.class); System.out.println(response.getFullName());
	 */

	/*
	 * WebResource resource = client.resource("http://localhost:8080/add_product");
	 * Product p1 = new Product("XXX", "bimber X", 44.0, 2.8); String response =
	 * resource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
	 * .post(String.class, p1); System.out.println(response);
	 */

}
