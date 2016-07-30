import java.util.ArrayList;

class Frame extends Component {
    private ArrayList<Tab> tabs;

    public Frame() {
        this.tabs = new ArrayList<Tab>(8);
    }

    public int addTab(Window w) {
        if (w instanceof Tab && !tabs.contains(w)) {
	        this.tabs.add((Tab)w);
        }

        return tabs.indexOf(w);
    }

    public int removeTab(Window w) {
        if (w instanceof Tab && tabs.contains(w)) {
            tabs.remove(w);
            return 0;
        }

        return -1;
    }

    // Note: the return type Tab is covariant with Window/Component.
    public Tab getTab(int index) {
        if (index >= 0 && index < tabs.size()) return tabs.get(index);
        //TODO - return a NullTab singleton instance
        return null;
    }

    public String getTabUrl(int index) {
        Tab tab = this.getTab(index);
        return (tab != null) ? tab.getUrl() : null;
    }

    // Note: Java 8 wonder, lambda expression is used here.
    public void reset() {
    	this.tabs.forEach(tab -> { tab.reset(); });
        this.tabs.clear();
    }
    
    public Frame frameFromTab(int index) {
    	//TODO - on failure, return a NullFrame singleton instance
    	Tab tab = this.getTab(index);
        if (tab != null) {
            Frame newFrame = new Frame();
            this.removeTab(tab);
            newFrame.addTab(tab);
            return newFrame;
        }

        return null;
    }

    public int getTabCount() {
        return this.tabs.size();
    }
}
