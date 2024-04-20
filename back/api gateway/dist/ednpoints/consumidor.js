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
exports.iniciarConsumidor = void 0;
const amqp = __importStar(require("amqplib/callback_api"));
const EXCHANGE_NAME = "exchange-microservicios";
const ROUTING_KEY = "microservicio-usuario";
const QUEUE_NAME = "queue-microservicio-usuario";
function iniciarConsumidor() {
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
exports.iniciarConsumidor = iniciarConsumidor;
