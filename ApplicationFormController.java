package Controller;
import model.ApplicationForm;
import Service.ApplicationFormService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

        import jakarta.validation.Valid;

@Controller
@RequestMapping("/forms")
public class ApplicationFormController {

    private final ApplicationFormService service;

    public ApplicationFormController(ApplicationFormService service) {
        this.service = service;
    }

    @GetMapping
    public String listForms(Model model) {
        model.addAttribute("forms", service.getAllForms());
        return "forms/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("form", new ApplicationForm());
        return "forms/new";
    }

    @PostMapping
    public String saveForm(@Valid @ModelAttribute("form") ApplicationForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "forms/new";
        }
        service.saveForm(form);
        return "redirect:/forms";
    }
}
