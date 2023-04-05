package com.palekov.bookshop;

import com.palekov.bookshop.config.SpringConfig;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
    properties = {"spring.jpa.properties.hbm2ddl.auto=none", "spring.jpa.properties.hibernate.hbm2ddl.import_files="},
    classes = {SpringConfig.class})
public abstract class AbstractUnitTest extends AbstractTest {

}
