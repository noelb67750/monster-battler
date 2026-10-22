package battler;

public class TypeChart {
    private static final double[][] effectivenessChart = buildEffectivenessChart();

    /**
     * Builds the effectiveness chart for all combinations of attack and defense types.
     *
     * @return a 2D array representing the effectiveness multipliers
     */
    private static double[][] buildEffectivenessChart() {

        //gives the number of types in the ElementType enum
        int typeCount = ElementType.values().length;

        //rows are attack types, columns are defense types
        double[][] chart = new double[typeCount][typeCount];

        // Initialize all values to 1.0 (normal effectiveness)
        for (int attack = 0; attack < typeCount; attack++) {
            for (int defense = 0; defense < typeCount; defense++) {
        
                chart[attack][defense] = 1.0;
            }
        }
        set(chart, ElementType.FIRE, ElementType.GRASS, 2.0);
        set(chart, ElementType.FIRE, ElementType.WATER, 0.5);
        set(chart, ElementType.WATER, ElementType.FIRE, 2.0);
        set(chart, ElementType.WATER, ElementType.GRASS, 0.5);
        set(chart, ElementType.GRASS, ElementType.WATER, 2.0);
        set(chart, ElementType.GRASS, ElementType.FIRE, 0.5);

        return chart;
    }

    private TypeChart() {
        // Private constructor to prevent instantiation
    }

    /**
     * Returns the effectiveness multiplier for the given attack and defense types.
     *
     * @param attackType the type of the attacking move
     * @param defenseType the type of the defending creature
     * @return the effectiveness multiplier
     */
    public static double getMultiplier(ElementType attackType, ElementType defenseType) {
        return effectivenessChart[attackType.ordinal()][defenseType.ordinal()];
    }
    /**
     * Sets the effectiveness multiplier for a specific combination of attack and defense types in the chart.
     *
     * @param chart the effectiveness chart
     * @param attack the attack type
     * @param defend the defense type
     * @param mult the effectiveness multiplier
     */
    private static void set(double[][] chart, ElementType attack, ElementType defend, double mult) {
        chart[attack.ordinal()][defend.ordinal()] = mult;
    }
}
