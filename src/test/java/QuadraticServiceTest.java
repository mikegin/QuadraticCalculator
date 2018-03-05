import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import quadraticFormula.Service.QuadraticService;
import org.junit.Assert;
import org.junit.Test;

public class QuadraticServiceTest {

    @Test
    public void testCalculatePositiveDeterminant() throws Exception {
        //Arrange
        int a = 5;
        int b = 6;
        int c = 1;
        QuadraticService quadraticService = new QuadraticService();
        String xIntercepts;
        String testAnswer = "{ \"x1\": -0.2,\"x2\": -1.0}";


        //Act
        xIntercepts = quadraticService.calculate(a, b, c);


        //Assert
        JSONAssert.assertEquals(xIntercepts, testAnswer, JSONCompareMode.LENIENT);
    }

    @Test
    public void testCalculateZeroDeterminant() throws Exception {
        //Arrange
        int a = 1;
        int b = -6;
        int c = 9;
        QuadraticService quadraticService = new QuadraticService();
        String xIntercepts;
        String testAnswer = "{ \"x1\": 3.0,\"x2\": \"\"}";


        //Act
        xIntercepts = quadraticService.calculate(a, b, c);


        //Assert
        JSONAssert.assertEquals(xIntercepts, testAnswer, JSONCompareMode.LENIENT);
    }

    @Test
    public void testCalculateNegativeDeterminant() throws Exception {
        //Arrange
        int a = 1;
        int b = 1;
        int c = 1;
        QuadraticService quadraticService = new QuadraticService();
        String xIntercepts;
        String testAnswer = "{ \"x1\": \"-0.5 + 0.8660254037844386i\",\"x2\": \"-0.5 - 0.8660254037844386i\"}";


        //Act
        xIntercepts = quadraticService.calculate(a, b, c);


        //Assert
        JSONAssert.assertEquals(xIntercepts, testAnswer, JSONCompareMode.LENIENT);
    }
}
