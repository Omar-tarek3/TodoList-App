const express = require('express');
const mysql = require('mysql')
const cors = require('cors')

const app = express()
app.use(cors())
app.use(express.json());


const db = mysql.createConnection({
//  use "mysql" & port:3306 to connect to the db in the mysql-container @ port 3306 through the docker-network created by the docker-compose.
//  use "host.docker.internal" & port:3000 to connect to the db in the mysql-container @ port 3306 through localhost(docker-host), port: 3000.
    host: "mysql", 
    port: "3306" , 

    user: "root",
    password: "omar1234", //"23690892"omar1234
    database: "todolist" //todos-db
})
 
app.get('/TodoList', (req,res)=>{
    const sql_query = "SELECT * FROM todolist.todoss";
    db.query(sql_query, (err , data)=>{
        if(err) return res.json(err);
        return res.json(data);
    })

})

app.post('/Add', (req,res)=> {
    const todo = req.body.todo
    const description  = req.body.description
    const deadline = req.body.deadline
    const priority = req.body.priority
    const status = req.body.status
    const tag = req.body.tag


    
//`todos-db`.todos
    db.query('INSERT INTO todolist.todoss(Todo, Description, Deadline, Priority, Status, Tag ) VALUES(?,?,?,?,?,?)',
    [todo,description,deadline,priority,status,tag] , 
    (err,result) => {
        if (err)  {
            console.log(err)
        } else {
            res.send(" Added to Todo-List")
            console.log("Todo added successfully");
            console.log(req.body);
        }
    }
    );
});


app.delete('/Delete/:id', (req,res)=> {
  

    const delete_query = 'DELETE FROM todolist.todoss WHERE todoss.id = ?';

    db.query(delete_query, [req.params.id],

    (err,result) => {
        if (err)  {
            console.log(err)
        } else {
            res.send("Todo Deleted ")
            console.log("Todo deleted successfully - ID:" ,req.params.id ) 
        }
    }
    );
});


app.get('/', (req,res)=>{
    return res.json("Backend");
})

app.listen(8081 ,'0.0.0.0', ()=> {
    console.log("Listening on port 8081")
})