let token = sessionStorage.getItem('token');
let login = document.getElementById('entrar');
let logoff = document.getElementById('sair');
let divOs = document.getElementById('divOs');

if(token == null){
    window.alert("NECESSÁRIO EFETUAR LOGIN");

   // window.location.href = "http://127.0.0.1:5501/TelaLogin.html" //
   window.location.href = '/TelaLogin.html'
}else{

    let user = sessionStorage.getItem('usuario').replace("\"" , ""); // tirando a primeira aspas
    let user2 = user.substring(0 , user.length -1); //retirando a segunda aspas  
    document.getElementById('usuarioMostrar').innerHTML = user2;     
    divOs.style.display = "flex";
    logoff.style.display = "flex";
    login.style.display = "none";
}



function sair(){
sessionStorage.clear('token')
sessionStorage.clear('usuario');
location.reload();
}
