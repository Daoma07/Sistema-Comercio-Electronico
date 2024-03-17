import { Request, Response } from "express"
import { enviarMensaje } from "../endpoints/producto";

export const nuevoUsuario = (req: Request, res: Response) => {


    res.json({
        msg: "Nuevo Usuario",
    })
}


export const loginUsuario = (req: Request, res: Response) => {
    const { correo, contrasenia, action } = req.body;
    const credenciales = JSON.stringify({ correo, contrasenia, action });

    enviarMensaje(credenciales, (respuesta: string) => {
        // Manejar la respuesta del microservicio aquí
        console.log("Respuesta del microservicio:", respuesta);

        // Enviar la respuesta al cliente
        res.json({
            respuesta
        });
    });
};