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
        // Enviar la respuesta al cliente
        res.json({
            respuesta
        });
    });
};
exports.loginUsuario = loginUsuario;
