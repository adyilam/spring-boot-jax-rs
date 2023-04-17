package com.javafeatures;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "products")
@Path("/products")
public class ProductResource {
    private static Map<Integer, Product> productDB = new HashMap<>();

    @GET
    @Produces("application/json")
    public Products getAllProducts() {
        Products products = new Products();
        products.setProducts(new ArrayList<>(productDB.values()));
        return products;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createUser(Product product) {
        if (product.getName() != null || product.getProductId() != 0) {

            product.setProductId(productDB.values().size() + 1);
            productDB.put(product.getProductId(), product);
            return Response.status(201).build();
        }
        return Response.status(400).entity(new ProductErrorHandler("Provide all the mandatory inputs", 400, "Please provide all mandatory inputs")).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getUserById(@PathParam("id") int id) {
        Product product = productDB.get(id);
        if (null != product) {
            return Response
                    .status(200)
                    .entity(product).build();
        }
        return Response.status(404).entity(new ProductErrorHandler("Record not found with the given Id: " + id, 404, "The requested URL was not found.")).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateUser(@PathParam("id") int id, Product product) {
        Product prod = productDB.get(id);
        if (null != prod) {
            prod.setProductId(product.getProductId());
            prod.setName(product.getName());
            productDB.put(prod.getProductId(), prod);
            return Response.status(200).entity(prod).build();
        }
        return Response.status(404).entity(new ProductErrorHandler("Record not found with the given Id: " + id, 404, "The requested URL was not found.")).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteUser(@PathParam("id") int id) {
        Product product = productDB.get(id);
        if (null != product) {
            productDB.remove(product.getProductId());
            return Response.status(200).build();
        }
        return Response.status(404).entity(new ProductErrorHandler("Record not found with the given Id: " + id, 404, "The requested URL was not found.")).build();
    }

    static {
        Product product1 = new Product();
        product1.setProductId(1);
        product1.setName("Computer");

        Product product2 = new Product();
        product2.setProductId(2);
        product2.setName("TV");

        productDB.put(product1.getProductId(), product1);
        productDB.put(product2.getProductId(), product2);
    }
}
