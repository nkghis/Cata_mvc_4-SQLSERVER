package org.sid.entities;

public class CltProjDto {

    private Long projId;
    private String projet;
    private String client;

    public CltProjDto(Long projId, String projet, String client) {
        this.projId = projId;
        this.projet = projet;
        this.client = client;
    }

    public Long getProjId() {
        return projId;
    }

    public void setProjId(Long projId) {
        this.projId = projId;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
