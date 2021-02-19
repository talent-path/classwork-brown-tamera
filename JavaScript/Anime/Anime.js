
const getMangas=function(){
    $.get(
        "https://api.jikan.moe/v3/search/manga?order_by=title&limit=10",
        function(data, testState,jqXHR ){

            console.log(data);
            console.log(testState);
            console.log(jqXHR);

            let allbodyTags=document.getElementsByTagName('body');
            let bodyTag= allbodyTags[0];
            let animeDivTag=document.createElement('div');
            bodyTag.appendChild(animeDivTag);

            for(let i=0;i<data.results.length;i++){
                let animeHeader=document.createElement('h3');
                animeHeader.id="Manga "+ data.results[i] + "header";
                $('h3').text(`${data.results[i].title}`);
                animeDivTag.appendChild(animeHeader);
                let animeImg=document.createElement('img');
                animeImg.id="Ma"
                $('img').attr('src',`${data.results[i].image_url}`);
                animeDivTag.appendChild(animeImg);
                let animeDesc=document.createElement('article');
                $('animeDesc').text(`${data.results[i].synopsis}`);
                animeDivTag.appendChild(animeDesc);

            }

           
        }
    );
    
    }

const SearchManga=function(){

const Genre=document.getElementById('Genre').value;
console.log(Genre);

    
    $.get(`https://api.jikan.moe/v3/search/manga?genre=${Genre}`,
    function(data,testState,jqXHR){
        
        for(let i=0;i<data.results.length;i++){

        $('h3').text(`${data.results[i].title}`)
        $('img').attr('src',`${data.results[i].image_url}`);
        $('article').text(`${data.results[i].synopsis}`);
        }
            console.log(data);
            console.log(testState);
            console.log(jqXHR);
    
    }
    )

    
}
getMangas();