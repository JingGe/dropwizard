package com.jingge.demo.msa.book.resources;

import com.jingge.demo.msa.book.representations.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;


@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookResource.class);

    @GET
    @Path("/{id}")
    public Response getBook(@PathParam("id") int id) {
        return Response.ok(new Book(id,
                "testISDN",
                "dropwizard in action",
                "developing restful msa with dropwizard",
                1)).build();
    }

    @POST
    public Response createBook(@Valid Book book) {
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
