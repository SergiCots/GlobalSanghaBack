package com.buddhapps.globalsanghaback.dto;

public class ToolCreationDTO {

    private String name;
    private String description;
    private Boolean available;
    private String status;
    private Long ownerId;

    // Constructor vacío
    public ToolCreationDTO() {
    }

    // Constructor con todos los campos
    public ToolCreationDTO(String name, String description, Boolean available, String status, Long ownerId) {
        this.name = name;
        this.description = description;
        this.available = available;
        this.status = status;
        this.ownerId = ownerId;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
