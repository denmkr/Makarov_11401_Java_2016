var groupId = "";

$(document).ready(function () {

    setCurrentMenu();

    if (window.location.pathname != "/signin" && window.location.pathname != "/signup" && window.location.pathname != "/admin") {
        $("header").addClass("animated fadeInUp");

        var pathArray = window.location.pathname.split( '/' );

        if (pathArray[1] == "catalog") {
            $(".main .content").css("min-height", $("html").height() - 400);

            $(".main aside").addClass("animated fadeInUp");
            $(".main .content").addClass("animated fadeInUp");

            $("aside").sticky({topSpacing: 60, bottomSpacing: 340});

            $("aside .aside_menu li div").click(function (event) {

                groupId = $(this).children("a").attr('rel');
                filterProducts();

                $("aside .aside_menu li div").removeClass('current');
                $(this).addClass('current');
                // $(this).parent("li").parent("ul").siblings("ul").children("li").children("div").removeClass('current'); find()

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

    if (window.location.pathname != "/signin" && window.location.pathname != "/signup" && window.location.pathname != "/admin") {
        $(window).stellar();
    }
});

$(window).resize(function() {
    var pathArray = window.location.pathname.split( '/' );

    if (pathArray[1] == "catalog") {
        $(".main .content").css("min-height", $("html").height() - 400);
    }
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
        $(".catalog-container").removeClass("animated fadeIn");
    }

    xmlhttp.onload = function() {
        $('html, body').animate({
            scrollTop: 0
        }, 400);
        $(".catalog-container").addClass("animated fadeIn");
    }

    var msg = $(".filter_form").serialize();

    var pathArray = window.location.pathname.split( '/' );

    if (groupId === null) {
        groupId = "";
    }

    xmlhttp.open("GET", pathArray[0] + '/' + pathArray[1] + '/' + pathArray[2] + '/1' + "?ajax=1&" + "groupId=" + groupId + "&" + msg, true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xmlhttp.send("");

    window.history.pushState(null, null, pathArray[0] + '/' + pathArray[1] + '/' + pathArray[2] + '/1' + "?" + "groupId=" + groupId + "&" + msg);

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

$(document).on("click", ".breadcrumbs li", function() {

    groupId = $(this).children("a").attr('rel');
    filterProducts();

    $("aside .aside_menu li div").removeClass('current');
    $(this).addClass('current');

});

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
        $(".catalog-container").addClass("animated fadeIn");
    }

    var msg = $(".filter_form").serialize();

    if (groupId === null) {
        groupId = "";
    }

    var pathArray = window.location.pathname.split( '/' );

    xmlhttp.open("GET", pathArray[0] + '/' + pathArray[1] + '/' + pathArray[2] + '/' + $(this).attr('rel') + "?ajax=1&" + "groupId=" + groupId + "&" + msg, true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlhttp.send("");

    window.history.pushState(null, null, pathArray[0] + '/' + pathArray[1] + '/' + pathArray[2] + '/' + $(this).attr('rel') + "?" + "groupId=" + groupId + "&" + msg);

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
            $(".shop-header .cart").addClass("animated flash");
        }
    }

    xmlhttp.onloadstart = function() {
        $(".shop-header .cart").removeClass("animated flash");
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
            $(".shop-header .cart").addClass("animated flash");

            getCart();
        }
    }

    xmlhttp.onloadstart = function() {
        $(".shop-header .cart").removeClass("animated flash");
    }

    var msg = "articule=" + articule;

    xmlhttp.open("POST", "/cart/remove", true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xmlhttp.send(msg);

}

function getCart() {

    var xmlhttp2;
    if (window.XMLHttpRequest) {
        xmlhttp2 = new XMLHttpRequest();
    }
    else {
        xmlhttp2 = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp2.onreadystatechange = function () {
        if (xmlhttp2.readyState == 4 && xmlhttp2.status == 200) {
            $(".cart-container").html(xmlhttp2.responseText);
        }
    }

    xmlhttp2.onloadstart = function() {
        $(".cart-container").removeClass("animated fadeInUp");
    }

    xmlhttp2.onload = function() {
        $(".cart-container").addClass("animated fadeInUp");
    }


    xmlhttp2.open("GET", window.location.pathname + "?ajax=1", true);
    xmlhttp2.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xmlhttp2.send("");

}