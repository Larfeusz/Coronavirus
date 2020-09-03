package Coronavirus.Coronavirus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DecimalFormat;

@Controller
public class HomeController {

    @GetMapping
    public String getHomePage(ModelMap map){

        DecimalFormat df=new DecimalFormat("0.000000");
        Coronavirus coronavirus = new Coronavirus();
        map.put( "activeCases", coronavirus.getActiveCases() );
        map.put("probability", df.format(5*coronavirus.getActiveCases()/(38*1000*10)));

        return "corona";
    }
}
