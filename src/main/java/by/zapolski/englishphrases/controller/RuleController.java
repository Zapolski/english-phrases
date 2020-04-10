package by.zapolski.englishphrases.controller;

import by.zapolski.englishphrases.domain.Rule;
import by.zapolski.englishphrases.repository.RuleRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("rules")
public class RuleController {

    private final RuleRepo ruleRepo;

    @Autowired
    public RuleController(RuleRepo ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @GetMapping
    public List<Rule> list() {
        return ruleRepo.findAll();
    }

    @GetMapping("{id}")
    public Rule getById(@PathVariable("id") Rule rule) {
        return rule;
    }

    @PostMapping
    public Rule create(@RequestBody Rule rule) {
        rule.setCreationDate(LocalDateTime.now());
        return ruleRepo.save(rule);
    }

    @PutMapping("{id}")
    public Rule update(
            @PathVariable("id") Rule ruleFromDb,
            @RequestBody Rule rule) {
        BeanUtils.copyProperties(rule, ruleFromDb, "id");
        return ruleRepo.save(ruleFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Rule rule) {
        ruleRepo.delete(rule);
    }

    // GET all
    // fetch('rules/').then(response => response.json().then(console.log))
    // GET one
    // fetch('/rules/2').then(response => response.json().then(console.log))
    // POST add new one
    // fetch('/rules',{method: 'POST',headers: { 'Content-Type': 'application/json' },body: JSON.stringify({id:10,value:'Fourth message (4)'})}).then(result => result.json().then(console.log))
    // PUT save existing
    // fetch('/rules/4',{method: 'PUT',headers: { 'Content-Type': 'application/json' },body: JSON.stringify({id:10,value:'Fourth message'})}).then(result => result.json().then(console.log));
    // DELETE existing
    // fetch('/rules/4', { method: 'DELETE' }).then(result => console.log(result))
}
