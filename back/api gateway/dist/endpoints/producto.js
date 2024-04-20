"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.enviarMensaje = void 0;
const amqp = __importStar(require("amqplib/callback_api"));
const EXCHANGE_NAME = "exchange-microservicios";
const ROUTING_KEY = "microservicio-usuario";
const RESPONSE_QUEUE_PREFIX = "response-";
function enviarMensaje(mensaje, callback) {
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
exports.enviarMensaje = enviarMensaje;
function generateCorrelationId() {
    return Date.now().toString();
}
