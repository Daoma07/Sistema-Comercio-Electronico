"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const usuario_controllers_1 = require("../controllers/usuario.controllers");
const router = (0, express_1.Router)();
router.post('/registrar', usuario_controllers_1.registarUsuario);
router.post('/login', usuario_controllers_1.loginUsuario);
exports.default = router;
