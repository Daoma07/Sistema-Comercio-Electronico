import * as amqp from 'amqplib/callback_api';

const EXCHANGE_NAME = "exchange-microservicios";
const ROUTING_KEY = "microservicio-usuario-api";
const QUEUE_NAME = "queue-api";

export function iniciarConsumidor(): void {
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
            channel.assertQueue(QUEUE_NAME, {
                durable: false
            }, function (error2, _queue) {
                if (error2) {
                    throw error2;
                }
                console.log(" [*] Esperando mensajes desde API Gateway. Para salir, presiona CTRL+C");

                channel.bindQueue(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);

                channel.consume(QUEUE_NAME, function (msg) {
                    if (msg !== null) {
                        console.log(" [x] Recibido desde API Gateway: '%s'", msg.content.toString());
                        // Implementa la lógica para procesar el mensaje aquí
                        channel.ack(msg);
                    }
                }, {
                    noAck: false
                });
            });
        });
    });
}
