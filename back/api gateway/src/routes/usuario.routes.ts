import { Router } from 'express';
import { loginUsuario, registarUsuario } from '../controllers/usuario.controllers';


const router = Router();

router.post('/registrar', registarUsuario);
router.post('/login', loginUsuario);

export default router;
