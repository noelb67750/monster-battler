package battler;

import java.util.List;

/**
 * 
 * Creature class represents a creature in the game with various attributes such
 * as
 * name, type, max HP, attack, defense, speed, and a list of moves.
 * It also keeps track of the current HP of the creature.
 */
public class Creature {
    private final String name;
    private final ElementType type;
    private final int maxHp;
    private final int attack;
    private final int defense;
    private final int speed;
    private final List<Move> moves;
    private int currentHp;

    /**
     * Constructs a new Creature with the specified attributes.
     * 
     * @param name    the name of the creature
     * @param type    the type of the creature
     * @param maxHp   the maximum HP of the creature
     * @param attack  the attack stat of the creature
     * @param defense the defense stat of the creature
     * @param speed   the speed stat of the creature
     * @param moves   the list of moves the creature can use
     */
    public Creature(String name, ElementType type, int maxHp, int attack, int defense, int speed, List<Move> moves) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Creature needs a name");
        }
        if (type == null) {
            throw new IllegalArgumentException("Creature needs a type");
        }
        if (maxHp <= 0) {
            throw new IllegalArgumentException("Creature's max HP must be greater than 0");
        }
        if (attack <= 0) {
            throw new IllegalArgumentException("Creature's attack cannot be zero or negative");
        }
        if (defense <= 0) {
            throw new IllegalArgumentException("Creature's defense cannot be negative");
        }
        if (speed < 0) {
            throw new IllegalArgumentException("Creature's speed cannot be negative");
        }
        if (moves == null || moves.isEmpty()) {
            throw new IllegalArgumentException("Creature must have at least one move");
        }
        if (moves.size() > 4) {
            throw new IllegalArgumentException("Creature cannot have more than 4 moves");
        }

        this.name = name.trim();
        this.type = type;
        this.maxHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        // defensive copy so the list of moves cannot be modified from outside the class
        this.moves = List.copyOf(moves);
        this.currentHp = maxHp;
    }

    public String getName() {
        return name;
    }

    public ElementType getType() {
        return type;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    /**
     * Sets the current HP of the creature.
     * 
     * @param currentHp
     */
    private void setCurrentHp(int currentHp) {
        if (currentHp < 0) {
            this.currentHp = 0;
        } else if (currentHp > maxHp) {
            this.currentHp = maxHp;
        } else {
            this.currentHp = currentHp;
        }
    }

    /**
     * Reduces the current HP of the creature by the specified damage amount.
     * 
     * @param damage
     */
    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        setCurrentHp(currentHp - damage);
    }

    /**
     * Increases the current HP of the creature by the specified amount, without
     * exceeding max HP.
     * 
     * @param amount
     */
    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Heal amount cannot be negative");
        } 
        setCurrentHp(currentHp + amount);
    }

    /**
     * Checks if the creature has fainted (current HP is 0).
     * 
     * @return true if the creature has fainted, false otherwise
     */
    public boolean isFainted() {
        return currentHp == 0;
    }

    /**
     * Returns a string representation of the creature.
     * 
     * @return a string with info of the creature
     */
    @Override
public String toString() {
    return String.format("%s (%s)  HP %d/%d", name, type, currentHp, maxHp);
}
}
