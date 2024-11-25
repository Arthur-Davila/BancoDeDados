package com.grupo.SolennitaStellare.controller;

import java.sql.Date;

public record UpdateEventoDto(String nomeEvento, Double custoEvento, Date inicio, Date fim) {
}