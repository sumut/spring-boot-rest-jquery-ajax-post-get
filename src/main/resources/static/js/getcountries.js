$(document).ready(function() {

    // GET REQUEST
    $("#regionId").change(function (event) {
        event.preventDefault();

        let regionId = $(this).find(":selected").val();

        console.log("regionId", regionId);

        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/regions/api/" + regionId,
            dataType: 'json',
            success: function (result) {
                if (result.status === "Done") {
                    let html = '';
                    $.each(result.data, function (key, value) {
                        html += '<option value="' + value.countryName + '">'
                            + value.countryName
                            + '</option>';
                    });
                    $('#countryId').html(html);
                    console.log("Success: ", result)
                } else {
                    $("#ifError").html("<strong>Error</strong>");
                    console.log("Fail: ", result);
                }
            },
            error: function (e) {
                $("#ifError").html("<strong>Error</strong>");
                console.log("ERROR: ", e);
            }
        });

    });

})