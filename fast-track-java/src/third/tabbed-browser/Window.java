interface Window {
    int     addTab(Window w);
    int     removeTab(Window w);
    Window  getTab(int index);
    Window  frameFromTab(int index);
    String  getTabUrl(int index);
    void    reset();
}
