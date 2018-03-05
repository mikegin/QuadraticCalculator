package quadraticFormula.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestParam;
import quadraticFormula.Service.QuadraticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuadraticController {

    @Autowired
    QuadraticService quadraticService;


    @GetMapping("quadratic_equation")
    public String solveEquation(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) throws Exception {
        return quadraticService.calculate(a,b,c);
    }
}
