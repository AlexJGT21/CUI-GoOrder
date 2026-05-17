package org.example;

import Interfaces.ICodigoDescuentoServicio;
import GoOrderDTO.CodigoDescuentoDTO;

public class VerificarCodigo {

    private ICodigoDescuentoServicio servicio;

    public VerificarCodigo(ICodigoDescuentoServicio servicio) {
        this.servicio = servicio;
    }

    public CodigoDescuentoDTO ejecutar(String codigo) {
        return servicio.verificarCodigo(codigo);
    }
}