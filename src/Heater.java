/**
 * Interfejs deklaruje metodę do podniesienia temperatury
 */
@FunctionalInterface
public interface Heater {
    /**
     * podnosi temperaturę
     * @return wartość boolean w zależności od pomyślności podniesienia temperatury
     */
    boolean heatUp(double kelvins);
}
