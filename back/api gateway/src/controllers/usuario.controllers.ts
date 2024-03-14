import { Request, Response } from "express"
import { enviarMensaje } from "../endpoints/producto";

export const nuevoUsuario = (req: Request, res: Response) => {


    res.json({
        msg: "Nuevo Usuario",
    })
}


export const loginUsuario = (req: Request, res: Response) => {

    const { correo, contrasenia } = req.body;
    const credenciales = JSON.stringify({ correo, contrasenia })
    console.log(correo);
    console.log(contrasenia);
    enviarMensaje(credenciales);
    res.json({
        msg: "Nuevo Usuario",

    })
}