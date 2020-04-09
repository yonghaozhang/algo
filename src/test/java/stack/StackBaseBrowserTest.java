package stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author toby Zhang
 * @date 2020-01-16 09:36
 * @description
 */
@Slf4j
public class StackBaseBrowserTest {

    @Test
    public void testOpen() throws Exception {
        StackBaseBrowser browser = new StackBaseBrowser();
        browser.open(1);
        log.info(browser.getBackStack().toString());
        log.info(browser.getForwardStack().toString());

        browser.open(2);
        log.info(browser.getBackStack().toString());
        log.info(browser.getForwardStack().toString());
    }

    @Test
    public void testGoBack() throws Exception {
        StackBaseBrowser browser = new StackBaseBrowser();
        browser.open(1);
        browser.open(2);
        Assert.assertEquals(2, browser.goBack());
        Assert.assertEquals(2, browser.getForwardStack().pop());
    }

    @Test
    public void testGoForwardHappyPath() throws Exception {
        StackBaseBrowser browser = new StackBaseBrowser();
        browser.open(1);
        browser.open(2);
        browser.goBack();
        Assert.assertEquals(2, browser.goForward());


    }

}