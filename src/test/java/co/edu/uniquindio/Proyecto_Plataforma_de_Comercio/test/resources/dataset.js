db = connect('mongodb://root:example@localhost:27017/Proyecto_Plataforma_de_Comercio?authSource=admin');
db.clientes.insertMany([
    {
        codigo: 'Cliente1',
        nickname: 'juanito',
        ciudad: 'Armenia',
        fotoPerfil: 'mi foto',
        email: 'juan@email.com',
        password: 'mipassword',
        nombre: 'Juan',
        estado: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente'
    },
    {
        codigo: 'Cliente2',
        nickname: 'maria',
        ciudad: 'Armenia',
        fotoPerfil: 'mi foto',
        email: 'maria@email.com',
        password: 'mipassword',
        nombre: 'Maria',
        estado: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente'
    },
    {
        codigo: 'Cliente3',
        nickname: 'pedrito',
        ciudad: 'Armenia',
        fotoPerfil: 'mi foto',
        email: 'pedro@email.com',
        password: 'mipassword',
        nombre: 'Pedro',
        estado: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente'
    },
    {
        codigo: 'Cliente5',
        nickname: 'ezequielito',
        ciudad: 'Armenia',
        fotoPerfil: 'mi foto',
        email: 'ezequielito69@email.com',
        password: 'jsr',
        nombre: 'ezequiel loaiza',
        estado: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente'
    }
]);
db.negocios.insertMany([
    {
        codigo: 'Negocio1',
        nombre: 'Restaurante Mexicano',
        descripcion: 'Restaurante de comida mexicana en Armenia',
        codigoCliente: 'Cliente1',
        ubicacion: {
            latitud: 4.540130,
            longitud: -75.665660
        },
        imagenes: ['imagen1', 'imagen2'],
        tipoNegocio: 'RESTAURANTE',
        horarios: [
            {
                dia: 'LUNES',
                horaInicio: '08:00',
                horaFin: '20:00'
            }
        ],
        telefonos: ['1234567', '7654321'],
        estado: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio'
    },
    {
        codigo: 'Negocio2',
        nombre: 'cine colombia',
        descripcion: 'cine en Armenia',
        codigoCliente: 'Cliente2',
        ubicacion: {
            latitud: 4.540130,
            longitud: -75.665660
        },
        imagenes: ['imagen1', 'imagen2'],
        tipoNegocio: 'RESTAURANTE',
        horarios: [
            {
                dia: 'LUNES-Domingo',
                horaInicio: '18:00',
                horaFin: '00:00'
            }
        ],
        telefonos: ['1234567', '7654321'],
        estado: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio'
    },
    {
        codigo: 'Negocio3',
        nombre: 'museo quimbaya',
        descripcion: 'museo del oro en Armenia',
        codigoCliente: 'Cliente3',
        ubicacion: {
            latitud: 4.540130,
            longitud: -75.665660
        },
        imagenes: ['imagen1', 'imagen2'],
        tipoNegocio: 'RESTAURANTE',
        horarios: [
            {
                dia: 'LUNES-Domingo',
                horaInicio: '18:00',
                horaFin: '00:00'
            }
        ],
        telefonos: ['1234567', '7654321'],
        estado: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio'
    },
    {
        codigo: 'Negocio4',
        nombre: 'jacobos burguer',
        descripcion: 'Restaurante de comida rapida en Armenia',
        codigoCliente: 'Cliente4',
        ubicacion: {
            latitud: 4.540130,
            longitud: -75.665660
        },
        imagenes: ['imagen1', 'imagen2'],
        tipoNegocio: 'RESTAURANTE',
        horarios: [
            {
                dia: 'LUNES-Domingo',
                horaInicio: '18:00',
                horaFin: '00:00'
            }
        ],
        telefonos: ['1234567', '7654321'],
        estado: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio'
    },
    {
        codigo: 'Negocio5',
        nombre: 'bbc',
        descripcion: 'bar en Armenia',
        codigoCliente: 'Cliente5',
        ubicacion: {
            latitud: 4.540130,
            longitud: -75.665660
        },
        imagenes: ['imagen1', 'imagen2'],
        tipoNegocio: 'RESTAURANTE',
        horarios: [
            {
                dia: 'LUNES-Domingo',
                horaInicio: '18:00',
                horaFin: '00:00'
            }
        ],
        telefonos: ['1234567', '7654321'],
        estado: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio'
    }
]);
db.comentarios.insertMany([
    {
        mensaje: "Excelente sitio, muy buena atención",
        fecha: new Date(),
        codigoCliente: 'Cliente1',
        codigoNegocio: 'Negocio1',
        calificacion: 5,
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario'
    },

    {
        mensaje: 'Ambiente acogedor y excelente café',
        fecha: new Date(),
        codigoCliente: 'Cliente2',
        codigoNegocio: 'Negocio2',
        calificacion: 5,
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario'
    },

    {
        mensaje: 'Los mejores helados de la ciudad',
        fecha: new Date(),
        codigoCliente: 'Cliente8',
        codigoNegocio: 'Negocio8',
        calificacion: 5,
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario'
    },
    {
        mensaje: 'Excelente selección de ropa',
        fecha: new Date(),
        codigoCliente: 'Cliente6',
        codigoNegocio: 'Negocio6',
        calificacion: 4,
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario'
    },
    {
        mensaje: 'Las joyas son de alta calidad y buen precio',
        fecha: new Date(),
        codigoCliente: 'Cliente7',
        codigoNegocio: 'Negocio7',
        calificacion: 5,
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario'
    },
    {
        mensaje: 'Un lugar perfecto para encontrar buenos libros',
        fecha: new Date(),
        codigoCliente: 'Cliente8',
        codigoNegocio: 'Negocio8',
        calificacion: 5,
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario'
    }


]);