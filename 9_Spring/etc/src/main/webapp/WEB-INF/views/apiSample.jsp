<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
    <h1>실시간 대기오염 정보</h1>
	
	지역 : 
	<select id="location">
		<option>서울</option>
		<option>대전</option>
		<option>대구</option>
		<option>부산</option>
	</select>

	<button id="btn1" class="btn btn-sm btn-primary" onclick="getAirStatusHandler()">해당지역 대기오염 정보</button>
	
	<br><br>

	<table id="result" class="table">
		<thead>
			<tr>
				<th>측정소명</th>
				<th>측정일자</th>
				<th>통합대기환경수치</th>
				<th>미세먼지농도</th>
				<th>일산화탄소농도</th>
				<th>일산화질소농도</th>
				<th>오존농도</th>
			</tr>
		</thead>
		<tbody>
			//서버로부터 받아온 데이터
		</tbody>
	</table>

	<script>
		function init(){
			document.getElementById("btn1").click()
		}

		function getAirStatusHandler(){
			// 지역명 포함해서 서버로 ajax 요청
			const location = document.querySelector("#location").value;

			// 스크립트 신문법으로 키-값이 똑같으면 한개만 써도 됨 {location:location} -> {location}
			getAirStatus({location : location}, function(airStatusList){
				console.log(airStatusList)
				const itemList = airStatusList.response.body.items;
				drawAirtBody(document.querySelector("#result tbody"), itemList)
			})
		}

		function getAirStatus(data, callback){
			$.ajax({
				url: "air",
				data: data,
				success: callback,
				error: function(){
					console.log("대기정보 api요청 실패")
				}
			})
		}

		function drawAirtBody(parent, itemArr){
			parent.innerHTML = "";

			for(const item of itemArr){
				parent.innerHTML += "<tr>"
									+ "<td>" + item.stationName + "</td>"
									+ "<td>" + item.dataTime + "</td>"
									+ "<td>" + item.khaiValue + "</td>"
									+ "<td>" + item.pm10Value + "</td>"
									+ "<td>" + item.coValue + "</td>"
									+ "<td>" + item.no2Value + "</td>"
									+ "<td>" + item.o3Value + "</td>"
								  + "</tr>"
			}
		}
	</script>
</body>
</html>