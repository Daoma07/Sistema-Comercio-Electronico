import { Router } from 'express';
import { loginUsuario, nuevoUsuario } from '../controllers/usuario.controllers';


const router = Router();

router.post('/registrar', nuevoUsuario);
router.post('/login', loginUsuario)

export default router;
