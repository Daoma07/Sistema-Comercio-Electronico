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
    const { correo, contrasenia } = req.body;
    const credenciales = JSON.stringify({ correo, contrasenia });
    console.log(correo);
    console.log(contrasenia);
    (0, producto_1.enviarMensaje)(credenciales);
    res.json({
        msg: "Nuevo Usuario",
    });
};
exports.loginUsuario = loginUsuario;
