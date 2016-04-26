<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<base href="<%=basePath%>">
	<title>Points</title>
    <script src="assets/js/jquery.js"></script>
    <!-- Echarts -->
	<script src="assets/js/echarts.min.js"></script>
    <!-- DataTables CSS -->
	<link rel="stylesheet" type="text/css" href="assets/css/jquery.dataTables.css">
	<!-- DataTables -->
	<script type="text/javascript" charset="utf8" src="assets/js/jquery.dataTables.js"></script>
    <style type="text/css">
    	#cluster_detail_1{
    		position: absolute;
    		left: 10px;
    	}
    	#cluster_detail_2{
    		position: absolute;
    		left: 320px;
    	}
    	#cluster_detail_3{
    		position: absolute;
    		left: 630px;
    	}
    	#decision{
    		position: relative;
    		left: 16px;
    	}
    	#autoChoose{
    		position: relative;
    		left: 10px;
    	}
    	#point_display{
    		position: absolute;
    		top: 80px;
    	}
    	#param_display{
    		position: absolute;
    		top: 80px;
    		left: 390px;
    	}
    	#cluster_param_table{
    		position: absolute;
    		top: 0px;
    		left: 1000px;
    	}
    	#download{
    		position: absolute;
    		top: 92%;
    	}
    	/*
    	#rights{
    		position: absolute;
    		top: 92%;
    		left: 45%;
    	}*/
    </style>
</head>
<body>
<div id="cluster_detail_1">
	<form>
		X1 Upper：<input type="text" style="width:50px" name="x_upper" id="x1_upper" value="2">
		Y1 Upper：<input type="text" style="width:50px" name="y_upper" id="y1_upper" value="2"><br/>
		X1 Lower：<input type="text" style="width:50px" name="x_lower" id="x1_lower" value="0">
		Y1 Lower：<input type="text" style="width:50px" name="y_lower" id="y1_lower" value="0"><br/>
		<input type="button" id="generate" value="Generate Random Points">
	</form>
</div>
<div id="cluster_detail_2">
	<form>
		X2 Upper：<input type="text" style="width:50px" name="x_upper" id="x2_upper" value="5">
		Y2 Upper：<input type="text" style="width:50px" name="y_upper" id="y2_upper" value="5"><br/>
		X2 Lower：<input type="text" style="width:50px" name="x_lower" id="x2_lower" value="3">
		Y2 Lower：<input type="text" style="width:50px" name="y_lower" id="y2_lower" value="3"><br/>
	</form>
</div>
<div id="cluster_detail_3">
	<form>
		Decision Boundary：<input type="text" style="width:50px" name="decision" id="decision" value="1">
		<input type="button" name="autoChoose" id="autoChoose" value="Auto Choose"  disabled="disabled"><br/>
		Number of a cluster：<input type="text" style="width:50px" name="number" id="number" value="100">
	</form>
</div>
<div id="cluster_param_table">
	<!-- 
	<table id="table" class="display">
		<thead>
			<tr>
				<th>X</th>
				<th>Y</th>
				<th>Rho</th>
				<th>Sigma</th>
			</tr>
		</thead>
	</table>
	 -->
</div>
<div id="download">
	<a href="assets/essay/Clustering_by_fast_search_and_find_of_density_peaks.pdf" target="_blank">
		Download Algorithm (.pdf)
	</a>
</div>
<!-- 
<div id="rights">
	<p>All rights reserved</p>
