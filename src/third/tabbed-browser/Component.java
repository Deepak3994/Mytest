import java.util.ArrayList;

class Component implements Window {
    public int addTab(Window w) {
        return -1;
    }

    public int removeTab(Window w) {
        return -1;
    }
    
    public Window getTab(int index) {
    	//TODO - return a NullTab singleton instance
        return null;
    }
    
    public Window frameFromTab(int index) {
    	//TODO - return a NullFrame singleton instance
        return null;
    }
    
    public String getTabUrl(int index) {
        return null;
    }

    public void reset() {
    }
}