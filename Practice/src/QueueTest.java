package simpl;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private QueueADT q;

    @BeforeEach
    public void setup(){
        q = new SimpleBoundedArrayQueueCorrect(5);
    }

    @Test
    public void insertOneElement(){
        //AAA
        //Arrange

        //Act
        q.enqueue("A");
        //Assert
        assertTrue(q.contains("A"));
    }

    @Test
    public void insertFourElements(){

        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        assertTrue(q.contains("A"));
        assertTrue(q.contains("B"));
        assertTrue(q.contains("C"));
        assertTrue(q.contains("D"));
    }

    @Test
    public void insertNull(){
        assertThrows(IllegalArgumentException.class,  () -> q.enqueue(null));

    }

    @Test
    public void insertSixElements(){

        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        q.enqueue("E");
        assertEquals(5, q.size());
        assertThrows(IllegalStateException.class,  () -> q.enqueue("F"));


    }

    @Test
    public void emptyQ(){
        assertTrue(q.isEmpty());
        assertEquals(0, q.size());

    }

}