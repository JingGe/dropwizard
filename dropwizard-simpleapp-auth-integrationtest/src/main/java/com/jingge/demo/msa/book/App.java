package com.jingge.demo.msa.book;

import com.google.common.cache.CacheBuilderSpec;
import com.jingge.demo.msa.book.auth.DefaultAuthenticator;
import com.jingge.demo.msa.book.resources.BookResource;
import io.dropwizard.Application;
import io.dropwizard.auth.CachingAuthenticator;
import io.dropwizard.auth.basic.BasicAuthProvider;
import io.dropwizard.auth.basic.BasicCredentials;
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
        e.jersey().register(new BasicAuthProvider<Boolean>(new DefaultAuthenticator(), "Restfull API authentication"));
    }

    /**
     * example of registering cache authenticator
     *
     * @param e
     */
    private void registerCacheAuthenticator(Environment e) {
        CachingAuthenticator<BasicCredentials, Boolean> authenticator
                = new CachingAuthenticator<BasicCredentials, Boolean>(
                e.metrics(), new DefaultAuthenticator(), CacheBuilderSpec.parse("maximumSize=100, expireAfterAccess=30m")
        );
        e.jersey().register(new BasicAuthProvider<Boolean>(authenticator, "Cached restfull API authentication"));

    }
}