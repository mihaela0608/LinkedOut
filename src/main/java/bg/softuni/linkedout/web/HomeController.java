package bg.softuni.linkedout.web;

import bg.softuni.linkedout.util.LastUpdated;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final LastUpdated lastUpdated;

    public HomeController(LastUpdated lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @GetMapping
    public String home(Model model){
        model.addAttribute("lastUpdate", lastUpdated.getLastUpdate());
        return "index";
    }
}
