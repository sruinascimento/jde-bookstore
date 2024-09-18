package br.com.rsfot.bookstore.state;

public record NewStateResponse(String stateName, String countryName) {
    public NewStateResponse(State state) {
        this(state.getName(), state.getCountryName());
    }
}
