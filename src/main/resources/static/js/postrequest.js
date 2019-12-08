$( document ).ready(function() {

    // SUBMIT FORM
    $("#customerForm").submit(function(event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPost();
    });


    function ajaxPost(){

        // PREPARE FORM DATA
        var formEmployeeData = {
            firstName : $("#firstname").val(),
            lastName :  $("#lastname").val(),
            email   : $("#email").val(),
            jobId   : $("#jobId").val()
        }

        // DO POST
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : window.location + "api/employees/save",
            data : JSON.stringify(formEmployeeData),
            dataType : 'json',
            success : function(result) {
                if(result.status === "Done"){
                    $.each(result.data, function(key, value){
                        let employee = "Employee id = " + value.id + ", firstname = " +
                            value.firstName + ", lastName = " + value.lastName + "<br>";
                        $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:5px 5px 5px 5px'>" +
                            "Post Successfully! <br>" +
                            "Employee's Info:" + employee + "</p>");
                    });
                }else{
                    $("#postResultDiv").html("<strong>Error</strong>");
                }
                console.log(result);
            },
            error : function(e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });

        // Reset FormData after Posting
        resetData();

    }

    function resetData(){
        $("#firstname").val("");
        $("#lastname").val("");
        $("#email").val("");
        $("#jobId").val("")
    }
})