interface MessageStore {
    boolean put(Message m);
    int     count();
    int     countUnread();
    boolean remove(String msgid);

}