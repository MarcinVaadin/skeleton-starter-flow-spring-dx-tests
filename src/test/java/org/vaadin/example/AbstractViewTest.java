package org.vaadin.example;

import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractViewTest {

    // update if required
    private static final String TEST_URL = "http://localhost:8080";

    // before each test it is required to open the test page using
    // webdriver injected by TestBench
    @BeforeEach
    public void beforeEach() {

    }

}
