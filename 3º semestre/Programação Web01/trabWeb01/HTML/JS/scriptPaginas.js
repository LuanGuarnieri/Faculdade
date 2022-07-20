
// pegando para o cadastro

let utilizarPaginacao = false;

let nome = document.querySelector('#nome');
let validNome = false;

let email = document.querySelector('#email')
let validEmail = false;

let usuario = document.querySelector('#usuario');
let valideUsuario = false;

let senha = document.querySelector('#senha');
let validSenha = false;

let tabela = document.querySelector("#tblListar");

let msgError = document.querySelector('#msgFalse');
let msgSucess = document.querySelector('#msgTrue');

let termo = document.getElementById('termo');


//pegando para editar 
let alert = document.querySelector('#alertbackgroud'); //

let nomeAlert = document.querySelector('#nomeAlert');

let emailAlert = document.querySelector('#emailAlert')

let usuarioAlert = document.querySelector('#usuarioAlert');

let senhaAlert = document.querySelector('#senhaAlert')

let editItemInfos = { item: null, i: 0 }

alert.style.display = 'none' 


//começo das funçoes
function verificar(){

    if (nome.value.length >= 5) {
        nome.setAttribute('style', 'border-bottom: solid #00ff88');
        validNome = true;
    }else{
        nome.setAttribute('style', 'border-bottom: solid rgb(241, 57, 57)');
        validNome = false;
    }

    if (senha.value.length >= 5) {
        senha.setAttribute('style', 'border-bottom: solid #00ff88');
        validSenha = true;
    }else{
        senha.setAttribute('style', ' border-bottom: solid rgb(241, 57, 57)');
        validSenha = false;
    }

    if ( usuario.value != '' && usuario.value.length >= 5) {
        usuario.setAttribute('style', ' border-bottom: solid #00ff88');
        valideUsuario = true;
    }else{
        usuario.setAttribute('style', ' border-bottom: solid rgb(241, 57, 57)');
        valideUsuario = false;
    }
    if (email != '' && email.value.includes('@')) {
         email.setAttribute('style', 'border-bottom: solid #00ff88');
        validEmail = true;
    }else{
        email.setAttribute('style', ' border-bottom: solid rgb(241, 57, 57');
        validEmail = false;
    }
}

function cadastrar(){
    if(validNome && validSenha && validEmail && valideUsuario && termo.checked){

        let listaUser = JSON.parse(localStorage.getItem('listaUser') || '[]');

        listaUser.push(
           {nome : nome.value,
            user : usuario.value,
            email : email.value,
            senha : senha.value,
           }

           
        )

        localStorage.setItem('listaUser', JSON.stringify(listaUser))


        msgError.setAttribute('style' , 'display: none' );
        msgSucess.innerHTML = '<Strong>Cadastrando Usuario...</Strong>'
        msgSucess.setAttribute('style' , 'display: block');

           setTimeout(() => {
               window.location.href = '#' //colocar href para tela de login    
           }, 6000);

        
    }else{  
        msgSucess.setAttribute('style' , 'display: none');
        msgError.setAttribute('style' , 'display: block' );
        msgError.innerHTML = '<Strong>Preencha os campos corretamente!</Strong>'
    }
}


    window.onload = function () { //adicionando na tabela

        let userLista = JSON.parse(window.localStorage.getItem('listaUser'));
        let tbody = document.getElementById('tbody');

        for (i = 0; i <userLista.length; i++) {
            
           tbody.innerHTML += "<tr>"+ "<td id='nomeTable'>" + userLista[i].nome + "</td><td id='userTable'>" + userLista[i].user + "</td><td id='emailTlb'>" + userLista[i].email + "</td><td id='tresh'>" + "<img id='lixeira' onclick ='deleteItem("+i+")' src = 'icons/lixeira.png'/>" + "</td>" + "</td><td id='lapis'>" + "<img id='editar' onclick ='editeItem("+i+")' src = 'icons/lapis.png'/>" + "</td>" + "</tr>"
          
         }


         let num = 0;
         let pag = document.getElementById('p');
     
         for (i = 0; i < userLista.length; i++) {
             if(i%5 == 0){
                 num = num + 1;
                 pag.innerHTML += "<button onclick = 'teste()' >" + num + "</button>";
             }
     
         }       
    };

    function teste(){
        window.alert('ok');
    }




function deleteItem(i){
    var listaUser = JSON.parse(localStorage.getItem('listaUser') || '[]');



    //Excluir elemento do array
    var indice = i;
    listaUser.splice(indice, 1);
    
    
    
    localStorage.setItem("listaUser",JSON.stringify(listaUser))
     
    location.reload();

}

function editeItem(i) {
    let userLista = JSON.parse(window.localStorage.getItem('listaUser'));

    editItemInfos.item = userLista[i]

    editItemInfos.i = i

    alert.style.display = 'flex'

    nomeAlert.value = editItemInfos.item.nome

    emailAlert.value = editItemInfos.item.email

    usuarioAlert.value = editItemInfos.item.user

    validEmail =  false;
    validNome = false;
    valideUsuario = false;


}

function alertCancelar() {

    alert.style.display = 'none'

}

function alertSalvar() {

    if (!validEmail || !validNome || !valideUsuario || !validSenha) {

        return;

    }

    let userLista = JSON.parse(window.localStorage.getItem('listaUser'));

    editItemInfos.item.nome = nomeAlert.value

    editItemInfos.item.email = emailAlert.value

    editItemInfos.item.user = usuarioAlert.value

    editItemInfos.item.senha = senhaAlert.value

    userLista[editItemInfos.i] = editItemInfos.item

    localStorage.setItem('listaUser', JSON.stringify(userLista));

    location.reload();
}

function verificarAlert() { //
    if (nomeAlert.value.length >= 5) {
        nomeAlert.setAttribute('style', 'border-bottom: solid #00ff88');
        validNome = true;
    }else{
        nomeAlert.setAttribute('style', ' border-bottom: solid rgb(241, 57, 57');
        validNome = false;
    }

    if (usuarioAlert.value.length >= 5) {
        usuarioAlert.setAttribute('style', 'border-bottom: solid #00ff88');
        valideUsuario = true;
    }else{
        usuarioAlert.setAttribute('style', ' border-bottom: solid rgb(241, 57, 57');
        valideUsuario = false;
    }
    if  (emailAlert.value.length >=  10) {
        emailAlert.setAttribute('style', 'border-bottom: solid #00ff88');
        validEmail = true;
    }else{
        emailAlert.setAttribute('style', ' border-bottom: solid rgb(241, 57, 57');
        validEmail = false;
    }
    if  (senhaAlert.value.length >=  5) {
        senhaAlert.setAttribute('style', 'border-bottom: solid #00ff88');
        validSenha = true;
    }else{
        senhaAlert.setAttribute('style', ' border-bottom: solid rgb(241, 57, 57');
        validSenha = false;
    }

}


var dados = JSON.parse(window.localStorage.getItem('listaUser'));


var tamanhoPagina = 5;
var pagina = 0;

function paginar(){

}


function pesquisar(){
    let t = document.getElementById('tbody')
    let tamanho = t.rows.length
    console.log(typeof tamanho)
  
    console.log(t.rows.length);
      
        for (i = 0; i < tamanho; i++) {
           console.log('indice ' + i);
            t.deleteRow(i);
            console.log(t.rows.length);
            tamanho = tamanho -1;
            console.log(tamanho)
 
    }
    
} 
