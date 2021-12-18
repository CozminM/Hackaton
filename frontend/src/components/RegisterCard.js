import React, {useState} from "react";
import Card from "@material-tailwind/react/Card";
import CardHeader from "@material-tailwind/react/CardHeader";
import CardBody from "@material-tailwind/react/CardBody";
import CardFooter from "@material-tailwind/react/CardFooter";
import InputIcon from "@material-tailwind/react/InputIcon";
import Button from "@material-tailwind/react/Button";
import H5 from "@material-tailwind/react/Heading5";

export default function LoginCard() {
    const[userDetails, setUserDetails] = useState({
        id: 0,
        name: "",
        password: "",
        mail: ""
    })

    const handleInput = (event) => {
        event.preventDefault();
        const {name, value} = event.target;
        setUserDetails({
            ...userDetails,
            [name]: value
        })
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        fetch("http://localhost:8080/api/auth/register", {
            method : "POST",
            headers : {
                "Content-Type" : "application/json"
            },
            body : JSON.stringify(userDetails)
        })
            .then(response => response.json())
            .then(response => console.log(response))
            .catch(function() {});
    }

    return (
        <div className="pt-16">
            <form>
            <Card>
                <CardHeader color="purple" size="lg">
                    <H5 color="white">Register</H5>
                </CardHeader>

                <CardBody>
                    <div className="mt-4 mb-8 px-4">
                        <InputIcon
                            type="text"
                            color="lightBlue"
                            placeholder="Username"
                            iconName="account_circle"
                            name="name"
                            onChange={handleInput}
                        />
                    </div>
                    <div className="mb-8 px-4">
                        <InputIcon
                            type="email"
                            color="lightBlue"
                            placeholder="Email Address"
                            iconName="email"
                            name="mail"
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
                            onChange={handleInput}

                        />
                    </div>
                    {/*<div className="mb-4 px-4">*/}
                    {/*    <InputIcon*/}
                    {/*        type="password"*/}
                    {/*        color="lightBlue"*/}
                    {/*        placeholder="Verify Password"*/}
                    {/*        iconName="lock"*/}
                    {/*    />*/}
                    {/*</div>*/}
                </CardBody>
                <CardFooter>
                    <div className="flex justify-center">
                        <Button
                            color="purple"
                            buttonType="submit"
                            size="lg"
                            ripple="dark"
                            onClick={handleSubmit}
                        >
                            Register
                        </Button>
                    </div>
                </CardFooter>
            </Card>
            </form>
        </div>
    );
}