import React, {useEffect, useState} from "react";
import Card from "@material-tailwind/react/Card";
import CardHeader from "@material-tailwind/react/CardHeader";
import CardBody from "@material-tailwind/react/CardBody";
import CardFooter from "@material-tailwind/react/CardFooter";
import InputIcon from "@material-tailwind/react/InputIcon";
import Button from "@material-tailwind/react/Button";
import H5 from "@material-tailwind/react/Heading5";
import {NavLink} from "react-router-dom";
import {useAtom} from "jotai"
import {USER} from "../context/STATES"
import axios from "axios"

export default function LoginCard() {

    const [userLogin, setUserLogin] = useState({
        email: "",
        password: ""
    })

    const handleInput = (event) => {
        event.preventDefault();
        const {name, value} = event.target;
        setUserLogin({
            ...userLogin,
            [name]: value
        })
        console.log(userLogin)
    }

    const handleSubmit = (event) => {
        event.preventDefault()
        fetch("http://localhost:8080/api/auth/signin", {
            method : "POST",
                headers : {
                "Content-Type" : "application/json"
            },
            body : JSON.stringify(userLogin)
        })
            .then(response => response.json())
            .then(response => {
                console.log(response.username)
                localStorage.setItem("userId", response.userId)
                localStorage.setItem("userToken", response.token)
                console.log("cacat")
            })

            // .then(response => {
            //     axios.get("http://localhost:8080/api/client/"+response.data.userId, {headers: {
            //         "Authorization": "Bearer " + response.data.token
            //         }})
            //         .then((res) => setUser(res.data))
            //         .then((res) => localStorage.setItem("user,es.data))
            //         .catch((err) => console.log(err.response))
            //
            // })
            .catch(function() {});
    }

    return (
        <div className="pt-16">
            <form>
        <Card>
            <CardHeader color="purple" size="lg">
                <H5 color="white">Login</H5>
            </CardHeader>

            <CardBody>
                <div className="mb-8 px-4">
                    <InputIcon
                        type="email"
                        color="lightBlue"
                        placeholder="Email Address"
                        iconName="email"
                        value={userLogin.email}
                        name="email"
                        onChange={handleInput}
                    />
                </div>
                <div className="mb-4 px-4">
                    <InputIcon
                        type="password"
                        color="lightBlue"
                        placeholder="Password"
                        iconName="lock"
                        name="password"
                        value={userLogin.password}
                        onChange={handleInput}
                    />
                </div>
            </CardBody>
            <CardFooter>
                <div className="flex justify-center">
                    <Button
                        color="purple"
                        // buttonType="submit"
                        size="lg"
                        onClick={handleSubmit}
                        ripple="dark"
                    >
                        Sign in
                    </Button>
                    <Button
                        color="red"
                        buttonType="link"
                        size="lg"
                        ripple="dark"
                    >
                        <NavLink to="/register">
                            Sign up
                        </NavLink>
                    </Button>
                </div>
            </CardFooter>
        </Card>
        </form>
        </div>
    );
}