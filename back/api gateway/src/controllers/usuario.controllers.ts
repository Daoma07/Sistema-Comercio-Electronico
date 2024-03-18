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
            } catch (error) {
                // Maneja el error si no se pudo parsear la respuesta
                console.error("Error al parsear la respuesta del microservicio:", error);
                res.status(500).send('Error al procesar la respuesta del microservicio');
            }
        } else {
            // Manejar el caso en que la respuesta sea undefined
            res.status(500).send('Respuesta del microservicio indefinida');
        }
    });
};