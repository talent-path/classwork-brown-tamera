
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
                card.className="flip-card";
                animeDivTag.appendChild(card);
                let inner=document.createElement('div');
                inner.className="flip-card-inner";
                card.appendChild(inner);
                let front=document.createElement('div');
                front.className="flip-card-front";
                inner.appendChild(front);

               let animeImg=document.createElement('img');
                animeImg.id="Manga " + i + " image";
                animeImg.className="card-img";
                animeImg.setAttribute("src",`${data.results[i].image_url}`);
                animeImg.setAttribute('alt','Manga');
                animeImg.style.width="300px";
                animeImg.style.height="400px";
                front.appendChild(animeImg);

                let back=document.createElement('flip-card-back');
                inner.appendChild(back);

                let animeHeader=document.createElement('h4');
                animeHeader.id="Manga "+ i + " header";
                animeHeader.className="card-title";
                animeHeader.innerHTML=`${data.results[i].title}`;
                back.appendChild(animeHeader);
                
                
                let animeDesc=document.createElement('article');
                animeDesc.id="Manga " + i + " description";
                animeDesc.className="card-text";
                animeDesc.innerHTML=`${data.results[i].synopsis}`;
                back.appendChild(animeDesc);

                let animeChapters=document.createElement('p');
                animeChapters.id="Manga " + i + " chapters";
                animeChapters.className="card-text";
                animeChapters.innerHTML="Chapters: " + `${data.results[i].chapters}`;
                back.appendChild(animeChapters);

                let animeVolumes=document.createElement('p');
                animeVolumes.id="Manga " + i + " volumes";
                animeVolumes.className="card-text";
                animeVolumes.innerHTML="Volumes: " + `${data.results[i].volumes}`;
                back.appendChild(animeVolumes);

                let animeScore=document.createElement('p');
                animeScore.id="Manga " + i + " score";
                animeScore.className="card-text";
                animeScore.innerHTML="Score: " + `${data.results[i].score}`;
                back.appendChild(animeScore);

 
            
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