function addTodo(){
    // todo-list영역에 
    /*
        <li>
            밥먹기<button><div class="todo-remove-btn"><i class="fa-solid fa-x"></i></div></button>
        </li>
    */

    const searchInput = document.querySelector('#search-bar input')

    const todoLi = document.createElement('li')
    todoLi.innerText = searchInput.value;

    const removeBtn = document.createElement('div')
    removeBtn.className = 'todo-remove-btn';
    removeBtn.innerHTML = "<i class='fa-solid fa-x'></i>"

    removeBtn.onclick = function(){
        this.parentNode.remove();
    }

    todoLi.appendChild(removeBtn)

    const todoUl = document.querySelector('.todo-list')
    todoUl.appendChild(todoLi)

    searchInput.value=''

}