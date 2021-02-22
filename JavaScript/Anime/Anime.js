
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
                let card= document.createElement('div');
                card.className="card";
                animeDivTag.appendChild(card);
                let animeHeader=document.createElement('h4');
                animeHeader.id="Manga "+ i + " header";
                animeHeader.className="card-title";
                animeHeader.innerHTML=`${data.results[i].title}`;
                card.appendChild(animeHeader);
                let animeImg=document.createElement('img');
                animeImg.id="Manga " + i + " image";
                animeImg.className="card-img";
                animeImg.setAttribute("src",`${data.results[i].image_url}`);

                animeImg.style.width="45%";
                card.appendChild(animeImg);
                let animeDesc=document.createElement('article');
                animeDesc.id="Manga " + i + " description";
                animeDesc.className="card-text";
                animeDesc.innerHTML=`${data.results[i].synopsis}`;
                card.appendChild(animeDesc);

               

            }
            
            
           
        }
    );
   
    }

const SearchManga=function(){

const Genre=document.getElementById('Genre').value;


    $.get(`https://api.jikan.moe/v3/search/manga?genre=${Genre}limit=10`,
    function(data,testState,jqXHR){

           console.log(data);
            console.log(testState);
            console.log(jqXHR);
    
        for(let i=0;i<data.results.length;i++){
            let animeHeader=document.getElementById('Manga ' + i + ' header');
    
        animeHeader.innerHTML=`${data.results[i].title}`;
        let animeImg=document.getElementById('Manga ' + i + ' image');
        animeImg.setAttribute("src",`${data.results[i].image_url}`);
        let animeDesc=document.getElementById('Manga ' + i + ' description');
        animeDesc.innerHTML=`${data.results[i].synopsis}`;
        }
            
    }
    )
console.log(Genre);
    
}
getMangas();