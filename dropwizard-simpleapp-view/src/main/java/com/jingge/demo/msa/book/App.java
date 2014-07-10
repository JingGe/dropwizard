package com.jingge.demo.msa.book;

import com.google.common.collect.ImmutableList;
import com.jingge.demo.msa.book.resources.BookResource;
import com.jingge.demo.msa.book.resources.BookViewResource;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.views.ViewBundle;
import io.dropwizard.views.ViewRenderer;
import io.dropwizard.views.freemarker.FreemarkerViewRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class App extends Application<BookConfiguration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<BookConfiguration> b) {
        b.addBundle(new ViewBundle(ImmutableList.<ViewRenderer>of(new FreemarkerViewRenderer())));
    }

    @Override
    public void run(BookConfiguration c, Environment e)
            throws Exception {
        LOGGER.info("Restful book app running by "
                + c.getTeam()
                + " team with "
                + c.getTeamSize()
                + " members.");

        // Add the resource to the environment
        e.jersey().register(new BookResource());
        e.jersey().register(new BookViewResource(new JerseyClientBuilder(e).build("Book Client")));
    }
}