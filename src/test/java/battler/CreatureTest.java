package battler;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CreatureTest {

    private Creature makePup() {
        Move ember = new Move("Ember Bite", ElementType.FIRE, 40, 95);
        return new Creature("Emberpup", ElementType.FIRE, 50, 12, 10, 14, List.of(ember));
    }

    @Test
    void takeDamageReducesHp() {
        Creature pup = makePup();
        pup.takeDamage(20);
        assertEquals(30, pup.getCurrentHp());
    }

    @Test
    void hpNeverGoesBelowZero() {
        Creature pup = makePup();
        pup.takeDamage(999);
        assertEquals(0, pup.getCurrentHp());
        }

    @Test
    void healNeverExceedsMaxHp() {
        Creature pup = makePup();
        pup.takeDamage(20);
        pup.heal(50);
        assertEquals(50, pup.getCurrentHp());
    }

    @Test
    void negativeDamageThrows() {
        Creature pup = makePup();
        assertThrows(IllegalArgumentException.class, () -> pup.takeDamage(-10));
        
    }
}
