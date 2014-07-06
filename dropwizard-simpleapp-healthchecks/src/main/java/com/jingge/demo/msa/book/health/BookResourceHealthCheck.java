package com.jingge.demo.msa.book.health;

import com.codahale.metrics.health.HealthCheck;
import com.jingge.demo.msa.book.representations.Book;
import com.jingge.demo.msa.book.resources.BookResource;
import com.sun.jersey.api.client.*;
import javax.ws.rs.core.MediaType;

/**
 * Keep refreshing http://localhost:8081/healthcheck you will see different result.
 * User: Jing
 * Date: 06.07.14
 * Time: 1:08
 * To change this template use File | Settings | File Templates.
 */
public class BookResourceHealthCheck extends HealthCheck {
    private final Client client;

    public BookResourceHealthCheck(Client client) {
        this.client = client;
    }

    @Override
    protected Result check() throws Exception {
        // Just simulate that the book resource will be available or unavailable.
        int count = (int) (Math.random()*10);
        return count % 2 == 0 ? checkBookResource() : Result.unhealthy("FATAL: Book Resource is not available!");
    }

    private Result checkBookResource() {
        WebResource contactResource = client
                .resource("http://localhost:8080/book/available");
        ClientResponse response = contactResource.get(ClientResponse.class);
        if (response.getStatus() == 200) {
            return Result.healthy();
        }
        else {
            return Result.unhealthy("Book Resource is not available!");
        }
    }

}
