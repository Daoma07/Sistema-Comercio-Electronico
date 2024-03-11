const slidePage = document.querySelector(".slidepage");
const firstNextBtn =document.querySelector(".nextBtn");
const prevBtnSec =document.querySelector(".prev-1");
const nextBtnSec =document.querySelector(".next-1");
const prevBtnThird =document.querySelector(".prev-2");
const nextBtnThird =document.querySelector(".next-2");
const prevBtnFourth =document.querySelector(".prev-3");
const nextBtnFourth =document.querySelector(".next-3");
const prevBtnFifth  =document.querySelector(".prev-4");
const submitBtn =document.querySelector(".submit");

firstNextBtn.addEventListener("click", function(){
    slidePage.style.marginLeft = "-25%";
});
nextBtnSec.addEventListener("click", function(){
    slidePage.style.marginLeft = "-50%";
});
nextBtnThird.addEventListener("click", function(){
    slidePage.style.marginLeft = "-75%";
});
nextBtnFourth.addEventListener("click", function(){
    slidePage.style.marginLeft = "-100%";
});

prevBtnSec.addEventListener("click", function(){
    slidePage.style.marginLeft = "0%";
});
prevBtnThird.addEventListener("click", function(){
    slidePage.style.marginLeft = "-25%";
});
prevBtnFourth.addEventListener("click", function(){
    slidePage.style.marginLeft = "-50%";
});
prevBtnFifth.addEventListener("click", function(){
    slidePage.style.marginLeft = "-75%";
});
submitBtn.addEventListener("click", function(){
    setTimeout(function(){
        alert("Se ha registrado Exitosamente");
        location.reload();
    },800);
});

function success() {
    if(document.getElementById("textsend").value==="") { 
           document.getElementById('button').disabled = true; 
       } else { 
           document.getElementById('button').disabled = false;
       }
   }

   function success1() {
    if(document.getElementById("textsend1").value==="") { 
           document.getElementById('button1').disabled = true; 
       } else { 
           document.getElementById('button1').disabled = false;
       }
   }

   function ValidateEmail() {

    var validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
  
    if(document.getElementById("textsend").value===(document.value.match(validRegex))) { 
  
      alert("Valid email address!");
  
      document.form1.text1.focus();
      
      document.getElementById('button').disabled = true; 
      return true
      
    } else {
  
      alert("Invalid email address!");
  
      document.form1.text1.focus();
  
      document.getElementById('button').disabled = false; 
  
    }
  
  }