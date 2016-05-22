var page;

$(document).ready(function () {

    $("aside .menu li .elem").click(function (event) {
        event.stopPropagation();
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

 


    