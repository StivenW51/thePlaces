package co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.implementaciones;

import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.dto.*;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoNegocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.EstadoRegistro;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.enums.TipoNegocio;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.repositorios.NegocioRepo;
import co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.servicios.interfaces.NegocioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class NegocioServicioImpl implements NegocioServicio {

    private final NegocioRepo negocioRepo;
    private final ImagenesServicioImpl imagenesServicio;

    /**
     * Obtiene los datos de un negocio dado su codigo
     * @param codigo
     * @return
     * @throws Exception
     */
    @Override
    public DetalleNegocioDTO obtenerNegocioCodigo(String codigo)throws Exception{
        Optional<Negocio> optionalNegocio = negocioRepo.findByCodigo(codigo);
        Negocio negocio;

        if (optionalNegocio.isPresent()){
            negocio = optionalNegocio.get();

            return new DetalleNegocioDTO(
                    negocio.getNombre(),
                    negocio.getDireccion(),
                    negocio.getHorarios(),
                    negocio.getUbicacion(),
                    negocio.getTipoNegocio(),
                    negocio.getImagenes(),
                    negocio.getTelefonos(),
                    negocio.getDescripcion(),
                    negocio.getCodigoCliente()
            );
        }
        else {
            throw new Exception("El codigo del negocio " + codigo + " no se encuentra");
        }
    }

    /**
     * Registra los datos de un negocio
     * @param crearNegocioDTO
     * @return
     * @throws Exception
     */
    @Override
    public String crearNegocio(CrearNegocioDTO crearNegocioDTO) throws Exception {
        //instanciamos el negocio
        Negocio negocio = new Negocio();
        List<String> ImagenesUrl = new ArrayList<>();
        String urlCloudinary;

        negocio.setNombre(crearNegocioDTO.nombre());
        negocio.setTipoNegocio(crearNegocioDTO.tipoNegocio());
        negocio.setDescripcion(crearNegocioDTO.descripcion());
        negocio.setDireccion(crearNegocioDTO.direccion());
        negocio.setUbicacion(crearNegocioDTO.ubicacion());
        negocio.setHorarios(crearNegocioDTO.horarios());
        negocio.setEstadoRegistro(crearNegocioDTO.estadoRegistro());
        negocio.setEstadoNegocio(crearNegocioDTO.estadoNegocio());
        negocio.setTelefonos(crearNegocioDTO.telefonos());
        negocio.setCodigoCliente(crearNegocioDTO.codigoCliente());

        for(String url_Local : crearNegocioDTO.imagenes()){

            File uploadedFile = new File(url_Local);
            Map cloudinaryResponse = imagenesServicio.subirImagenII(uploadedFile);

            urlCloudinary = cloudinaryResponse.get("url").toString();
            ImagenesUrl.add(urlCloudinary);
        }

        negocio.setImagenes(ImagenesUrl);
        Negocio negocioGuardado = negocioRepo.save(negocio);

        return negocioGuardado.getCodigo();
    }

    /**
     * Actualiza los datos de un negocio
     * @param editarNegocioDTO
     * @throws Exception
     */
    @Override
    public void actualizarNegocio(EditarNegocioDTO editarNegocioDTO) throws Exception {

        //Buscamos el negocio a actualizar
        Optional<Negocio>optionalNegocio = negocioRepo.findByCodigo(editarNegocioDTO.id());

        //excepcion sino se encuentra el negocio
        if (optionalNegocio.isEmpty()) {

            throw new Exception("Negocio no encontrado");
        }

        //Actualizamos los datos del negocio
        Negocio negocio = optionalNegocio.get();
        negocio.setNombre(editarNegocioDTO.nombreNegocio());
        negocio.setTipoNegocio(editarNegocioDTO.tipoNegocio());
        negocio.setDescripcion(editarNegocioDTO.descripcion());
        negocio.setUbicacion(editarNegocioDTO.ubicacion());
        negocio.setTelefonos(editarNegocioDTO.telefonos());
        negocio.setHorarios(editarNegocioDTO.horarios());
        negocio.setImagenes(editarNegocioDTO.imagenes());
        negocio.setEstadoNegocio(editarNegocioDTO.estadoNegocio());
        negocio.setEstadoRegistro(editarNegocioDTO.estadoRegistro());

        //Guardamos los cambios
        Negocio negocioActualizado = negocioRepo.save(negocio);

    }

    /**
     * Realiza un borrado logico del negocio
     * @param idNegocio
     * @throws Exception
     */
    @Override
    public void eliminarNegocio(String idNegocio) throws Exception {
        Optional<Negocio> optionalNegocio = negocioRepo.findByCodigo(idNegocio);

        if (optionalNegocio.isEmpty()) {
            throw new Exception("El cliente no se ha encontrado");
        }

        Negocio negocio = optionalNegocio.get();

        negocio.setEstadoNegocio(EstadoNegocio.INACTIVO);
        negocioRepo.save(negocio);
    }


    /**
     * Lista los negocio dado un id de cliente (propietario)
     * @param idCliente
     * @return
     * @throws Exception
     */
    @Override
    public List<DetalleNegocioDTO> listarNegociosCliente(String idCliente) throws Exception {
        List<Negocio> listaNegocios = new ArrayList<>();
        Optional<List<Negocio>> optionalNegocios = negocioRepo.findByCodigoCliente(idCliente);
        List<DetalleNegocioDTO> listaDetalleNegocio = new ArrayList<>();
        Negocio negocio;

        if(optionalNegocios.isEmpty()){
            throw new Exception("el cliente no tiene negocios");
        }

        listaNegocios = optionalNegocios.get();

       if(listaNegocios.size() == 0){
           throw new Exception("el cliente no tiene negocios");
       }

        for(int i = 0; i < listaNegocios.size(); i++){
           negocio = listaNegocios.get(i);

            listaDetalleNegocio.add(new DetalleNegocioDTO(
                    negocio.getNombre(),
                    negocio.getDireccion(),
                    negocio.getHorarios(),
                    negocio.getUbicacion(),
                    negocio.getTipoNegocio(),
                    negocio.getImagenes(),
                    negocio.getTelefonos(),
                    negocio.getDescripcion(),
                    negocio.getCodigoCliente()
            ));
        }

        return listaDetalleNegocio;
    }

    /**
     * Lista los negocios que cumplen con todos los requisitos de la plataforma
     * @return
     * @throws Exception
     */
    @Override
    public List<DetalleNegocioDTO> listarNegociosActivosAprobados() throws Exception {
        List<Negocio> listaNegocios = new ArrayList<>();
        Optional<List<Negocio>> optionalNegocios = negocioRepo.findByEstadoNegocioAndEstadoRegistro(EstadoNegocio.ACTIVO, EstadoRegistro.APROBADO);
        List<DetalleNegocioDTO> listaDetalleNegocio = new ArrayList<>();
        Negocio negocio;

        if(optionalNegocios.isEmpty()){
            throw new Exception("No hay negocios");
        }

        listaNegocios = optionalNegocios.get();

        for(int i = 0; i < listaNegocios.size(); i++){
            negocio = listaNegocios.get(i);

            listaDetalleNegocio.add(new DetalleNegocioDTO(
                    negocio.getNombre(),
                    negocio.getDireccion(),
                    negocio.getHorarios(),
                    negocio.getUbicacion(),
                    negocio.getTipoNegocio(),
                    negocio.getImagenes(),
                    negocio.getTelefonos(),
                    negocio.getDescripcion(),
                    negocio.getCodigoCliente()
            ));
        }

        return listaDetalleNegocio;
    }


    /**
     * Lista los negocios que están pendientes de revisión
     * @return
     * @throws Exception
     */
    @Override
    public List<DetalleNegocioDTO> listarNegociosPendientes() throws Exception {
        List<Negocio> listaNegocios = new ArrayList<>();
        Optional<List<Negocio>> optionalNegocios = negocioRepo.findByEstadoRegistro(EstadoRegistro.PENDIENTE);
        List<DetalleNegocioDTO> listaDetalleNegocio = new ArrayList<>();
        Negocio negocio;

        if(optionalNegocios.isEmpty()){
            throw new Exception("No hay negocios pendientes");
        }
        else{
            listaNegocios = optionalNegocios.get();

            for(int i = 0; i < listaNegocios.size(); i++){
                negocio = listaNegocios.get(i);

                listaDetalleNegocio.add(new DetalleNegocioDTO(
                        negocio.getNombre(),
                        negocio.getDireccion(),
                        negocio.getHorarios(),
                        negocio.getUbicacion(),
                        negocio.getTipoNegocio(),
                        negocio.getImagenes(),
                        negocio.getTelefonos(),
                        negocio.getDescripcion(),
                        negocio.getCodigoCliente()
                ));
            }
        }

        return listaDetalleNegocio;
    }

    /**
     * Realiza un busqueda por coincidencia de los negocios dado un nombre o una catyegoría
     * @param negocioNombreTipoDistanciaDTO
     * @return
     * @throws Exception
     */
    @Override
    public List<DetalleNegocioDTO> listarNegocioNombreOTipo(NegocioNombreTipoDistanciaDTO negocioNombreTipoDistanciaDTO) throws Exception {
        List<Negocio> listaNegocios = new ArrayList<>();
        Optional<List<Negocio>> optionalNegocios = negocioRepo.findByNombreIsLikeOrTipoNegocioIsLike(negocioNombreTipoDistanciaDTO.nombre(), negocioNombreTipoDistanciaDTO.tipoNegocio().toUpperCase());
        List<DetalleNegocioDTO> listaDetalleNegocio = new ArrayList<>();
        Negocio negocio;

        if(optionalNegocios.isEmpty()){
            throw new Exception("No hay negocios");
        }

        listaNegocios = optionalNegocios.get();

        if(listaNegocios.size() == 0){
            throw new Exception("No hay negocios");
        }

        for(int i = 0; i < listaNegocios.size(); i++){
            negocio = listaNegocios.get(i);

            listaDetalleNegocio.add(new DetalleNegocioDTO(
                    negocio.getNombre(),
                    negocio.getDireccion(),
                    negocio.getHorarios(),
                    negocio.getUbicacion(),
                    negocio.getTipoNegocio(),
                    negocio.getImagenes(),
                    negocio.getTelefonos(),
                    negocio.getDescripcion(),
                    negocio.getCodigoCliente()
            ));
        }

        return listaDetalleNegocio;
    }

    /**
     * Realiza una actualización del estado del registro del negocio (APROBADO, RECHAZADO)
     * @param cambioEstadoRegistroDTO
     * @throws Exception
     */
    @Override
    public void CambiarEstadoRegistro(CambioEstadoRegistroDTO cambioEstadoRegistroDTO) throws Exception{
        Optional<Negocio> optionalNegocio = negocioRepo.findByCodigo(cambioEstadoRegistroDTO.idNegocio());

        if (optionalNegocio.isEmpty()) {
            throw new Exception("El negocio no existe");
        }

        Negocio negocio = optionalNegocio.get();

        negocio.setEstadoRegistro(cambioEstadoRegistroDTO.estadoRegistro());
        negocio.setEstadoNegocio(cambioEstadoRegistroDTO.estadoNegocio());
        negocioRepo.save(negocio);
    }

}
