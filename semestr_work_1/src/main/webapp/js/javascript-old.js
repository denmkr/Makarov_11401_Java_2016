var bottomned;

$(document).ready(function () {

    if (window.location.pathname != "/auth" && window.location.pathname != "/") {

        setCurrentMenu();
        setCurrentPage();

        $("aside li").addClass("animated fadeInLeft");
        $(".main > *").addClass("animated fadeInUp");

        $("aside").hover(function () {
            if (bottomned) {
                $(".main").toggleClass("translated");
                $("aside .menu li img").toggleClass("slided");
                $("aside .menu li div").toggleClass("slideda");
            }
        });


        $("aside .menu li div").click(function (event) {
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

});

$(window).load(function () {
	
});

function setCurrentMenu() {
    var pathArray = window.location.pathname.split( '/' );
    var uri = "/" + pathArray[1];

    $('aside .menu li a').each(function(){
        if ($(this).attr('href') == uri) {
            $(this).addClass('active');
            $(this).parent().addClass('active');
        }
        else {
            $(this).removeClass('active');
            $(this).parent().removeClass('active');
        }
    });

    if (uri == "/cart") $('.main .cart').addClass('active');
}

function setCurrentPage() {
    var uri = window.location.pathname;

    var pathArray = window.location.pathname.split( '/' );
    var uriNew = pathArray[pathArray.length-1];

    if (pathArray.length==4) {
        var selector = ".paginator li[rel='%d']".replace('%d', uriNew);
        var notSelector = ".paginator li[rel!='%d']".replace('%d', uriNew);
        $(selector).addClass("active");
        $(notSelector).removeClass("active");
    }
    else {
        $(".paginator li[rel='1']").addClass("active");
    }
}

/* AJAX функции */

function addToCart(article) {

    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            $(".cart .text span").html(xmlhttp.responseText);
            $(".main .cart .text").addClass("animated wobble");
        }
    }

    xmlhttp.onloadstart = function() {
        $(".main .cart .text").removeClass("animated wobble");
    }

    var msg = "article=" + article;

    xmlhttp.open("POST", "/add_to_cart", true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xmlhttp.send(msg);

}

function deleteFromCart(article) {

    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    }
    else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            $(".cart .text span").html(xmlhttp.responseText);
            $(".main .cart .text").addClass("animated wobble");
        }
    }

    xmlhttp.onloadstart = function() {
        $(".main .cart .text").removeClass("animated wobble");
    }

    xmlhttp.onloadend = function () {

        var xmlhttp2;

        if (window.XMLHttpRequest) {
            xmlhttp2 = new XMLHttpRequest();
        }
        else {
            xmlhttp2 = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xmlhttp2.onreadystatechange = function () {
            if (xmlhttp2.readyState == 4 && xmlhttp2.status == 200) {
                $(".table_panel").html(xmlhttp2.responseText);
            }
        }

        xmlhttp2.onloadstart = function() {
            $(".table_panel").removeClass("animated fadeInUp");
            $(".ajax_loader").css("display", "block");
        }

        xmlhttp2.onload = function() {
            $(".ajax_loader").css("display", "none");

            $('html, body').animate({
                scrollTop: 0
            }, 400);

            $(".table_panel").addClass("animated fadeInUp");
        }

        xmlhttp2.open("POST", "/cart", true);
        xmlhttp2.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

        xmlhttp2.send("");

    }

    var msg = "article=" + article;

    xmlhttp.open("POST", "/delete_from_cart", true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xmlhttp.send(msg);

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
            $(".table_panel").html(xmlhttp.responseText);
        }
    }

    xmlhttp.onloadstart = function() {
        $(".table_panel").removeClass("animated fadeInUp");
        $(".ajax_loader").css("display", "block");
    }

    xmlhttp.onload = function() {
        $(".ajax_loader").css("display", "none");

        $('html, body').animate({
            scrollTop: 0
        }, 400);

        $(".table_panel").addClass("animated fadeInUp");
        setCurrentPage();
    }

    var msg = $(".order_form").serialize();

    var pathArray = window.location.pathname.split( '/' );
    xmlhttp.open("POST", pathArray[0] + '/' + pathArray[1] + '/' + pathArray[2] + '/' + $(this).text(), true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xmlhttp.send(msg);

    window.history.pushState(null, null, pathArray[0] + '/' + pathArray[1] + '/' + pathArray[2] + '/' + $(this).text());

});

function stockProducts() {
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

    xmlhttp.onloadstart = function() {
        $(".table_panel").removeClass("animated fadeInUp");
        $(".ajax_loader").css("display", "block");
    }

    xmlhttp.onload = function() {
        $(".ajax_loader").css("display", "none");

        $('html, body').animate({
            scrollTop: 0
        }, 400);

        $(".table_panel").addClass("animated fadeInUp");
        setCurrentPage();
    }

    var msg = "stock=" + $(".stock_form_input").prop('checked');

    var pathArray = window.location.pathname.split( '/' );
    xmlhttp.open("POST", pathArray[0] + '/' + pathArray[1] + '/' + pathArray[2], true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xmlhttp.send(msg);

    window.history.pushState(null, null, pathArray[0] + '/' + pathArray[1] + '/' + pathArray[2]);

}

function sortProducts() {
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

    xmlhttp.onloadstart = function() {
        $(".table_panel").removeClass("animated fadeInUp");
        $(".ajax_loader").css("display", "block");
    }

    xmlhttp.onload = function() {
        $(".ajax_loader").css("display", "none");

        $('html, body').animate({
            scrollTop: 0
        }, 400);

        $(".table_panel").addClass("animated fadeInUp");
        setCurrentPage();
    }

    var msg = $(".order_form").serialize();

    var pathArray = window.location.pathname.split( '/' );
    xmlhttp.open("POST", pathArray[0] + '/' + pathArray[1] + '/' + pathArray[2], true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xmlhttp.send(msg);

    window.history.pushState(null, null, pathArray[0] + '/' + pathArray[1] + '/' + pathArray[2]);

}


function getProducts(group) {
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

    xmlhttp.onloadstart = function() {
        $(".table_panel").removeClass("animated fadeInUp");
        $(".ajax_loader").css("display", "block");
    }

    xmlhttp.onload = function() {
        $(".ajax_loader").css("display", "none");

        $('html, body').animate({
            scrollTop: 0
        }, 400);

        $(".table_panel").addClass("animated fadeInUp");
        setCurrentPage();
    }

    xmlhttp.open("POST", "/catalog/" + group, true);
    xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xmlhttp.send("");

    window.history.pushState(null, null, "/catalog/" + group);
}

 


    