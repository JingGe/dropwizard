package com.jingge.demo.msa.book.resources;

import com.codahale.metrics.annotation.Timed;
import com.jingge.demo.msa.book.representations.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: jing.ge
 * Date: 01.07.14
 * Time: 10:03
 * To change this template use File | Settings | File Templates.
 */
@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookResource.class);

    @GET
    @Path("/{id}")
    @Timed
    public Response getBook(@PathParam("id") int id) {
        LOGGER.info("ONLY for demo: let us slow down the method.");
        int count = (int) (Math.random()*1000);
        do {
            count++;
        } while (count > 0);


        return Response.ok(new Book(id,
                "testISDN",
                "dropwizard in action",
                "developing restful msa with dropwizard",
                1)).build();
    }

    @POST
    public Response createBook(Book book) {
        LOGGER.info("create new book: " + book.toString());
        return Response.created(UriBuilder.fromResource(BookResource.class).build(book.getId())).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") int id) {
        LOGGER.info("Delete book with id= " + id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") int id, Book book) {
        return Response.ok(new Book(id,
                book.getIsdn(),
                book.getName(),
                book.getDescription(),
                book.getEdition())).build();
    }
}
