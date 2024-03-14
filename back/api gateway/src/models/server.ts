import express, { Application } from 'express';
import routesUsuario from '../routes/usuario.routes'


class Server {

    private app: Application;
    private port: string;

    constructor() {
        this.app = express();
        this.port = process.env.PORT || "3001";
        this.lsiten();
        this.midlewares();
        this.routes();
    }

    lsiten() {
        this.app.listen(this.port, () => {
            console.log('Aplicacion corriendo en el puerto ' + this.port);
        })
    }

    routes() {
        this.app.use('/api/usuario', routesUsuario);
    }

    midlewares() {
        this.app.use(express.json());
    }
}

export default Server;