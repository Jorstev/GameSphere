'use strict';

//Implementing sticky nav
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

//Implementing revealing news scroll

const SectionObserver = function(entries, observer){
    const [entry] = entries;
    console.log(entry);
    if(entry.isIntersecting){
        entry.target.classList.remove('news-container--hidden');
        observer.unobserve(entry.target);
    }
}

const sectionObserver = new IntersectionObserver(SectionObserver,{
    root:null,
    threshold: 0.15,
})

const allSections = document.querySelectorAll('.news-specific-container');
allSections.forEach(function(section){
    sectionObserver.observe(section);
    section.classList.add('news-container--hidden');
})
