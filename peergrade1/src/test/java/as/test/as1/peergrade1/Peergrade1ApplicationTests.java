package as.test.as1.peergrade1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import static org.junit.Assert.*;

@SpringBootTest
class Peergrade1ApplicationTests {

    @Test
    void testFahrenHeitToCelciusConverter_expectsCorrectconversionOfValue() {
        //Arrange
            int fahrenheitvalue = 100;
            int expectedCelciusValue = 37; //Correct value is 37,77 but we expect it to round down
            TemperatureConverter tc = new TemperatureConverter();
        //Act
            int resultValue = tc.convertFahrenheitToCelcius(fahrenheitvalue);

        //Assert
            assertEquals(expectedCelciusValue, resultValue);
    }

    @Test
    void testCelciusToFahrenheitConverter_expectsCorrectConversionOfValue(){
        //Arrange
        int celciusvalue = 100;
        int expectedFahrenheitValue = 212; //Correct value is 37,77 but we expect it to round down
        TemperatureConverter tc = new TemperatureConverter();
        //Act
        int resultValue = tc.convertCelciusToFahrenheit(celciusvalue);

        //Assert
        assertEquals(expectedFahrenheitValue, resultValue);
    }

    @Test
    void testCelciusToFahrenheitConverter_expectsExceptionThrown(){
        //Arrange
        int celciusvalue = -300;
        Exception caughtException = new Exception();
        TemperatureConverter tc = new TemperatureConverter();

        //Act
        try{
            tc.convertCelciusToFahrenheit(celciusvalue);
            Assert.isTrue(false, "false");
        } catch (Exception e) {
            caughtException = e;
        }

        //Assert
        assertEquals("Cannot be less than 273", caughtException.getMessage());

    }

    @Test
    void testconvertIntToRomanNumeralString_expectsCorrectStringConversion(){
        //Arrange
        int[] intValue = {12, 43, 76, 99, 100, 101, 123,149, 150, 151, 175, 199, 200, 499, 500, 501, 750, 950, 999, 1000, 1230, 2345, 2499, 2501, 4531, 4999};
        String[] expectedNumeralValue = {"XII", "XLIII", "LXXVI", "XCIX", "C", "CI", "CXXIII", "CXLIX", "CL", "CLI", "CLXXV", "CXCIX", "CC", "CDXCIX", "D", "DI",
                "DCCL", "CML", "CMXCIX", "M", "MCCXXX", "MMCCCXLV", "MMCDXCIX", "MMDI", "MMMMDXXXI", "MMMMCMXCIX" };
        String[] resultValue = new String[intValue.length];
        RomanNumeralsConverter rc = new RomanNumeralsConverter();

        //Act
        for(int i = 0; i < intValue.length; i++){
            resultValue[i] = rc.convertIntToRomanNumeralString(intValue[i]);
        }

        //Assert
        assertEquals(expectedNumeralValue, resultValue);
    }


    @Test
    void testconvertIntToRomanNumeralString_expectsExceptionThrown(){
        //Arrange
        int intValue = -1;
        RomanNumeralsConverter rc = new RomanNumeralsConverter();
        Exception caughtException = new Exception();

        //Act
        try{
            rc.convertIntToRomanNumeralString(intValue);
            Assert.isTrue(false, "false");
        } catch (Exception e) {
            caughtException = e;
        }

        //Assert
        assertEquals("Value needs to be between 0 and 5000", caughtException.getMessage());

    }



}
