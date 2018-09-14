var id = 1;
var id1 = 1;
var id2 = 1;
var id3 = 1;
function image_like_feedbck1(){

   if (id%2==0)
   {
       document.getElementById("image_like1").src = '../static/images/like/like' + 1 + '.png'; //动态设定src images/like/like1.png
       id++;
       var a = parseInt(document.getElementById("first_like").innerText);
       a--;
       document.getElementById("first_like").innerText=a.toString();
   }
   else
   {
       document.getElementById("image_like1").src = '../static/images/like/like' + 2 + '.png'; //动态设定src images/like/like2.png
       id++;
       var a = parseInt(document.getElementById("first_like").innerText);
       a++;
       document.getElementById("first_like").innerText=a.toString();
   }


}
function image_like_feedbck2(){

    if (id1%2==0)
    {
        document.getElementById("image_like2").src = '../static/images/like/like' + 1 + '.png'; //动态设定src images/like/like1.png
        id1++;
        var a = parseInt(document.getElementById("second_like").innerText);
        a--;
        document.getElementById("second_like").innerText=a.toString();
    }
    else
    {
        document.getElementById("image_like2").src = '../static/images/like/like' + 2 + '.png'; //动态设定src images/like/like2.png
        id1++;
        var a = parseInt(document.getElementById("second_like").innerText);
        a++;
        document.getElementById("second_like").innerText=a.toString();
    }


}
function image_like_feedbck3(){

    if (id2%2==0)
    {
        document.getElementById("image_like3").src = '../static/images/like/like' + 1 + '.png'; //动态设定src images/like/like1.png
        id2++;
        var a = parseInt(document.getElementById("third_like").innerText);
        a--;
        document.getElementById("third_like").innerText=a.toString();


    }
    else
    {
        document.getElementById("image_like3").src = '../static/images/like/like' + 2 + '.png'; //动态设定src images/like/like2.png
        id2++;
        var a = parseInt(document.getElementById("third_like").innerText);
        a++;
        document.getElementById("third_like").innerText=a.toString();
    }


}
function image_like_feedbck4(){

    if (id3%2==0)
    {
        document.getElementById("image_like4").src = '../static/images/like/like' + 1 + '.png'; //动态设定src images/like/like1.png
        id3++;
        var a = parseInt(document.getElementById("fouth_like").innerText);
        a--;
        document.getElementById("fouth_like").innerText=a.toString();
    }
    else
    {
        document.getElementById("image_like4").src = '../static/images/like/like' + 2 + '.png'; //动态设定src images/like/like2.png
        id3++;
        var a = parseInt(document.getElementById("fouth_like").innerText);
        a++;
        document.getElementById("fouth_like").innerText=a.toString();
    }


}