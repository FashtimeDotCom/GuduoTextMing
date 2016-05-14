$(function(){
    loadPage("dashboard");
});

function loadPage(url){
    if (url !== ""){
        $('.content-wrapper').load(url);
    }
}


