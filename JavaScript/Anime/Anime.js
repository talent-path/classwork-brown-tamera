
const getMangas=function(){
    $.get(
        "https://api.jikan.moe/v3/search/manga?order_by=title&limit=10",
        function(data, testState,jqXHR ){
           
            $("#Manga1").text(`${data.results[0].title}`)
            $('#icon1').attr('src',`${data.results[0].image_url}`);
            $('#Manga1Desc').text(`${data.results[0].synopsis}`);

            $("#Manga2").text(`${data.results[1].title}`)
            $('#icon2').attr('src',`${data.results[1].image_url}`);
            $('#Manga2Desc').text(`${data.results[1].synopsis}`);

            $("#Manga3").text(`${data.results[2].title}`)
            $('#icon3').attr('src',`${data.results[2].image_url}`);
            $('#Manga3Desc').text(`${data.results[2].synopsis}`);

            $("#Manga4").text(`${data.results[3].title}`)
            $('#icon4').attr('src',`${data.results[3].image_url}`);
            $('#Manga4Desc').text(`${data.results[3].synopsis}`);

            console.log(data);
            console.log(testState);
            console.log(jqXHR);
        }
    );
    
    }

const SearchManga=function(){

const Genre=$('#Genre').val;


    
    $.get(`https://api.jikan.moe/v3/search/manga?genre=${Genre}&genre_exclude=0`),
    function(data,testState,jqXHR){

        $("#Manga1").text(`${data.results[0].title}`)
        $('#icon1').attr('src',`${data.results[0].image_url}`);
        $('#Manga1Desc').text(`${data.results[0].synopsis}`);

            console.log(data);
            console.log(testState);
            console.log(jqXHR);
    }

    console.log("No Manga available");

}
getMangas();