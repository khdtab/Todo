package se.lexicon;

import org.testng.annotations.Test;
import se.lexicon.data.PersonSequencer;
import se.lexicon.data.TodoSequencer;

import static org.junit.Assert.assertEquals;


public class TodoSequencerTest
{
    @Test
    public void testNextTodoId() throws Exception {
        TodoSequencer sequencer =new TodoSequencer();
        assertEquals(sequencer.nextTodoId(),1);
        assertEquals(sequencer.nextTodoId(),2);
    }


    @Test
    public void testReset() throws Exception {
        TodoSequencer sequencer =new TodoSequencer();
        assertEquals(sequencer.nextTodoId(),1);
        assertEquals(sequencer.nextTodoId(),2);

        sequencer.reset();
        assertEquals(sequencer.nextTodoId(),1);


    }
}
