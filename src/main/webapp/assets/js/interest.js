function rssclip(studentNum){
	alert(1);
	var mid,title,url,date,description;
	

	mid=studentNum;
	title=$('[name=infoname]').val();
	url=$('[name=infourl]').val();
	date=$('[name=infodate]').val();
	description=$('[name=infodescription]').val();
	alert(mid);
	alert(title);
	alert(url);
	alert(date);
	alert(description);
	
	$.ajax({
		type:"POST",
		url:"#",
		data:{mid:mid,
		title:title,
		url:url,
		date:date,
		description:description
		},
		
		success:function(data){
			console.log("success updateApply !!");
		},
		error: function(request,status,error){
			alert("지원서 정보 수정 실패!");
		}
		
	});
	
	alert(1);
	
}