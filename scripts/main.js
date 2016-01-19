(function(){
    $("#code").get(0).value ="int a;\na := 1;\nprint a"

    $("#reset_btn").on("click", function(){
        if(window.confirm("OK?")){
            $("#code").get(0).value = "";
        }
    });

    $("#run_btn").on("click", function(){
        $.ajax({
    		url: "http://0.0.0.0:4567/api",
            data: {
                code: $("#code").get(0).value
            }
    	}).done(function(data){
            $("#result").get(0).value = data;
    	}).fail(function(data){
            alert("error!");
            $("#result").get(0).value = "error!";
    	});
    })
})();
