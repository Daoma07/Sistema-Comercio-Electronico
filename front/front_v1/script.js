const slidePage = document.querySelector(".slidepage");
const firstNextBtn = document.querySelector("#button1");
const prevBtnSec = document.querySelector(".prev-1");
const nextBtnSec = document.querySelector(".next-1");
const prevBtnThird = document.querySelector(".prev-2");
const nextBtnThird = document.querySelector(".next-2");
const prevBtnFourth = document.querySelector(".prev-3");
const nextBtnFourth = document.querySelector(".next-3");
const prevBtnFifth = document.querySelector(".prev-4");
const submitBtn = document.querySelector(".submit");

firstNextBtn.addEventListener("click", function () {
    slidePage.style.marginLeft = "-25%";
});
nextBtnSec.addEventListener("click", function () {
    slidePage.style.marginLeft = "-50%";
});
nextBtnThird.addEventListener("click", function () {
    slidePage.style.marginLeft = "-75%";
});
nextBtnFourth.addEventListener("click", function () {
    slidePage.style.marginLeft = "-100%";
});

prevBtnSec.addEventListener("click", function () {
    slidePage.style.marginLeft = "0%";
});
prevBtnThird.addEventListener("click", function () {
    slidePage.style.marginLeft = "-25%";
});
prevBtnFourth.addEventListener("click", function () {
    slidePage.style.marginLeft = "-50%";
});
prevBtnFifth.addEventListener("click", function () {
    slidePage.style.marginLeft = "-75%";
});

submitBtn.addEventListener("click", function () {

    console.log("Click en el botón de Registrar");
    // Extraer los valores del formulario
    const nombre = document.querySelector('input[id="textsend1"]').value;
    const apellidoPaterno = document.querySelector('input[type="text"]').value;
    const apellidoMaterno = document.querySelectorAll('input[type="text"]')[1].value;
    const correoElectronico = document.querySelector('input[type="email"]').value;
    const password = document.querySelector('input[type="password"]').value; // Nueva línea
    const telefono = document.querySelector('input[type="tel"]').value;
    const estado = document.querySelectorAll('input[type="text"]')[2].value;
    const ciudad = document.querySelectorAll('input[type="text"]')[3].value;
    const codigoPostal = document.querySelectorAll('input[type="text"]')[4].value;
    const fechaNacimiento = document.querySelector('input[type="date"]').value;
    const genero = document.querySelector('select').value;
    const colonia = document.querySelectorAll('input[type="text"]')[5].value;
    const calle = document.querySelectorAll('input[type="text"]')[6].value;
    const numero = document.querySelectorAll('input[type="text"]')[7].value;
    const action = "registrar";

    console.log(numero);

    // Construir el objeto con la información del formulario
    const formData = {
        nombres: nombre,
        apellido_paterno: apellidoPaterno,
        apellido_materno: apellidoMaterno,
        correo: correoElectronico,
        password: password,
        telefono: telefono,
        estado: estado,
        ciudad: ciudad,
        codigo_postal: codigoPostal,
        fecha_nacimiento: fechaNacimiento,
        sexo: genero,
        colonia: colonia,
        calle: calle,
        numero: numero,
        action
    };


    // Enviar los datos a través de una solicitud fetch
    fetch('http://localhost:3001/api/usuario/registrar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
        .then(response => response.json())
        .then(data => {
            // Manejar la respuesta de la API
            alert(data.msg);
            window.location.href = 'login.html';

        })
        .catch(error => {
            location.reload();
            console.error('Error al enviar los datos:', error);
            // Manejar el error
        });
});

function success() {
    if (document.getElementById("textsend").value !== "" && document.getElementById("phone").value !== "") {
        document.getElementById('next-1').disabled = false;
    } else {
        document.getElementById('next-1').disabled = true;
    }
}

function success1() {
    if (document.getElementById("textsend1").value === "") {
        document.getElementById('button1').disabled = true;
    } else {
        document.getElementById('button1').disabled = false;
    }
}

function ValidateEmail() {
    var validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    if (document.getElementById("textsend").value.match(validRegex)) {
        //alert("Valid email address!");
        document.form1.text1.focus();
        document.getElementById('button').disabled = true;
        return true;
    } else {
        alert("Invalid email address!");
        document.form1.text1.focus();
        document.getElementById('button').disabled = false;
    }
}

document.getElementById("textsend").addEventListener("input", success);
document.getElementById("phone").addEventListener("input", success);
