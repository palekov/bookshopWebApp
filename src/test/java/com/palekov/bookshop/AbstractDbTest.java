package com.palekov.bookshop;

import jakarta.transaction.Transactional;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
        properties = {"spring.jpa.properties.hibernate.hbm2ddl.auto=create-drop"})
public class AbstractDbTest extends AbstractTest {
}