</div>
 -->
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="point_display" style="width: 400px; height:400px;"></div>
<div id="param_display" style="width: 600px; height:400px;"></div>
<script>
$(function(){
	
	// 设置Datatable不报错，用于在表格中“仅显示点坐标，但保留Rho、Sigma两列为空”
	// $.fn.dataTable.ext.errMode = 'none';
	
	var point = [];					// 数据点坐标
	var param = [];				// 参数 Rho & Sigma
	var table_data = [];			// 表格数据，拼接 点坐标 和 参数
	var table;							// 表格
	// 数据点展示
	var pointChart = echarts.init(document.getElementById('point_display'));
	// 决策图展示
	var paramChart = echarts.init(document.getElementById('param_display'));
	var color = ['#c23531','#2f4554', '#61a0a8', '#d48265', '#91c7ae','#749f83',  '#ca8622', '#bda29a','#6e7074', '#546570', '#c4ccd3'];

	$("#generate").click(function(){
		var x1_upper = parseInt($("#x1_upper").val());
		var x1_lower = parseInt($("#x1_lower").val());
		var y1_upper = parseInt($("#y1_upper").val());
		var y1_lower = parseInt($("#y1_lower").val());
		var x2_upper = parseInt($("#x2_upper").val());
		var x2_lower = parseInt($("#x2_lower").val());
		var y2_upper = parseInt($("#y2_upper").val());
		var y2_lower = parseInt($("#y2_lower").val());
		var number = parseInt($("#number").val());
		var dc = parseFloat($("#decision").val());
		if((x1_upper <= x1_lower) || (y1_upper <= y1_lower) || (x2_upper <= x2_lower) || (y2_upper <= y2_lower)){
			alert("Error: \nUpper bound must be larger than lower bound");
		} else {
			$.ajax({
				type: "POST",
				url: "point/generator",
				dataType: "json",
				data: {
					x1_upper: x1_upper,
					x1_lower: x1_lower,
					y1_upper: y1_upper,
					y1_lower: y1_lower,
					x2_upper: x2_upper,
					x2_lower: x2_lower,
					y2_upper: y2_upper,
					y2_lower: y2_lower,
					num: number,
					dc: dc
				},
				success: function(result){
					$("#autoChoose").removeAttr("disabled");
					point = result.point;
					param = result.param;
					table_data = loadTableData(point, param);
					loadGraphic(pointChart, "Point: <br /> ( {c} )","Point", point, color[0]);
					loadGraphic(
							paramChart, 
							function(params, ticket, callback){
								return "Point: ( " + point[params.dataIndex][0] + 
										" , " + point[params.dataIndex][1] + " ) <br\>" +
										"Param: ( "+ params.data[0] +" , " + params.data[1] +" )";
							},
							"Decision", param, color[1]);
					loadTable(table_data);
				}
			});
		}
	});
	
	$("#autoChoose").on("click", function(e){
		//alert("This button has no use. Don't click it again.");
		$("#decision").val(Math.random());
	});
	
	function loadTableData(point, param){
		var result = [];
		
		$.each(point, function(i, item){
			var temp = [item[0], item[1], param[i][0], param[i][1]];
			result.push(temp);
		})
		
		return result;
	}
	
	function loadTable(data){
		var options =[];		
		options.push("<table id=\"table\" class=\"display\"><thead><tr>");
		options.push("<th>X</th><th>Y</th><th>Rho</th><th>Sigma</th>");
		//options.push("<th>X</th><th>Y</th>");
		options.push("</tr></thead></table>");
		$("#cluster_param_table").html(options.join(" "));
		
		table = 
			$("#table").DataTable({
				language: {
		        	url: "assets/lang/language.txt"
		        },
		        ordering: false,
		        pageLength: 15,
				data: data,
				dom: "tp"
			});
	}
	
	function loadGraphic(myChart, formatter, graphicName, data, color){
		 var option = {
                title: {
                    text: graphicName + " Graphic"
                },
               legend: {
                  data:[graphicName],
                  left: 'center'
              	},
              	tooltip: {
              		formatter: formatter
              	},
              	xAxis: {},
              	yAxis: {},
                series: [{
                	name: graphicName,
                	type: 'scatter',
                	data: data,
                	itemStyle: {
                		normal: {
                			color: color
                		}
                	},
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
	}
	
})
</script>
</body>
</html>