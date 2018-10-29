$(function () {
  $(".changeBtn").click(function () {
    var l = $(".langSelect").val();
    var url = window.location.href;
    if(url.includes("=")){
        var index = url.indexOf("=");
        var lang = url.substring(index, index + 3);
        var newUrl = url.replace(lang,'=' + l);
        location.href = newUrl;
    }else{
    location.href = addParameterToURL("lang=" + l);
    }
  });
});
function addParameterToURL(param){
    url = location.href;
    url += (url.split('?')[1] ? '&':'?') + param;
    return url;
}