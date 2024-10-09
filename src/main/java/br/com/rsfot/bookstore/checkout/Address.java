package br.com.rsfot.bookstore.checkout;

import br.com.rsfot.bookstore.country.Country;
import br.com.rsfot.bookstore.state.State;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class Address {
    private String address;

    private String complement;

    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Deprecated
    public Address() {
    }


    public Address(String address,
                   String complement,
                   String city,
                   String zipCode,
                   State state,
                   Country country) {
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStateName() {
        return state.getName();
    }

    public String getCountryName() {
        return country.getName();
    }
}
