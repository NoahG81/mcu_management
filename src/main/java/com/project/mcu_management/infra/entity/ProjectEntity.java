package com.project.mcu_management.infra.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "projet")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_media")
    private Long id;
    private String titre;
    @Lob
    private byte[] affiche;
    @Column(name = "ordre_visionnage")
    private int ordreVisionnage;
    @Column(name = "duree_minutes")
    private int dureeMinute;
    @Column(name = "date_sortie")
    private String dateSortie;
    @Column(name = "type_media")
    private String typeMedia;
    @Column(name = "id_phase")
    private Long idPhase;
    private String universe;
    @Column(name = "importance_id")
    private Integer importanceId;

    public ProjectEntity(){

    }

    public ProjectEntity(String titre, byte[] affiche, int ordreVisionnage, int dureeMinute,
                         String dateSortie, String typeMedia, Long idPhase, String universe, Integer importanceId) {
        this.titre = titre;
        this.affiche = affiche;
        this.ordreVisionnage = ordreVisionnage;
        this.dureeMinute = dureeMinute;
        this.dateSortie = dateSortie;
        this.typeMedia = typeMedia;
        this.idPhase = idPhase;
        this.universe = universe;
        this.importanceId = importanceId;
    }

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public byte[] getAffiche() {
        return affiche;
    }

    public int getOrdreVisionnage() {
        return ordreVisionnage;
    }

    public int getDureeMinute() {
        return dureeMinute;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public String getTypeMedia() {
        return typeMedia;
    }

    public Long getIdPhase() {
        return idPhase;
    }

    public String getUniverse() {
        return universe;
    }

    public Integer getImportanceId() {
        return importanceId;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAffiche(byte[] affiche) {
        this.affiche = affiche;
    }

    public void setOrdreVisionnage(int ordreVisionnage) {
        this.ordreVisionnage = ordreVisionnage;
    }

    public void setDureeMinute(int dureeMinute) {
        this.dureeMinute = dureeMinute;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public void setIdPhase(Long idPhase) {
        this.idPhase = idPhase;
    }

    public void setTypeMedia(String typeMedia) {
        this.typeMedia = typeMedia;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public void setImportanceId(Integer importanceId) {
        this.importanceId = importanceId;
    }
}
