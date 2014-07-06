package com.jingge.demo.msa.book;

import com.jingge.demo.msa.book.health.BookResourceHealthCheck;
import com.jingge.demo.msa.book.health.SimpleHealthCheck;
import com.jingge.demo.msa.book.resources.BookResource;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<BookConfiguration>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<BookConfiguration> b) {
    }

    @Override
    public void run(BookConfiguration c, Environment e)
            throws Exception {
        LOGGER.info("Restful book app running by "
                + c.getTeam()
                + " team with "
                + c.getTeamSize()
                + " members.");

        e.healthChecks().register("physicalMemorySize", new SimpleHealthCheck(c.getMinMemory()));
        e.healthChecks().register("BookResource", new BookResourceHealthCheck(new JerseyClientBuilder(e).build("REST Client")));
        // Add the resource to the environment
        e.jersey().register(new BookResource());
    }
}