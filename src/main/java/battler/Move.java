package battler;

/**
Noel Baca

contains fields like (name, type, power and accuracy)
constructor - validate inputs, throw illegalArgumentException
getters - no setters becuase moves arent assigning or changing 
*/

public class Move {

    private final String name;
    private final String type;
    private final int power;
    private final int accuracy;

    public Move(String name, String type, int power, int accuracy) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("move needs name");
        }
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("move needs type");
        }
        if (power < 0) {
            throw new IllegalArgumentException("move cannot have negative power");
        }
        if (accuracy < 0 || accuracy > 100) {
            throw new IllegalArgumentException("move cannot have negative accuracy or accuracy greater than 100");
        }

        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy; 
    }

    /**
     * Returns the name of the move
     */
    public String getName() {
        return name;
    }



    /**
     * Returns the type of the move
     */
    public String getType() {
        return type;
    }
    /**
     * Returns the power of the move
     */
    public int getPower() {
        return power;
    }

    /**
     * Returns the accuracy of the move
     */
    public int getAccuracy() {
        return accuracy;
    }

    @Override
    /**
     * will return the following format: battle.Move: [name], Type: [type], Power: [power], Accuracy: [accuracy]
     */
    public String toString() {
        return String.format("Move: %s, Type: %s, Power: %d, Accuracy: %d", name, type, power, accuracy);
    }
}