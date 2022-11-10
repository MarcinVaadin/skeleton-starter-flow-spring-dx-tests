package org.vaadin.example;

import org.junit.jupiter.api.BeforeEach;

import com.vaadin.testbench.BrowserTestBase;
import com.vaadin.testbench.annotations.RunLocally;
import com.vaadin.testbench.browser.BrowserTestInfo;
import com.vaadin.testbench.parallel.Browser;

/**
 * Test step #2 - extend TestBench JUnit 5 parent utility class and remember to
 * open test page before running test
 */
@RunLocally(Browser.CHROME) // Test step #6 - define specific browser
public abstract class AbstractViewTest extends BrowserTestBase {

    // update if required
    private static final String TEST_URL = "http://localhost:8080";

    // before each test it is required to open the test page using
    // webdriver injected by TestBench
    @BeforeEach
    public void beforeEach(BrowserTestInfo browserTestInfo) {
        browserTestInfo.driver().get(TEST_URL);
    }

}
