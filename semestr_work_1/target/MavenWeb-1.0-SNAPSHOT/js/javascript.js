$(document).ready(function () {

    $(".main .content").css("min-height", $("html").height() - 400);

    setCurrentMenu();

    if (window.location.pathname != "/signin" && window.location.pathname != "/signup") {
        $("header").addClass("animated fadeInUp");

        if (window.location.pathname == "/catalog") {
            $(".main aside").addClass("animated fadeInUp");
            $(".main .content").addClass("animated fadeInUp");

            $("aside").sticky({topSpacing: 60, bottomSpacing: 340});

            $("aside .aside_menu li div").click(function (event) {
                event.stopPropagation();
                if ($(this).children(".menu_icon").hasClass("opened")) {
                    $(this).children(".menu_icon").removeClass("opened");
                    $(this).children(".menu_icon").addClass("closed");
                    $(this).siblings(".sub_menu").hide(250);
                }
                else {
                    $(this).children(".menu_icon").removeClass("closed");
                    $(this).children(".menu_icon").addClass("opened");

                    $(this).siblings(".sub_menu").show(250);
                }

                $('html, body').animate({
                    scrollTop: 100
                }, 500);
            });
        }
    }

    if (window.location.pathname == "/signin" || window.location.pathname == "signup") {
        $('#signin_form').on('keyup', function(e){
            if(e.which == 13) document.getElementById('signin_form').submit();
        });

        $('#signup_form').on('keyup', function(e){
            if(e.which == 13) document.getElementById('signup_form').submit();
        });
    }
});

$(window).load(function() {
    setTimeout(function() {
        $('.loader').css('display', 'none');
    }, 1000);
    $('.loader').addClass("animated slideOutUp");
    $("header").addClass("animated fadeInUp");
    $(".back_text").addClass("animated fadeInUp");
    $(".back").addClass("animated fadeInUp");

    $(window).stellar();
});

$(window).resize(function(){
    $(".main .content").css("min-height", $("html").height() - 400);
});


function filterProducts() {

    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            $(".catalog-container").html(xmlhttp.responseText);
        }
    }

    xmlhttp.onloadstart = function() {
        $(".catalog-container").removeClass("animated fadeInUp");
    }

    xmlhttp.onload = function() {
        $('html, body').animate({
            scrollTop: 0
        }, 400);
        $(".catalog-container").addClass("animated fadeInUp");
    }

    var msg = $(".filter_form").serialize();

    var pathArray = window.location.pathname.split( '/' );

    xmlhttp.open("GET", pathArray[0] + '/' + pathArray[1] + '/' + pathArray[2] + '/1' + "?ajax=1&" + msg, true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xmlhttp.send("");

    window.history.pushState(null, null, pathArray[0] + '/' + pathArray[1] + '/' + pathArray[2] + '/1' + "?" + msg);

}


function setCurrentMenu() {
    var pathArray = window.location.pathname.split( '/' );
    var uri = "/" + pathArray[1];

    $('header .menu a').each(function(){
        if ($(this).attr('href') == uri) {
            $(this).addClass('current');
            $(this).children("li").addClass('current');
        }
        else {
            $(this).removeClass('current');
            $(this).children("li").removeClass('current');
        }
    });

    $('.shop-header .inside a').each(function(){
        if ($(this).attr('href') == uri) {
            $(this).addClass('current');
            $(this).children("li").addClass('current');
        }
        else {
            $(this).removeClass('current');
            $(this).children("li").removeClass('current');
        }
    });

}


$(document).on("click", ".paginator li", function() {

    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            $(".catalog-container").html(xmlhttp.responseText);
        }
    }

    xmlhttp.onloadstart = function() {

    }

    xmlhttp.onload = function() {
        $('html, body').animate({
            scrollTop: 0
        }, 400);
        $(".catalog-container").addClass("animated fadeInUp");
    }

    var msg = $(".filter_form").serialize();

    var pathArray = window.location.pathname.split( '/' );

    xmlhttp.open("GET", pathArray[0] + '/' + pathArray[1] + '/' + pathArray[2] + '/' + $(this).attr('rel') + "?ajax=1&" + msg, true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send("");

    window.history.pushState(null, null, pathArray[0] + '/' + pathArray[1] + '/' + pathArray[2] + '/' + $(this).attr('rel') + "?" + msg);

});


/* AJAX функции */

function addToCart(articule) {

    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            $(".shop-header .cart .size").html(xmlhttp.responseText);
            $(".shop-header .cart").addClass("animated wobble");
        }
    }

    xmlhttp.onloadstart = function() {
        $(".shop-header .cart").removeClass("animated wobble");
    }

    var msg = "articule=" + articule;

    xmlhttp.open("POST", "/cart/add", true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xmlhttp.send(msg);

}

function removeFromCart(articule) {

    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            $(".shop-header .cart .size").html(xmlhttp.responseText);
            $(".shop-header .cart").addClass("animated wobble");
        }
    }

    xmlhttp.onloadstart = function() {
        $(".shop-header .cart").removeClass("animated wobble");
    }

    var msg = "articule=" + articule;

    xmlhttp.open("POST", "/cart/remove", true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xmlhttp.send(msg);

}