package se.lexicon;

import org.testng.annotations.Test;
import se.lexicon.data.PersonSequencer;
import se.lexicon.model.Person;
import se.lexicon.model.Todo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PersonSequencerTest
{
    @Test
    public void testNextPersonId() throws Exception {
        PersonSequencer sequencer =new PersonSequencer();
        assertEquals(sequencer.nextPersonId(),1);
        assertEquals(sequencer.nextPersonId(),2);
    }


    @Test
    public void testReset() throws Exception {
        PersonSequencer sequencer =new PersonSequencer();
        assertEquals(sequencer.nextPersonId(),1);
        assertEquals(sequencer.nextPersonId(),2);

        sequencer.reset();
        assertEquals(sequencer.nextPersonId(),1);


    }
}
