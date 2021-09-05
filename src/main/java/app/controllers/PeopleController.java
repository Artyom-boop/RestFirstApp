package app.controllers;

import app.dao.PersonDAO;
import app.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping("/people")
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());

        return "index";
    }

    @GetMapping("/people/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "show";
    }

    @GetMapping("/people/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "new";
    }

    @PostMapping("/people")
    public String create(@ModelAttribute("person")  @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";
        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/people/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "edit";
    }

    @PatchMapping("/people/{id}")
    public String update(@ModelAttribute("person")  @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "edit";
        personDAO.update(person, id);
        return "redirect:/people";
    }

    @DeleteMapping("/people/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
