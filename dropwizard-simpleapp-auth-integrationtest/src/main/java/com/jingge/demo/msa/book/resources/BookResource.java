package com.jingge.demo.msa.book.resources;

import com.jingge.demo.msa.book.representations.Book;
import io.dropwizard.auth.Auth;
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
    public Response getBook(@PathParam("id") int id, @Auth(required = false) Boolean isAuthenticated) {
        isAuthenticated = isAuthenticated != null;
        Book book = isAuthenticated ? new Book(id,
                "testISDN",
                "dropwizard in action",
                "developing restful msa with dropwizard",
                1): new Book("testISDN",
                "dropwizard in action"
                );
        return Response.ok(book).build();
    }

    @POST
    public Response createBook(@Valid Book book, @Auth Boolean isAuthenticated) {
        LOGGER.info("create new book: " + book.toString());
        return Response.created(UriBuilder.fromResource(BookResource.class).build(book.getId())).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") int id, @Auth Boolean isAuthenticated) {
        LOGGER.info("Delete book with id= " + id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") int id, Book book, @Auth Boolean isAuthenticated) {
        return Response.ok(new Book(id,
                book.getIsdn(),
                book.getName(),
                book.getDescription(),
                book.getEdition())).build();
    }
}
