import * as amqp from 'amqplib/callback_api';

const EXCHANGE_NAME = "exchange-microservicios";
const ROUTING_KEY = "microservicio-usuario";
const RESPONSE_QUEUE_PREFIX = "response-";

export function enviarMensaje(mensaje: String, callback: (respuesta: string) => void): void {

    amqp.connect('amqp://root:1234@localhost', (error0, connection) => {
        if (error0) {
            throw error0;
        }
        connection.createChannel((error1, channel) => {
            if (error1) {
                throw error1;
            }
            channel.assertExchange(EXCHANGE_NAME, 'topic', { durable: false });

            // Crear una cola de respuesta exclusiva para esta solicitud
            const correlationId = generateCorrelationId();
            const RESPONSE_QUEUE_NAME = `${RESPONSE_QUEUE_PREFIX}${correlationId}`;
            channel.assertQueue(RESPONSE_QUEUE_NAME, { exclusive: true }, (error2, _queue) => {
                if (error2) {
                    throw error2;
                }

                // Configurar el consumidor para la cola de respuesta
                channel.consume(RESPONSE_QUEUE_NAME, (msg) => {
                    if (msg !== null) {
                        // Llamar al callback con la respuesta recibida
                        callback(msg.content.toString());
                    }
                }, { noAck: true });

                // Publicar el mensaje en el exchange

                const messageOptions = { correlationId: correlationId.toString(), replyTo: RESPONSE_QUEUE_NAME };
                channel.publish(EXCHANGE_NAME, ROUTING_KEY, Buffer.from(mensaje), messageOptions);
                console.log(" [x] Enviado desde API Gateway: '" + mensaje + "'");
            });
        });
    });
}

function generateCorrelationId(): string {
    return Date.now().toString();
}
