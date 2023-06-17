'use strict';

const nav = document.querySelector('.nav-container');
const intro_section = document.querySelector('.introduction-container');

const StickyNav = function(entries){
    const [entry] = entries;
    console.log(entry);
    if(!entry.isIntersecting){
        nav.classList.add('sticky');
    }else{
        nav.classList.remove('sticky');
    }
}

const introObserver = new IntersectionObserver(StickyNav,{
    root:null,
    threshold: 0.5,
});

introObserver.observe(intro_section);