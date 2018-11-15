public class Klimatyzator implements Heater{
    private double temperature;

    Klimatyzator(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean heatUp(double kelvins) {
        if (kelvins < 0)
            return false;

        if (this.temperature + kelvins < 30) {
            this.temperature += kelvins;
            return true;
        }
        return false;
    }

    public boolean cool(double kelvins) {
        if (kelvins < 0)
            return false;
        if (this.temperature - kelvins > -20) {
            this.temperature -= kelvins;
        }
        return false;
    }
}
