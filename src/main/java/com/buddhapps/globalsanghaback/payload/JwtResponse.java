package com.buddhapps.globalsanghaback.payload;

import com.buddhapps.globalsanghaback.model.User;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private User user; // Agrega esta línea para incluir el usuario en la respuesta

    public JwtResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    // Getters (y setters si es necesario)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() { // Getter para el usuario
        return user;
    }

    public void setUser(User user) { // Setter para el usuario
        this.user = user;
    }
}
