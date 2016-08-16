class Client {
    private static void testOneTabbedFrame() {
        Frame main = new Frame();
        assert(main.getTabCount() == 0);
        Tab tab = new Tab();
        main.addTab(tab);
        assert(main.getTabCount() == 1);
        assert(main.getTab(0) == tab);
        main.reset();
        assert(main.removeTab(tab) == -1);
        assert(main.getTabCount() == 0);
    }
    
    private static void testTwoTabbedFrame() {
        Frame main = new Frame();
        assert(main.getTabCount() == 0);
        Tab tab = new Tab();
        main.addTab(tab);
        assert(main.getTabCount() == 1);
        assert(main.getTab(0) == tab);

        Tab tab2 = new Tab();
        main.addTab(tab2);
        assert(main.getTabCount() == 2);
        assert(main.getTab(1) == tab2);

        main.removeTab(tab);
        assert(main.getTabCount() == 1);
        
        main.removeTab(tab2);
        assert(main.getTabCount() == 0);
    }

    public static void main(String[] args) {
        testOneTabbedFrame();
        testTwoTabbedFrame();
    }
}