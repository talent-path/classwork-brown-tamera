//alert("page is connected");  
const GetWeather=function(){
    const zipcode= $("#zip").val();
$.get(
   
    `http://api.openweathermap.org/data/2.5/weather?zip=${zipcode},us&appid=daa1bb6563c9cd0fc44fdd52043bf959&units=imperial`,
    function(data,textState,jqXHR){
      $("#reportHeader").text(`Weathher report for ${data.name}`);
      $("#weatherDesc").text(data.weather[0].description);

      let imageurl=`http://openweathermap.org/img/wn/${data.weather[0].icon}@2x.png`;
      $("#weathericon").attr("src",imageurl)

      $("#currenttemp").text(`${data.main.temp} degrees`);

        console.log(data);
        console.log(textState);
        console.log(jqXHR);
    }
);
}
