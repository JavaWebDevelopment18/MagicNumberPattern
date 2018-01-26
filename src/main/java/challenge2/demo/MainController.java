package challenge2.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/*
* Magic Number Challenge
* Author: Saniya Godil
* Date: January 26, 2018
*
* Program takes in a positive integer x through the browser
* @ localhost:8080/?number=x
* It loops, modifying x and stops once x = 1
* Program prints every value of x that it loops through
* Even numbers are divided by 2 and Odd numbers are multiplied by three and increased by one
 */

@RestController
public class MainController {

    @RequestMapping("/")
    public String makeMagic(HttpServletRequest param) {
        String output = "Magic Number Challenge" + "<br>" + "Starting number: "; //Static starting message
        String startNum = param.getParameter("number");
        output += startNum + "<br>" + startNum + "     ";
        int x = Integer.parseInt(startNum);  //Converts the input into an int
        if (startNum == null){ //Checking that x is properly inputted into the url
            return "Error";
        } else do {
            if (x < 0) {
                return "Error, number is not positive"; //Returns error if x is negative
            } else if (x % 2 == 0) {
                x = x/2;
                output += + x + "     ";
            } else {
                x = 3 * x + 1;
                output += + x + "     ";
            }
        }while (x != 1); //Stops the loop once x = 1 and 1 is added to the output
        return output;
    }


}
