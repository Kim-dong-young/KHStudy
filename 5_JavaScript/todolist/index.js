let todoList = localStorage.getItem('todoList') ?
            JSON.parse(localStorage.getItem('todoList')) : [];

/*{
title : '밥먹기',
date : new Date().getTime(),
isDone : false
*/

// JSON.stringfy( 객체 | 배열 ) -> 객체, 배열을 string으로 변환
// JSON.parse(변환된문자열) -> 원래의 객체, 배열로 변경

// localStroage.setItem('키','밸류') => localSctorage영엑에 key:value 형태로 값 저장
// localStorage.getItem('키) => localStrorage 영역의 데이터를 key로 불러오는 것이다.

window.onload = function(){
    drawTodoList();
}

// 할 일을 todoList에 넣기
function addTodo(){
    // input요소 가져오기
    const searchInput = document.querySelector('#search-bar input')
    todoList.push({
        title: searchInput.value,
        date : new Date().getTime(),
        isDone: false
    })

    localStorage.setItem('todoList', JSON.stringify(todoList))

    searchInput.value='';
    drawTodoList();
}

// 할 일 목록을 ui에 나타내기
function drawTodoList(){
    
    const removeTodo = function(removeTodo){
        todoList = todoList.filter((todo) => 
            !(todo.date === removeTodo.date && todo.title === removeTodo.title)
        )

        localStorage.setItem('todoList', JSON.stringify(todoList))
        drawTodoList();
    }

    const toggleStatus = function(targetTodo){
        // console.log(targetTodo)
        // console.log(todoList)
        todoList = todoList.map(function(t){
            if( t.date === targetTodo.date && t.title === targetTodo.title){
                t.isDone = !t.isDone;
            }
            return t;
        })

        localStorage.setItem('todoList', JSON.stringify(todoList))
        drawTodoList();
    }

    const todoUi = document.querySelector('.todo-list')
    todoUi.innerHTML = ''

    for(let todo of todoList){
        const todoLi = document.createElement('li')
        todoLi.innerText = todo.title; // title : 내가 입력한 값
        todoLi.className = todo.isDone ? 'done' : '';
        todoUi.appendChild(todoLi)

        todoLi.onclick = function(){
            toggleStatus(todo);
        }

        const removeBtn = document.createElement('div')
        removeBtn.className = 'todo-remove-btn';
        removeBtn.innerHTML = "<i class='fa-solid fa-x'></i>"
        todoLi.appendChild(removeBtn)
    
        removeBtn.onclick = function(){
            removeTodo(todo)
        }
    }
}


/*
function addTodo(){
    // todo-list영역에 
    //    <li>
    //        밥먹기<button><div class="todo-remove-btn"><i class="fa-solid fa-x"></i></div></button>
    //    </li>

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
*/