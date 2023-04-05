package com.palekov.bookshop;

import com.palekov.bookshop.config.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = {"spring.jpa.properties.hbm2ddl.auto=none"},
        classes = {SpringConfig.class})
@AutoConfigureWireMock(port=0)
public class AbstractApiTest extends AbstractTest {

    @Autowired
    protected MockMvc mockMvc;

    protected MediaType mediaTypeJson = new MediaType(MediaType.APPLICATION_JSON);
}
