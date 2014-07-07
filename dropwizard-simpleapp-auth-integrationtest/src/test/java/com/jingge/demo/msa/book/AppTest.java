package com.jingge.demo.msa.book;

import com.jingge.demo.msa.book.representations.Book;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Integration Test
 */
public class AppTest {
    @ClassRule
    public static final DropwizardAppRule<BookConfiguration> RULE =
            new DropwizardAppRule<BookConfiguration>(App.class, "config-test.yml");

    @Test
    public void unauthenticatedGetBook() {
        assertBook(new Client(), new Book("testISDN",
                "dropwizard in action"
        ));
    }

    @Test
    public void authenticatedGetBook() {
        Client client = new Client();
        client.addFilter(new HTTPBasicAuthFilter("jing", "jing"));
        assertBook(client, new Book(1,
                "testISDN",
                "dropwizard in action",
                "developing restful msa with dropwizard",
                1));
    }

    @Test
    public void unauthenticatedDelete() {
        WebResource resource = new Client().resource("http://localhost:8080/book/1");
        try {
            resource.delete();
        } catch (UniformInterfaceException e) {
            assertThat(e.getResponse().getStatus()).isEqualTo(ClientResponse.Status.UNAUTHORIZED.getStatusCode());
            return;
        }
        assertThat(false);
    }

    private void assertBook(Client client, Book bookTest) {
        WebResource resource = client.resource("http://localhost:8080/book/1");
        ClientResponse response = resource
                .get(ClientResponse.class);
        assertThat(response.getStatus()).isEqualTo(ClientResponse.Status.OK.getStatusCode());

        Book book = resource.get(Book.class);
        assertThat(book.getId()).isEqualTo(bookTest.getId());
        assertThat(book.getIsdn()).isEqualTo(bookTest.getIsdn());
        assertThat(book.getName()).isEqualTo(bookTest.getName());
        assertThat(book.getDescription()).isEqualTo(bookTest.getDescription());
    }

}
