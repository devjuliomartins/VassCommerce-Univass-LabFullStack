package br.com.juliomartins.VassCommerce.auth.dto;

public class TokenResponse {

    private String token;

    public TokenResponse(String token){
        this.token=token;
    }

    public String getToken() {
        return token;
    }
}
