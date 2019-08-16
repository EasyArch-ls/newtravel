function qiehuan() {
    document.getElementById("qiehuan").style.display = 'block';
}

function quxiao() {
    document.getElementById("qiehuan").style.display = 'none';
}

var cur = 'tehui0';
var cur1 = 'a0';

function tehui(tehui, a) {
    document.getElementById(cur1).className = '';
    document.getElementById(cur).style.display = 'none';
    document.getElementById(a).className = 'Fnavon';
    document.getElementById(tehui).style.display = 'block';
    cur = tehui;
    cur1 = a;
}

var chucur = 'chujing0';
var chucur1 = 'chujinga0';
function chujing(chujing, a) {
    document.getElementById(chucur1).className = '';
    document.getElementById(chucur).style.display = 'none';
    document.getElementById(a).className = 'Ynavon';
    document.getElementById(chujing).style.display = 'block';
    chucur = chujing;
    chucur1 = a;
    document.getElementById("chujingsearch").href=houtaiurl+'/listinfo/search?content='+document.getElementById(chucur1).innerHTML+'&city='+document.getElementById("c").innerHTML;;
}

var guoneicur = 'guonei0';
var guoneicur1 = 'guoneia0';

function guonei(guonei, a) {
    document.getElementById(guoneicur1).className = '';
    document.getElementById(guoneicur).style.display = 'none';
    document.getElementById(a).className = 'Bnavon';
    document.getElementById(guonei).style.display = 'block';
    guoneicur = guonei;
    guoneicur1 = a;
    document.getElementById("guoneisearch").href=houtaiurl+'/listinfo/search?content='+document.getElementById(guoneicur1).innerHTML+'&city='+document.getElementById("c").innerHTML;;

}

var dangdicur = 'dangdi0';
var dangdicur1 = 'dangdia0';

function dangdi(dangdi, a) {
    document.getElementById(dangdicur1).className = '';
    document.getElementById(dangdicur).style.display = 'none';
    document.getElementById(a).className = 'Rnavon';
    document.getElementById(dangdi).style.display = 'block';
    dangdicur = dangdi;
    dangdicur1 = a;
    document.getElementById("dangdisearch").href=houtaiurl+'/listinfo/search?content='+document.getElementById(dangdicur1).innerHTML+'&city='+document.getElementById("c").innerHTML;;

}
var houtaiurl='http://localhost:8080';
function detail(id){
    sessionStorage.detail=id;
    window.open(houtaiurl+'/detail?'+id.split("&")[0]);
}

function login() {
    var account=document.getElementById("account").value;
    var password=document.getElementById("password").value;
    if (account===''&&password===''){
        alert("账号不能为空")
        return;
    }else {

        var login={};
        login.uname=account;
        login.password=password;
        var logininfo=JSON.stringify(login);
        $.ajax({
            url: houtaiurl + '/loginto',
            type: "POST",
            contentType: 'application/json;charset=utf-8',
            data: logininfo,
            success: function (ReceivedData) {
                alert(ReceivedData)
                var i=ReceivedData.split("~");
                if(i[0]==='欢迎您的到来!!!'){
                    sessionStorage.obj=i[1];
                    window.location.href=houtaiurl+'/travel';
                }

            }
        })
    }
}
function register() {
    var account=document.getElementById("reaccount").value;
    var password=document.getElementById("repassword").value;
    if (account===''&&password===''){
        alert("账号不能为空")
        return;
    }else {
        var login={};
        login.uname=account;
        login.password=password;
        var logininfo=JSON.stringify(login);
        $.ajax({
            url: houtaiurl + '/register',
            type: "POST",
            contentType: 'application/json;charset=utf-8',
            data: logininfo,
            success: function (ReceivedData) {
                alert(ReceivedData)
            }
        })
    }
}
