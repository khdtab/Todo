package se.lexicon.data;

public class PersonSequencer {
    private static int personId;


    public PersonSequencer() {
        personId = 0;
    }

    public int nextPersonId() {
        personId++;
        return personId;
    }

    public void reset() {
        personId = 0;
    }


}
