import java.util.ArrayList;

class Group {
    private String id;
    private String name;
    private Contact owner;
    private ArrayList<Contact> members;

    public Group(String id, String name, Contact owner) {
        assert(id != null && name != null && owner != null);
        this.id = id;
        this.name = name;
        this.owner = owner;

        members = new ArrayList<Contact>();
        this.members.add(owner);
    }

    public boolean addMember(Contact newmember) {
        for (Contact c: this.members) {
            if (c.getId() == newmember.getId()) return false;
        }

        this.members.add(newmember);
        return true;
    }

    // TODO : IMPLEMENT ME!!!
    public boolean removeMember(Contact member) {
        return false;
    }

    public void sendMessage(String senderId, String text) {
    	MessageService.send(senderId, text, this.members);
    }    
}