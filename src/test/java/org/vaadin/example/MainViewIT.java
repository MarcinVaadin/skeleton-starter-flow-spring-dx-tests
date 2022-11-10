package org.vaadin.example;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Assertions;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.html.testbench.ParagraphElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.testbench.BrowserTest;
import com.vaadin.testbench.browser.BrowserTestInfo;
import com.vaadin.testbench.parallel.BrowserUtil;

/**
 * Test step #2 - make nameEntered_greetingPresent test run using TestBench
 */
public class MainViewIT extends AbstractViewTest {

    private static final String THE_NAME = "Grzegorz";

    private static final String THE_LAST_NAME = "Brzęczyszczykiewicz";

    private static final String THE_AGE = "35";

    // Greeting base test
    @BrowserTest
    public void nameEntered_greetingPresent() {
        $(TextFieldElement.class).id("name").setValue(THE_NAME);
        $(ButtonElement.class).first().click();
        String value = $(ParagraphElement.class).first().getText();

        Assertions.assertEquals("Hello " + THE_NAME, value);
    }

    // Test step #3 - add additional test methods for running in parallel
    @BrowserTest
    public void nameSubmitted_nameIsOk() {
        $(TextFieldElement.class).id("name").setValue(THE_NAME);
        $(ButtonElement.class).first().click();
        String value = $(TextFieldElement.class).id("nameValue").getValue();

        Assertions.assertEquals(THE_NAME, value);

        // Test step #5 - rerunning flaky test
        // rerunFailingTestsCount = 3, so pass on 3
        Assertions.assertEquals(3, someRetryCounter.getAndIncrement());
    }
    private static final AtomicInteger someRetryCounter = new AtomicInteger(1);

    @BrowserTest
    public void lastnameSubmitted_lastnameIsOk(BrowserTestInfo browserTestInfo) {

        // Test step #6 - check browser that is used in test
        System.out.println(browserTestInfo.runLocallyBrowser());
        Assertions.assertTrue(BrowserUtil.isChrome(browserTestInfo.capabilities()));

        $(TextFieldElement.class).id("lastname").setValue(THE_LAST_NAME);
        $(ButtonElement.class).first().click();
        String value = $(TextFieldElement.class).id("lastnameValue").getValue();

        Assertions.assertEquals(THE_LAST_NAME, value);
    }

    @BrowserTest
    public void ageSubmitted_ageIsOk() {
        $(TextFieldElement.class).id("age").setValue(THE_AGE);
        $(ButtonElement.class).first().click();
        String value = $(TextFieldElement.class).id("ageValue").getValue();

        Assertions.assertEquals(THE_AGE, value);
    }

}
