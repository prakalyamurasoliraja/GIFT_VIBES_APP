import React, { useState } from "react";
import { Button, Form } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import arrayt from "./arraytheme";
import { v4 as uuid } from "uuid";
import { Link, useNavigate } from "react-router-dom";
import './createtheme.css';

function Create() {
    const [image, setImage] = useState("");
    const [themeName, setThemeName] = useState("");
    const [themePrice, setThemePrice] = useState("");
    const [themeDetails, setThemeDetails] = useState("");

    let history = useNavigate();

    const handleImageChange = (e) => {
        const file = e.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onloadend = () => {
                setImage(reader.result);
            };
            reader.readAsDataURL(file);
        }
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        const id = uuid();
        arrayt.push({ id, Image: image, "Theme Name": themeName, "Theme Price": themePrice, "Theme Details": themeDetails });

        history("/themehome");
    };

    return (
        <div>
            <Form className="create-theme-comtainer" style={{ margin: "5rem" }}>
                <Form.Group className="mb-3">
                    <Form.Control onChange={(e) => handleImageChange(e)} type="file" placeholder="Image" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Control onChange={(e) => setThemeName(e.target.value)} type="text" placeholder="Theme Name" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Control onChange={(e) => setThemePrice(e.target.value)} type="number" placeholder="Theme Price" required />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Control onChange={(e) => setThemeDetails(e.target.value)} type="text" placeholder="Theme Details" required />
                </Form.Group>
                <Button onClick={(e) => handleSubmit(e)} variant="primary" type="submit" className="submittheme">
                    Submit
                </Button>
                <Link className="createtheme" to="/themehome">
                    <Button variant="createinfo" size="lg">
                        Home
                    </Button>
                </Link>
            </Form>
        </div>
    );
}

export default Create;