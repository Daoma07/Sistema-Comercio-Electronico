import * as amqp from 'amqplib/callback_api';

const EXCHANGE_NAME = "exchange-microservicios";
const ROUTING_KEY = "microservicio-usuario";

export function enviarMensaje(mensaje: String): void {
    amqp.connect('amqp://root:1234@localhost', function (error0, connection) {
        if (error0) {
            throw error0;
        }
        connection.createChannel(function (error1, channel) {
            if (error1) {
                throw error1;
            }
            channel.assertExchange(EXCHANGE_NAME, 'topic', {
                durable: false
            });

            const message = mensaje;
            channel.publish(EXCHANGE_NAME, ROUTING_KEY, Buffer.from(message));
            console.log(" [x] Enviado desde API Gateway: '" + message + "'");

            setTimeout(function () {
                connection.close();
            }, 500);
        });
    });
}
