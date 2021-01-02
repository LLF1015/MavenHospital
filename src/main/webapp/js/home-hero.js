var imglist = document.getElementById("imags")
var imgs=document.getElementById("imags").getElementsByTagName("li");
var icons = document.getElementById("icons").getElementsByTagName("li");
var timer;
var left = 0;
imglist.style.marginLeft = left + 'px';
run();

function run() {
    if(left <= -1600) {
        imglist.style.marginLeft = left + 'px';
        left = 0;

    }
    //设置自动移动时间
    var n = (left % 800== 0) ? 600 : 10;
    var m = Math.floor(-left / 800);
    changimg();
    changicon(m);
    left -= 10; //移动频率
    timer = setTimeout(run, n);
}

function changimg() {
    imglist.style.marginLeft = left + 'px';
}
//改变按钮颜色
function changicon(m) {
    for(var i = 0; i < icons.length; i++) {
        icons[i].style.backgroundColor = "";
    }
    icons[m].style.backgroundColor="red";
}
//移动图片
for(var i = 0; i < imgs.length; i++) {
    (function(i) {
        imgs[i].onmouseover = function() {
            clearTimeout(timer);
            left = -i * 800;
            changimg();
            changicon(i);
        }
        imgs[i].onmouseout = function() {
            run();
        }
    })(i)

}
//按动按钮
for(var i = 0; i < icons.length; i++) {
    (function(i) {
        icons[i].onmouseover = function() {
            clearTimeout(timer);
            left = -i * 800;
            changimg();
            changicon(i);
        }
        icons[i].onmouseout = function() {
            run();
        }
    })(i)

}