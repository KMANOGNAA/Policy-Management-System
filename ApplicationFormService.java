package Service;
import model.ApplicationForm;
import Repository.ApplicationFormRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationFormService {

    private final ApplicationFormRepository repository;

    public ApplicationFormService(ApplicationFormRepository Repository) {
        this.repository = Repository;
    }

    public List<ApplicationForm> getAllForms() {
        return repository.findAll();
    }

    public ApplicationForm saveForm(ApplicationForm form) {
        return repository.save(form);
    }
}
