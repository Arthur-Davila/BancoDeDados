package com.grupo.SolennitaStellare.controller;

import java.sql.Date;

public record CreateEventoDto(String nomeEvento, Double custoEvento, Date inicio, Date fim) {

}