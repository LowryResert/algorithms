package stack;

/**
 * 使用前后栈实现浏览器的前进和后退
 *
 * @author Lowry
 */
public class SampleBrowser {
    public static void main(String[] args) {
        SampleBrowser browser = new SampleBrowser();
        browser.open("http://www.baidu.com");
        browser.open("http://www.baidu.com/");
        browser.open("http://www.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentPage();
    }

    private String currentPage;

    private void checkCurrentPage() {

    }

    private void goForward() {

    }

    private void goBack() {

    }

    private void open(String url) {

    }
}
