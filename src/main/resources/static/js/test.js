//서브메뉴 슬라이드
$(function(){
    $('#menu>ul>li').mouseover(function(){
        $(this).children('.submenu').stop().slideDown(500);
    });
    $('#menu>ul>li').mouseleave(function(){
        $(this).children('.submenu').stop().slideUp(500);
    });
});