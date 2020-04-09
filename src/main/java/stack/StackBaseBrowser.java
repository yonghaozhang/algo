package stack;

/**
 * @author toby Zhang
 * @date 2020-01-15 15:56
 * @description
 */
public class StackBaseBrowser {

    private LinkedListBaseStack backStack;

    private LinkedListBaseStack forwardStack;

    /**
     * construct
     */
    public StackBaseBrowser() {
        this.backStack = new LinkedListBaseStack();
        this.forwardStack = new LinkedListBaseStack();
    }


    /**
     * 打开新网页
     * @param i
     */
    public void open(int i) {
        backStack.push(i);
        forwardStack.clear();
    }


    public boolean canGoBack() {
        return backStack.getCount() > 0;
    }


    public boolean canGoForward() {
        return forwardStack.getCount() > 0;

    }


    public int goBack() {
        if (canGoBack()) {
            int value = backStack.pop();
            forwardStack.push(value);
            return value;
        }
        return -1;

    }


    public int goForward() {
        if (canGoForward()) {
            int value = forwardStack.pop();
            backStack.push(value);
            return value;
        }
        return -1;
    }

    public LinkedListBaseStack getBackStack() {
        return backStack;
    }

    public LinkedListBaseStack getForwardStack() {
        return forwardStack;
    }
}
