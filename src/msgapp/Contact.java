import java.util.ArrayList;

public class Contact implements MessageReceiver {
	private String id;
	private String name;
	private String textStatus;

    private MessageStore msgs;

    private Contact(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // MessageReceiver method
    @Override
    public String getId() {
        return this.id;
    }

    // MessageReceiver method
    @Override
	public boolean receive(Message msg) {
		msg.setDeliveryState(Message.DeliveryState.DELIVERED);

        return this.msgs.put(msg);
	}
    
	public static Contact create(String id, String name, MessageStore store) {
        Contact contact = new Contact(id, name);
        contact.msgs = store;

        return contact;
	}
}