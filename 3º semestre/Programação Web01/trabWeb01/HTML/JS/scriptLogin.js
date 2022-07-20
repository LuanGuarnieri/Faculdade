var btn = document.querySelector('#btnLogin');

let btnSair = document.querySelector('#sair');

//inicio função entrar
function entrar(){

    if(sessionStorage.getItem('token') != null){
        window.alert('Já exite um usuario logado')
        
    }


    let usuario = document.querySelector('#usuario');
    let labelUsuario = document.querySelector('#userLabel');

    let login = document.querySelector('#entrar');
    let os = document.querySelector('#divOs');
    let sair = document.querySelector('#sair');

    let senha = document.querySelector('#senha');
    let labelSenha = document.querySelector('#senhaLabel');

    let msgError = document.querySelector('#msgError');
    let msgValided = document.querySelector('#msgValided');

    let listaUser = []; //criando array vazio

    let userValid = {
        nome : '',
        user : '',
        email : '',
        senha: '',
    }

    listaUser = JSON.parse(localStorage.getItem('listaUser')); // listaUser recebendo do localStorange

    if(usuario.value == null || usuario.value == "" &&  senha.value == null || senha.value == ""){

        usuario.setAttribute('style', 'border-bottom: solid rgb(241, 57, 57)')
        labelUsuario.setAttribute('style', 'color: rgb(241, 57, 57)')
    
        senha.setAttribute('style', 'border-bottom: solid rgb(241, 57, 57)')
        labelSenha.setAttribute('style', 'color: rgb(241, 57, 57)')

        msgValided.setAttribute('style' , 'display: none')
        msgError.setAttribute('style' , 'display: block')
        msgError.innerHTML = 'Usuario ou senha Inválida!'
        usuario.focus();
         return false;
    }else{
        senha.setAttribute('style', 'border-bottom: solid #00ff88');
        labelSenha.setAttribute('style', 'color: solid #00ff88');
        usuario.setAttribute('style', 'border-bottom: solid #00ff88');
        labelUsuario.setAttribute('style', 'color: solid #00ff88');
    }


    listaUser.forEach(item => {
        if(usuario.value == item.user && senha.value == item.senha){
            userValid = {
                nome : item.nome,
                user: item.user,
                email : item.email,
                senha: item.senha,
            }
        }
    });

    if (usuario.value == userValid.user && senha.value ==userValid.senha) { 
        
        login.setAttribute('style' , 'display: none');
        os.setAttribute('style' , 'display: flex');
        sair.setAttribute('style' , 'display: flex');

        let token = Math.random().toString(16)
        sessionStorage.setItem('token' , token) 
        sessionStorage.setItem('usuario' ,JSON.stringify(usuario.value));


        
        msgError.setAttribute('style' , 'display: none')
        msgValided.setAttribute('style' , 'display: block')
        msgValided.innerHTML = 'Efetuando login!' 


        setTimeout(() => {
            location.reload(); 
        }, 3000);

        window.location.href = "#"; //ver onde ira jogar a pag

    }else{
        usuario.setAttribute('style', 'border-bottom: solid rgb(241, 57, 57)')
        labelUsuario.setAttribute('style', 'color: rgb(241, 57, 57)')
    
        senha.setAttribute('style', 'border-bottom: solid rgb(241, 57, 57)')
        labelSenha.setAttribute('style', 'color: rgb(241, 57, 57)')

        msgValided.setAttribute('style' , 'display: none')
        msgError.setAttribute('style' , 'display: block')
        msgError.innerHTML = 'Usuario ou senha Inválida!'
        usuario.focus();

    }


}


function sair(){
    let os = document.querySelector('#divSair')
    os.setAttribute('style' , 'display:none');
    localStorage.removeItem('token');

    setTimeout(() => {
        window.location.href = '#'; // colocar pagina 
    }, 2000);

}



