package br.com.rsfot.bookstore.state;

import br.com.rsfot.bookstore.country.Country;
import br.com.rsfot.bookstore.country.CountryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {
    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;

    public StateController(CountryRepository countryRepository, StateRepository stateRepository) {
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
    }

    @PostMapping("/state")
    @Transactional
    public ResponseEntity create(@Valid @RequestBody NewStateRequest newStateRequest) {
        Country country = countryRepository.findByName(newStateRequest.countryName())
                .orElseThrow(() -> new EntityNotFoundException("Country does not exists with name: " + newStateRequest.countryName()));

        State newState = newStateRequest.toModel(country);
        stateRepository.save(newState);
        return ResponseEntity.ok(new NewStateResponse(newState));
    }
}
