<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>MQTT</title>
<!-- Bootstrap Core CSS -->
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
<!-- Btn CSS --><!-- 동작안되는 중 -->
<link href="/resources/dist/css/btn.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<body>
<!-- <ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
  <li><a data-toggle="tab" href="#menu1">Menu 1</a></li>
</ul>

<div class="tab-content">
  <div id="home" class="tab-pane fade in active">
    <h3>HOME</h3>
    <p>Some content.</p>
  </div>
  <div id="menu1" class="tab-pane fade">
    <h3>Menu 1</h3>
    <p>Some content in menu 1.</p>
  </div>
</div> -->
	<div class="container">
	    <h1>MQTT</h1>
	    <div class="row">
	        <div class="col-sm-3" style="background-color:white;">
	            <div class="panel panel-default">
	                <div class="panel-heading">
	                    <h3 class="panel-title">command</h3>
	                </div>
	                   <div class="panel-body">
	                       <div class="row">
	                           <div class="col-sm-6" style="background-color:white;">
	                           <a id="command" data-value="open" class="btn btn-lg btn-success btn-block">DOOR <br> OPEN</a>
	                           </div>
	                           <div class="col-sm-6" style="background-color:white;">
	                           <a id="command" data-value="close" class="btn btn-lg btn-success btn-block">DOOR <br> CLOSE</a></div>
	                       </div>
	                       <br/>
	                       <div class="row">
	                           <div class="col-sm-6" style="background-color:white;">
	                           <a id="command" data-value="on" class="btn btn-lg btn-success btn-block">FAN<br> ON</a></div>
	                           <div class="col-sm-6" style="background-color:white;">
	                           <a id="command" data-value="off"class="btn btn-lg btn-success btn-block">FAN<br> OFF</a></div>
	                       </div>
	                       <br/>
	                       <div class="row">
	                           <div class="col-sm-6" style="background-color:white;">
	                           <a id="command" data-value="1" class="btn btn-lg btn-success btn-block">ALERT<br> ON</a></div>
	                           <div class="col-sm-6" style="background-color:white;">
	                           <a id="command" data-value="0"class="btn btn-lg btn-success btn-block">ALERT<br> OFF</a></div>
	                       </div>
			        </div>
		        </div>
	            <div class="panel panel-default">
	                <div class="panel-heading">
	                    <h3 class="panel-title">LED</h3>
	                </div>
	                   <div class="panel-body">
	                       <div class="row">
	                           <div class="col-sm-6" style="background-color:white;">
	                           <a id="led" data-value="red" class="btn btn-lg btn-success btn-block">RED</a>
	                           </div>
	                           <div class="col-sm-6" style="background-color:white;">
	                           <a id="led" data-value="yellow" class="btn btn-lg btn-success btn-block">YELLOW</a></div>
	                       </div>
	                       <br/>
	                       <div class="row">
	                           <div class="col-sm-6" style="background-color:white;">
	                           <a id="led" data-value="blue" class="btn btn-lg btn-success btn-block">BLUE</a></div>
	                           <div class="col-sm-6" style="background-color:white;">
	                           <a id="led" data-value="violet"class="btn btn-lg btn-success btn-block">VIOLET</a></div>
	                       </div>
	                       <br/>
	                       <div class="row">
	                           <div class="col-sm-6" style="background-color:white;">
	                           <a id="led" data-value="orange" class="btn btn-lg btn-success btn-block">ORANGE</a></div>
	                           <div class="col-sm-6" style="background-color:white;">
	                           <a id="led" data-value="green"class="btn btn-lg btn-success btn-block">GREEN</a></div>
	                       </div>
	                       <br/>
	                       <div class="row">
	                           <div class="col-sm-6" style="background-color:white;">
	                           <a id="led" data-value="white" class="btn btn-lg btn-success btn-block">WHITE</a></div>
	                           <div class="col-sm-6" style="background-color:white;">
	                           <a id="led" data-value="black" class="btn btn-lg btn-success btn-block">OFF</a></div>
	                       </div>
			        </div>
		        </div>
	   		</div>
		    <div class="col-sm-9" style="background-color:white;">
		        <div class="row">
		        	<div class="col-sm-2" style="background-color:white;">
		        		<div class="panel panel-default">
			        		<div class="panel-heading">
		                       <h3 class="panel-title">Humidity</h3>
		                   </div>
		                   <div class="panel-body">
		                       <div class="form-group">
		                           <input id="s_humi" class="form-control" type="text" readonly="readonly">
		                       </div>
	                   		</div>
	                   </div>
		        	</div>
		        	<div class="col-sm-2" style="background-color:white;">
		        		<div class="panel panel-default">
			        		<div class="panel-heading">
		                       <h3 class="panel-title">Temperature</h3>
		                   </div>
		                   <div class="panel-body">
		                       <div class="form-group">
		                           <input id="s_temp" class="form-control" type="text" readonly="readonly">
		                       </div>
	                   		</div>
	                   </div>
		        	</div>
		        	<div class="col-sm-2" style="background-color:white;">
		        		<div class="panel panel-default">
			        		<div class="panel-heading">
		                       <h3 class="panel-title">LED</h3>
		                   </div>
		                   <div class="panel-body">
		                       <div class="form-group">
		                           <input id="s_led" class="form-control" type="text" readonly="readonly">
		                       </div>
	                   		</div>
	                   </div>
		        	</div>
    			    <div class="col-sm-2" style="background-color:white;">
		        		<div class="panel panel-default">
			        		<div class="panel-heading">
		                       <h3 class="panel-title">ALERT</h3>
		                   </div>
		                   <div class="panel-body">
		                       <div class="form-group">
		                           <input id="s_alert" class="form-control" type="text" readonly="readonly">
		                       </div>
	                   		</div>
	                   </div>
		        	</div>
		        	<div class="col-sm-2" style="background-color:white;">
		        		<div class="panel panel-default">
			        		<div class="panel-heading">
		                       <h3 class="panel-title">DOOR</h3>
		                   </div>
		                   <div class="panel-body">
		                       <div class="form-group">
		                           <input id="s_door" class="form-control" type="text" readonly="readonly">
		                       </div>
	                   		</div>
	                   </div>
		        	</div>
					<div class="col-sm-2" style="background-color:white;">
		        		<div class="panel panel-default">
			        		<div class="panel-heading">
		                       <h3 class="panel-title">FAN</h3>
		                   </div>
		                   <div class="panel-body">
		                       <div class="form-group">
		                           <input id="s_fan" class="form-control" type="text" readonly="readonly">
		                       </div>
	                   		</div>
	                   </div>
		        	</div>
		        	<div class="col-sm-12" style="background-color:white;">
		        		<div class="panel panel-default">
			        		<div class="panel-heading">
		                       <h3 class="panel-title">LCD</h3>
		                   </div>
		                   <div class="panel-body">
		                       <div class="form-group">
		                           <input id="s_lcd" class="form-control" type="text" readonly="readonly">
		                       </div>
	                   		</div>
	                   </div>
		        	</div>
		        	
		        </div>
		        <div class="row">
			        <div class="col-lg-12">
			  	    <!-- /.panel -->
			            <div class="panel panel-default">
				    	    <div class="panel-heading">
				    		    <i class="fa fa-database fa-fw"></i> Database
			    		    </div> 
			      		    <!-- /.panel-heading -->
			      		    <div class="panel-body">
					            <ul class="chat"></ul>
				      	    </div>
			      		    <!-- /.panel-body -->
			      		    <div class="panel-footer"></div>
			    	    </div>
			  	    </div>
		        </div>
		    </div>
	    </div>
	</div>
	
