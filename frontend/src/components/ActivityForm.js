import Card from '@material-tailwind/react/Card';
import CardHeader from '@material-tailwind/react/CardHeader';
import CardBody from '@material-tailwind/react/CardBody';
import InputIcon from "@material-tailwind/react/InputIcon";
import React, {useEffect, useState} from "react";
import Button from "@material-tailwind/react/Button";
import CardFooter from "@material-tailwind/react/CardFooter";
import Image from "@material-tailwind/react/Image";

export default function ActivityForm() {

    // const [user, setUser] = useState({
    //     dayDetails: [],
    //     id: 0,
    //     mail: "",
    //     name: "",
    //     password: "",
    //     roles: Array [ "ROLES_USER" ]
    // })

    const [activities, setActivities] = useState([])
    const [foods, setFoods] = useState([])

    const [intakeCalories, setIntakeCalories] = useState(0)
    const [consumedCalories, setConsumedCalories] = useState(0)

    const [date, setDate] = useState("")

    useEffect(() => {
        fetch('http://localhost:8080/list-activities',
            {headers: {"Content-Type": "application/json"}})
            .then(response => response.json())
            .then((response) => {
                setActivities(response)
            });
    }, [])

    useEffect(() => {
        fetch('http://localhost:8080/list-food',
            {headers: {"Content-Type": "application/json"}})
            .then(response => response.json())
            .then((response) => {
                setFoods(response)
            });
    }, [])

    // useEffect(() => {
    //     fetch("http://localhost:8080/api/client/get/" + localStorage.getItem("userId"),
    //         {headers: {"Content-Type": "application/json"}})
    //         .then((response => response.json()))
    //         .then(response => setUser(response))
    //     console.log(user)
    // }, [])



    const handleIntakeInput = (event) => {
        event.preventDefault()

        setIntakeCalories((prev) => prev + (parseInt(event.target.value) * parseInt(event.target.name)))
        console.log(intakeCalories)
    }

    const handleConsumedInput = (event) => {
        event.preventDefault()

        setConsumedCalories((prev) => prev + (parseInt(event.target.value) * parseInt(event.target.name)))
        console.log(consumedCalories)
    }

    const handleDateInput = (event) => {
        event.preventDefault()
        setDate(event.target.value)
        console.log(date)
    }

    const handleSubmit = (event) => {
        event.preventDefault()
        const detailsToSend = {
            id: 0,
            date: date,
            intakeCalories: intakeCalories,
            consumedCalories: consumedCalories
        }
        fetch(
            "http://0.0.0.0:8080/add-details",
            {
                method : "POST",
                headers : {
                    "Content-Type" : "application/json"
                },
                body : JSON.stringify(detailsToSend)
            })
            .then(response => response.json())
            .catch(function() {});
    }

    return(
        <div className="pt-16">
            <form>
                <Card>
                    <CardHeader color="purple">
                        <h2 className="text-white text-2xl">Day Details</h2>
                    </CardHeader>
                    <CardBody>
                        <h2 className="text-black text-xl pb-16">
                            <InputIcon
                                type="text"
                                color="purple"
                                placeholder="Today's date"
                                onChange={handleDateInput}
                            />
                        </h2>
                        <Card>
                            <CardHeader color="green">
                                <h3 className="text-white text-2xl">Activities</h3>
                            </CardHeader>
                            <div className="overflow-x-auto">
                                <CardBody>
                                <table className="items-center w-full bg-transparent border-collapse">
                                    <thead>
                                    <tr>
                                        {activities.map((activity) => (
                                            <th className="px-2 text-green-500 align-middle border-b border-solid border-gray-200 py-3 text-sm whitespace-nowrap font-light text-center">
                                                <Image src={activity.activitySymbolLink} rounded/>
                                            </th>
                                        ))}
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        {activities.map((activity) => (
                                        <th className="border-b border-gray-200 align-middle font-light text-sm whitespace-nowrap px-2 py-4 text-left">
                                            <div className="mt-4 mb-8 px-4">
                                                <InputIcon
                                                    name={activity.caloriesAmount}
                                                    type="text"
                                                    color="green"
                                                    placeholder="minutes"
                                                    onChange={handleConsumedInput}
                                                />
                                            </div>
                                        </th>
                                        ))}
                                    </tr>
                                    </tbody>
                                </table>
                                </CardBody>
                            </div>
                        </Card>
                        <Card>
                            <CardHeader color="red">
                                <h3 className="text-white text-2xl">Food</h3>
                            </CardHeader>
                            <div className="overflow-x-auto">
                                <CardBody>
                                    <table className="items-center w-full bg-transparent border-collapse">
                                        <thead>
                                        <tr>
                                            {foods.map((food) => (
                                            <th className="px-2 text-red-500 align-middle border-b border-solid border-gray-200 py-3 text-sm whitespace-nowrap font-light text-center">
                                                <Image src={food.foodSymbolLink} rounded/>
                                            </th>
                                            ))}
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            {foods.map((food) => (
                                                <th className="border-b border-gray-200 align-middle font-light text-sm whitespace-nowrap px-2 py-4 text-left">
                                                    <div className="mt-4 mb-8 px-4">
                                                        <InputIcon
                                                            type="text"
                                                            color="red"
                                                            placeholder="grams"
                                                            name={food.caloriesAmount}
                                                            onChange={handleIntakeInput}
                                                        />
                                                    </div>
                                                </th>
                                            ))}
                                        </tr>
                                        </tbody>
                                    </table>
                                </CardBody>
                            </div>
                        </Card>
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
                                Finish
                            </Button>
                        </div>
                    </CardFooter>
                </Card>
            </form>
        </div>
    )
}