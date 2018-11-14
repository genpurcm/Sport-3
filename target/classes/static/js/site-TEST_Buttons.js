function myInnerHTML() {
    var x = location.hostname;
    var p = location.port;
    document.getElementById("InnerHTML-text").innerHTML= location.protocol + "//" + x + ":" + p + location.pathname + location.search;
    document.getElementById("hidden").innerHTML="HIDDEN ONLY ON Micro-Small";
    document.getElementById("hidden").style.color=orange;
};


$(document).ready(function() {
    $("#mouse").mousemove(function() {
       alert("Mouse Movement!");
    });
});

//$(document).ready(function openNewTab() {
function openNewTab() {
    window.open("/excelreader");
    console.log("JS ExcelReader Button");
    alert("JS ExcelReader Button Alert");
};

$(function DocumentReadyOpenNewTab() {
    window.open("/excelreader");
    console.log("DocumentReadyOpenNewTab ConsoleLog");
    alert("DocumentReadyOpenNewTab Alert");
});

document.getElementById("doc.getElement").onclick = openNewTab2;
function openNewTab2() {
    window.open("/excelreader");
    console.log("doc.getElement Button");
    alert("doc.getElement Button Alert");
};

function Ajax() {
    $.ajax({
        type: 'GET',
//        contentType: "application/json",
//        dataType: "json",
        url: "/excelreader",
        success: function(result){
            window.open("/excelreader", "_blank");
            console.log("Ajax Button");
            alert("Ajax Button Alert");
            System.out.println("result");
        },
    });
};

$('#Ajax2').on("click", function(){
    $.ajax({
        type: 'GET',
//        contentType: "application/json",
//        dataType: "json",
        url: "/excelreader",
        async:false
     }).done(function(result){
            console.log("Inside SUCCESS");
            console.log(result.success);
            alert(result.success);
            if (result.success == true){
                window.open("/excelreader", "_blank");
                <!--window.location.href = "/excelreader";-->
                console.log("Ajax2 Button");
                alert("Ajax2 Button Alert TRUE");
                System.out.println("Ajax2 button result");
            } else {
                alert("Ajax2 Button Alert FALSE");
                window.open("/excelreaderA");
                var result = result.success;
                $("#Ajax2P").html("<p id='error' style='color:blue'>"+"result"+"</p>");
            };
        }).fail(function(result){
             console.log("result.success");
             console.log(result.success);
             alert(result.success);
             $("#Ajax2P").html("<p id='error' style='color:red'>"+"result"+"</p>");
        });

});

//$('#Ajax2').on("click", function(){
//    $.ajax({
//        type: 'GET',
////        contentType: "application/json",
////        dataType: "json",
//        url: "/excelreader",
//        async:false,
//        success: function(result){
//            console.log("Inside SUCCESS");
//            console.log(result.success);
//            alert(result.success);
//            if (result.success == true){
//                window.open("/excelreader", "_blank");
//                <!--window.location.href = "/excelreader";-->
//                console.log("Ajax2 Button");
//                alert("Ajax2 Button Alert TRUE");
//                System.out.println("Ajax2 button result");
//            } else {
//                alert("Ajax2 Button Alert FALSE");
//            };
//        },
//        error: function(result){
//             console.log("result.success");
//             console.log(result.success);
//             alert(result.success);
//             $("#Ajax2P").html("<p id='error' style='color:red'>"+"result"+"</p>");
//        },
//    });
//})

$("a.ajax-test").on('click', function(event){
    event.preventDefault();
    event.stopPropagation();
    var newtabs = $(this).attr('target');
    var URL = $(this).attr('href');
    setTimeout(function(event){
        if (newtabs === undefined){
            alert('Open URL in the same Tab using AJAX');
            window.location.href = URL;
            console.log('Open URL in the same Tab using AJAX');
        } else if (newtabs === '_blank'){
            alert('Open URL in New Tab using AJAX');
            window.open(URL, '_blank');
            console.log('Open URL in New Tab using AJAX');
        } else {
            alert('Reload Page from Server');
            window.location.reload(true);
            console.log("Reloading the page from SERVER");
        }
    }, 500);
});

$(document).ready(function() {
  $("#JQueryButton").click(function() {
      $(this).fadeOut();
      window.open("/excelreader", "_blank");
      console.log("JQuery Button");
      alert("Jquery Button Alert");
      System.out.println("Ejecutando JQuery Button");
  });
});

function JS2() {
    console.log("JS2 Button Alert");
    alert("JS2 Button Alert");
    window.location.assign("/excelreader");
};

function JS3() {
    console.log("JS3 Button Alert");
    alert("JS3 Button Alert");
    window.open("/excelreader");
};

function JS4() {
    console.log("JS4 SELF Button");
    alert("JS4 Button Alert");
    window.open("/excelreader", "_self");
};

function DocumentWriter() {
    var myWindow = window.open("", "myWindow", "width=200,height=100");
    myWindow.document.write("<p style='color:yellow'>This is" + 'myWindow' + "</p>");
//    myWindow.opener.document.write("<p id='DocWriter' style='color:green'>This is the source window!</p>");
    myWindow.opener.document.getElementById("DocWriter").innerHTML="HIDDEN ONLY ON Micro-Small DocumentWriter";
};