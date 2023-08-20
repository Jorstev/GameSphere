'use strict';
document.querySelector('.card-number-input').oninput = () => {
    document.querySelector('.card-number-box').innerText = document.querySelector('.card-number-input').value;
}

document.querySelector('.card-holder-input').oninput = () => {
    document.querySelector('.card-holder-name').innerText = document.querySelector('.card-holder-input').value;
}

document.querySelector('.month-input').oninput = () => {
    document.querySelector('.exp-month').innerText = document.querySelector('.month-input').value;
}

document.querySelector('.year-input').oninput = () => {
    document.querySelector('.exp-year').innerText = document.querySelector('.year-input').value;
}

document.querySelector('.cvv-input').onmouseenter = () => {
    document.querySelector('.front').style.transform = 'perspective(1000px) rotateY(-180deg)';
    document.querySelector('.back').style.transform = 'perspective(1000px) rotateY(0deg)';
}

document.querySelector('.cvv-input').onmouseleave = () => {
    document.querySelector('.front').style.transform = 'perspective(1000px) rotateY(0deg)';
    document.querySelector('.back').style.transform = 'perspective(1000px) rotateY(180deg)';
}

document.querySelector('.cvv-input').oninput = () => {
    document.querySelector('.cvv-box').innerText = document.querySelector('.cvv-input').value;
}


const AddtoCart = document.querySelectorAll('.btn-AddCart');
console.log(AddtoCart);
const cartNumber = document.querySelector('#cart-number');
const shoppingCart = document.querySelector('.fa-cart-shopping');
const productContainer = document.querySelector('.items-container');
const productItem = document.querySelectorAll('.item');
const btnRemove = document.querySelector('.btn-remove');
const btnPayment = document.querySelector('#submit-Payment');

productContainer.innerHTML = "";

AddtoCart.forEach((btn) => {
    btn.addEventListener('click', function () {
        cartNumber.textContent++;
        let parentParent = btn.parentElement;

        let parent = parentParent.parentElement;
        let name = parent.querySelector('.game-Name').textContent;
        let price = parent.querySelector('.game-price').textContent;
       
        let html = `<div class="item">
                        <p>${name}</p>
                        <p>$<span class="class">${price}</span></p>
                        <input class="btn-remove" type="submit" value="Eliminar" name="Eliminar" />
                    </div>`;
        productContainer.insertAdjacentHTML('afterbegin', html);
    });
});

btnPayment.addEventListener('click', function (e) {
    e.preventDefault();
    console.log('test');
    swal("Pago Procesado", "Disfrute su videojuego", "success");
    cartNumber.textContent=0;
    productContainer.innerHTML = "";
})

console.log(productItem);
btnRemove.forEach(function (btn) {
    btn.addEventListener('click', function () {
        productItem.remove();
    });
});