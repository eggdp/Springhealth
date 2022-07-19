// JavaScript Document
//슬라이드 메뉴바
$('.main_menu>li').mouseover(function(){
    $(this).children('.sub_menu').stop().slideDown('slow');
});
$('.main_menu>li').mouseleave(function(){
    $(this).children('.sub_menu').stop().slideUp('slow');
});

$(document).ready(function(){
    //메인 이미지 슬라이드
    //초기정렬
    $('.slide').each(function(index){
        $(this).css('top',-index*400);
    });
    //무한 반복 슬라이더
    setInterval(function(){
        $('.slide').each(function(index){
            $(this).show().animate({top:400-index*400},'slow');
        });
        $('.slide').eq(4).hide().animate({top:-1600},'slow');
        $('.slide').first().appendTo($('#main_slide_box'));
    },2000);
});

//팝업배너띄우기
$('.partner_img').click(function(){
    $('#modal').addClass('active');
});
$('#modal>.body>button').click(function(){
    $('#modal').removeClass('active');
});
