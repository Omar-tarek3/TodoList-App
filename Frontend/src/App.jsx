import "./style.css";
import { useState } from "react";
import Axios from "axios";
import axios from "axios";


export default function App(){


  const [todo, setTodo]= useState("");
  const [description, setDescription]= useState("");
  const [deadline, setDeadline]= useState();
  const [proirity, setProirity]= useState(0);
  const [status, setstatus]= useState("");
  const [tag, setTag]= useState("");

  const [todoList, setTodoList] = useState([]);

  const getTodoList = () => {

    Axios.get("http://todolist.app.com/TodoList" , ) .then((response) => { 
      setTodoList(response.data)
    });

  };

  
  const addTodo = () =>{
    console.log(todo);
    Axios.post("http://todolist.app.com/Add" , { // todolist.app as I have a dns etnery to map it localhost (where Ingress controller run).
      todo: todo,
      description: description,
      deadline: deadline,
      proirity: proirity,
      status: status,
      tag: tag
    }) .then(() => {
      console.log("success");
    });
  }

  
  function deleteTodo (id)  {

    setTodoList(currentTodos => {
      return currentTodos.filter(todo =>todo.id !== id ) //remove todo from react
    })

    Axios.delete("http://todolist.app.com/Delete/:id".replace(':id', id)) 
    .then(response => {
      console.log('Row deleted successfully - ID: ', id);
      
    })
    .catch(error => {
      console.error('Error deleting row:', error);
    });

    
       
  }


  function handleSubmit(e){
    e.preventDefault()
  }

  return(
    <>
      <form onSubmit={handleSubmit} className="new-item-form">
        <div className="form-row">
        
          <label htmlFor="todo"> Todo </label> 
          <input 
            type="text" id="todo"
            onChange={(event)=> { // Update the value of the const todo when entering a new input 
              setTodo(event.target.value);
            }}
            />

          <label htmlFor="Description"> Description</label>
          <input 
          type="text" id="Description"
          onChange={(event)=> {
            setDescription(event.target.value);
          }}
          />

          <label htmlFor="dead"> Deadline </label>
          <input
           type="date" id="dead"
           onChange={(event)=> {
            setDeadline(event.target.value);
          }}
           />

          <label htmlFor="prio"> Priority</label>
          <input 
          type="number" id="prio"
          onChange={(event)=> {
            setProirity(event.target.value);
          }}
          />

          <label htmlFor="status"> Status (0 for no , 1 for yes) </label>
          <input 
          type="number" id="Status"
          onChange={(event)=> {
            setstatus(event.target.value);
          }}
          />

          <label htmlFor="tag"> Tag </label>
          <input
           type="text" id="tag"
           onChange={(event)=> {
            setTag(event.target.value);
          }}
           />
          
        </div>
        <button onClick={addTodo} className="btn"> Add </button>
        <button onClick={getTodoList} className="btn"> TodoList</button>
        </form>
        <h1 className="header">Todo-List</h1>
        <ul className="list">
        {
          todoList.map((val, key) => {
            return (
              <li>
                <label>
                  <input type="checkbox" checked={val.Status} />
                  {val.Todo} 
                </label>
                <h2> : {val.Deadline}</h2>
                <button onClick={()=> deleteTodo(val.id)} className="btn btn-danger"> Delete </button>
              </li>
            )
          })
        }
        </ul>
    
    
    
    </>
    
  )
}