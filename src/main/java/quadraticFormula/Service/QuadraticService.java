package quadraticFormula.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

@Service
public class QuadraticService {

    public String calculate(int a, int b, int c) throws Exception {
        double determinant = Math.pow(b,2.0) - (4*a*c);

        ObjectMapper xIntercepts = new ObjectMapper();

        JsonNode intercepts = xIntercepts.createObjectNode();


        if(determinant == 0) {
            ((ObjectNode) intercepts).put("x1", (-1 * b + Math.sqrt(determinant))/(2*a));
            ((ObjectNode) intercepts).put("x2", "");
        }
        else if(determinant > 0) {
            ((ObjectNode) intercepts).put("x1", (-1 * b + Math.sqrt(determinant))/(2*a));
            ((ObjectNode) intercepts).put("x2", (-1 * b - Math.sqrt(determinant))/(2*a));
        }
        else {
            StringBuilder imaginary = new StringBuilder();
            StringBuilder imaginary2 = new StringBuilder();
            double nonImagPart = (-1*(double)b)/(2*(double)a);
            double imaginaryDeterminant = (Math.sqrt(Math.abs(determinant)))/(2*a);
            imaginary.append(nonImagPart).append(" + ").append(imaginaryDeterminant).append("i");
            imaginary2.append(nonImagPart).append(" - ").append(imaginaryDeterminant).append("i");
            ((ObjectNode) intercepts).put("x1", imaginary.toString());
            ((ObjectNode) intercepts).put("x2", imaginary2.toString());
        }

        String jsonString = xIntercepts.writerWithDefaultPrettyPrinter().writeValueAsString(intercepts);

        return jsonString;
    }


}
