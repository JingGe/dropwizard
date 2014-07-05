package com.jingge.demo.msa.book;

import com.jingge.demo.msa.book.representations.Book;
import com.jingge.demo.msa.book.resources.BookResource;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private Environment environment = mock(Environment.class);
    private final JerseyEnvironment jersey = mock(JerseyEnvironment.class);
    private final App application = new App();
    private final BookConfiguration config = new BookConfiguration();

    @Before
    public void setup() throws Exception {
        config.setTeamSize(10);
        when(environment.jersey()).thenReturn(jersey);
    }

    @Test
    public void checkcJersyRegister() throws Exception {
        application.run(config, environment);

        verify(jersey).register(isA(BookResource.class));

    }


}
