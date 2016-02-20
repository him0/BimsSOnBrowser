(function(){

    var set_sample1 = function(){
        $("#code").get(0).value ="/* Simple sample */\nint a;\na := 1;\nprint a";
    }



    var set_sample2 = function(){
        $("#code").get(0).value ="/* the bubble sort program with BimsS */\n\n// Define temporary variables\nint i;\ni := 0;\nint j;\nj := 0;\nint tmp;\n\n// Define the unsorted data\nint length;\nlength := 10;\nint data [length];\ndata[0] := 1;\ndata[1] := 3;\ndata[2] := 9;\ndata[3] := 0;\ndata[4] := 2;\ndata[5] := 6;\ndata[6] := 5;\ndata[7] := 7;\ndata[8] := 4;\ndata[9] := 8;\n\n// Bubble Sort\nwhile (i < length) do {\n  j := length - 1;\n  while (i < j) do {\n    if (data[j] < data[j - 1]) then {\n      tmp := data[j];\n      data[j] := data[j - 1];\n      data[j - 1] := tmp;\n    } else {\n      skip;\n    };\n    j := j - 1;\n  };\n  i := i + 1;\n};\n\n// Print result\ni := 0;\nwhile (i < length) do {\n  print data[i];\n  i := i + 1\n};\n";
    }

    set_sample1();
    $("#smpl1_btn").on("click", set_sample1);
    $("#smpl2_btn").on("click", set_sample2);

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
