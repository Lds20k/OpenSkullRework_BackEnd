package com.teamrogerio.openskullrework.controller.translator;

import org.modelmapper.ModelMapper;

public class Translator {
    public static <Entrada, Saida> Saida translate(Entrada ent, Class<Saida> sai) {
        return (new ModelMapper()).map(ent, sai);
    }
}