db = connect('mongodb://root:example@localhost:27017/Proyecto_Plataforma_de_Comercio?authSource=admin');
db.clientes.insertMany([
    {
        _id: ObjectId('66217d234d458c2ee3f5d252'),
        cedula: '10949324253',
        nombre: 'Laura',
        apellido: 'González',
        ciudad: 'Armenia',
        idCuenta: '66217d234d458c2ee3f5d253',
        telefono: [
            '3148327292'
        ],
        favoritos:[],
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente'
    },
    {
        _id: ObjectId('66217d234d458c2ee3f5d254'),
        cedula: '10949324254',
        nombre: 'Carlos',
        apellido: 'Martínez',
        ciudad: 'Armenia',
        idCuenta: '66217d234d458c2ee3f5d255',
        telefono: [
            '3148327293'
        ],
        favoritos:[],
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente'
    },
    {
        _id: ObjectId('66217d234d458c2ee3f5d256'),
        cedula: '10949324255',
        nombre: 'Sofia',
        apellido: 'Lopez',
        ciudad: 'Armenia',
        idCuenta: '66217d234d458c2ee3f5d257',
        telefono: [
            '3148327294'
        ],
        favoritos:[],
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente'
    },
    {
        _id: ObjectId('66217d234d458c2ee3f5d258'),
        cedula: '10949324256',
        nombre: 'Mariana',
        apellido: 'Velasquez',
        ciudad: 'Armenia',
        idCuenta: '66217d234d458c2ee3f5d259',
        telefono: [
            '3148327295'
        ],
        favoritos:[],
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente'
    },
    {
        _id: ObjectId('66217d234d458c2ee3f5d25a'),
        cedula: '10949324257',
        nombre: 'Andres',
        apellido: 'Cano',
        ciudad: 'Armenia',
        idCuenta: '66217d234d458c2ee3f5d25b',
        telefono: [
            '3148327296'
        ],
        favoritos:[],
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente'
    },
    {
        _id: ObjectId('66217d234d458c2ee3f5d25c'),
        cedula: '10949324258',
        nombre: 'Felipe',
        apellido: 'Moreno',
        ciudad: 'Armenia',
        idCuenta: '66217d234d458c2ee3f5d25d',
        telefono: [
            '3148327297'
        ],
        favoritos:[],
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente'
    },
    {
        _id: ObjectId('66217d234d458c2ee3f5d25e'),
        cedula: '10949324259',
        nombre: 'Beatriz',
        apellido: 'Estrada',
        ciudad: 'Armenia',
        idCuenta: '66217d234d458c2ee3f5d25f',
        telefono: [
            '3148327298'
        ],
        favoritos:[],
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Cliente'
    }
]);
db.negocios.insertMany([
    {
        _id: ObjectId('66218a1784612825e5995b19'),
        nombre: 'La Esquina del Sabor',
        tipoNegocio: 'RESTAURANTE',
        descripcion: 'Comida casera y ambiente familiar',
        direccion: 'Calle Principal',
        imagenes: [
            'imagen3',
            'imagen4'
        ],
        ubicacion: {
            longitud: 34.470,
            latitud: -15858.240
        },
        horarios: [
            {
                dia: 'Martes',
                HoraInicio: '09:00',
                HoraFinal: '20:00'
            }
        ],
        estadoRegistro: 'PENDIENTE',
        estadoNegocio: 'ACTIVO',
        telefonos: [
            '1234567',
            '7654321'
        ],
        codigoCliente: '66209a3adf1d017a38b47ba0',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio'
    },
    {
        _id: ObjectId('66218a1784612825e5995b1a'),
        nombre: 'Café del Pueblo',
        tipoNegocio: 'CAFETERÍA',
        descripcion: 'Variedad en café y postres',
        direccion: 'Avenida Central',
        imagenes: [
            'imagen5',
            'imagen6'
        ],
        ubicacion: {
            longitud: 34.475,
            latitud: -15858.246
        },
        horarios: [
            {
                dia: 'Miércoles',
                HoraInicio: '10:00',
                HoraFinal: '21:00'
            }
        ],
        estadoRegistro: 'PENDIENTE',
        estadoNegocio: 'ACTIVO',
        telefonos: [
            '2345678',
            '8765432'
        ],
        codigoCliente: '66209a3adf1d017a38b47ba0',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio'
    },
    {
        _id: ObjectId('66218a1784612825e5995b1b'),
        nombre: 'Moda y Estilo',
        tipoNegocio: 'TIENDA',
        descripcion: 'Ropa de última moda para todas las edades',
        direccion: 'Calle Comercial',
        imagenes: [
            'imagen7',
            'imagen8'
        ],
        ubicacion: {
            longitud: 34.480,
            latitud: -15858.252
        },
        horarios: [
            {
                dia: 'Jueves',
                HoraInicio: '11:00',
                HoraFinal: '22:00'
            }
        ],
        estadoRegistro: 'PENDIENTE',
        estadoNegocio: 'ACTIVO',
        telefonos: [
            '3456789',
            '9876543'
        ],
        codigoCliente: '66209a3adf1d017a38b47ba0',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio'
    },
    {
        _id: ObjectId('66218a1784612825e5995b1c'),
        nombre: 'El Rincón del Deporte',
        tipoNegocio: 'DEPORTES',
        descripcion: 'Todo para los amantes del deporte',
        direccion: 'Avenida Deportiva',
        imagenes: [
            'imagen9',
            'imagen10'
        ],
        ubicacion: {
            longitud: 34.485,
            latitud: -15858.258
        },
        horarios: [
            {
                dia: 'Viernes',
                HoraInicio: '12:00',
                HoraFinal: '23:00'
            }
        ],
        estadoRegistro: 'PENDIENTE',
        estadoNegocio: 'ACTIVO',
        telefonos: [
            '4567890',
            '0123456'
        ],
        codigoCliente: '66209a3adf1d017a38b47ba0',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio'
    },
    {
        _id: ObjectId('66218a1784612825e5995b1d'),
        nombre: 'Belleza y Estética',
        tipoNegocio: 'BELLEZA',
        descripcion: 'Servicios de belleza profesional',
        direccion: 'Calle Belleza',
        imagenes: [
            'imagen11',
            'imagen12'
        ],
        ubicacion: {
            longitud: 34.490,
            latitud: -15858.264
        },
        horarios: [
            {
                dia: 'Sábado',
                HoraInicio: '13:00',
                HoraFinal: '00:00'
            }
        ],
        estadoRegistro: 'PENDIENTE',
        estadoNegocio: 'ACTIVO',
        telefonos: [
            '5678901',
            '1234567'
        ],
        codigoCliente: '66209a3adf1d017a38b47ba0',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio'
    },
    {
        _id: ObjectId('66218a1784612825e5995b1e'),
        nombre: 'Libros y Más',
        tipoNegocio: 'LIBRERÍA',
        descripcion: 'Amplia selección de libros y material educativo',
        direccion: 'Calle de los Libros',
        imagenes: [
            'imagen13',
            'imagen14'
        ],
        ubicacion: {
            longitud: 34.495,
            latitud: -15858.270
        },
        horarios: [
            {
                dia: 'Domingo',
                HoraInicio: '14:00',
                HoraFinal: '01:00'
            }
        ],
        estadoRegistro: 'PENDIENTE',
        estadoNegocio: 'ACTIVO',
        telefonos: [
            '6789012',
            '2345678'
        ],
        codigoCliente: '66209a3adf1d017a38b47ba0',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Negocio'
    }
]);
db.cuentas.insertMany([
    {
        _id: ObjectId('66217d234d458c2ee3f5d251'),
        email: 'lauragonzalez@gmail.com',
        nickname: 'lau_89',
        password: '$2a$10$V.ZzcmMs74qyWTR117aDNu6VNEtl9z4P0H.CW39h7.TAC0a1gONmK',
        fotoPerfil: 'xxxxxxxxxxxxxxxxxxxxxx',
        estadoCliente: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Cuenta'
    },
    {
        _id: ObjectId('66217d234d458c2ee3f5d252'),
        email: 'carlosmartinez@gmail.com',
        nickname: 'carlitos123',
        password: '$2a$10$V.ZzcmMs74qyWTR117aDNu6VNEtl9z4P0H.CW39h7.TAC0a1gONmK',
        fotoPerfil: 'xxxxxxxxxxxxxxxxxxxxxx',
        estadoCliente: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Cuenta'
    },
    {
        _id: ObjectId('66217d234d458c2ee3f5d253'),
        email: 'sofialopez@gmail.com',
        nickname: 'sofi_22',
        password: '$2a$10$V.ZzcmMs74qyWTR117aDNu6VNEtl9z4P0H.CW39h7.TAC0a1gONmK',
        fotoPerfil: 'xxxxxxxxxxxxxxxxxxxxxx',
        estadoCliente: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Cuenta'
    },
    {
        _id: ObjectId('66217d234d458c2ee3f5d254'),
        email: 'mariaramirez@gmail.com',
        nickname: 'mari_rami',
        password: '$2a$10$V.ZzcmMs74qyWTR117aDNu6VNEtl9z4P0H.CW39h7.TAC0a1gONmK',
        fotoPerfil: 'xxxxxxxxxxxxxxxxxxxxxx',
        estadoCliente: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Cuenta'
    },
    {
        _id: ObjectId('66217d234d458c2ee3f5d255'),
        email: 'andresc@gmail.com',
        nickname: 'andres_7',
        password: '$2a$10$V.ZzcmMs74qyWTR117aDNu6VNEtl9z4P0H.CW39h7.TAC0a1gONmK',
        fotoPerfil: 'xxxxxxxxxxxxxxxxxxxxxx',
        estadoCliente: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Cuenta'
    },
    {
        _id: ObjectId('66217d234d458c2ee3f5d256'),
        email: 'felipemoreno@gmail.com',
        nickname: 'feli_more',
        password: '$2a$10$V.ZzcmMs74qyWTR117aDNu6VNEtl9z4P0H.CW39h7.TAC0a1gONmK',
        fotoPerfil: 'xxxxxxxxxxxxxxxxxxxxxx',
        estadoCliente: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Cuenta'
    },
    {
        _id: ObjectId('66217d234d458c2ee3f5d257'),
        email: 'beatrizestrada@gmail.com',
        nickname: 'bea_estrada',
        password: '$2a$10$V.ZzcmMs74qyWTR117aDNu6VNEtl9z4P0H.CW39h7.TAC0a1gONmK',
        fotoPerfil: 'xxxxxxxxxxxxxxxxxxxxxx',
        estadoCliente: 'ACTIVO',
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.entidades.Cuenta'
    }
]);
db.comentarios.insertMany([
    {
        _id: ObjectId('661f71ffa51a611e21fac287'),
        mensaje: 'Increíble experiencia, totalmente recomendado',
        fecha: ISODate('2024-04-17T08:00:00.000Z'),
        codigoCliente: 'Cliente2',
        codigoNegocio: 'Negocio1',
        calificacion: 5,
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario'
    },
    {
        _id: ObjectId('661f71ffa51a611e21fac288'),
        mensaje: 'Muy buen servicio, comida deliciosa',
        fecha: ISODate('2024-04-17T08:05:00.000Z'),
        codigoCliente: 'Cliente3',
        codigoNegocio: 'Negocio1',
        calificacion: 4,
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario'
    },
    {
        _id: ObjectId('661f71ffa51a611e21fac289'),
        mensaje: 'Ambiente agradable y precios justos',
        fecha: ISODate('2024-04-17T08:10:00.000Z'),
        codigoCliente: 'Cliente4',
        codigoNegocio: 'Negocio1',
        calificacion: 5,
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario'
    },
    {
        _id: ObjectId('661f71ffa51a611e21fac28a'),
        mensaje: 'La atención podría mejorar, pero la comida es buena',
        fecha: ISODate('2024-04-17T08:15:00.000Z'),
        codigoCliente: 'Cliente5',
        codigoNegocio: 'Negocio1',
        calificacion: 3,
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario'
    },
    {
        _id: ObjectId('661f71ffa51a611e21fac28b'),
        mensaje: 'Perfecto para cenas familiares',
        fecha: ISODate('2024-04-17T08:20:00.000Z'),
        codigoCliente: 'Cliente6',
        codigoNegocio: 'Negocio1',
        calificacion: 5,
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario'
    },
    {
        _id: ObjectId('661f71ffa51a611e21fac28c'),
        mensaje: 'Rápidos en el servicio y muy cordiales',
        fecha: ISODate('2024-04-17T08:25:00.000Z'),
        codigoCliente: 'Cliente7',
        codigoNegocio: 'Negocio1',
        calificacion: 4,
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario'
    },
    {
        _id: ObjectId('661f71ffa51a611e21fac28d'),
        mensaje: 'Gran variedad en el menú, volveré sin duda',
        fecha: ISODate('2024-04-17T08:30:00.000Z'),
        codigoCliente: 'Cliente8',
        codigoNegocio: 'Negocio1',
        calificacion: 5,
        _class: 'co.edu.uniquindio.Proyecto_Plataforma_de_Comercio.modelo.documentos.Comentario'
    }
]);
