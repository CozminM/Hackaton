import React from "react";
import {useState} from "react";

export default function Form() {

    const [user, setUser] = useState({
        id: 0,
        name: "",
        mail: ""
    })

    const handleInput = (event) => {
        event.preventDefault();

        const {name, value} = event.target

        setUser({
            ...user,
            [name] : value
        });
        console.log(user);
    }

    const handleSubmit = event => {
        event.preventDefault();
        fetch(
            "http://0.0.0.0:8080/add-user",
            {
                method : "POST",
                headers : {
                    "Content-Type" : "application/json"
                },
                body : JSON.stringify(user)
            })
            .then(response => response.json())
            .catch(function() {});
    }

    return (
      <div>
          <form onSubmit={handleSubmit}>
              <input type="text" placeholder="name" name="name" value={user.name} onChange={handleInput}/>
              <input type="text" placeholder="email" name="mail" value={user.mail} onChange={handleInput}/>
              <button type="submit"/>
          </form>
      </div>
    );
}