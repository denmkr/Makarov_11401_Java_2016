var page;

$(document).ready(function () {

    $("aside .menu li").addClass("animated fadeInLeft");

    $("aside .menu li .elem").click(function (event) {


        if ($(this).children(".menu_icon").hasClass("opened")) {
            $(this).children(".menu_icon").removeClass("opened");
            $(this).children(".menu_icon").addClass("closed");

            $(this).siblings(".sub_menu").toggle(250);
        }
        else {
            $(this).children(".menu_icon").removeClass("closed");
            $(this).children(".menu_icon").addClass("opened");

            $(this).siblings(".sub_menu").toggle(250);
        }

        event.stopPropagation();

        $("aside .menu li .elem").removeClass('current');
        $(this).addClass('current');

        page = $(this).attr("rel");
        getPage();

    });

});

$(window).load(function() {
    setTimeout(function() {
        $('.loader').css('display', 'none');
    }, 1000);
    $('.loader').addClass("animated slideOutUp");
});

function getPage() {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            $(".table_panel").html(xmlhttp.responseText);
        }
    }

    xmlhttp.onload = function() {

        $('html, body').animate({
            scrollTop: 0
        }, 400);

        $(".table_panel").addClass("animated fadeInUp");
    }

    xmlhttp.open("POST", "/admin/" + page, true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xmlhttp.send("");

    window.history.pushState(null, null, "/admin/" + page);
}

 


    