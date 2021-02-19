const getMangas=function(){
    $.get(
        "https://api.jikan.moe/v3/manga/1",
        function(data, testState,jqXHR ){
            $("#Manga1").text(`${data.title}`)
            $('#icon1').attr('src',`${data.image_url}`)
            console.log(data);
            console.log(testState);
            console.log(jqXHR);
        }
    );
    $.get(
        "https://api.jikan.moe/v3/manga/2",
        function(data, testState,jqXHR ){
            $("#Manga2").text(`${data.title}`)
            $('#icon2').attr('src',`${data.image_url}`)
            console.log(data);
            console.log(testState);
            console.log(jqXHR);
        }
    );
    $.get(
        "https://api.jikan.moe/v3/manga/3",
        function(data, testState,jqXHR ){
            $("#Manga3").text(`${data.title}`)
            $('#icon3').attr('src',`${data.image_url}`)
            console.log(data);
            console.log(testState);
            console.log(jqXHR);
        }
    );
    $.get(
        "https://api.jikan.moe/v3/manga/4",
        function(data, testState,jqXHR ){
            $("#Manga4").text(`${data.title}`)
            $('#icon4').attr('src',`${data.image_url}`)
            console.log(data);
            console.log(testState);
            console.log(jqXHR);
        }
    );
}
getMangas();