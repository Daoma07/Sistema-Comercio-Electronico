"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.loginUsuario = exports.nuevoUsuario = void 0;
const producto_1 = require("../endpoints/producto");
const nuevoUsuario = (req, res) => {
    res.json({
        msg: "Nuevo Usuario",
    });
};
exports.nuevoUsuario = nuevoUsuario;
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
                    respuestaServidor: {
                        nombre,
                        apellido_paterno,
                        apellido_materno,
                        telefono
                    }
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