<!-- jQuery -->
<script src="/resources/vendor/jquery/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="/resources/dist/js/sb-admin-2.js"></script>
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script>
$(function() {
	startTimer()
	function startTimer() {
	    timer = setInterval(
	        function() {
	        	$.getJSON("/mqtt/getSmartHomeState",
	        	    function(iot){
	        		    console.log(iot);
	        		    $("#s_temp").attr("value", iot.temsensor+"\u2103");
	        		    $("#s_humi").attr("value", iot.humidity);
	        		    if (iot.red != null) {
	        		    	$("#s_led").attr("value", iot.red + "," + iot.green + "," + iot.blue);
	        		    }
	        		    if (iot.fan != null) {
	        		    	$("#s_fan").attr("value", iot.fanState);
	        		    }
	        		    if (iot.motor != null) {
	        		    	$("#s_door").attr("value", iot.motorState);
	        		    }
	        		    if (iot.irsensor != null) {
	        		    	$("#s_alert").attr("value", iot.irsensorState);
	        		    }
	        		    if (iot.lcd != null) {
	        		    	$("#s_lcd").attr("value", iot.lcd);
	        		    }
	        	});
	        	showList();
            }, 3000);
    }
	
	function showList() {
		$.getJSON("/mqtt/list",
		    function(list) {
				var str="";
			    if(list == null || list.length == 0){
			    	replyUL.html(str);
			    	return;
			    }
			    for (var i = 0, len = list.length || 0; i < len; i++) {
			    	str += "<li class='left clearfix' data-no='"+list[i].id+"'>";
			    	str += "  <div><div class='header'><strong class='primary-font'>["+list[i].id;
			    	str += "] Humidity " + list[i].humidity +"%" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "Temperature " + list[i].temsensor +"°C";
			    	str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LED " + list[i].red + ", " + list[i].green + ", " + list[i].blue;
			    	str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Alert " + list[i].irsensorState;
			    	str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Door " + list[i].motorState;
			    	str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FAN " + list[i].fanState;
			    	str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LCD " + list[i].lcd + "</strong>";
			    	str += "<small class='pull-right text-muted'>";
			    	str += displayTime(list[i].time)+"</small></div></div></li>";
    			}
			    $(".chat").html(str);
		}).fail(function(xhr, status, err) {
			if (error) {
				error();
			}
		});
	}
});

function displayTime(timeValue) {
	var today = new Date();
	var gap = today.getTime() - timeValue;
	var dateObj = new Date(timeValue);
	var str = "";
	var yy = dateObj.getFullYear();
	var mm = dateObj.getMonth() + 1; // getMonth() is zero-based
	var dd = dateObj.getDate();
	var hh = dateObj.getHours();
	var mi = dateObj.getMinutes();
	var ss = dateObj.getSeconds();
	return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/', (dd > 9 ? '' : '0') + dd + "&nbsp;&nbsp;&nbsp;"
		+ (hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi, ':', (ss > 9 ? '' : '0') + ss ].join('');
}

$(".btn-success").on("click", function(e) {
	let command = $(this).data("value")
	console.log(command)
	$.get("/mqtt/pubish/", {"command":command} ,
			function(result) {
			    alert(result);
		})
})
		
</script>
</body>
</html>
