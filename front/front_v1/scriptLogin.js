
document.getElementById('loginForm').addEventListener('submit', function (event) {

    event.preventDefault();


    var email = document.getElementById('emailInput').value;
    var password = document.getElementById('passwordInput').value;

    const credenciales = {
        correo: email,
        contrasenia: password
    }


    fetch('http://localhost:3001/api/usuario/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(credenciales)
    })
        .then(response => {

            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Error al iniciar sesión');
            }
        })
        .then(data => {

            console.log(data);
        })
        .catch(error => {

            console.error(error);
        });
});