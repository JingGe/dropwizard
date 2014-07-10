package com.jingge.demo.msa.book.resources;

import com.jingge.demo.msa.book.representations.Book;
import com.jingge.demo.msa.book.views.BookView;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/views/book/")
@Produces(MediaType.TEXT_HTML)
public class BookViewResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookViewResource.class);
    private Client client;

    public BookViewResource(Client client) {
        this.client = client;
    }

    @GET
    @Path("{id}")
    public BookView getBook(@Context HttpServletRequest request, @PathParam("id") int id) {
        StringBuffer buffer = new StringBuffer("http://")
                .append(request.getServerName())
                .append(":")
                .append(request.getServerPort())
                .append("/book/")
                .append(id);
        LOGGER.info(buffer.toString());
        return new BookView(client.resource(buffer.toString()).get(Book.class));
    }

}
