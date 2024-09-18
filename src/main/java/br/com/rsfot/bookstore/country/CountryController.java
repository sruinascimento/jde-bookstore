package br.com.rsfot.bookstore.country;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PostMapping("/country")
    public ResponseEntity<NewCountryResponse> create(@Valid @RequestBody NewCountryRequest request) {
        Country country = request.toModel();
        countryRepository.save(country);
        return ResponseEntity.ok(new NewCountryResponse(country));
    }
}
