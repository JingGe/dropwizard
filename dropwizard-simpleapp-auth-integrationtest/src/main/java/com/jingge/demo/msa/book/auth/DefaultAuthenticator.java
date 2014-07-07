package com.jingge.demo.msa.book.auth;

import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class DefaultAuthenticator implements Authenticator<BasicCredentials, Boolean> {

    @Override
    public Optional<Boolean> authenticate(BasicCredentials credentials) throws AuthenticationException {
        return doAuthentication(credentials) ? Optional.of(true) : Optional.<Boolean>absent();
    }

    /**
     * Used ONLY for example. Never ever do it in production!
     *
     * @param credentials
     * @return
     */
    private boolean doAuthentication(BasicCredentials credentials) {
        return "jing".equals(credentials.getUsername())
                && "jing".equals(credentials.getPassword());
    }
}
