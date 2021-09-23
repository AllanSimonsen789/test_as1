package as.test.as1.peergrade1;

public class TemperatureConverter {

    public int convertFahrenheitToCelcius(int fahrenheitValue){
        return (int) ((fahrenheitValue - 32) / 1.8);
    }

    public int convertCelciusToFahrenheit(int celciusValue){
        if(celciusValue < -273){
            throw new IllegalArgumentException("Cannot be less than 273");
        }
        return (((int) (celciusValue * 1.8)) + 32);
    }
}


