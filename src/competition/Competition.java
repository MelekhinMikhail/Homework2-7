package competition;

import transport.Transport;

import java.util.LinkedList;

public class Competition {
    private String name;
    private LinkedList<Transport> participants;

    public Competition(String name) {
        this.name = (name.isEmpty() || name.isBlank()) ? "default" : name;
        this.participants = new LinkedList<>();
    }

    public void addParticipant(Transport transport) {
        if (transport != null) participants.add(transport);
    }

    public void deleteParticipant(Transport transport) {
        if (transport != null) participants.remove(transport);
    }

    public String getName() {
        return name;
    }

    public LinkedList<Transport> getParticipants() {
        return participants;
    }
}
