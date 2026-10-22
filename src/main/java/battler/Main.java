package battler;

import java.util.List;

public class Main {
    public static void main(String[] args) {
    Move ember = new Move("Ember Bite", ElementType.FIRE, 40, 95);
Creature pup = new Creature("Emberpup", ElementType.FIRE, 50, 12, 10, 14, List.of(ember));

System.out.println(pup);
pup.takeDamage(20);
System.out.println(pup);
    }

}