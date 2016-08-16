interface MessageReceiver {
    String getId();
    boolean receive(Message msg);
}