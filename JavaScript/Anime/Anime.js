const Genres={
    "Action": 1,
    "Adventure:":2,
    "Cars:":3,
    "Comedy":4,
    "Dementia":5,
    "Demons":6,
    "Mystery":7,
    "Drama":8,
    "Ecchi":9,
    "Fantasy":10,
    "Game":11

}
const getMangas=function(){
    $.get(
        "https://api.jikan.moe/v3/manga/1",
        function(data, testState,jqXHR ){
            $("#Manga1").text(`${data.title}`)
            $('#icon1').attr('src',`${data.image_url}`);
            $('#Manga1Desc').text(`${data.synopsis}`);
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
            $('#Manga2Desc').text(`${data.synopsis}`);
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
            $('#Manga3Desc').text(`${data.synopsis}`);
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
            $('#Manga4Desc').text(`${data.synopsis}`);
            console.log(data);
            console.log(testState);
            console.log(jqXHR);
        }
    );
    $.get(
        "https://api.jikan.moe/v3/manga/7",
        function(data, testState,jqXHR ){
            $("#Manga7").text(`${data.title}`)
            $('#icon7').attr('src',`${data.image_url}`)
            $('#Manga7Desc').text(`${data.synopsis}`);
            console.log(data);
            console.log(testState);
            console.log(jqXHR);
        }
    );
}
const SearchManga=function(){
const Genre=$('#Genre').val;

if(Genre===`${Genres.key}`){
    $.get(`https://api.jikan.moe/v3/search/manga?genre=${Genres.key.val}genre_exclude=0`),
    function(data,testState,jqXHR){
        console.log(data);
            console.log(testState);
            console.log(jqXHR);
    }
}
}
getMangas();