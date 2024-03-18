"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.loginUsuario = exports.registarUsuario = void 0;
const producto_1 = require("../endpoints/producto");
const registarUsuario = (req, res) => {
    const { nombres, apellido_paterno, apellido_materno, correo, password, telefono, estado, ciudad, codigo_postal, fecha_nacimiento, sexo, colonia, calle, numero } = req.body;
    const action = "registrar";
    const datosRegistro = JSON.stringify({
        nombres, apellido_paterno,
        apellido_materno, correo,
        password,
        telefono,
        estado,
        ciudad,
        codigo_postal,
        fecha_nacimiento,
        sexo,
        colonia,
        calle,
        numero, action
    });
    (0, producto_1.enviarMensaje)(datosRegistro, (respuesta) => {
        // Manejar la respuesta del microservicio aquí
        console.log("Respuesta del microservicio:", respuesta);
        if (respuesta) {
            try {
                // Parsea la respuesta del microservicio
                const respuestaServidor = JSON.parse(respuesta);
                // Extrae los datos relevantes de la respuesta
                const { msg, id } = respuestaServidor;
                // Envia los datos al cliente como una respuesta JSON
                res.json({
                    msg,
                    id
                });
            }
            catch (error) {
                // Maneja el error si no se pudo parsear la respuesta
                console.error("Error al parsear la respuesta del microservicio:", error);
                res.status(500).send('Error al procesar la respuesta del microservicio');
            }
        }
        else {
            // Manejar el caso en que la respuesta sea undefined
            res.status(500).send('Respuesta del microservicio indefinida');
        }
    });
};
exports.registarUsuario = registarUsuario;
const loginUsuario = (req, res) => {
    const { correo, contrasenia, action } = req.body;
    const credenciales = JSON.stringify({ correo, contrasenia, action });
    (0, producto_1.enviarMensaje)(credenciales, (respuesta) => {
        // Manejar la respuesta del microservicio aquí
        console.log("Respuesta del microservicio:", respuesta);
        if (respuesta) {
            try {
                // Parsea la respuesta del microservicio
                const respuestaServidor = JSON.parse(respuesta);
                // Extrae los datos relevantes de la respuesta
                const { nombre, apellido_paterno, apellido_materno, telefono } = respuestaServidor;
                // Envia los datos al cliente como una respuesta JSON
                res.json({
                    nombre,
                    apellido_paterno,
                    apellido_materno,
                    telefono
                });
            }
            catch (error) {
                // Maneja el error si no se pudo parsear la respuesta
                console.error("Error al parsear la respuesta del microservicio:", error);
                res.status(500).send('Error al procesar la respuesta del microservicio');
            }
        }
        else {
            // Manejar el caso en que la respuesta sea undefined
            res.status(500).send('Respuesta del microservicio indefinida');
        }
    });
};
exports.loginUsuario = loginUsuario;
