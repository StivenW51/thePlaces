package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.implementaciones;

public interface ModeradorServicio {
    void AceptarNegocio(String idModerador) throws Exception;
    void RechazarNegocio(String idModerador) throws Exception;
}
