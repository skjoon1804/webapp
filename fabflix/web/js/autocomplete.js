$(document).ready(function(){
    $(function(){
        $("#f_title").autocomplete({
            source:function(request,response){
                $.ajax({
                    url : "autocom",
                    type: "GET",
                    data : { term: request.term},
                    dataType: "json",
                    success: function(data) {
                        response(data);
                    }
                });
            }
        });
    });

    $('.title_page').click(function (event) {

        event.preventDefault();
        window.open($(this).attr("href"), "popupWindow", "width=600,height=600,scrollbars=yes");
    });
});