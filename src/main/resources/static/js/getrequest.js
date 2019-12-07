$( document ).ready(function() {

    // GET REQUEST
    $("#getAllCustomerId").click(function(event){
        event.preventDefault();
        ajaxGet();
    });

    // DO GET
    function ajaxGet(){
        $.ajax({
            type : "GET",
            url : window.location + "api/employees",
            success: function(result){
                if(result.status === "Done"){
                    $.each(result.data, function(key, value){
                        var employee = "Employee id = " + value.id + ", firstname = " +
                            value.firstName + ", lastName = " + value.lastName + "<br>";
                        $('#getResultDiv .list-group').append('<li><h4 class="list-group-item">'+employee+'</h4></li>')
                    });
                    console.log("Success: ", result);
                }else{
                    $("#getResultDiv").html("<strong>Error</strong>");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                $("#getResultDiv").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });
    }
})