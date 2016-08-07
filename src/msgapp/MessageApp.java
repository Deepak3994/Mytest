import java.util.ArrayList;

class MessageApp {
    private ArrayList<Contact> contacts;
    private ArrayList<Group> groups;

    public MessageApp() {
        this.contacts = new ArrayList<Contact>();
        this.groups = new ArrayList<Group>();
    }

    // FIX ME: DUPLICATES ARE NOT ALLOWED!!!
    public boolean addNewContact(String id, String name) {
    	MessageStore store = new SimpleMessageStore();
    	Contact c = Contact.create(id, name, store);
    	return this.contacts.add(c);
    }

    // FIX ME: COMPLETE THE IMPLEMENTATION!!!
    public boolean addGroup(Contact owner) {
        return false;
    }

    // FIX ME: COMPLETE THE IMPLEMENTATION!!!
    public boolean removeGroup(Contact owner, String gid) {
        return false;
    }

	private static class SimpleMessageStore implements MessageStore {
		private ArrayList<Message> store;

		public SimpleMessageStore() {
		    store = new ArrayList<Message>();
		}

		@Override
	    public boolean put(Message m) {
	        assert(m != null);
	        if (m == null) return false;
	        this.store.add(m);
	        return true;
	    }

	    @Override
	    public int count() {
	    	return this.store.size();
	    }

        // TODO: FIX ME!!!!
        @Override
	    public int countUnread() {
	    	return 0;
	    }

        // TODO: FIX ME!!!!
        @Override
	    public boolean remove(String msgid) {
	        return false;	
	    }
	}
}