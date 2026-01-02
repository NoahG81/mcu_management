package com.project.mcu_management.appli.bean;

import java.time.LocalDate;

public record ProjectBean(String titre, Integer ordreVisionnage, Integer dureeMinutes, LocalDate dateSortie,
                          MediaTypeBean typeMedia, Long phaseId, byte[] affiche, String universe,
                          String importance) {
}
